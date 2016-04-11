/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.logica;

import com.udea.modelo.Courses;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Daego_000
 */
@Local
public interface CoursesFacadeLocal {

    void create(Courses courses);

    void edit(Courses courses);

    void remove(Courses courses);

    Courses find(Object id);

    List<Courses> findAll();

    List<Courses> findRange(int[] range);

    int count();
    
}
