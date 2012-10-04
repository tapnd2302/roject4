/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Foods;
import entity.Images;
import helper.FoodsHelper;
import helper.ImagesHelper;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KyHuu
 */
@ManagedBean
@ViewScoped
public class saltyFood {
    private List<Foods> listSalty;
    private ArrayList<Images> listIMG;
    private Images selected;

    public Images getSelected() {
        return selected;
    }

    public void setSelected(Images selected) {
        this.selected = selected;
    }

    public ArrayList<Images> getListIMG() {
        return listIMG;
    }

    public void setListIMG(ArrayList<Images> listIMG) {
        this.listIMG = listIMG;
    }

    public List<Foods> getListSalty() {
        return listSalty;
    }

    public void setListSalty(List<Foods> listSalty) {
        this.listSalty = listSalty;
    }

    public saltyFood() {
        FoodsHelper<Foods> food = new FoodsHelper<Foods>();
        listSalty = food.getFoodsSalty();
        ImagesHelper<Images> img = new ImagesHelper<Images>();
        listIMG = new ArrayList<Images>();
        for(Foods f : listSalty){
            listIMG.add(img.showIMGConditional(f.getFoodId()));
        }
    }
}
