/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Roles;
import exception.ObjectException;
import helper.ObjectHelper;
import helper.RoleHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class createRole {

    private int roleID;
    private String roleName;
    private String roleDescription;
    private List<Roles> role;

    public createRole() {
        RoleHelper<Roles> helper = new RoleHelper<Roles>();
        role = helper.showRoleDesc();
        roleID = role.get(0).getRoleId();
    }

    public String insertData() {
        Roles r = new Roles();
        r.setRoleName(roleName);
        r.setDescriptions(roleDescription);
        ObjectHelper<Roles> obj = new ObjectHelper<Roles>();
        try {
            obj.add(r);
        } catch (ObjectException ex) {
            Logger.getLogger(createRole.class.getName()).log(Level.SEVERE, null, ex);
            return "false";
        }
        return "success";
    }

    public String resetField() {
        roleName = null;
        roleDescription = null;
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
