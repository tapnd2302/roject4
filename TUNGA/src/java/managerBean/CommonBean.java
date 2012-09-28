/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author LOAN JURI
 */
@ManagedBean
@SessionScoped
public class CommonBean {

    /**
     * Creates a new instance of CommonBean
     */
    public CommonBean() {
    }
    
    public String getUrl(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(request.getServerName());
        sb.append(":");
        sb.append(request.getServerPort());
        
        sb.append(request.getContextPath());
        
    return sb.toString();
    }
}
