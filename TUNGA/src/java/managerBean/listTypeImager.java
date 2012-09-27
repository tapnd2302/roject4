/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Roles;
import entity.Typeimages;
import exception.ObjectException;
import helper.ObjectHelper;
import helper.RoleHelper;
import helper.TypeImageHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author KyHuu
 */
@ManagedBean
@ViewScoped
public class listTypeImager {

    private List<Typeimages> roleList;
    private List<Typeimages> filteredCars;
    private Typeimages selected;
    

    public Typeimages getSelected() {
        return selected;
    }

    public void setSelected(Typeimages selected) {
        this.selected = selected;
    }

    public List<Typeimages> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Typeimages> filteredCars) {
        this.filteredCars = filteredCars;
    }

    public List<Typeimages> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Typeimages> roleList) {
        this.roleList = roleList;
    }
    
    
    public listTypeImager() {
        TypeImageHelper<Typeimages> helper = new TypeImageHelper<Typeimages>();
        roleList = helper.showTypeIMG();
    }
    
    public void onEdit(RowEditEvent event) {

        ObjectHelper<Typeimages> helper = new ObjectHelper<Typeimages>();
        try {
            helper.update((Typeimages) event.getObject());
        } catch (ObjectException ex) {
            Logger.getLogger(roleManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacesMessage msg = new FacesMessage("Edit Comleted", ((Typeimages) event.getObject()).getTypeName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Typeimages) event.getObject()).getTypeName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteRole() {
        ObjectHelper<Typeimages> obj = new ObjectHelper<Typeimages>();
        try {
            obj.delete(selected);
            FacesMessage msg = new FacesMessage("Delete Success");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (ObjectException ex) {
            FacesMessage msg = new FacesMessage("Delete Error, Because " + ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        TypeImageHelper<Typeimages> helper = new TypeImageHelper<Typeimages>();
        roleList = helper.showTypeIMG();
//        roleList = new Role().showRole();
    }
}
