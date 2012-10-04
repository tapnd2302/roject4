/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Typeimages;
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
public class createTypeImage implements Serializable{
    
    private String TypeImgName;
    private String TypeImgDescription;

    public String getTypeImgDescription() {
        return TypeImgDescription;
    }

    public void setTypeImgDescription(String TypeImgDescription) {
        this.TypeImgDescription = TypeImgDescription;
    }

    public String getTypeImgName() {
        return TypeImgName;
    }

    public void setTypeImgName(String TypeImgName) {
        this.TypeImgName = TypeImgName;
    }
    
    
    public createTypeImage() {
    }
    public String insertData(){
        Typeimages img = new Typeimages();
        img.setTypeName(TypeImgName);
        img.setTypeDescription(TypeImgDescription);
        ObjectHelper<Typeimages> obj = new HotelHelper<Typeimages>();
        try {
            obj.add(img);
        } catch (ObjectException ex) {
            Logger.getLogger(createTypeImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "listTypeImager.jsf?faces-redirect=true";
    }
    public String resetField(){
        this.TypeImgName = "";
        this.TypeImgDescription = "";
        return "createTypeImage.jsf?faces-redirect=true";
    }
}
