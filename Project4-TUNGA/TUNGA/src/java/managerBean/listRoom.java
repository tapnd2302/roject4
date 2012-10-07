
package managerBean;

import entity.HotelRestaurant;
import entity.Images;
import entity.Rooms;
import entity.Typerooms;
import exception.ObjectException;
import helper.HotelHelper;
import helper.ObjectHelper;
import java.io.File;
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
public class listRoom {
    
    private List<Rooms> listRoom;
    private List<Rooms> filteredCars;
    private Rooms selRoom;
    private int typeRoomid;
    private int hotelid; 
    private Boolean statusRoom;
    private String desRoom;
    private List<HotelRestaurant> listHr;
    private List<Typerooms> listTypeRoom;
    private List<Images> listImage;
    private int roomid;
    private Images selectedImg;
    private String _desImg;
    

    public String getDesImg() {
        return _desImg;
    }

    public void setDesImg(String _desImg) {
        this._desImg = _desImg;
    }

    public Images getSelectedImg() {
        return selectedImg;
    }

    public void setSelectedImg(Images selectedImg) {
        this.selectedImg = selectedImg;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public List<Images> getListImage() {
        return listImage;
    }

    public void setListImage(List<Images> listImage) {
        this.listImage = listImage;
    }

    public List<Typerooms> getListTypeRoom() {
        return listTypeRoom;
    }

    public void setListTypeRoom(List<Typerooms> listTypeRoom) {
        this.listTypeRoom = listTypeRoom;
    }

    public List<HotelRestaurant> getListHr() {
        return listHr;
    }

    public void setListHr(List<HotelRestaurant> listHr) {
        this.listHr = listHr;
    }
    
    

    public String getDesRoom() {
        return desRoom;
    }

    public void setDesRoom(String desRoom) {
        this.desRoom = desRoom;
    }

    public int getHotelid() {
        return hotelid;
    }

    public void setHotelid(int hotelid) {
        this.hotelid = hotelid;
    }

    public Boolean getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(Boolean statusRoom) {
        this.statusRoom = statusRoom;
    }

    public int getTypeRoomid() {
        return typeRoomid;
    }

    public void setTypeRoomid(int typeRoomid) {
        this.typeRoomid = typeRoomid;
    }
    
    
    

    public Rooms getSelRoom() {
        return selRoom;
    }

    public void setSelRoom(Rooms selRoom) {
        this.selRoom = selRoom;
    }
    
    

    public List<Rooms> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Rooms> filteredCars) {
        this.filteredCars = filteredCars;
    }

    public List<Rooms> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<Rooms> listRoom) {
        this.listRoom = listRoom;
    }
   
    
    
    public listRoom() {
        HotelHelper<Rooms> helperRoom = new HotelHelper<Rooms>();
        listRoom = helperRoom.showRooms();
        HotelHelper<HotelRestaurant> helperHr = new HotelHelper<HotelRestaurant>();
        listHr = helperHr.showHR();
        HotelHelper<Typerooms> helperTr = new HotelHelper<Typerooms>();
        listTypeRoom = helperTr.showTypeRoom();
        
    }
    
    public void showDesImg(){
        _desImg = selectedImg.getDescriptions();
    }
    public void btnCancel(){
        FacesMessage msg = new FacesMessage("Edit Canceled");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void editDesImg(){
        ObjectHelper<Images> helperImg = new ObjectHelper<Images>();
        selectedImg.setDescriptions(_desImg);
        try {
            helperImg.update(selectedImg);
        } catch (ObjectException ex) {
            Logger.getLogger(hotelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesMessage msg = new FacesMessage("Success");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    private String destination = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
    public void delImg(){
        ObjectHelper<Images> helperImg = new ObjectHelper<Images>();
        try {
            helperImg.delete(selectedImg);
            File f = new File(destination +File.separator+ "images" +File.separator+ "hotel" +File.separator+ selectedImg.getImageLink());
            f.delete();
            FacesMessage msg = new FacesMessage("Deleted");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (ObjectException ex) {
            Logger.getLogger(hotelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        HotelHelper<Images> helper = new HotelHelper<Images>();
        listImage = helper.showImage(3, roomid);
    }
    
    public void btnUpdate(ActionEvent actionEvent){
        ObjectHelper<Rooms> objHelper = new ObjectHelper<Rooms>();
        selRoom.setRoomId(roomid);
        selRoom.setHrid(hotelid);
        selRoom.setTyperooms(typeRoomid);
        selRoom.setRoomStatus(statusRoom);
        selRoom.setRoomDescription(desRoom);
        try {
            objHelper.update(selRoom);
            
        } catch (ObjectException ex) {
            Logger.getLogger(listRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesMessage msg = new FacesMessage("Update Success");
        FacesContext.getCurrentInstance().addMessage(null, msg);
            
    }
    
    public void btnDelRoom(){
        HotelHelper<Images> helper = new HotelHelper<Images>();
        listImage = helper.showImage(3, selRoom.getRoomId());
        for (Images img : listImage) {
                File f = new File(destination +File.separator+ "images" +File.separator+ "hotel" +File.separator+ img.getImageLink());
                f.delete();
            }
        
        try {
            ObjectHelper<Images> objHelperImg = new ObjectHelper<Images>();
            objHelperImg.delList(listImage);
            
            ObjectHelper<Rooms> objHelperRoom = new ObjectHelper<Rooms>();
            objHelperRoom.delete(selRoom);
            FacesMessage msg = new FacesMessage("Delete Success");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (ObjectException ex) {
            Logger.getLogger(hotelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        HotelHelper<Rooms> helperRoom = new HotelHelper<Rooms>();
        listRoom = helperRoom.showRooms();
    }
    
    public void showRoom(){
        hotelid = selRoom.getHrid();
        typeRoomid = selRoom.getTyperooms();
        statusRoom = selRoom.getRoomStatus();
        desRoom = selRoom.getRoomDescription();
        roomid = selRoom.getRoomId();
        HotelHelper<Images> helper = new HotelHelper<Images>();
        listImage = helper.showImage(3, roomid);
    }
    
   
}
