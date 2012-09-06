/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Roles;
import helper.Role;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class createRole {

    private int roleID;
    private String roleName;
    private String roleDescription;
    private List<Roles> role;
    
    public createRole() {
        role = new Role().showRole();
        roleID = role.get(0).getRoleId();
    }

    public String insertData() {
        Role r = new Role();
        if (r.insertRole(roleName, roleDescription) != null) {
            return "success";
        } else {
            return "false";
        }
    }

    public String resetField() {
        roleName=null;
        roleDescription=null;
        return "reset";
        
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
