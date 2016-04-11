/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.logica;

import com.udea.modelo.Programs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Daego_000
 */
@Stateless
public class ProgramsFacade extends AbstractFacade<Programs> implements ProgramsFacadeLocal {
    @PersistenceContext(unitName = "EnrolmentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProgramsFacade() {
        super(Programs.class);
    }
    
}
