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
public class ReimbType {

    int reimbTypeId;
    String reimbType;

    public ReimbType(int reimbTypeId, String reimbType) {
        this.reimbType = reimbType;
        this.reimbTypeId = reimbTypeId;
    }

    public void setReimbType(String reimbType) {
        this.reimbType = reimbType;
    }

    public void setReimbTypeId(int reimbTypeId) {
        this.reimbTypeId = reimbTypeId;
    }

    public String getReimbType() {
        return reimbType;
    }

    public int getReimbTypeId() {
        return reimbTypeId;
    }

}
