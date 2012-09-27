
package managerBean;


import entity.HotelRestaurant;
import exception.ObjectException;
import helper.HotelHelper;
import helper.ObjectHelper;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.RowEditEvent;


@ManagedBean
@ViewScoped
public class hotelManager implements Serializable{

    private List<HotelRestaurant> listHR;
    private List<HotelRestaurant> filteredCars;
    private HotelRestaurant hr;
    private String _name;
    private String _address;
    private String _phone;
    private String _email;
    private String _info;
    private int _id;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getAddress() {
        return _address;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getInfo() {
        return _info;
    }

    public void setInfo(String _info) {
        this._info = _info;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String _phone) {
        this._phone = _phone;
    }
    
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
    
    public void btnEdit(ActionEvent actionEvent){
        ObjectHelper<HotelRestaurant> helper = new HotelHelper<HotelRestaurant>();
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;  
        boolean edit = false;
        if (!edit) { //check validator
            hr.setHrid(_id);
            hr.setHrname(_name);
            hr.setHraddress(_address);
            hr.setHrphone(_phone);
            hr.setHremail(_email);
            hr.setHrinfo(_info);
            try {
                helper.update(hr);
            } catch (ObjectException ex) {
                Logger.getLogger(hotelManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            edit = true;
            msg = new FacesMessage("Update Comleted");
        }
        else {
            edit = false;  
            msg = new FacesMessage("Failed");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("edit", edit);
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
    
    public void btnCancel(){
        FacesMessage msg = new FacesMessage("Edit Canceled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
    public void showHotel(){
        _name = hr.getHrname();
        _address = hr.getHraddress();
        _phone = hr.getHrphone();
        _email = hr.getHremail();
        _info = hr.getHrinfo();
        _id = hr.getHrid();
    }
}
