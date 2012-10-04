/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KyHuu
 */
@ManagedBean
@ViewScoped
public class defaultIndex implements Serializable{

    private List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
 
    
    
    public defaultIndex() {
        images = new ArrayList<String>();  
  
        for(int i=1;i<=6;i++) {  
            images.add(i + ".jpg");  
        } 
        
    }
}
