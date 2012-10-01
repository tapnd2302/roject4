/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Foods;
import entity.ProductItem;
import entity.Typeimages;
import exception.ObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author HP
 */
@ManagedBean
@SessionScoped
public class CartBean {
    private Foods selectItem;

    private List<ProductItem> listP;
    private ProductItem filteredCars;
    private Map<String, String> parameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    public CartBean() {
        listP = new ArrayList<ProductItem>();
        System.out.println("CartBean()=================================================================");
    }

    public void addCart() {
        try {
            int exist = 0;
            int quantity = 1;
            int id = selectItem.getFoodId();
            String name = selectItem.getFoodName();
            String image = selectItem.getFoodImages();
            double price = selectItem.getFoodPrices();
            for (ProductItem p : listP) {
                if (p.getProdID() == selectItem.getFoodId()) {
                    p.setQuantity(p.getQuantity() + 1);
                    exist = 1;
                    return;
                }
            }
            if (exist == 0) {
                ProductItem product = new ProductItem(id, name, image, price, quantity);
                listP.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateCart(RowEditEvent event){
       try {
            int id = filteredCars.getProdID();
             for (ProductItem p : listP) {
                  if(p.getProdID() == id){
                    p.setQuantity(1);        
                  }
             }
        } catch (Exception ex) {
             Logger.getLogger(roleManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesMessage msg = new FacesMessage("Edit Comleted", ((ProductItem) event.getObject()).getProdName());
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    public void removeCart(){
        listP.remove(this);
        
    }
    
    public void removeItems(    ) {
        int id = filteredCars.getProdID();
        for (int i = 0; i < listP.size(); i++) {
             if(listP.get(i).getProdID() == id){
                 listP.remove(i);
             }
        }
    }
    public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((ProductItem) event.getObject()).getProdName(
                ));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<ProductItem> getListP() {
        return listP;
    }

    public void setListP(List<ProductItem> listP) {
        this.listP = listP;
    }

    public ProductItem getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(ProductItem filteredCars) {
        this.filteredCars = filteredCars;
    }
    
     public Foods getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(Foods selectItem) {
        this.selectItem = selectItem;
    }
}
