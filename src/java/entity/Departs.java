package entity;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Departs  implements java.io.Serializable {


     private String id;
     private String name;
     private Set<Staffs> staffses = new HashSet<Staffs>(0);

    public Departs() {
    }

	
    public Departs(String id) {
        this.id = id;
    }
    public Departs(String id, String name, Set<Staffs> staffses) {
       this.id = id;
       this.name = name;
       this.staffses = staffses;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set<Staffs> getStaffses() {
        return this.staffses;
    }
    
    public void setStaffses(Set<Staffs> staffses) {
        this.staffses = staffses;
    }




}


