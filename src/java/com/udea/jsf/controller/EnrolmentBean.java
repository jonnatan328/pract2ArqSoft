/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.jsf.controller;

import com.udea.logica.CoursesFacadeLocal;
import com.udea.logica.EnrolmentsFacadeLocal;
import com.udea.modelo.Courses;
import com.udea.modelo.Enrolments;
import com.udea.modelo.Students;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

@ManagedBean(name = "enrolment")
@SessionScoped
public class EnrolmentBean implements Serializable {

    private final static Logger LOGGER = Logger.getLogger(EnrolmentBean.class.getCanonicalName());

    @EJB
    private EnrolmentsFacadeLocal enrolmentsFacade;

    @EJB
    private CoursesFacadeLocal coursesFacade;

    @ManagedProperty(value = "#{student}")
    private StudentBean studentBean;

    //Componentes de control del formulario.
    private UIComponent myButton;
    boolean disable = true;

    //Atributos del formulario
    private long student;
    private String program;
    private Date startingDate = new Date();
    private List<String> courses;
    
    //Lista de cursos que hay en la base de datos.
    private List<String> availableCourses;

    //Arreglo de POJOS de la entidad de cursos.
    private List<Courses> courseList;

    public EnrolmentBean() {
    }

    //Inicializacion de los cursos disponibles, se obtienen apartir de 
    //la base de datos luego de la creacion del managedbean
    @PostConstruct
    public void updateCourses() {
        if (availableCourses == null) {
            availableCourses = new ArrayList<String>();
            courseList = coursesFacade.findAll();
            for (Courses c : courseList) {
                availableCourses.add(c.getCourseName());
            }
        }
    }

    //Funcion para validar la cantidad de cursos seleccionados por el usuario,
    //se verifica que solo pueda escoger entre 1 y 6 materias
    public String validate() {
        if (courses.size() >= 7 || courses.size() <= 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "Debe escoger entre 1 y 6 materias.");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(myButton.getClientId(context), message);
            disable = true;
        } else {
            disable = false;
        }
        return null;
    }

    //Acción para guardar los datos de matricula.  
    public void save() {
        //Primero se guarda la informacion del estudiando haciendo llamado a la funcion
        //del managedBean del estudiante que guarda la informacion correspondiente en la base de datos 
        studentBean.save();
        Students studentDB  = studentBean.getStudent();
        
        //Se procede a guardar la lista de cursos matriculados por el estudiante en la base de datos.
        Enrolments enrolment;
        for (int i = 0; i < courses.size(); i++) {
            enrolment = new Enrolments();
            Courses c = courseList.get(availableCourses.indexOf(courses.get(i)));
            enrolment.setStudentIdentification(studentDB);
            enrolment.setCourseId(c);
            enrolment.setEnrolmentDate(startingDate);
            enrolmentsFacade.create(enrolment);
        }
    }

    
    //Setters y Getters
    public void setStudentBean(StudentBean studentBean) {
        this.studentBean = studentBean;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public List<String> getAvailableCourses() {
        return availableCourses;
    }

    public void setAvailableCourses(List<String> availableCourses) {
        this.availableCourses = availableCourses;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
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

    public UIComponent getMyButton() {
        return myButton;
    }

    public void setMyButton(UIComponent myButton) {
        this.myButton = myButton;
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
