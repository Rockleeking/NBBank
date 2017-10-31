/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.logic;

import com.db.entity.TblMemo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rabin
 */
@Stateless
public class TblMemoFacade extends AbstractFacade<TblMemo> {
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblMemoFacade() {
        super(TblMemo.class);
    }
    
}
