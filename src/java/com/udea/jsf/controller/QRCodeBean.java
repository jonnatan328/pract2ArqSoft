package com.udea.jsf.controller;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "QRCode")
@SessionScoped
public class QRCodeBean implements Serializable {

    private final static Logger LOGGER = Logger.getLogger(QRCodeBean.class.getCanonicalName());

    //Valores maximos y minimos del codigo QR a generar
    private final int MIN = 1000;
    private final int MAX = 9999;

    //Valor del codigo qr generado
    private String qrCodeString;

    //Se genera el valor del codigo QR en el constructor
    public QRCodeBean() {
        createQRString();
    }

    //Funcion que genera el valor del codigo QR teniendo en cuenta el maximo y el minimo valor posible.
    private void createQRString() {
        Random random = new Random();
        int i = random.nextInt(MAX - MIN + 1) + 1000;
        qrCodeString = String.valueOf(i);
    }

    //Funcion de validacion que verifica un valor ingresado en el formulario corresponda al valor del codigo QR generado.
    public void makeValidation(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        //Si el valor no coincide se genera un mensaje de error y se obtiene un codigo nuevo.
        //caso contrario se genera un nuevo codigo para la nueva sección y se procede.
        if (!value.toString().equalsIgnoreCase(qrCodeString)) { 
            createQRString();
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Codigo incorrecto", "codigo incorrupto"));
        } else {
            createQRString();
        }
    }

    //Getters y Setters
    public String getQrCodeString() {
        return qrCodeString;
    }

    public void setQrCodeString(String qrCodeString) {
        this.qrCodeString = qrCodeString;
    }
}
