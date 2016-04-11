
package com.udea.jsf.captcha;

import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "captcha1")
@Dependent
public class Captcha {

    public Captcha() {
    }
     public void check(ActionEvent e){
        FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Su codigo es correcto!",null));
    }
}
