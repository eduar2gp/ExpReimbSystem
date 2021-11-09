package revature.controller.dao;

import revature.model.ReimbStatus;
import revature.model.Reimbursement;
import revature.model.ReimbType;
import revature.model.ReimbUnresolved;

import java.util.List;

import org.json.JSONObject;

public interface ReimbursementDAO {

	public boolean insertReimbursement(Reimbursement reimb);

	public List<ReimbType> selectReimbType();

	public List<Reimbursement> selectReimbursemets(String userId);
	
	public List<ReimbUnresolved> selectReimbursementsUnresolved(String userId);

	public List<ReimbStatus> selectReimbStatus();

	public int updateReimbursement(Reimbursement reimb);
	
	public int updateReimbursement(JSONObject reimb);

}
