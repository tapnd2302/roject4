/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author KyHuu
 */
@ManagedBean
@ViewScoped
public class loginAdmin implements Serializable{

    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    public loginAdmin() {
    }
    
    public String submit(){
        return "";
    }
}
