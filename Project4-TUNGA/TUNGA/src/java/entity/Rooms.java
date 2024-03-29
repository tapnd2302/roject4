package entity;
// Generated Sep 27, 2012 7:29:24 AM by Hibernate Tools 3.2.1.GA


import helper.RoomsHelper;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Rooms generated by hbm2java
 */
public class Rooms  implements java.io.Serializable {


     private int roomId;
     private Integer typerooms;
     private Integer hrid;
     private Boolean roomStatus;
     private String roomDescription;
     private String nameTypeRoom;
     private String nameHotel;

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getNameTypeRoom() {
        return nameTypeRoom;
    }

    public void setNameTypeRoom(String nameTypeRoom) {
        this.nameTypeRoom = nameTypeRoom;
    }
     

   
     
    public Rooms() {
    }

	
    public Rooms(int roomId) {
        this.roomId = roomId;
    }
    public Rooms(int roomId, Integer typerooms, Integer hrid, Boolean roomStatus, String roomDescription) {
       this.roomId = roomId;
       this.typerooms = typerooms;
       this.hrid = hrid;
       this.roomStatus = roomStatus;
       this.roomDescription = roomDescription;
    }
   
    public int getRoomId() {
        return this.roomId;
    }
    
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public Integer getTyperooms() {
        return this.typerooms;
    }
    
    public void setTyperooms(Integer typerooms) {
        this.typerooms = typerooms;
        RoomsHelper<Typerooms> Tr = new RoomsHelper<Typerooms>();
        nameTypeRoom =  Tr.showTypeRoom(typerooms).getTypeRoomName();
    }
    public Integer getHrid() {
        return this.hrid;
    }
    
    public void setHrid(Integer hrid) {
        this.hrid = hrid;
        RoomsHelper<HotelRestaurant> Hr = new RoomsHelper<HotelRestaurant>();
        nameHotel = Hr.showNameHotel(hrid).getHrname();
    }
    public Boolean getRoomStatus() {
        return this.roomStatus;
    }
    
    public void setRoomStatus(Boolean roomStatus) {
        this.roomStatus = roomStatus;
    }
    public String getRoomDescription() {
        return this.roomDescription;
    }
    
    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }
    

}


