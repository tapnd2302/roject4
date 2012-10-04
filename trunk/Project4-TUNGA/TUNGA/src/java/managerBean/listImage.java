/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Images;
import helper.ImagesHelper;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KyHuu
 */
@ManagedBean
@ViewScoped
public class listImage implements Serializable{

    private List<Images> listIMG;
    private Images selected;

    public Images getSelected() {
        return selected;
    }

    public void setSelected(Images selected) {
        this.selected = selected;
    }
    
    public List<Images> getListIMG() {
        return listIMG;
    }

    public void setListIMG(List<Images> listIMG) {
        this.listIMG = listIMG;
    }

   
    
    public listImage() {
        ImagesHelper<Images> helper = new ImagesHelper<Images>();
        listIMG = helper.showIMG();
    }
}
