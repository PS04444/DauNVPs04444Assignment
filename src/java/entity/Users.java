package entity;



import java.io.Serializable;


public class Users  implements java.io.Serializable {


     private String username;
     private String password;
     private String fullname;

    public Users() {
    }

	
    public Users(String username) {
        this.username = username;
    }
    public Users(String username, String password, String fullname) {
       this.username = username;
       this.password = password;
       this.fullname = fullname;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullname() {
        return this.fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }




}


