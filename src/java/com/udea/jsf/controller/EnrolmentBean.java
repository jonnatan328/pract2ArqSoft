/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.jsf.controller;

import com.udea.logica.EnrolmentFacadeLocal;
import com.udea.modelo.Enrolment;
import com.udea.modelo.Student;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;


@Named(value = "enrolmentBean")
@Dependent
public class EnrolmentBean implements Serializable {
    @EJB
    private EnrolmentFacadeLocal enrolmentFacade;
    
    private UIComponent mybutton;
    @ManagedProperty(value="#{StudentBean}")
    StudentBean studentBean;
    
    public UIComponent getMybutton() {
        return mybutton;
    }
    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }

    private int id;
    private Student student;
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
    String mensajeExist;
    String m;

    public String getM(){
        return m;
    }
    public void setM(String m){
        this.m = m;
    }
    public String getMensajeExist() { 
        return mensajeExist;
    }
    public void setMensajecard(String mensajecard) {
        this.mensajeExist = mensajeExist;
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
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
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

 //AcciÃ³n para insertar el registro en la BD.  
public String guardar(){
     //FacesContext facesContext = FacesContext.getCurrentInstance();
     //studentBean = facesContext.getApplication().evaluateExpressionGet(facesContext,"#{StudentBean}", StudentBean.class);
     //student=studentBean.createStudent();
     Enrolment p = new Enrolment();
     p.setId(id);
     p.setStudent(student);
     p.setProgram(program);
     p.setSemester(semester);
     p.setStartingDate(startingDate);
     this.enrolmentFacade.create(p);
     m=this.getMensajeExist();
     return "EnrolmentCreate";
}


//Permite Validar el tipo de tarjeta de crÃ©dito
//Validad el rango de los primeros 4 digitos segÃºn el tipo de Tarjeta Visa o Mastercard. Si esta en algÃºn rango se activa el botÃ³n submit.  
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
//Para InternacionalizaciÃ³n
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
