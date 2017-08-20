/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;


public class ThanhTich {
    private int id;
    private int type;
    private String reason;
    private Date date;
    private String staffid;

    public ThanhTich() {
    }

    public ThanhTich(int id, int type, String reason, Date date, String staffid) {
        this.id = id;
        this.type = type;
        this.reason = reason;
        this.date = date;
        this.staffid = staffid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }
    
    
}
