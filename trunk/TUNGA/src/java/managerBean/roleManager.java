/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Roles;
import exception.ObjectException;
import helper.ObjectHelper;
import helper.RoleHelper;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Administrator
 */
@ManagedBean
@ViewScoped
public class roleManager implements Serializable {

    private List<Roles> roleList;
    private List<Roles> filteredCars;
    private Roles selected;

    public Roles getSelected() {
        return selected;
    }

    public void setSelected(Roles selected) {
        this.selected = selected;
    }

    public List<Roles> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Roles> roleList) {
        this.roleList = roleList;
    }

    public List<Roles> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Roles> filteredCars) {
        this.filteredCars = filteredCars;
    }

    public roleManager() {
        RoleHelper<Roles> helper = new RoleHelper<Roles>();
        roleList = helper.showRole();
//     roleList = new Role().showRole();     

    }

    public void onEdit(RowEditEvent event) {

        ObjectHelper<Roles> helper = new ObjectHelper<Roles>();
        try {
            helper.update((Roles) event.getObject());
        } catch (ObjectException ex) {
            Logger.getLogger(roleManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacesMessage msg = new FacesMessage("Edit Comleted", ((Roles) event.getObject()).getRoleName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Roles) event.getObject()).getRoleName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteRole() {
        ObjectHelper<Roles> obj = new ObjectHelper<Roles>();
        try {
            obj.delete(selected);
            FacesMessage msg = new FacesMessage("Delete Success");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (ObjectException ex) {
            FacesMessage msg = new FacesMessage("Delete Error, Because " + ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        RoleHelper<Roles> helper = new RoleHelper<Roles>();
        roleList = helper.showRole();
//        roleList = new Role().showRole();
    }
}
