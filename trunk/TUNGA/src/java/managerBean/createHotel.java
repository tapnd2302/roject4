/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;


import helper.Role;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class createHotel {
    private String _name;
    private String _Address;
    private String _phone;
    private String _email;
    private String _info;
    private boolean check;
    private boolean checkUp;

    public boolean isCheckUp() {
        return checkUp;
    }

    public void setCheckUp(boolean checkUp) {
        this.checkUp = checkUp;
    }
    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getAddress() {
        return _Address;
    }

    public void setAddress(String _Address) {
        this._Address = _Address;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getInfo() {
        return _info;
    }

    public void setInfo(String _info) {
        this._info = _info;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getPhone() {
        return _phone;
    }

    public void setPhone(String _phone) {
        this._phone = _phone;
    }

    public createHotel() {
        check = true;
        checkUp = false;
    }
    
    public void newHotel(){
        check = false;
        checkUp = true;
    }
    public String success(){
        Role r = new Role();
        if (r.insertHotel(_name, _Address, _phone, _email, _info) != null) {
            _name = null;
            _Address = null;
            _phone = null;
            _email = null;
            _info = null;
            return "success";
        } else {
            return "false";
        }
    }
    public void back(){
        check = true;
        checkUp = false;
    }
}
