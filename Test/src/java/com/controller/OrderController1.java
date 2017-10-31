
package com.controller;

import com.db.controller.util.JsfUtil;
import com.db.entity.TblVendor;
import com.db.entity.TblItems;
import com.db.entity.TblOrder;
import com.db.logic.TblVendorFacade;
import com.db.logic.TblItemsFacade;
import com.db.logic.TblOrderFacade;
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

@ManagedBean(name="oc")
@SessionScoped
public class OrderController1 implements Serializable{
 @EJB
    private TblOrderFacade ejbFacade;
    
    public TblOrder selected;
    public TblVendor vName;
    public TblItems itemName;
    
@EJB
    private TblItemsFacade ejbFacadeItems;
    private List items = null;
   
@EJB
    private TblVendorFacade ejbVendorFacade;
    private List Vendor = null;

    
    public TblVendor getVName() {
        return vName;
        
    }

    public void setVName(TblVendor vName) {
        this.vName = vName;
        
    }

    public TblItems getItemName() {
        return itemName;
    }

    public void setItemName(TblItems itemName) {
        this.itemName = itemName;
        
    }
    public void Operation (){
    for(TblVendor a: ejbVendorFacade.findAll()){
            if(a.getVName().equals(vName.getVName())){
                selected.setVId((a));
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
        selected = new TblOrder();
        initializeEmbeddableKey();
         vName= new TblVendor();
        itemName= new TblItems();
        items = new LinkedList<>();
        Vendor = new LinkedList<>();
       
        
        
    }
    public OrderController1() {
    }
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    public TblOrder getSelected() {
        
        
        return selected;
    }
    
     
    public void setSelected(TblOrder selected) {
        
        this.selected = selected;
        
        
        
    }
    public List<TblItems> getItemsAvailableSelectOneitems() {
        if(items.isEmpty()){
         for(TblItems a: ejbFacadeItems.findAll()){
            items.add(a.getItmName());
         }
    }
        
        return items;
    }
    public List<TblVendor> getItemsAvailableSelectOneVendor() {
         if(Vendor.isEmpty()){
        for(TblVendor a: ejbVendorFacade.findAll()){
            Vendor.add(a.getVName());
        }
        }
        return Vendor;
    }
    private TblOrderFacade getFacade() {
        return ejbFacade;
    }
     public void create() {
         Operation();
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TblOrderCreated"));
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
