/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Foods;
import entity.Roles;
import entity.Typefoods;
import exception.ObjectException;
import helper.FoodsHelper;
import helper.ObjectHelper;
import helper.RoleHelper;
import helper.TypeFoodHelper;
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
public class listFood {

    private List<Foods> listFood;
    private List<Foods> filteredCars;
    private Foods selected;
    private List<Typefoods> listTypeFood;

    public List<Typefoods> getListTypeFood() {
        return listTypeFood;
    }

    public void setListTypeFood(List<Typefoods> listTypeFood) {
        this.listTypeFood = listTypeFood;
    }

    public List<Foods> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Foods> filteredCars) {
        this.filteredCars = filteredCars;
    }

    public List<Foods> getListFood() {
        return listFood;
    }

    public void setListFood(List<Foods> listFood) {
        this.listFood = listFood;
    }

    public Foods getSelected() {
        return selected;
    }

    public void setSelected(Foods selected) {
        this.selected = selected;
    }

    public listFood() {
        FoodsHelper<Foods> helper = new FoodsHelper<Foods>();
        listFood = helper.getFoods();
        TypeFoodHelper<Typefoods> t = new TypeFoodHelper<Typefoods>();
        listTypeFood = t.showTypeFood();

    }

    public void onEdit(RowEditEvent event) {

        ObjectHelper<Foods> helper = new ObjectHelper<Foods>();
        try {
            helper.update((Foods) event.getObject());
        } catch (ObjectException ex) {
            Logger.getLogger(roleManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacesMessage msg = new FacesMessage("Edit Comleted", ((Foods) event.getObject()).getFoodName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Foods) event.getObject()).getFoodName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteRole() {
        ObjectHelper<Foods> obj = new ObjectHelper<Foods>();
        try {
            obj.delete(selected);
            FacesMessage msg = new FacesMessage("Delete Success");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (ObjectException ex) {
            FacesMessage msg = new FacesMessage("Delete Error, Because " + ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        FoodsHelper<Foods> f = new FoodsHelper<Foods>();
        listFood = f.getFoods();

    }
}
