/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Users;
import exception.ObjectException;
import helper.ObjectHelper;
import helper.UserHelper;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author KyHuu
 */
@ManagedBean
@ViewScoped
public class userManager implements Serializable{

    private List<Users> usersList;
    private List<Users> filteredCars;
    private Users selected;
    private Users seletedEdit;

    public Users getSeletedEdit() {
        return seletedEdit;
    }

    public void setSeletedEdit(Users seletedEdit) {
        this.seletedEdit = seletedEdit;
    }
    
    
    public List<Users> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Users> filteredCars) {
        this.filteredCars = filteredCars;
    }

    public Users getSelected() {
        return selected;
    }

    public void setSelected(Users selected) {
        this.selected = selected;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }
    
    public userManager() {
        UserHelper<Users> helper = new UserHelper<Users>();
        usersList = helper.showUsers();
    }
    public void deleteUser(){
        ObjectHelper<Users> obj = new ObjectHelper<Users>();
        try {
            obj.delete(selected);
            FacesMessage msg = new FacesMessage("Delete Success");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (ObjectException ex) {
            FacesMessage msg = new FacesMessage("Delete Error, Because " + ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        UserHelper<Users> helper = new UserHelper<Users>();
        usersList = helper.showRole();
    }
    public String edit(){
        return "editUser.jsf?faces-redirect=true&id="+ seletedEdit.getAccountId();
    }
}
