/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.Roles;
import entity.Users;
import exception.ObjectException;
import helper.ObjectHelper;
import helper.UserHelper;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Administrator
 */
@ManagedBean
@ViewScoped
public class createUser {

    private Integer accountID;
    private Integer roleID;
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private Date birthday;
    private Integer gender;
    private String address;
    private String phone;
    private String email;
    private Integer allowLogin;
    private List<Roles> listRole;
    private Roles selectItem;

    public Roles getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(Roles selectItem) {
        this.selectItem = selectItem;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAllowLogin() {
        return allowLogin;
    }

    public void setAllowLogin(Integer allowLogin) {
        this.allowLogin = allowLogin;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Roles> getListRole() {
        return listRole;
    }

    public void setListRole(List<Roles> listRole) {
        this.listRole = listRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public createUser() {
        UserHelper<Roles> helper = new UserHelper<Roles>();
        listRole = helper.showRole();
    }

    public String insertData() {
        Users u = new Users();
        u.setRoles(selectItem);
        u.setUserName(userName);
        u.setUserPassword(passWord);
        u.setUserFirstName(userName);
        u.setUserLastName(userName);
        u.setUserBirthDay(birthday);
        boolean gd = (gender == 1) ? true : false;
        u.setUserGender(gd);
        u.setUserAddress(address);
        u.setUserPhone(userName);
        u.setUserEmail(userName);
        boolean allow = (allowLogin == 1) ? true : false;
        u.setAllowLogin(allow);

        ObjectHelper<Users> helper = new ObjectHelper<Users>();
        try {
            helper.add(u);
            return "Success";
        } catch (ObjectException ex) {
            Logger.getLogger(createUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "False";
    }

    public String resetField() {
        return "";
    }
}