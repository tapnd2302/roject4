package entity;
// Generated Sep 27, 2012 7:29:24 AM by Hibernate Tools 3.2.1.GA


import java.io.Serializable;

/**
 * Images generated by hbm2java
 */
public class Images  implements java.io.Serializable {


     private int imageId;
     private Typeimages typeimages;
     private Integer id;
     private String descriptions;
     private String imageLink;

    public Images() {
    }

	
    public Images(int imageId) {
        this.imageId = imageId;
    }
    public Images(int imageId, Typeimages typeimages, Integer id, String descriptions, String imageLink) {
       this.imageId = imageId;
       this.typeimages = typeimages;
       this.id = id;
       this.descriptions = descriptions;
       this.imageLink = imageLink;
    }
   
    public int getImageId() {
        return this.imageId;
    }
    
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public Typeimages getTypeimages() {
        return this.typeimages;
    }
    
    public void setTypeimages(Typeimages typeimages) {
        this.typeimages = typeimages;
    }
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescriptions() {
        return this.descriptions;
    }
    
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    public String getImageLink() {
        return this.imageLink;
    }
    
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }




}


