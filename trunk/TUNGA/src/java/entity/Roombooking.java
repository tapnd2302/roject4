package entity;
// Generated Sep 5, 2012 10:40:14 PM by Hibernate Tools 3.2.1.GA



/**
 * Roombooking generated by hbm2java
 */
public class Roombooking  implements java.io.Serializable {


     private int bookingDetailsId;
     private Rooms rooms;
     private Booking booking;

    public Roombooking() {
    }

	
    public Roombooking(int bookingDetailsId) {
        this.bookingDetailsId = bookingDetailsId;
    }
    public Roombooking(int bookingDetailsId, Rooms rooms, Booking booking) {
       this.bookingDetailsId = bookingDetailsId;
       this.rooms = rooms;
       this.booking = booking;
    }
   
    public int getBookingDetailsId() {
        return this.bookingDetailsId;
    }
    
    public void setBookingDetailsId(int bookingDetailsId) {
        this.bookingDetailsId = bookingDetailsId;
    }
    public Rooms getRooms() {
        return this.rooms;
    }
    
    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }
    public Booking getBooking() {
        return this.booking;
    }
    
    public void setBooking(Booking booking) {
        this.booking = booking;
    }




}

