package entity;
// Generated Sep 20, 2012 1:15:31 AM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;
import java.util.Date;

/**
 * Bookingparty generated by hbm2java
 */
public class Bookingparty  implements java.io.Serializable {


     private int id;
     private String fullName;
     private String email;
     private String phone;
     private String address;
     private Integer scale;
     private Date time;
     private String conntent;

    public Bookingparty() {
    }

	
    public Bookingparty(int id) {
        this.id = id;
    }
    public Bookingparty(int id, String fullName, String email, String phone, String address, Integer scale, Date time, String conntent) 
    {
       this.id = id;
       this.fullName = fullName;
       this.email = email;
       this.phone = phone;
       this.address = address;
       this.scale = scale;
       this.time = time;
       this.conntent = conntent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConntent() {
        return conntent;
    }

    public void setConntent(String conntent) {
        this.conntent = conntent;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}


