/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.jsf.controller;

import com.udea.logica.EnrolmentFacadeLocal;
import com.udea.modelo.Enrolment;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


@Named(value = "enrolmentBean")
@Dependent
public class EnrolmentBean implements Serializable {
    @EJB
    private EnrolmentFacadeLocal enrolmentFacade;
    
    private UIComponent mybutton;
    public UIComponent getMybutton() {
        return mybutton;
    }
    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }

    private int id;
    private long student;
    private String semester;
    private String program;
    private Date startingDate = new Date();
    boolean disable=true;
    
    public EnrolmentBean() {
    }
    
     public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
   
    String sSubCadena;
    String mensajecard;
    String m;

    public String getM(){
        return m;
    }
    public void setM(String m){
        this.m = m;
    }
    public String getMensajecard() { 
        return mensajecard;
    }
    public void setMensajecard(String mensajecard) {
        this.mensajecard = mensajecard;
    }
    public String getsSubCadena() {
        return sSubCadena;
    }
    public void setsSubCadena(String sSubCadena) {
        this.sSubCadena = sSubCadena;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public long getStudent() {
        return student;
    }
    public void setStudent(long student) {
        this.student = student;
    }
    public String getProgram() {
        return program;
    }
    public void setProgram(String program) {
        this.program = program;
    }
public Date getStartingDate() {
    return startingDate;
}
public void setStartingDate(Date startingDate) {
    this.startingDate = startingDate;
}
public String getSemester() {
    return semester;
}
public void setSemester(String semester) {
    this.semester = semester;
}

 //Acción para insertar el registro en la BD.  
public String guardar(){
     
     Enrolment p = new Enrolment();
     p.setId(id);
     //p.setStudent(student);
     p.setProgram(program);
     p.setSemester(semester);
     p.setStartingDate(startingDate);
     this.enrolmentFacade.create(p);
     m=this.getMensajecard();
     return "EnrolmentCreate";
}


//Permite Validar el tipo de tarjeta de crédito
//Validad el rango de los primeros 4 digitos según el tipo de Tarjeta Visa o Mastercard. Si esta en algún rango se activa el botón submit.  
/*
public String validar() {
     String sCadena;
     sCadena=String.valueOf(id);
     sSubCadena = sCadena.substring(0,4);
     int val=Integer.parseInt(sSubCadena);
     if(val>=0000 && val<=5555) {  
      FacesMessage message = new FacesMessage("TARJETA VISA");
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(mybutton.getClientId(context), message);
      mensajecard="Es VISA";
      disable=false;
       this.setMensajecard(mensajecard);
        return this.getMensajecard();
     } else if(val>=8000 && val<=9999) { System.out.println("El valor es MASTERCARD "); 
       FacesMessage message = new FacesMessage("TARJETA MASTERCARD");
       FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(mybutton.getClientId(context), message);
       mensajecard="Es MASTER CARD";
       disable=false;
       this.setMensajecard(mensajecard);
       return this.getMensajecard();
       }else {
        FacesMessage message = new FacesMessage("Invalid card");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(mybutton.getClientId(context), message);
          }
       return null;
    }
*/
//Para Internacionalización
private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
  public Locale getLocale() {
  return locale;
    }
 public String getLanguage() {
        return locale.getLanguage();
   }
 public void changeLanguage(String language) {
    locale = new Locale(language);
    FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
  }

}