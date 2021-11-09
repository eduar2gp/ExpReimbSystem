package revature.model;

import java.sql.Timestamp;
import java.util.Arrays;

public class Reimbursement {
	
	private int reimbursementId;
	private double reimbAmount;
	private Timestamp reimbSubmittedDate;
	private Timestamp reimbResolvedDate;
	private byte[] reimbReceipt;
	private String reimbDescription;
	private int reimbAuthorId;
	private int reimbResolverId;
	private int reimbStatusId;
	private int reimbTypeId;
	
	public Reimbursement() {
		
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", reimbAmount=" + reimbAmount
				+ ", reimbSubmittedDate=" + reimbSubmittedDate + ", reimbResolvedDate=" + reimbResolvedDate
				+ ", reimbReceipt=" + Arrays.toString(reimbReceipt) + ", reimbDescription=" + reimbDescription
				+ ", reimbAuthorId=" + reimbAuthorId + ", reimbResolverId=" + reimbResolverId + ", reimbStatusId="
				+ reimbStatusId + ", reimbTypeId=" + reimbTypeId + "]";
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
	public int getReimbAuthorId() {
		return reimbAuthorId;
	}
	public void setReimbAuthorId(int reimbAuthorId) {
		this.reimbAuthorId = reimbAuthorId;
	}
	public int getReimbResolverId() {
		return reimbResolverId;
	}
	public void setReimbResolverId(int reimbResolverId) {
		this.reimbResolverId = reimbResolverId;
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