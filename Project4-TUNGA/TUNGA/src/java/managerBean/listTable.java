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
import javax.faces.event.ActionEvent;


@ManagedBean
@ViewScoped
public class listTable {
    private List<RestaurantTables> listRT;
    private List<RestaurantTables> filteredCars;
    private RestaurantTables selRT;
    private int typeTableid;
    private int hotelid; 
    private Boolean statusTable;
    private String desTable;
    private List<HotelRestaurant> listHr;
    private List<Typetable> listTypeTable;
    private int tableid;

    
    public List<Typetable> getListTypeTable() {
        return listTypeTable;
    }

    public void setListTypeTable(List<Typetable> listTypeTable) {
        this.listTypeTable = listTypeTable;
    }
    
    public String getDesTable() {
        return desTable;
    }

    public void setDesTable(String desTable) {
        this.desTable = desTable;
    }

    public List<RestaurantTables> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<RestaurantTables> filteredCars) {
        this.filteredCars = filteredCars;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public List<HotelRestaurant> getListHr() {
        return listHr;
    }

    public void setListHr(List<HotelRestaurant> listHr) {
        this.listHr = listHr;
    }

    public List<RestaurantTables> getListRT() {
        return listRT;
    }

    public void setListRT(List<RestaurantTables> listRT) {
        this.listRT = listRT;
    }

   

    public RestaurantTables getSelRT() {
        return selRT;
    }

    public void setSelRT(RestaurantTables selRT) {
        this.selRT = selRT;
    }

    public Boolean getStatusTable() {
        return statusTable;
    }

    public void setStatusTable(Boolean statusTable) {
        this.statusTable = statusTable;
    }

    public int getTableid() {
        return tableid;
    }

    public void setTableid(int tableid) {
        this.tableid = tableid;
    }

    public int getTypeTableid() {
        return typeTableid;
    }

    public void setTypeTableid(int typeTableid) {
        this.typeTableid = typeTableid;
    }
    
    
    public listTable() {
        HotelHelper<HotelRestaurant> helperHr = new HotelHelper<HotelRestaurant>();
        listHr = helperHr.showHR();
        HotelHelper<RestaurantTables> helperRt = new HotelHelper<RestaurantTables>();
        listRT = helperRt.showTable();
        HotelHelper<Typetable> helperTt = new HotelHelper<Typetable>();
        listTypeTable = helperTt.showTypeTable();
    }
    
    public void showTable(){
        hotelid = selRT.getHrid();
        typeTableid = selRT.getTypetable();
        statusTable = selRT.getStatusTable();
        desTable = selRT.getTableDescription();
        tableid = selRT.getResTableId();
    }
    
    public void btnDelTable(){
        ObjectHelper<RestaurantTables> objHelperRt = new ObjectHelper<RestaurantTables>();
        try {
            objHelperRt.delete(selRT);
        } catch (ObjectException ex) {
            Logger.getLogger(listTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesMessage msg = new FacesMessage("Delete Success");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        HotelHelper<RestaurantTables> helperRt = new HotelHelper<RestaurantTables>();
        listRT = helperRt.showTable();
    }
    
    public void btnCancel(){
        FacesMessage msg = new FacesMessage("Edit Canceled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void btnUpdate(ActionEvent actionEvent){
        selRT.setHrid(hotelid);
        selRT.setResTableId(tableid);
        selRT.setStatusTable(statusTable);
        selRT.setTableDescription(desTable);
        selRT.setTypetable(typeTableid);
        ObjectHelper<RestaurantTables> objHelperRt = new ObjectHelper<RestaurantTables>();
        try {
            objHelperRt.update(selRT);
        } catch (ObjectException ex) {
            Logger.getLogger(listTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesMessage msg = new FacesMessage("Update Success");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
