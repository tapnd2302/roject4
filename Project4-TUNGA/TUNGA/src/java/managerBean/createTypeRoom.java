/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Typerooms;
import exception.ObjectException;
import helper.ObjectHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author LOAN JURI
 */
@ManagedBean
@RequestScoped
public class createTypeRoom {

    private String nameTR;
    private double priceTR;
    private String desTR;

    public String getDesTR() {
        return desTR;
    }

    public void setDesTR(String desTR) {
        this.desTR = desTR;
    }

    public String getNameTR() {
        return nameTR;
    }

    public void setNameTR(String nameTR) {
        this.nameTR = nameTR;
    }

    public double getPriceTR() {
        return priceTR;
    }

    public void setPriceTR(double priceTR) {
        this.priceTR = priceTR;
    }
    /**
     * Creates a new instance of createTypeRoom
     */
    public createTypeRoom() {
        
    }
    
    public String btnsuccess(){
        Typerooms tr = new Typerooms();
        tr.setTypeRoomName(nameTR);
        tr.setTypeRoomPrice(priceTR);
        tr.setTypeRoomDescription(desTR);
        
        ObjectHelper<Typerooms> objHelperTR = new ObjectHelper<Typerooms>();
        try {
            objHelperTR.add(tr);
        } catch (ObjectException ex) {
            Logger.getLogger(createTypeRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesMessage msg = new FacesMessage("Success!"); 
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "createTypeRoom.jsf?faces-redirect=true";
    }
}
