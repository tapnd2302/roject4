package entity;
// Generated Sep 27, 2012 7:29:24 AM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Roles generated by hbm2java
 */
public class Roles  implements java.io.Serializable {


     private int roleId;
     private String roleName;
     private String descriptions;
     private Set<Users> userses = new HashSet<Users>(0);

    public Roles() {
    }

	
    public Roles(int roleId) {
        this.roleId = roleId;
    }
    public Roles(int roleId, String roleName, String descriptions, Set<Users> userses) {
       this.roleId = roleId;
       this.roleName = roleName;
       this.descriptions = descriptions;
       this.userses = userses;
    }
   
    public int getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getDescriptions() {
        return this.descriptions;
    }
    
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    public Set<Users> getUserses() {
        return this.userses;
    }
    
    public void setUserses(Set<Users> userses) {
        this.userses = userses;
    }




}


