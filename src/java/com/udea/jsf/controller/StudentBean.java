package com.udea.jsf.controller;

import com.udea.logica.StudentsFacadeLocal;
import com.udea.modelo.Students;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

@ManagedBean(name = "student")
@SessionScoped
public class StudentBean implements Serializable {

    @EJB
    private StudentsFacadeLocal studentsFacade;

    private UIComponent mybutton;

    private long id;
    private String name;
    private String lastName;
    private String program;
    private String phone;
    private String address;
    private int stratum;
    boolean disable = true;
    
    private Students student;

    private List<String> availablePrograms;

    String sSubCadena;
    String mensajecard;
    String m;

    public StudentBean() {
    }

    @PostConstruct
    public void init() {
        availablePrograms = new ArrayList<String>();
        availablePrograms.add("Ingenieria de sistemas");
        availablePrograms.add("Ingenieria industrial");
        availablePrograms.add("Ingenieria telecomunicaciones");
        availablePrograms.add("Ingenieria ambiental");
        availablePrograms.add("Ingenieria electrica");
        availablePrograms.add("Filosofia");
    }

    public void save() {
        student = new Students();
        student.setIdentification(id);
        student.setNames(name);
        student.setLastNames(lastName);
        student.setProgram(program);
        student.setAddress(address);
        student.setPhone(phone);
        student.setStratum(stratum);
        
        studentsFacade.create(student);
    }

    public void setMybutton(UIComponent mybutton) {
        this.mybutton = mybutton;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }   

    public UIComponent getMybutton() {
        return mybutton;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public List<String> getAvailablePrograms() {
        return availablePrograms;
    }

    public void setAvailablePrograms(List<String> availablePrograms) {
        this.availablePrograms = availablePrograms;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
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
