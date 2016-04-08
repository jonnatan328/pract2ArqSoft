/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.jsf.controller;

import com.udea.logica.StudentFacadeLocal;
import com.udea.modelo.Student;
import java.util.Locale;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author acerpc
 */
@Named(value = "studentBean")
@Dependent
public class StudentBean {
    @EJB
    private StudentFacadeLocal studentFacade;
    
    public StudentBean() {
    }
    
    private UIComponent mybutton;
    public UIComponent getMybutton() {
        return mybutton;
    }
    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }
    
    private long id;
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private int stratum;
    boolean disable=true;
    
    
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
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
     public int getStratum() {
        return stratum;
    }
    public void setStratum(int stratum) {
        this.stratum = stratum;
    }
    
    //Acción para insertar el registro en la BD.  
    public String guardar(){

         Student s = new Student();
         s.setId(id);
         s.setName(name);
         s.setLastName(lastName);
         s.setPhone(phone);
         s.setAddress(address);
         s.setStratum(stratum);
         this.studentFacade.create(s);
         m=this.getMensajecard();
         return "StudentCreate";
    }
    
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