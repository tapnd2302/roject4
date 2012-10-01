/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Typefoods;
import exception.ObjectException;
import helper.HotelHelper;
import helper.ObjectHelper;
import java.io.Serializable;
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
public class createTypeFood implements Serializable{
    private String typeFoodName;
    private String typeFoodDescription;

    public String getTypeFoodDescription() {
        return typeFoodDescription;
    }

    public void setTypeFoodDescription(String typeFoodDescription) {
        this.typeFoodDescription = typeFoodDescription;
    }

    public String getTypeFoodName() {
        return typeFoodName;
    }

    public void setTypeFoodName(String typeFoodName) {
        this.typeFoodName = typeFoodName;
    }
    
    public createTypeFood() {
    }
    public String insertData(){
        Typefoods type= new Typefoods();
        type.setTypeFoodName(typeFoodName);
        type.setTypeFoodDescription(typeFoodDescription);
        ObjectHelper<Typefoods> obj = new HotelHelper<Typefoods>();
        try {
            obj.add(type);
        } catch (ObjectException ex) {
            Logger.getLogger(createTypeFood.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "listFood.jsf?faces-redirect=true";
    }
    public String resetField(){
        this.typeFoodName = "";
        this.typeFoodDescription = "";
        return "createFood.jsf?faces-redirect=true";
    }
}
