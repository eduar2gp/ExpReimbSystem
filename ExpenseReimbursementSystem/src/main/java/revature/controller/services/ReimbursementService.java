package revature.controller.services;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import revature.model.ReimbStatus;
import revature.model.ReimbType;
import revature.model.ReimbUnresolved;
import revature.model.Reimbursement;

public interface ReimbursementService {

	public boolean addReimbursement(JSONObject reimb, byte[] image);

	public JSONArray getReimbTypes1();
	
	public JSONArray getReimbStatus1();
	
	public List<ReimbStatus> getReimbStatus();

	public JSONArray getReimbursement1(String userId);
	
	public List<Reimbursement> getReimbursement(String userId);
	
	public List<ReimbType> getReimbTypes();
	
	public int updateReimb(Reimbursement reimb);
	
	public int updateReimb(JSONObject reimb);
	
	public List<ReimbUnresolved> getReimbUnresolved(String userId);
	

}

