package entity;
// Generated Sep 27, 2012 7:29:24 AM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Typerooms generated by hbm2java
 */
public class Typerooms  implements java.io.Serializable {


     private int typeRoomId;
     private Serializable typeRoomName;
     private Double typeRoomPrice;
     private Serializable typeRoomDescription;
     private Set<Rooms> roomses = new HashSet<Rooms>(0);

    public Typerooms() {
    }

	
    public Typerooms(int typeRoomId) {
        this.typeRoomId = typeRoomId;
    }
    public Typerooms(int typeRoomId, Serializable typeRoomName, Double typeRoomPrice, Serializable typeRoomDescription, Set<Rooms> roomses) {
       this.typeRoomId = typeRoomId;
       this.typeRoomName = typeRoomName;
       this.typeRoomPrice = typeRoomPrice;
       this.typeRoomDescription = typeRoomDescription;
       this.roomses = roomses;
    }
   
    public int getTypeRoomId() {
        return this.typeRoomId;
    }
    
    public void setTypeRoomId(int typeRoomId) {
        this.typeRoomId = typeRoomId;
    }
    public Serializable getTypeRoomName() {
        return this.typeRoomName;
    }
    
    public void setTypeRoomName(Serializable typeRoomName) {
        this.typeRoomName = typeRoomName;
    }
    public Double getTypeRoomPrice() {
        return this.typeRoomPrice;
    }
    
    public void setTypeRoomPrice(Double typeRoomPrice) {
        this.typeRoomPrice = typeRoomPrice;
    }
    public Serializable getTypeRoomDescription() {
        return this.typeRoomDescription;
    }
    
    public void setTypeRoomDescription(Serializable typeRoomDescription) {
        this.typeRoomDescription = typeRoomDescription;
    }
    public Set<Rooms> getRoomses() {
        return this.roomses;
    }
    
    public void setRoomses(Set<Rooms> roomses) {
        this.roomses = roomses;
    }




}


