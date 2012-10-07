/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.HotelRestaurant;
import entity.RestaurantTables;
import entity.Typetable;
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


@ManagedBean
@ViewScoped
public class createTable {
    private List<HotelRestaurant> listHr;
    private List<Typetable> listTypeTable;
    private int selectedHrid;
    private int selectedTypeTableid;
    private String desTable;

    public String getDesTable() {
        return desTable;
    }

    public void setDesTable(String desTable) {
        this.desTable = desTable;
    }

    public List<HotelRestaurant> getListHr() {
        return listHr;
    }

    public void setListHr(List<HotelRestaurant> listHr) {
        this.listHr = listHr;
    }

    public List<Typetable> getListTypeTable() {
        return listTypeTable;
    }

    public void setListTypeTable(List<Typetable> listTypeTable) {
        this.listTypeTable = listTypeTable;
    }

    public int getSelectedHrid() {
        return selectedHrid;
    }

    public void setSelectedHrid(int selectedHrid) {
        this.selectedHrid = selectedHrid;
    }

    public int getSelectedTypeTableid() {
        return selectedTypeTableid;
    }

    public void setSelectedTypeTableid(int selectedTypeTableid) {
        this.selectedTypeTableid = selectedTypeTableid;
    }
    
   
    public createTable() {
        HotelHelper<HotelRestaurant> helperHr = new HotelHelper<HotelRestaurant>();
        listHr = helperHr.showHR();
        HotelHelper<Typetable> helperTb = new HotelHelper<Typetable>();
        listTypeTable = helperTb.showTypeTable();
    }
    
    public void btnsuccess(){
        RestaurantTables rt = new RestaurantTables();
        rt.setHrid(selectedHrid);
        rt.setTypetable(selectedTypeTableid);
        rt.setStatusTable(true);
        rt.setTableDescription(desTable);
        ObjectHelper<RestaurantTables> objHelperRT = new ObjectHelper<RestaurantTables>();
        try {
            objHelperRT.add(rt);
        } catch (ObjectException ex) {
            Logger.getLogger(createTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesMessage msg = new FacesMessage("Success!"); 
        FacesContext.getCurrentInstance().addMessage(null, msg);
        selectedHrid = 0;
        selectedTypeTableid = 0;
        desTable = null;
    }
    
    public void resetField(){
        selectedHrid = 0;
        selectedTypeTableid = 0;
        desTable = null;
    }
}
