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
import java.util.logging.Level;
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

    private UIComponent myButton;
    boolean disable = true;

    private long student;
    private String program;
    private Date startingDate = new Date();
    private List<String> availableCourses;
    private List<String> courses;

    private List<Courses> courseList;

    public EnrolmentBean() {
    }

    public String validate() {
        if (courses.size() >= 6 || courses.size() <= 0) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:","Debe escoger entre 1 y 6 materias.");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(myButton.getClientId(context), message);
            disable = true;
        } else {
            disable = false;
        }
        return null;
    }

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

    //Acción para insertar el registro en la BD.  
    public void save() {
        studentBean.save();
        Students student = studentBean.getStudent();
        Enrolments enrolment;

        for (int i = 0; i < courses.size(); i++) {
            enrolment = new Enrolments();
            Courses c = courseList.get(availableCourses.indexOf(courses.get(i)));
            enrolment.setStudentIdentification(student);
            enrolment.setCourseId(c);
            enrolment.setEnrolmentDate(startingDate);
            enrolmentsFacade.create(enrolment);
        }
    }

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
