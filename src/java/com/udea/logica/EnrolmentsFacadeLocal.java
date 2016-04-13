/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.logica;

import com.udea.modelo.Enrolments;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Daego_000
 */
@Local
public interface EnrolmentsFacadeLocal {

    void create(Enrolments enrolments);

    void edit(Enrolments enrolments);

    void remove(Enrolments enrolments);

    Enrolments find(Object id);

    List<Enrolments> findAll();

    List<Enrolments> findRange(int[] range);

    int count();
    
}
