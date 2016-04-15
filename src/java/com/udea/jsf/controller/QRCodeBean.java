package com.udea.jsf.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Random;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.primefaces.model.DefaultStreamedContent;

@ManagedBean(name = "qRCodeBean")
@RequestScoped
public class QRCodeBean implements Serializable {

    private final static Logger LOGGER = Logger.getLogger(QRCodeBean.class.getCanonicalName());

    private final int MIN = 1000;
    private final int MAX = 9999;

    private DefaultStreamedContent qrStream;
    private UIComponent qrButton;
    private String qrString;
    private String qrStringGenerated;
    private boolean disable = true;

    public QRCodeBean() {

    }

    @PostConstruct
    private void makeQR() {
        Random rand = new Random();
        int randomNum = rand.nextInt((MAX - MIN) + 1) + MIN;
        qrStringGenerated = String.valueOf(randomNum);

        ByteArrayOutputStream stream = QRCode.from(qrStringGenerated).stream();
        ByteArrayInputStream in = new ByteArrayInputStream(stream.toByteArray());
        qrStream = new DefaultStreamedContent(in);
    }

    public void check() {
        LOGGER.info(qrString + " " + qrStringGenerated);
        if (qrString.equalsIgnoreCase(qrStringGenerated)) {
            disable = false;
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "Wrong number inserted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(qrButton.getClientId(context), message);
            disable = true;
        }
    }

    public DefaultStreamedContent getQrStream() {
        return qrStream;
    }

    public void setQrStream(DefaultStreamedContent qrStream) {
        this.qrStream = qrStream;
    }

    public String getQrString() {
        return qrString;
    }

    public void setQrString(String qrString) {
        this.qrString = qrString;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public UIComponent getQrButton() {
        return qrButton;
    }

    public void setQrButton(UIComponent qrButton) {
        this.qrButton = qrButton;
    }
}
