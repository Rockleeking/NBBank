/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.logic;

import com.db.entity.TblLoginGenere;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rabin
 */
@Stateless
public class TblLoginGenereFacade extends AbstractFacade<TblLoginGenere> {
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblLoginGenereFacade() {
        super(TblLoginGenere.class);
    }
    
}
