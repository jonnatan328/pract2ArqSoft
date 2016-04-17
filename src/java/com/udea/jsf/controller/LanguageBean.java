package com.udea.jsf.controller;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "languageBean")
@SessionScoped
public class LanguageBean implements Serializable {

    //Para Internacionalización
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public LanguageBean() {
    }

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
