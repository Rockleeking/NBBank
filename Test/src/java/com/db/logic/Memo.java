/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.db.logic;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author Rabin
 */
@Stateless
public class Memo {
@PersistenceUnit(unitName ="TestPU")
private EntityManager em;


    public Boolean setMemo(Date d ,String f ,String t , String de){
        System.out.println(d+" "+f+" "+t+" "+d+" "+de);
    Query q=em.createNativeQuery("INSERT INTO `new`.`tbl_memo` (`m_Id`, `m_Date`, `m_From`, `m_to`, `detail`) VALUES (NULL, '"+d+"', '"+f+"', '"+t+"', '"+de+"')");
    q.executeUpdate();
    return true;    
    }
    
    
}
