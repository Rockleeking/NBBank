/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.logic;

import com.db.entity.TblItems;
import com.db.entity.TblRequestation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Rabin
 */
@Stateless
public class TblRequestationFacade extends AbstractFacade<TblRequestation> {
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblRequestationFacade() {
        super(TblRequestation.class);
    }
    
    public Object view(TblItems itmid){
        Query q=em.createNativeQuery("select itm_Name FROM tbl_items,tbl_requestation WHERE tbl_items.itm_Id=1");
        System.out.println(itmid);
        return q.getSingleResult();
    } 

  
}
