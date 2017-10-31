/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.db.controller.TblDeptController;
import com.db.controller.TblItemsController;
import com.db.controller.TblRequestationController;
import com.db.controller.util.JsfUtil;
import com.db.entity.TblMemo;
import com.db.logic.Memo;
import com.db.logic.TblLoginFacade;
import com.db.logic.TblMemoFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rabin
 */
@ManagedBean(name="mc")
@SessionScoped
public class middleController implements Serializable {
@EJB
private TblMemoFacade memoFacade;


GrowlView g = new GrowlView();
private TblMemo memo;

@PostConstruct
public void init(){
    memo = new TblMemo();
    initializeEmbeddableKey();
}
    protected void initializeEmbeddableKey() {
    }
    protected void setEmbeddableKeys() {
    }
    private TblMemoFacade getFacade() {
        return memoFacade;
    }
    

    public middleController() {
    }

   public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TblMemoCreated"));
        if (!JsfUtil.isValidationFailed()) {
           
        }
        g.setMessage("saved sucessfully");
        g.saveMessage();
        init();
    }
   private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (memo != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    getFacade().edit(memo);
                } else {
                    getFacade().remove(memo);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }
    public TblMemo getMemo() {
        return memo;
    }

    public void setMemo(TblMemo memo) {
        this.memo = memo;
    }
    
    
}
