package managerBean;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import entity.Foods;
import entity.Typeimages;
import helper.TypeImageHelper;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author KyHuu
 */
@ManagedBean
@RequestScoped
public class createImage implements Serializable{

    private Typeimages typeimages;
    private Integer id;
    private String descriptions;
    private String imageLink;
    private List<Typeimages> listType;
    private List<Foods> listFood;
    private String selectItem;
    private String TypeName;

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }
    

    public List<Foods> getListFood() {
        return listFood;
    }

    public void setListFood(List<Foods> listFood) {
        this.listFood = listFood;
    }

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
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String msgID = request.getParameter("ID");
        this.id = Integer.parseInt(msgID);
        String msgType = request.getParameter("type");
        TypeImageHelper<Typeimages> tHelper = new TypeImageHelper<Typeimages>();
        typeimages = tHelper.showTypeIMGCondition(msgType).get(0);
        TypeName = typeimages.getTypeName();
    }

    public String insertData() {
        return "";
    }

    public String resetField() {
        return "";
    }
}
