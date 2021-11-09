/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revature.model;

/**
 *
 * @author eduar
 */
public class ReimbStatus {

    int reimbStatusId;
    String reimbStatus;

    public ReimbStatus(int reimbStatusId, String reimbStatus) {
        this.reimbStatus = reimbStatus;
        this.reimbStatusId = reimbStatusId;
    }

    public String getReimbStatus() {
        return reimbStatus;
    }

    public int getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatus(String reimbStatus) {
        this.reimbStatus = reimbStatus;
    }

    public void setReimbStatusId(int reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

}
