package entity;
// Generated Sep 27, 2012 7:29:24 AM by Hibernate Tools 3.2.1.GA



/**
 * HomedeliveryDetails generated by hbm2java
 */
public class HomedeliveryDetails  implements java.io.Serializable {


     private int deliveryDetailsId;
     private Foods foods;
     private Homedelivery homedelivery;
     private Integer quantity;
     private Double subTotal;

    public HomedeliveryDetails() {
    }

	
    public HomedeliveryDetails(int deliveryDetailsId) {
        this.deliveryDetailsId = deliveryDetailsId;
    }
    public HomedeliveryDetails(int deliveryDetailsId, Foods foods, Homedelivery homedelivery, Integer quantity, Double subTotal) {
       this.deliveryDetailsId = deliveryDetailsId;
       this.foods = foods;
       this.homedelivery = homedelivery;
       this.quantity = quantity;
       this.subTotal = subTotal;
    }
   
    public int getDeliveryDetailsId() {
        return this.deliveryDetailsId;
    }
    
    public void setDeliveryDetailsId(int deliveryDetailsId) {
        this.deliveryDetailsId = deliveryDetailsId;
    }
    public Foods getFoods() {
        return this.foods;
    }
    
    public void setFoods(Foods foods) {
        this.foods = foods;
    }
    public Homedelivery getHomedelivery() {
        return this.homedelivery;
    }
    
    public void setHomedelivery(Homedelivery homedelivery) {
        this.homedelivery = homedelivery;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getSubTotal() {
        return this.subTotal;
    }
    
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }




}


