
package managerBean;


import entity.HotelRestaurant;
import exception.ObjectException;
import helper.HotelHelper;
import helper.ObjectHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;


@ManagedBean
@ViewScoped
public class hotelManager {

    private List<HotelRestaurant> listHR;
    private List<HotelRestaurant> filteredCars;
    private HotelRestaurant hr;

    public HotelRestaurant getHr() {
        return hr;
    }

    public void setHr(HotelRestaurant hr) {
        this.hr = hr;
    }

    public List<HotelRestaurant> getListHR() {
        return listHR;
    }

    public void setListHR(List<HotelRestaurant> listHR) {
        this.listHR = listHR;
    }
    
    public List<HotelRestaurant> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<HotelRestaurant> filteredCars) {
        this.filteredCars = filteredCars;
    }
    
    public hotelManager() {
        HotelHelper<HotelRestaurant> helper = new HotelHelper<HotelRestaurant>();
        listHR = helper.showHR();
    }
    
    public void btnEdit(RowEditEvent event){
        ObjectHelper<HotelRestaurant> helper = new HotelHelper<HotelRestaurant>();
        try {
            helper.update((HotelRestaurant) event.getObject());
        } catch (ObjectException ex) {
            Logger.getLogger(hotelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesMessage msg = new FacesMessage("Edit Comleted", ((HotelRestaurant) event.getObject()).getHrname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void btnCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Canceled", ((HotelRestaurant) event.getObject()).getHrname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void btnDelete(){
        ObjectHelper<HotelRestaurant> objHelper = new HotelHelper<HotelRestaurant>();
        try {
            objHelper.delete(hr);
            FacesMessage msg = new FacesMessage("Delete Success");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (ObjectException ex) {
            Logger.getLogger(hotelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        HotelHelper<HotelRestaurant> helper = new HotelHelper<HotelRestaurant>();
        listHR = helper.showHR();
    }
    
    public String redirectImage(){
        return "imagesManager.jsf?faces-redirect=true&id=";
    }
}
