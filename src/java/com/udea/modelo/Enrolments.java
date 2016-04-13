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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daego_000
 */
@Entity
@Table(name = "enrolments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enrolments.findAll", query = "SELECT e FROM Enrolments e"),
    @NamedQuery(name = "Enrolments.findById", query = "SELECT e FROM Enrolments e WHERE e.id = :id"),
    @NamedQuery(name = "Enrolments.findByEnrolmentDate", query = "SELECT e FROM Enrolments e WHERE e.enrolmentDate = :enrolmentDate")})
public class Enrolments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "enrolment_date")
    @Temporal(TemporalType.DATE)
    private Date enrolmentDate;
    @JoinColumn(name = "student_identification", referencedColumnName = "identification")
    @ManyToOne
    private Students studentIdentification;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne
    private Courses courseId;

    public Enrolments() {
    }

    public Enrolments(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(Date enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }

    public Students getStudentIdentification() {
        return studentIdentification;
    }

    public void setStudentIdentification(Students studentIdentification) {
        this.studentIdentification = studentIdentification;
    }

    public Courses getCourseId() {
        return courseId;
    }

    public void setCourseId(Courses courseId) {
        this.courseId = courseId;
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
        if (!(object instanceof Enrolments)) {
            return false;
        }
        Enrolments other = (Enrolments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Enrolments[ id=" + id + " ]";
    }
    
}
