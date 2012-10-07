
package managerBean;

import entity.Typetable;
import exception.ObjectException;
import helper.ObjectHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped
public class createTypeTable {
    private String nameTB;
    private double priceTB;
    private String desTB;

    public String getDesTB() {
        return desTB;
    }

    public void setDesTB(String desTB) {
        this.desTB = desTB;
    }

    public String getNameTB() {
        return nameTB;
    }

    public void setNameTB(String nameTB) {
        this.nameTB = nameTB;
    }

    public double getPriceTB() {
        return priceTB;
    }

    public void setPriceTB(double priceTB) {
        this.priceTB = priceTB;
    }
    
    public createTypeTable() {
    }
    
    public void btnsuccess(){
        Typetable tb = new Typetable();
        tb.setTypeTableName(nameTB);
        tb.setTypeTableDescription(desTB);
        tb.setTablePrice(priceTB);
        
        
        ObjectHelper<Typetable> objHelperTB = new ObjectHelper<Typetable>();
        try {
            objHelperTB.add(tb);
        } catch (ObjectException ex) {
            Logger.getLogger(createTypeRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesMessage msg = new FacesMessage("Success!"); 
        FacesContext.getCurrentInstance().addMessage(null, msg);
        nameTB = null;
        desTB = null;
        priceTB = 0;
    }
    
    public void resetField(){
        nameTB = null;
        desTB = null;
        priceTB = 0;
    }
}
