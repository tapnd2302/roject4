/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;  
  
import org.primefaces.event.map.OverlaySelectEvent;  
import org.primefaces.model.map.DefaultMapModel;  
import org.primefaces.model.map.LatLng;  
import org.primefaces.model.map.MapModel;  
import org.primefaces.model.map.Marker;  
  

/**
 *
 * @author HP
 */
@ManagedBean
@RequestScoped
public class MapBean {
    private MapModel advancedModel;  
  
    private Marker marker;  
  
    public MapBean() {  
        advancedModel = new DefaultMapModel();  
          
        //Shared coordinates  
        LatLng coord1 = new LatLng(36.129504,-115.16496);    
          
        //Icons and Data  
        advancedModel.addOverlay(new Marker(coord1,"", "", "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));  
        
    }  
  
    public MapModel getAdvancedModel() {  
        return advancedModel;  
    }  
      
    public void onMarkerSelect(OverlaySelectEvent event) {  
        marker = (Marker) event.getOverlay();  
    }  
      
    public Marker getMarker() {  
        return marker;  
    }  
}
