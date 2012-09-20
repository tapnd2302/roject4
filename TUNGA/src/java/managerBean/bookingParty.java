

package managerBean;
import entity.Bookingparty;
import exception.ObjectException;
import helper.PartyHelper;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import javax.faces.context.FacesContext;

/**
 *
 * @author 
 */
@ManagedBean
@RequestScoped
public class bookingParty  {

   

    private String fullName;
    private String email;
    private String phone;
    private String address;
    private int scale;
    private Date time;
    private String content;
    public bookingParty() {
        
    }
    public void add(){
       Bookingparty bk = new Bookingparty();
       bk.setFullName(fullName);
       bk.setEmail(email);
       bk.setPhone(phone);
       bk.setAddress(address);
       bk.setScale(scale);
       bk.setTime(time);
       bk.setConntent(content);
       PartyHelper<Bookingparty> ph = new PartyHelper<Bookingparty>();
        try {
            ph.add(bk);
            FacesMessage msg = new FacesMessage("Action Success");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (ObjectException ex) {
            FacesMessage msg = new FacesMessage("Action Error, Because " + ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);  
        }      
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
  
}
