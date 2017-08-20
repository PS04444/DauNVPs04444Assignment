package entity;



import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Staffs  implements java.io.Serializable {


     private String id;
     private Departs departs;
     private String name;
     private boolean gender;
     private Date birthday;
     private String photo;
     private String email;
     private String phone;
     private double salary;
     private String notes;
     private Set<Records> recordses = new HashSet<Records>(0);

    public Staffs() {
    }

	
    public Staffs(String id, Departs departs) {
        this.id = id;
        this.departs = departs;
    }
    public Staffs(String id, Departs departs, String name, boolean gender, Date birthday, String photo, String email, String phone, double salary, String notes, Set<Records> recordses) {
       this.id = id;
       this.departs = departs;
       this.name = name;
       this.gender = gender;
       this.birthday = birthday;
       this.photo = photo;
       this.email = email;
       this.phone = phone;
       this.salary = salary;
       this.notes = notes;
       this.recordses = recordses;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public Departs getDeparts() {
        return this.departs;
    }
    
    public void setDeparts(Departs departs) {
        this.departs = departs;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public boolean getGender() {
        return this.gender;
    }
    
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public double getSalary() {
        return this.salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Set<Records> getRecordses() {
        return this.recordses;
    }
    
    public void setRecordses(Set<Records> recordses) {
        this.recordses = recordses;
    }




}


