package entity;
// Generated Sep 5, 2012 10:40:14 PM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * HotelRestaurant generated by hbm2java
 */
public class HotelRestaurant  implements java.io.Serializable {


     private int hrid;
     private Serializable hrname;
     private Serializable hraddress;
     private Serializable hrphone;
     private Serializable hremail;
     private Serializable hrinfo;
     private Serializable hrimage;
     private Boolean hrstatus;
     private Set<Images> imageses = new HashSet<Images>(0);
     private Set<Booking> bookings = new HashSet<Booking>(0);

    public HotelRestaurant() {
    }

	
    public HotelRestaurant(int hrid) {
        this.hrid = hrid;
    }
    public HotelRestaurant(int hrid, Serializable hrname, Serializable hraddress, Serializable hrphone, Serializable hremail, Serializable hrinfo, Serializable hrimage, Boolean hrstatus, Set<Images> imageses, Set<Booking> bookings) {
       this.hrid = hrid;
       this.hrname = hrname;
       this.hraddress = hraddress;
       this.hrphone = hrphone;
       this.hremail = hremail;
       this.hrinfo = hrinfo;
       this.hrimage = hrimage;
       this.hrstatus = hrstatus;
       this.imageses = imageses;
       this.bookings = bookings;
    }
   
    public int getHrid() {
        return this.hrid;
    }
    
    public void setHrid(int hrid) {
        this.hrid = hrid;
    }
    public Serializable getHrname() {
        return this.hrname;
    }
    
    public void setHrname(Serializable hrname) {
        this.hrname = hrname;
    }
    public Serializable getHraddress() {
        return this.hraddress;
    }
    
    public void setHraddress(Serializable hraddress) {
        this.hraddress = hraddress;
    }
    public Serializable getHrphone() {
        return this.hrphone;
    }
    
    public void setHrphone(Serializable hrphone) {
        this.hrphone = hrphone;
    }
    public Serializable getHremail() {
        return this.hremail;
    }
    
    public void setHremail(Serializable hremail) {
        this.hremail = hremail;
    }
    public Serializable getHrinfo() {
        return this.hrinfo;
    }
    
    public void setHrinfo(Serializable hrinfo) {
        this.hrinfo = hrinfo;
    }
    public Serializable getHrimage() {
        return this.hrimage;
    }
    
    public void setHrimage(Serializable hrimage) {
        this.hrimage = hrimage;
    }
    public Boolean getHrstatus() {
        return this.hrstatus;
    }
    
    public void setHrstatus(Boolean hrstatus) {
        this.hrstatus = hrstatus;
    }
    public Set<Images> getImageses() {
        return this.imageses;
    }
    
    public void setImageses(Set<Images> imageses) {
        this.imageses = imageses;
    }
    public Set<Booking> getBookings() {
        return this.bookings;
    }
    
    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }




}


