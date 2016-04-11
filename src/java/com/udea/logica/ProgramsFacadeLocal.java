/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.logica;

import com.udea.modelo.Programs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Daego_000
 */
@Local
public interface ProgramsFacadeLocal {

    void create(Programs programs);

    void edit(Programs programs);

    void remove(Programs programs);

    Programs find(Object id);

    List<Programs> findAll();

    List<Programs> findRange(int[] range);

    int count();
    
}
