package revature.model;

import java.sql.Timestamp;

public class ReimbUnresolved {
	
	private int reimbursementId;
	private double reimbAmount;
	private Timestamp reimbSubmittedDate;
	private Timestamp reimbResolvedDate;
	private byte[] reimbReceipt;
	private String reimbDescription;	
	private String reimbAuthorUsername;
	private String reimbAuthorFirstname;
	private String reimbAuthorLastname;
	private String reimbAuthorEmail;	
	private int reimbStatusId;
	private int reimbTypeId;
	private String reimbStatus;
	private String reimbType;
	
	public ReimbUnresolved() {
		
	}
		
	public String getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Timestamp getReimbSubmittedDate() {
		return reimbSubmittedDate;
	}
	public void setReimbSubmittedDate(Timestamp reimbSubmittedDate) {
		this.reimbSubmittedDate = reimbSubmittedDate;
	}
	public Timestamp getReimbResolvedDate() {
		return reimbResolvedDate;
	}
	public void setReimbResolvedDate(Timestamp reimbResolvedDate) {
		this.reimbResolvedDate = reimbResolvedDate;
	}
	public byte[] getReimbReceipt() {
		return reimbReceipt;
	}
	public void setReimbReceipt(byte[] reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}
	public String getReimbDescription() {
		return reimbDescription;
	}
	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}
	
	public String getReimbAuthorUsername() {
		return reimbAuthorUsername;
	}

	public void setReimbAuthorUsername(String reimbAuthorUsername) {
		this.reimbAuthorUsername = reimbAuthorUsername;
	}

	public String getReimbAuthorFirstname() {
		return reimbAuthorFirstname;
	}

	public void setReimbAuthorFirstname(String reimbAuthorFirstname) {
		this.reimbAuthorFirstname = reimbAuthorFirstname;
	}

	public String getReimbAuthorLastname() {
		return reimbAuthorLastname;
	}

	public void setReimbAuthorLastname(String reimbAuthorLastname) {
		this.reimbAuthorLastname = reimbAuthorLastname;
	}

	public String getReimbAuthorEmail() {
		return reimbAuthorEmail;
	}

	public void setReimbAuthorEmail(String reimbAuthorEmail) {
		this.reimbAuthorEmail = reimbAuthorEmail;
	}

	public int getReimbStatusId() {
		return reimbStatusId;
	}
	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}
	public int getReimbTypeId() {
		return reimbTypeId;
	}
	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}

}
