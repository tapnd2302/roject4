/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBean;

import entity.*;
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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author LOAN JURI
 */
@ManagedBean
@ViewScoped
public class createRoom {

    private List<HotelRestaurant> listHr;
    private List<Typerooms> listTypeRoom;
    
    private int selectedHrid;
    private int selectedTypeRoomid;
    private String desRoom;
    private  List<String> listname;
    private List<Images> listImg;
     int idRoom = 0;
    

    

    public String getDesRoom() {
        return desRoom;
    }

    public void setDesRoom(String desRoom) {
        this.desRoom = desRoom;
    }
    
    
    public List<Typerooms> getListTypeRoom() {
        return listTypeRoom;
    }

    public void setListTypeRoom(List<Typerooms> listTypeRoom) {
        this.listTypeRoom = listTypeRoom;
    }

    public int getSelectedHrid() {
        return selectedHrid;
    }

    public void setSelectedHrid(int selectedHrid) {
        this.selectedHrid = selectedHrid;
    }

    public int getSelectedTypeRoomid() {
        return selectedTypeRoomid;
    }

    public void setSelectedTypeRoomid(int selectedTypeRoomid) {
        this.selectedTypeRoomid = selectedTypeRoomid;
    }

    public List<HotelRestaurant> getListHr() {
        return listHr;
    }

    public void setListHr(List<HotelRestaurant> listHr) {
        this.listHr = listHr;
    }



    public createRoom() {
        HotelHelper<HotelRestaurant> helperHr = new HotelHelper<HotelRestaurant>();
        listHr = helperHr.showHR();
        HotelHelper<Typerooms> helperTr = new HotelHelper<Typerooms>();
        listTypeRoom = helperTr.showTypeRoom();
        listImg = new ArrayList<Images>();
        listname = new ArrayList<String>();
        
    }

    public void newRoom(){
        Rooms room = new Rooms();
        room.setHrid(selectedHrid);
        room.setTyperooms(selectedTypeRoomid);
        room.setRoomStatus(true);
        room.setRoomDescription(desRoom);
        ObjectHelper<Rooms> objHelperRoom = new ObjectHelper<Rooms>();
        try {
            objHelperRoom.add(room);
            idRoom = room.getRoomId();
        } catch (ObjectException ex) {
            Logger.getLogger(createRoom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    public String btnsuccess(){
        newRoom();
        TypeImageHelper<Typeimages> tHelper = new TypeImageHelper<Typeimages>();
        if (!listname.isEmpty()) {
            for (String str : listname) {
                Images img = new Images();
                img.setTypeimages(tHelper.showTypeIMGCondition("3").get(0));
                img.setId(idRoom);
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
        FacesMessage msg = new FacesMessage("Success!"); 
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "createRoom.jsf?faces-redirect=true";
    }
    
    public String resetField(){
        return "createRoom.jsf?faces-redirect=true";
        
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
