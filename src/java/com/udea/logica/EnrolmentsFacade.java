/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.logica;

import com.udea.modelo.Enrolments;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Daego_000
 */
@Stateless
public class EnrolmentsFacade extends AbstractFacade<Enrolments> implements EnrolmentsFacadeLocal {
    @PersistenceContext(unitName = "EnrolmentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnrolmentsFacade() {
        super(Enrolments.class);
    }
    
}