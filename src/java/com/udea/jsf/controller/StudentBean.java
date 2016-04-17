package com.udea.jsf.controller;

import com.udea.logica.StudentsFacadeLocal;
import com.udea.modelo.Students;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

@ManagedBean(name = "student")
@SessionScoped
public class StudentBean implements Serializable {

    @EJB
    private StudentsFacadeLocal studentsFacade;
    

    //Atributos de el formulario de estudiantes
    private long id;
    private String name;
    private String lastName;
    private String program;
    private String phone;
    private String address;
    private int stratum;
    private List<String> availablePrograms;

    //Componentes de control del formulario.
    private UIComponent mybutton;
    boolean disable = true;

    //POJO de la entidad de estudiante
    private Students student;

    public StudentBean() {
    }

    //Inicializacion de los programas disponibles, se ejecuta luego de la creacion de el bean.
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

    //Se verifica que el estudiante no haya sido matriculado.
    public String validateStudent() {
       
        if (studentsFacade.find(id) == null) { //Si el estudiante no existe se procede a la siguiente vista de matricula
            return "submitStudent";
        } else { //Si el estudiante ya existe se verifica mediante un mensaje de error.
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El estudiante ya ha sido matriculado.");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(mybutton.getClientId(context), message);
        }
        return null;
    }

    //Funcion para guardar en la base de datos la informacion del estudiante.
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

    //Getters y Setters
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
}
