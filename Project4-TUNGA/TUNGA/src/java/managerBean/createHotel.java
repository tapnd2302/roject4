/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;



import entity.HotelRestaurant;
import entity.Images;
import entity.Typeimages;
import exception.ObjectException;
import helper.HotelHelper;
import helper.ObjectHelper;
import helper.TypeImageHelper;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import org.primefaces.event.FileUploadEvent;
import sun.misc.Cleaner;

@ManagedBean
@ViewScoped
public class createHotel {
    private String _name;
    private String _Address;
    private String _phone;
    private String _email;
    private String _info;

    int idHotel;
    private  List<String> listname;
    private List<Images> listImg;
    private Images selectedImg;
    private String _desImg;
    
    
    public List<Images> getListImg() {
        return listImg;
    }

    public void setListImg(List<Images> listImg) {
        this.listImg = listImg;
    }
    public String getDesImg() {
        return _desImg;
    }

    public void setDesImg(String _desImg) {
        this._desImg = _desImg;
    }

    public Images getSelectedImg() {
        return selectedImg;
    }

    public void setSelectedImg(Images selectedImg) {
        this.selectedImg = selectedImg;
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

        listImg = new ArrayList<Images>();
        listname = new ArrayList<String>();
    }
    
    public void newHotel(){
        HotelRestaurant hr = new HotelRestaurant();
        hr.setHrname(_name);
        hr.setHraddress(_Address);
        hr.setHremail(_email);
        hr.setHrphone(_phone);
        hr.setHrinfo(_info);
        hr.setHrstatus(true);
        ObjectHelper<HotelRestaurant> OHP = new ObjectHelper<HotelRestaurant>();
        try {
            OHP.add(hr);
            idHotel = hr.getHrid();
        } catch (ObjectException ex) {
            Logger.getLogger(createHotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /***************** Button Create Hotel ****************/
    public void btnsuccess(){
        newHotel();
        TypeImageHelper<Typeimages> tHelper = new TypeImageHelper<Typeimages>();
        if (!listname.isEmpty()) {
            for (String str : listname) {
                Images img = new Images();
                img.setTypeimages(tHelper.showTypeIMGCondition("2").get(0));
                img.setId(idHotel);
                img.setImageLink(str);
                listImg.add(img);
            }
            ObjectHelper<Images> OHPImages = new ObjectHelper<Images>();
            try {
                
                OHPImages.addList(listImg);
            } catch (ObjectException ex) {
                Logger.getLogger(createHotel.class.getName()).log(Level.SEVERE, null, ex);
            }
            listname.clear();
            listImg.clear();
        }

        FacesMessage msg = new FacesMessage("Success! " + _name + " is Created"); 
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        _Address = null;
        _email = null;
        _info = null;
        _name = null;
        _phone = null;
    }
    
//    public void addDesImg(){
//        ObjectHelper<Images> helperImg = new HotelHelper<Images>();
//        selectedImg.setDescriptions(_desImg);
//        try {
//            helperImg.update(selectedImg);
//        } catch (ObjectException ex) {
//            Logger.getLogger(hotelManager.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        FacesMessage msg = new FacesMessage("Success");
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
    
    public String ok(){
        FacesMessage msg = new FacesMessage("Successful");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "success";
    }
    
    public String resetField(){
        if (!listname.isEmpty()) {
            for (String str : listname) {
                File f = new File(destination +File.separator+ "images" +File.separator+ "hotel" +File.separator+ str);
                f.delete();
            }
            listname.clear();
            listImg.clear();
        }
        _Address = null;
        _email = null;
        _info = null;
        _name = null;
        _phone = null;
        return "createHotel.jsf?faces-redirect=true";
    }
    

    private String destination = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
    public void saveimage(FileUploadEvent event){
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
            fileName = sdf.format(cal.getTime()) + Integer.toString(rd.nextInt(100)) + fileName;
            
            OutputStream out = new FileOutputStream(new File(destination +File.separator+ "images" +File.separator+ "hotel" +File.separator+ fileName));
            int read = 0; 
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
            listname.add(fileName);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
