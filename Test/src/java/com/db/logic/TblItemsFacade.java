/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.logic;

import com.db.entity.TblItems;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Rabin
 */
@Stateless
public class TblItemsFacade extends AbstractFacade<TblItems> {
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblItemsFacade() {
        super(TblItems.class);
    }
    
    public List itemsName(){
    return em.createNativeQuery("SELECT itm_name FROM tbl_items").getResultList();
    }
    public List itemsId(){
    return em.createNativeQuery("SELECT itm_id FROM tbl_items").getResultList();
    }
//    s
}
