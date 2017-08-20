package entity;



import java.io.Serializable;
import java.util.Date;


public class Records  implements java.io.Serializable {


     private long id;
     private Staffs staffs;
     private Integer type;
     private String reason;
     private Date date;

    public Records() {
    }

	
    public Records(long id, Staffs staffs, Date date) {
        this.id = id;
        this.staffs = staffs;
        this.date = date;
    }
    public Records(long id, Staffs staffs, Integer type, String reason, Date date) {
       this.id = id;
       this.staffs = staffs;
       this.type = type;
       this.reason = reason;
       this.date = date;
    }
   
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public Staffs getStaffs() {
        return this.staffs;
    }
    
    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }
    public Integer getType() {
        return this.type;
    }
    
    public void setType(Integer type) {
        this.type = type;
    }
    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }




}


