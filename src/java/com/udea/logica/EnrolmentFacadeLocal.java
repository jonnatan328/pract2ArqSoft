/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.logica;

import com.udea.modelo.Enrolment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acerpc
 */
@Local
public interface EnrolmentFacadeLocal {

    void create(Enrolment enrolment);

    void edit(Enrolment enrolment);

    void remove(Enrolment enrolment);

    Enrolment find(Object id);

    List<Enrolment> findAll();

    List<Enrolment> findRange(int[] range);

    int count();
    
}
