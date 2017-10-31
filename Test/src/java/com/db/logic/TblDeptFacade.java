/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.logic;

import com.db.entity.TblDept;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rabin
 */
@Stateless
public class TblDeptFacade extends AbstractFacade<TblDept> {
    @PersistenceContext(unitName = "TestPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblDeptFacade() {
        super(TblDept.class);
    }
    public List deptName(){
    return em.createNativeQuery("SELECT dept_name FROM tbl_dept").getResultList();
    }
    public List deptId(){
    return em.createNativeQuery("SELECT dept_id FROM tbl_dept").getResultList();
    }
    public TblDept deptsid(String s){
        String bb = "'SELECT dept_Id FROM tbl_items WHERE tbl_items.dept_Name='"+s+"";
    return  (TblDept) em.createNativeQuery(bb).getSingleResult();
    } 
}
