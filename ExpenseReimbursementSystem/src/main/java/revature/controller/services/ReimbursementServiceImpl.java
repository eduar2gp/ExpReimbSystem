package revature.controller.services;

import revature.controller.dao.ReimbursementDAO;
import revature.model.ReimbStatus;
import revature.model.ReimbType;
import revature.model.ReimbUnresolved;
import revature.model.Reimbursement;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReimbursementServiceImpl implements ReimbursementService {

    ReimbursementDAO reimbDAO;
    
    public ReimbursementServiceImpl(ReimbursementDAO reimbDAO) {
    	this.reimbDAO = reimbDAO;    	
    }

    @Override
    public boolean addReimbursement(JSONObject reimbJson, byte[] image) {
        System.out.println(reimbJson.toString());
        Reimbursement reimb = new Reimbursement();
        reimb.setReimbAmount(Double.parseDouble(reimbJson.getString("amount")));
        reimb.setReimbDescription(reimbJson.getString("description"));
        reimb.setReimbTypeId(Integer.parseInt(reimbJson.getString("type")));
        reimb.setReimbAuthorId(reimbJson.getInt("user_id"));
        
        reimb.setReimbReceipt(image);
        
        return reimbDAO.insertReimbursement(reimb);
    }

    @Override
    public JSONArray getReimbTypes1() {
        List<ReimbType> reimbTypes = reimbDAO.selectReimbType();
        JSONArray reimbTypeJson = new JSONArray();
        for (ReimbType reimbType : reimbTypes) {
            JSONObject json = new JSONObject();
            json.put("reimb_type_id", reimbType.getReimbTypeId());
            json.put("reimb_type", reimbType.getReimbType());
            reimbTypeJson.put(json);
        }
        return reimbTypeJson;
    }

    @Override
    public JSONArray getReimbursement1(String userId) {
        JSONArray reimbJsonArray = new JSONArray();
        List<Reimbursement> reimbList = reimbDAO.selectReimbursemets(userId);
        for(Reimbursement reimb: reimbList){
            JSONObject r = new JSONObject();
            r.put("reimb_id", reimb.getReimbursementId());
            r.put("reimb_amount", reimb.getReimbAmount());
            r.put("reimb_submitted", reimb.getReimbSubmittedDate());
            r.put("reimb_resolved", reimb.getReimbResolvedDate());
            r.put("reimb_description", reimb.getReimbDescription());
            r.put("reimb_author", reimb.getReimbAuthorId());
            r.put("reimb_resolver", reimb.getReimbResolverId());
            r.put("reimb_status", reimb.getReimbStatusId());
            r.put("reimb_type", reimb.getReimbTypeId());        
            reimbJsonArray.put(r);
        }
        return reimbJsonArray;
    }

    @Override
    public JSONArray getReimbStatus1() {
        JSONArray jsonArrayReimbStatus = new JSONArray();
        List<ReimbStatus> reimbStatus = reimbDAO.selectReimbStatus();
        for(ReimbStatus reimb: reimbStatus){
            JSONObject j = new JSONObject();
            j.put("reimb_status_id", reimb.getReimbStatusId());
            j.put("reimb_status", reimb.getReimbStatus());
            jsonArrayReimbStatus.put(j);
        }        
        return jsonArrayReimbStatus;
    }
    
    @Override
    public List<ReimbStatus> getReimbStatus() {       
       return reimbDAO.selectReimbStatus();       
    }

	@Override
	public List<Reimbursement> getReimbursement(String userId) {
		return reimbDAO.selectReimbursemets(userId);
	}

	@Override
	public List<ReimbType> getReimbTypes() {
		return reimbDAO.selectReimbType();
	}

	@Override
	public int updateReimb(Reimbursement reimb) {
		return reimbDAO.updateReimbursement(reimb);
	}

	@Override
	public List<ReimbUnresolved> getReimbUnresolved(String userId) {
		return reimbDAO.selectReimbursementsUnresolved(userId);
	}

	@Override
	public int updateReimb(JSONObject reimb) {
		return reimbDAO.updateReimbursement(reimb);
	}
}
