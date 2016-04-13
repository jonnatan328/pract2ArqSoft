/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Daego_000
 */
@Entity
@Table(name = "students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s"),
    @NamedQuery(name = "Students.findByIdentification", query = "SELECT s FROM Students s WHERE s.identification = :identification"),
    @NamedQuery(name = "Students.findByNames", query = "SELECT s FROM Students s WHERE s.names = :names"),
    @NamedQuery(name = "Students.findByLastNames", query = "SELECT s FROM Students s WHERE s.lastNames = :lastNames"),
    @NamedQuery(name = "Students.findByProgram", query = "SELECT s FROM Students s WHERE s.program = :program"),
    @NamedQuery(name = "Students.findByAddress", query = "SELECT s FROM Students s WHERE s.address = :address"),
    @NamedQuery(name = "Students.findByPhone", query = "SELECT s FROM Students s WHERE s.phone = :phone"),
    @NamedQuery(name = "Students.findByStratum", query = "SELECT s FROM Students s WHERE s.stratum = :stratum")})
public class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "identification", nullable = false)
    private Long identification;
    @Size(max = 50)
    @Column(name = "names", length = 50)
    private String names;
    @Size(max = 50)
    @Column(name = "last_names", length = 50)
    private String lastNames;
    @Size(max = 50)
    @Column(name = "program", length = 50)
    private String program;
    @Size(max = 20)
    @Column(name = "address", length = 20)
    private String address;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone", length = 20)
    private String phone;
    @Column(name = "stratum")
    private Integer stratum;
    @OneToMany(mappedBy = "studentIdentification")
    private List<Enrolments> enrolmentsList;

    public Students() {
    }

    public Students(Long identification) {
        this.identification = identification;
    }

    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStratum() {
        return stratum;
    }

    public void setStratum(Integer stratum) {
        this.stratum = stratum;
    }

    @XmlTransient
    public List<Enrolments> getEnrolmentsList() {
        return enrolmentsList;
    }

    public void setEnrolmentsList(List<Enrolments> enrolmentsList) {
        this.enrolmentsList = enrolmentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identification != null ? identification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.identification == null && other.identification != null) || (this.identification != null && !this.identification.equals(other.identification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Students[ identification=" + identification + " ]";
    }
    
}
