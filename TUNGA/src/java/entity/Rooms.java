package entity;
// Generated Sep 27, 2012 7:29:24 AM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Rooms generated by hbm2java
 */
public class Rooms  implements java.io.Serializable {


     private int roomId;
     private Typerooms typerooms;
     private Integer hrid;
     private Boolean roomStatus;
     private Serializable roomDescription;
     private Set<Roombooking> roombookings = new HashSet<Roombooking>(0);

    public Rooms() {
    }

	
    public Rooms(int roomId) {
        this.roomId = roomId;
    }
    public Rooms(int roomId, Typerooms typerooms, Integer hrid, Boolean roomStatus, Serializable roomDescription, Set<Roombooking> roombookings) {
       this.roomId = roomId;
       this.typerooms = typerooms;
       this.hrid = hrid;
       this.roomStatus = roomStatus;
       this.roomDescription = roomDescription;
       this.roombookings = roombookings;
    }
   
    public int getRoomId() {
        return this.roomId;
    }
    
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    public Typerooms getTyperooms() {
        return this.typerooms;
    }
    
    public void setTyperooms(Typerooms typerooms) {
        this.typerooms = typerooms;
    }
    public Integer getHrid() {
        return this.hrid;
    }
    
    public void setHrid(Integer hrid) {
        this.hrid = hrid;
    }
    public Boolean getRoomStatus() {
        return this.roomStatus;
    }
    
    public void setRoomStatus(Boolean roomStatus) {
        this.roomStatus = roomStatus;
    }
    public Serializable getRoomDescription() {
        return this.roomDescription;
    }
    
    public void setRoomDescription(Serializable roomDescription) {
        this.roomDescription = roomDescription;
    }
    public Set<Roombooking> getRoombookings() {
        return this.roombookings;
    }
    
    public void setRoombookings(Set<Roombooking> roombookings) {
        this.roombookings = roombookings;
    }




}


