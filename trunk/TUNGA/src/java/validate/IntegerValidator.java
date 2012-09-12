/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Administrator
 */
public class IntegerValidator implements javax.faces.validator.Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        try {
            Integer.parseInt(o.toString());
        } catch(Exception e) {
            throw new ValidatorException(new FacesMessage("ban can phai nhap so"));
        }
    }
    
}
