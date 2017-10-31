
package com.controller;

import com.db.controller.util.JsfUtil;
import com.db.entity.TblDept;
import com.db.entity.TblItems;
import com.db.entity.TblRequestation;
import com.db.logic.TblDeptFacade;
import com.db.logic.TblItemsFacade;
import com.db.logic.TblRequestationFacade;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="rc")
@SessionScoped
public class RequestController implements Serializable{
 @EJB
    private TblRequestationFacade ejbFacade;
    
    public TblRequestation selected;
    public TblDept deptName;
    public TblItems itemName;
    
@EJB
    private TblItemsFacade ejbFacadeItems;
    private List items = null;
   
@EJB
private TblDeptFacade ejbDeptFacade;
private List Dept = null;


    public TblDept getDeptName() {
        return deptName;
        
    }

    public void setDeptName(TblDept deptName) {
        this.deptName = deptName;
        
    }

    public TblItems getItemName() {
        return itemName;
    }

    public void setItemName(TblItems itemName) {
        this.itemName = itemName;
        
    }
    public void Operation (){
    for(TblDept a: ejbDeptFacade.findAll()){
            if(a.getDeptName().equals(deptName.getDeptName())){
                selected.setDeptId((a));
            }
            
    }
    
    for(TblItems a: ejbFacadeItems.findAll()){
            if(a.getItmName().equals(itemName.getItmName())){
                selected.setItmId(a);
            
    }
    }
    
    }

 GrowlView g= new GrowlView();

    @PostConstruct
    public void init(){
        selected = new TblRequestation();
        initializeEmbeddableKey();
        items= new LinkedList<>();
        Dept= new LinkedList<>();
        deptName= new TblDept();
        itemName= new TblItems();
        
    }
    public RequestController() {
    }
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    public TblRequestation getSelected() {
        
        
        return selected;
    }
    
     
    public void setSelected(TblRequestation selected) {
        
        this.selected = selected;
        
        
        
    }
    public List<TblItems> getItemsAvailableSelectOneitems() {
         for(TblItems a: ejbFacadeItems.findAll()){
            items.add(a.getItmName());
            
    }
        
        return items;
    }
    public List<TblDept> getItemsAvailableSelectOneDept() {
         
        for(TblDept a: ejbDeptFacade.findAll()){
        Dept.add(a.getDeptName());
    }
        return Dept;
    }
    private TblRequestationFacade getFacade() {
        return ejbFacade;
    }
     public void create() {
         Operation();
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TblRequestationCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        g.setMessage("saved sucessfully");
        g.saveMessage();
        init();
    }
     private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
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
}
