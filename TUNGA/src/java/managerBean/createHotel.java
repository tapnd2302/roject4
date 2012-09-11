/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;



import entity.HotelRestaurant;
import exception.ObjectException;
import helper.ObjectHelper;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.tomcat.jni.FileInfo;
import org.primefaces.event.FileUploadEvent;

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
    HotelRestaurant hr = new HotelRestaurant();
    List<String> linkImg = null;
    
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
        hr.setHrname(_name);
        hr.setHraddress(_Address);
        hr.setHremail(_email);
        hr.setHrphone(_phone);
        hr.setHrinfo(_info);
        hr.setHrstatus(true);
        check = false;
        checkUp = true;
    }
    public String success(){
        ObjectHelper<HotelRestaurant> OHP = new ObjectHelper<HotelRestaurant>();
        try {
            OHP.add(hr);
            
            
            
            
        } catch (ObjectException ex) {
            Logger.getLogger(createHotel.class.getName()).log(Level.SEVERE, null, ex);
            return "false";
        }
        return "success";
    }
    public void back(){
        hr = new HotelRestaurant();
        check = true;
        checkUp = false;
    }
    
    
    public void delImage(){
        File f = new File(destination + nameImage);
        f.delete();
        
    }
    
    private String nameImage = "";
    private String destination= FacesContext.getCurrentInstance().getExternalContext().getRealPath("images/hotel/hotel");
    public void saveImage(FileUploadEvent event){
        
        FacesMessage msg = new FacesMessage("Success! " + event.getFile().getFileName() + " is uploaded."); 
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void copyFile(String fileName, InputStream in) {

        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
            Random rd = new Random();
            nameImage = sdf.format(cal.getTime()) + Integer.toString(rd.nextInt(100)) + fileName;
            OutputStream out = new FileOutputStream(new File(destination + nameImage));
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            linkImg.add(nameImage);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
