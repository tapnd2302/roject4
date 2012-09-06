/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Roles;
import helper.Role;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class roleManager {

    private List<Roles> roleList;
    private List<Roles> filteredCars;
    private Roles selectedID;

    public Roles getSelectedID() {
        return selectedID;
    }

    public void setSelectedID(Roles selectedID) {
        this.selectedID = selectedID;
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
        roleList = new Role().showRole();
    }

    public void onEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((Roles) event.getObject()).getRoleName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Cancelled", ((Roles) event.getObject()).getRoleName());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteRole() {
        Role ro = new Role();
        Object result = ro.deleteRole(selectedID);
        if (result == null) {
            FacesMessage msg = new FacesMessage("Delete Success ...");

            FacesContext.getCurrentInstance().addMessage(null, msg);

        } else {

            FacesMessage msg = new FacesMessage("Delete False !!!");

            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
