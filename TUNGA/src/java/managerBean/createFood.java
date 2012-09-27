/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Foods;
import entity.Typefoods;
import exception.ObjectException;
import helper.HotelHelper;
import helper.ObjectHelper;
import helper.TypeFoodHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KyHuu
 */
@ManagedBean
@ViewScoped
public class createFood {

    private List<Typefoods> listTypeFood;
    private String foodName;
    private Double foodPrices;
    private String foodDescription;
    private int foodStatus;
    private String selectItem;
    private Typefoods typeFood;

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getFoodPrices() {
        return foodPrices;
    }

    public void setFoodPrices(Double foodPrices) {
        this.foodPrices = foodPrices;
    }

    public int getFoodStatus() {
        return foodStatus;
    }

    public void setFoodStatus(int foodStatus) {
        this.foodStatus = foodStatus;
    }

    public List<Typefoods> getListTypeFood() {
        return listTypeFood;
    }

    public void setListTypeFood(List<Typefoods> listTypeFood) {
        this.listTypeFood = listTypeFood;
    }

    public String getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(String selectItem) {
        this.selectItem = selectItem;
        TypeFoodHelper<Typefoods> t = new TypeFoodHelper<Typefoods>();
        typeFood = t.showTypeFoodCondition(selectItem).get(0);
        
    }
    
    
    
    public createFood() {
        TypeFoodHelper<Typefoods> helper = new TypeFoodHelper<Typefoods>();
        listTypeFood = helper.showTypeFood();
        
    }
    public String insertData(){
        Foods f = new Foods();
        f.setFoodName(foodName);
        f.setFoodPrices(foodPrices);
        f.setTypefoods(typeFood);
        f.setFoodDescription(foodDescription);
        boolean status = (foodStatus == 0)? false : true;
        f.setFoodStatus(status);
        ObjectHelper<Foods> obj = new HotelHelper<Foods>();
        try {
            obj.add(f);
        } catch (ObjectException ex) {
            Logger.getLogger(createFood.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "listFood.jsf?faces-redirect=true";
    }
    public String resetField(){
        this.setFoodDescription("");
        this.setFoodName("");
        this.setFoodPrices(0.0);
        return "createFood.jsf?faces-redirect=true";
    }
}
