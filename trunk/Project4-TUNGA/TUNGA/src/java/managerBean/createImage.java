package managerBean;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import entity.Foods;
import entity.Images;
import entity.Typeimages;
import exception.ObjectException;
import helper.ObjectHelper;
import helper.TypeImageHelper;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author KyHuu
 */
@ManagedBean
@ViewScoped
public class createImage implements Serializable {

    private Typeimages typeimages;
    private Integer id;
    private String descriptions;
    private String imageLink;
    private List<Typeimages> listType;
    private List<Foods> listFood;
    private String selectItem;
    private String TypeName;
    private List<String> listname;
    private List<Images> listImg;

    public List<Images> getListImg() {
        return listImg;
    }

    public void setListImg(List<Images> listImg) {
        this.listImg = listImg;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<String> getListname() {
        return listname;
    }

    public void setListname(List<String> listname) {
        this.listname = listname;
    }

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
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String msgID = request.getParameter("ID");
        id = Integer.parseInt(msgID);
        String msgType = request.getParameter("type");
        TypeImageHelper<Typeimages> tHelper = new TypeImageHelper<Typeimages>();
        typeimages = tHelper.showTypeIMGCondition(msgType).get(0);
        TypeName = typeimages.getTypeName();
    }

    public String insertData() {

        return "listImage.jsf?faces-redirect=true";
    }

    public String resetField() {
        return "";
    }
    private String destination = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");

    public void saveimage(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Success! " + event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);

        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void copyFile(String fileName, InputStream in) {
        ObjectHelper<Images> OHPImages = new ObjectHelper<Images>();
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
            Random rd = new Random();
            fileName = sdf.format(cal.getTime()) + Integer.toString(rd.nextInt(100)) + fileName;

            OutputStream out = new FileOutputStream(new File(destination + File.separator + "images" + File.separator + "hotel" + File.separator + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
//            listname.add(fileName);
            Images img = new Images();
            img.setTypeimages(typeimages);
            img.setId(id);
            img.setImageLink(fileName);
            try {
                OHPImages.add(img);
    //            listImg.add(img);
            } catch (ObjectException ex) {
                Logger.getLogger(createImage.class.getName()).log(Level.SEVERE, null, ex);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
