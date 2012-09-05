package entity;
// Generated Sep 5, 2012 10:40:14 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;

/**
 * Images generated by hbm2java
 */
public class Images  implements java.io.Serializable {


     private int imageId;
     private Foods foods;
     private Rooms rooms;
     private Users users;
     private HotelRestaurant hotelRestaurant;
     private Integer typeImage;
     private Serializable descriptions;
     private Serializable imageLink;

    public Images() {
    }

	
    public Images(int imageId) {
        this.imageId = imageId;
    }
    public Images(int imageId, Foods foods, Rooms rooms, Users users, HotelRestaurant hotelRestaurant, Integer typeImage, Serializable descriptions, Serializable imageLink) {
       this.imageId = imageId;
       this.foods = foods;
       this.rooms = rooms;
       this.users = users;
       this.hotelRestaurant = hotelRestaurant;
       this.typeImage = typeImage;
       this.descriptions = descriptions;
       this.imageLink = imageLink;
    }
   
    public int getImageId() {
        return this.imageId;
    }
    
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public Foods getFoods() {
        return this.foods;
    }
    
    public void setFoods(Foods foods) {
        this.foods = foods;
    }
    public Rooms getRooms() {
        return this.rooms;
    }
    
    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    public HotelRestaurant getHotelRestaurant() {
        return this.hotelRestaurant;
    }
    
    public void setHotelRestaurant(HotelRestaurant hotelRestaurant) {
        this.hotelRestaurant = hotelRestaurant;
    }
    public Integer getTypeImage() {
        return this.typeImage;
    }
    
    public void setTypeImage(Integer typeImage) {
        this.typeImage = typeImage;
    }
    public Serializable getDescriptions() {
        return this.descriptions;
    }
    
    public void setDescriptions(Serializable descriptions) {
        this.descriptions = descriptions;
    }
    public Serializable getImageLink() {
        return this.imageLink;
    }
    
    public void setImageLink(Serializable imageLink) {
        this.imageLink = imageLink;
    }




}


