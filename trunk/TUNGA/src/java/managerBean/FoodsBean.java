/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;


import entity.Foods;
import entity.Typefoods;
import helper.FoodsHelper;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author HP
 */
@ManagedBean
@RequestScoped
public class FoodsBean {
  
    private List<Foods> listF;
    private List<Foods> filteredCars;
    private Foods f;
    private int id;
    private Typefoods type;
    private String name;
    private String images;
    private Double price;
    private String description;
    
    public FoodsBean() {
      FoodsHelper<Foods> helper  = new FoodsHelper<Foods>();
      listF = helper.getFoods();
    }
    
    public void showF(){
        id = f.getFoodId();
        type = f.getTypefoods();
        name = f.getFoodName();
        images = f.getFoodImages();
        price = f.getFoodPrices();
        description =  f.getFoodDescription();
    }    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Foods getF() {
        return f;
    }

    public void setF(Foods f) {
        this.f = f;
    }

    public List<Foods> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Foods> filteredCars) {
        this.filteredCars = filteredCars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public List<Foods> getListF() {
        return listF;
    }

    public void setListF(List<Foods> listF) {
        this.listF = listF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Typefoods getType() {
        return type;
    }

    public void setType(Typefoods type) {
        this.type = type;
    }
    
}