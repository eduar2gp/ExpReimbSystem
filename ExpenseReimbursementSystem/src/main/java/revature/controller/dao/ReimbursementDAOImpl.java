package revature.controller.dao;

import revature.controller.utils.Logs;
import revature.model.ReimbStatus;
import revature.model.ReimbType;
import revature.model.ReimbUnresolved;
import revature.model.Reimbursement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public boolean insertReimbursement(Reimbursement reimb) {
		// INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_resolved,
		// reimb_description, reimb_author, reimb_resolver, reimb_status, reimb_type)
		// VALUES(150.45, '12-31-2020', 'just some money spent on cookies', 6, 1, 1, 3);
		Connection connection;
		try {
			connection = ConnectionFactory.getConnection();

			StringBuilder str = new StringBuilder();
			str.append(
					"INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id, reimb_receipt) ");
			str.append("VALUES( ?, now(), ?, ?, ?, ?, ?)");

			PreparedStatement stm = connection.prepareStatement(str.toString());
			stm.setDouble(1, reimb.getReimbAmount());
			// stm.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
			stm.setString(2, reimb.getReimbDescription());
			stm.setInt(3, reimb.getReimbAuthorId());
			stm.setInt(4, 1);
			stm.setInt(5, reimb.getReimbTypeId());
			
			
			stm.setBytes(6, reimb.getReimbReceipt());

			stm.executeUpdate();

			return true;

		} catch (SQLException e) {
			if (Logs.SAVE_LOGS) {
				Logs.log4j.error(e);
			}
			if (Logs.SHOW_LOGS) {
				e.printStackTrace();
			}
			return false;
		}
	}

	@Override
	public List<ReimbType> selectReimbType() {
		List<ReimbType> reimbType = new ArrayList<>();
		Connection connection;
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement pstm = connection.prepareStatement("SELECT * FROM ers_reimbursement_type");
			ResultSet resSet = pstm.executeQuery();
			while (resSet.next()) {
				reimbType.add(new ReimbType(resSet.getInt(1), resSet.getString(2)));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logs.log4j.error(ex);
		}
		return reimbType;
	}

	@Override
	public List<Reimbursement> selectReimbursemets(String userId) {
		List<Reimbursement> reimbList = new ArrayList<>();
		Connection connection;
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement pstm;
			if (userId == null || userId.isEmpty()) {
				pstm = connection.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT");
			} else {
				pstm = connection.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?");
				pstm.setInt(1, Integer.parseInt(userId));
			}
			ResultSet resSet = pstm.executeQuery();
			while (resSet.next()) {
				Reimbursement reimb = new Reimbursement();
				reimb.setReimbursementId(resSet.getInt("reimb_id"));
				reimb.setReimbAmount(resSet.getDouble("reimb_amount"));
				reimb.setReimbSubmittedDate(resSet.getTimestamp("reimb_submitted"));
				reimb.setReimbResolvedDate(resSet.getTimestamp("reimb_resolved"));
				reimb.setReimbDescription(resSet.getString("reimb_description"));
				reimb.setReimbAuthorId(resSet.getInt("reimb_author"));
				reimb.setReimbResolverId(resSet.getInt("reimb_resolver"));
				reimb.setReimbStatusId(resSet.getInt("reimb_status_id"));
				reimb.setReimbTypeId(resSet.getInt("reimb_type_id"));
				reimb.setReimbReceipt(resSet.getBytes("reimb_receipt"));
				
				reimbList.add(reimb);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logs.log4j.error(ex);
		}
		return reimbList;
	}

	@Override
	public int updateReimbursement(Reimbursement reimb) {
		Connection connection;
		int rows = 0;
		try {
			connection = ConnectionFactory.getConnection();
			StringBuilder str = new StringBuilder();
			str.append("UPDATE ERS_REIMBURSEMENT ");
			str.append("set REIMB_RESOLVED = now(), REIMB_RESOLVER = ?, REIMB_STATUS_ID = ? ");
			str.append("WHERE REIMB_ID = ?");
			PreparedStatement stm = connection.prepareStatement(str.toString());
			stm.setInt(1, reimb.getReimbResolverId());
			stm.setInt(2, reimb.getReimbStatusId());
			stm.setInt(3, reimb.getReimbursementId());
			rows = stm.executeUpdate();
		} catch (SQLException e) {
			if (Logs.SAVE_LOGS)
				Logs.log4j.error(e);
			if (Logs.SHOW_LOGS)
				e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public int updateReimbursement(JSONObject reimb) {
		Connection connection;
		int rows = 0;
		try {
			connection = ConnectionFactory.getConnection();
			StringBuilder str = new StringBuilder();
			str.append("UPDATE ERS_REIMBURSEMENT ");
			str.append("set REIMB_RESOLVED = now(), REIMB_RESOLVER = ?, REIMB_STATUS_ID = ? ");
			str.append("WHERE REIMB_ID = ?");
			PreparedStatement stm = connection.prepareStatement(str.toString());
			stm.setInt(1, reimb.getInt("reimbResolverId"));
			stm.setInt(2, reimb.getInt("reimbStatusId"));
			stm.setInt(3, reimb.getInt("reimbursementId"));					
			rows = stm.executeUpdate();
			
		} catch (SQLException e) {
			if (Logs.SAVE_LOGS)
				Logs.log4j.error(e);
			if (Logs.SHOW_LOGS)
				e.printStackTrace();
		}
		return rows;
	}

	@Override
	public List<ReimbStatus> selectReimbStatus() {
		List<ReimbStatus> reimbStatus = new ArrayList<>();
		Connection connection;
		try {
			connection = ConnectionFactory.getConnection();
			Statement stm = connection.createStatement();
			ResultSet resSet = stm.executeQuery("SELECT * FROM ers_reimbursement_status");
			while (resSet.next()) {
				reimbStatus.add(new ReimbStatus(resSet.getInt(1), resSet.getString(2)));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logs.log4j.error(ex);
		}
		return reimbStatus;
	}

	@Override
	public List<ReimbUnresolved> selectReimbursementsUnresolved(String userId) {
		List<ReimbUnresolved> reimbList = new ArrayList<>();
		Connection connection;
		try {
			connection = ConnectionFactory.getConnection();
			PreparedStatement pstm;
			if (userId == null || userId.isEmpty()) {
				pstm = connection.prepareStatement("select * from ers_reimb_unresolved_function()");
			} else {
				pstm = connection.prepareStatement("select * from ers_reimb_unresolved_function_by_user_id(?)");
				pstm.setInt(1, Integer.parseInt(userId));
			}
			ResultSet resSet = pstm.executeQuery();
			while (resSet.next()) {
				ReimbUnresolved reimb = new ReimbUnresolved();
				reimb.setReimbursementId(resSet.getInt("reimb_id"));
				reimb.setReimbAmount(resSet.getDouble("reimb_amount"));
				
				//System.out.println(resSet.getTimestamp("reimb_submitted"));
				
				reimb.setReimbSubmittedDate(resSet.getTimestamp("reimb_submitted"));
				
				//System.out.println(reimb.getReimbSubmittedDate());
				
				reimb.setReimbResolvedDate(resSet.getTimestamp("reimb_resolved"));
				reimb.setReimbDescription(resSet.getString("reimb_description"));				
				reimb.setReimbAuthorUsername(resSet.getString("reimb_author_username"));				
				reimb.setReimbAuthorFirstname(resSet.getString("reimb_author_firstname"));				
				reimb.setReimbAuthorLastname(resSet.getString("reimb_author_lastname"));
				reimb.setReimbAuthorEmail(resSet.getString("reimb_author_email"));				
				reimb.setReimbStatusId(resSet.getInt("reimb_status_id"));
				reimb.setReimbTypeId(resSet.getInt("reimb_type_id"));				
				reimb.setReimbStatus(resSet.getString("reimb_status"));
				reimb.setReimbType(resSet.getString("reimb_type"));		
				reimb.setReimbReceipt(resSet.getBytes("reimb_receipt"));
				reimbList.add(reimb);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logs.log4j.error(ex);
		}
		return reimbList;
	}
}
