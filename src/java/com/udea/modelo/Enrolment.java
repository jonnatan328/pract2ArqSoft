/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acerpc
 */
@Entity
@Table(name = "enrolment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enrolment.findAll", query = "SELECT e FROM Enrolment e"),
    @NamedQuery(name = "Enrolment.findById", query = "SELECT e FROM Enrolment e WHERE e.id = :id"),
    @NamedQuery(name = "Enrolment.findBySemester", query = "SELECT e FROM Enrolment e WHERE e.semester = :semester"),
    @NamedQuery(name = "Enrolment.findByStartingDate", query = "SELECT e FROM Enrolment e WHERE e.startingDate = :startingDate")})
public class Enrolment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "semester")
    private String semester;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startingDate")
    @Temporal(TemporalType.DATE)
    private Date startingDate;
    @JoinColumn(name = "student", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Student student;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "program")
    private String program;

    public Enrolment() {
    }

    public Enrolment(Integer id) {
        this.id = id;
    }

    public Enrolment(Integer id, String semester, Date startingDate) {
        this.id = id;
        this.semester = semester;
        this.startingDate = startingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enrolment)) {
            return false;
        }
        Enrolment other = (Enrolment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Enrolment[ id=" + id + " ]";
    }
    
}
