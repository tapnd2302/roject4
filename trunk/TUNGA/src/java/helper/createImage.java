/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entity.Typeimages;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author KyHuu
 */
@ManagedBean
@RequestScoped
public class createImage {

    private Typeimages typeimages;
    private Integer id;
    private String descriptions;
    private String imageLink;
    private List<Typeimages> listType;
    private String selectItem;

    public List<Typeimages> getListType() {
        return listType;
    }

    public void setListType(List<Typeimages> listType) {
        this.listType = listType;
    }

    public String getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(String selectItem) {
        this.selectItem = selectItem;
    }
    

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Typeimages getTypeimages() {
        return typeimages;
    }

    public void setTypeimages(Typeimages typeimages) {
        this.typeimages = typeimages;
    }

    public createImage() {
        TypeImageHelper<Typeimages> helper = new TypeImageHelper<Typeimages>();
        
        listType = helper.showTypeIMG();
        
    }
    
    public String insertData(){
        return "";
    }
    public String resetField(){
        return "";
    }
}
