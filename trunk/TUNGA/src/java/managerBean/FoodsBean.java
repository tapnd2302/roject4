/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;


import entity.Foods;
import entity.Images;
import entity.Typefoods;
import entity.Typeimages;
import helper.FoodsHelper;
<<<<<<< .mine
import helper.ImagesHelper;
import helper.TypeFoodHelper;
import helper.TypeImageHelper;
import java.awt.Image;
=======
>>>>>>> .r48
import java.util.ArrayList;
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
<<<<<<< .mine
=======
  
    private List<Foods> listF;
    private List<Foods> filteredCars;
    private Foods f;
    private int id;
    private Typefoods type;
    private String name;
    private String images;
    private Double price;
    private String description;
>>>>>>> .r48
    
<<<<<<< .mine
    private List<Images> listIMG;
    private List<Foods> listFood;
    private Images selected;
    private List<Foods> listVegetable;
=======
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
>>>>>>> .r48

    public List<Foods> getListVegetable() {
        return listVegetable;
    }

    public void setListVegetable(List<Foods> listVegetable) {
        this.listVegetable = listVegetable;
    }

    public Images getSelected() {
        return selected;
    }

    public void setSelected(Images selected) {
        this.selected = selected;
    }

    public List<Foods> getListFood() {
        return listFood;
    }

    public void setListFood(List<Foods> listFood) {
        this.listFood = listFood;
    }

    public List<Images> getListIMG() {
        return listIMG;
    }

    public void setListIMG(List<Images> listIMG) {
        this.listIMG = listIMG;
    }

    public FoodsBean() {
        FoodsHelper<Foods> food = new FoodsHelper<Foods>();
        listVegetable = food.getFoodsVegetable();
        ImagesHelper<Images> img = new ImagesHelper<Images>();
        listIMG = new ArrayList<Images>();
        for(Foods f : listVegetable){
            listIMG.add(img.showIMGConditional(f.getFoodId()));
        }
    }
}