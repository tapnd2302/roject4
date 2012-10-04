/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Users;
import helper.UserHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author KyHuu
 */
@ManagedBean
@ViewScoped
public class indexMaster implements Serializable{

    private String userN;
    private String pass;
    private String userName;
    private List<Users> u;
    private boolean login;

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public List<Users> getU() {
        return u;
    }

    public void setU(List<Users> u) {
        this.u = u;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserN() {
        return userN;
    }

    public void setUserN(String userN) {
        this.userN = userN;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    

    public indexMaster() {
        Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        
        if(session.get("UserLogin") == null){
            login = false;
        }
        else{
            login = true;
            Users a = (Users) session.get("UserLogin");
            setUserName(a.getUserName());
        }
    }

    public void submit() {
        UserHelper<Users> user = new UserHelper<Users>();
        u = user.showUsersLogin(userN, pass);
        if (u.size() > 0) {
            Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
            session.put("UserLogin", u.get(0));
            System.out.println("----------------- login");
            System.out.println(u.get(0).getAccountId());
            setLogin(true);
        } else {
            System.out.println("-----------------");
        }
    }
}
