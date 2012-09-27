/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Roles;
import entity.Typefoods;
import exception.ObjectException;
import helper.HotelHelper;
import helper.ObjectHelper;
import helper.TypeFoodHelper;
import java.io.Serializable;
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
public class listTypeFood implements Serializable{
    private List<Typefoods> listTypeFood;
    private List<Typefoods> filteredCars;
    private Typefoods selected;

    public Typefoods getSelected() {
        return selected;
    }

    public void setSelected(Typefoods selected) {
        this.selected = selected;
    }

    public List<Typefoods> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Typefoods> filteredCars) {
        this.filteredCars = filteredCars;
    }
    

    public List<Typefoods> getListTypeFood() {
        return listTypeFood;
    }

    public void setListTypeFood(List<Typefoods> listTypeFood) {
        this.listTypeFood = listTypeFood;
    }
    
   
    public listTypeFood() {
        TypeFoodHelper<Typefoods> helper = new TypeFoodHelper<Typefoods>();
        listTypeFood = helper.showTypeFood();
    }
    public void deleteRole(){
        ObjectHelper<Typefoods> obj = new HotelHelper<Typefoods>();
        try {
            obj.delete(selected);
        } catch (ObjectException ex) {
            Logger.getLogger(listTypeFood.class.getName()).log(Level.SEVERE, null, ex);
        }
        TypeFoodHelper<Typefoods> helper = new TypeFoodHelper<Typefoods>();
        listTypeFood = helper.showTypeFood();
    }
    
    public void onEdit(RowEditEvent event) {

        ObjectHelper<Typefoods> helper = new ObjectHelper<Typefoods>();
        try {
            helper.update((Typefoods) event.getObject());
        } catch (ObjectException ex) {
            Logger.getLogger(roleManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacesMessage msg = new FacesMessage("Edit Comleted", ((Typefoods) event.getObject()).getTypeFoodName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Typefoods) event.getObject()).getTypeFoodName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
