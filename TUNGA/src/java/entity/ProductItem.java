/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public final class ProductItem implements java.io.Serializable {
    private int prodID;
    private String prodName;
    private String proImage;
    private double price;
    private int quantity;

    public ProductItem() {
    }
    public ProductItem(int prodID, String prodName,String proImage,double price, int quantity) {
        setProdID(prodID);
        setProdName(prodName);
        setProImage(proImage);
        setPrice(price);
        setQuantity(quantity);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

}
