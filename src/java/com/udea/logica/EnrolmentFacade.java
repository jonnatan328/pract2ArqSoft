/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.logica;

import com.udea.modelo.Enrolment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author acerpc
 */
@Stateless
public class EnrolmentFacade extends AbstractFacade<Enrolment> implements EnrolmentFacadeLocal {
    @PersistenceContext(unitName = "EnrolmentPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnrolmentFacade() {
        super(Enrolment.class);
    }
    
}
