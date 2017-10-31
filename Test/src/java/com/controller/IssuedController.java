
package com.controller;

import com.db.controller.TblStockController;
import com.db.controller.util.JsfUtil;
import com.db.entity.TblRequestation;
import com.db.entity.TblItems;
import com.db.entity.TblIssue;
import com.db.entity.TblStock;
import com.db.logic.TblRequestationFacade;
import com.db.logic.TblItemsFacade;
import com.db.logic.TblIssueFacade;
import com.db.logic.TblStockFacade;
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

@ManagedBean(name="iss")
@SessionScoped
public class IssuedController implements Serializable{
 @EJB
 private TblStockFacade ejbStock;
 public TblStock selectedStock;
 public TblStockController TSC;
 @EJB
    private TblIssueFacade ejbFacade;
    
    public TblIssue selected;
    public TblRequestation reqId;
    public TblItems itemName;
    
@EJB
    private TblItemsFacade ejbFacadeItems;
    private List items = null;
   
@EJB
    private TblRequestationFacade ejbRequestationFacade;
    private List req = null;
    private String z;
    
    public TblRequestation getReqId() {
        return reqId;
        
    }

    public void setReqId(TblRequestation reqId) {
        this.reqId = reqId;
        
    }

    public TblItems getItemName() {
        return itemName;
    }

    public void iteam() {
        for(TblRequestation a: ejbRequestationFacade.findAll()){
        if(a.getReqId()==reqId.getReqId()){
            for(TblItems b: ejbFacadeItems.findAll()){
             if(b.getItmId()==a.getItmId().getItmId()){
                        z=b.getItmName();
             }
            }
        }
        }
////        z= reqId.getItmId().getItmName();   
//        System.out.println(reqId.getReqId());
////        System.out.println(reqId.getItmId());
//        System.out.println(reqId.toString());
//          List <TblItems> tbl = new LinkedList<>();
//          for(TblItems a: ejbFacadeItems.findAll()){
//                if(req.contains(a))
//            tbl.add(a);          
//        }
//         for(TblItems c:tbl){
//             if(c.getItmId().equals(reqId.getItmId())){
//                 z= c.getItmName();
//             }
//         }
    }
    
        
     
     
    public void setItemName(TblItems itemName) {
        this.itemName = itemName;
        
    }
    public void Operation (){
  for(TblRequestation a: ejbRequestationFacade.findAll()){
      if(a.getReqId().equals(reqId.getReqId())){
                selected.setReqId((a));
            }
            
    }
    
//    for(TblItems a: ejbFacadeItems.findAll()){
//            if(a.getItmName().equals(itemName.getItmName())){
//                selected.setItmId(a);
//            
//    }
//    }
    
    }

 GrowlView g= new GrowlView();

    @PostConstruct
    public void init(){
        selected = new TblIssue();
        selectedStock= new TblStock();
        initializeEmbeddableKey();
         reqId= new TblRequestation();
        itemName= new TblItems();
        items = new LinkedList<>();
        req = new LinkedList<>();
       TSC= new TblStockController();
        
        
    }
    public IssuedController() {
    }
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    public TblIssue getSelected() {
        
        
        return selected;
    }
    
     
    public void setSelected(TblIssue selected) {
        
        this.selected = selected;
        
        
        
    }
     public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TblStockUpdated"));
    }
    public List<TblItems> getItemsAvailableSelectOneitems() {
        if(items.isEmpty()){
         for(TblItems a: ejbFacadeItems.findAll()){
            items.add(a.getItmId());
         }
    }
        
        return items;
    }
    public List<TblRequestation> getItemsAvailableSelectOneRequestation() {
         if(req.isEmpty()){
        for(TblRequestation a: ejbRequestationFacade.findAll()){
            req.add(a.getReqId());
        }
        }
        return req;
    }
    private TblIssueFacade getFacade() {
        return ejbFacade;
    }
    public void stocking(){
        
             for(TblRequestation a: ejbRequestationFacade.findAll()){
        if(a.getReqId()==reqId.getReqId()){
            for(TblItems b: ejbFacadeItems.findAll()){
             if(b.getItmId()==a.getItmId().getItmId()){
            for(TblStock c: ejbStock.findAll()){
               if(  c.getItmId().getItmId()==b.getItmId()){
                   double f=((c.getRemQty())-(selected.getIQty()));
                   System.out.println(c.getItmId());
                   System.out.println(c.getMeta());
                   System.out.println(c.getMinQty());
                   System.out.println(c.getRate());
                   System.out.println(c.getRemQty());
                   System.out.println(c.getSId());
                   System.out.println(f);  
//                   selectedStock =TSC.getSelected();
//                        TSC.getSelected().setSId(c.getSId());
//                        TSC.getSelected().getItmId().setItmId(b.getItmId());
//                        TSC.getSelected().getMeta().setMeta(c.getMeta().getMeta());
//                        TSC.getSelected().setMinQty(c.getMinQty());
//                        TSC.getSelected().setRate(c.getRate());
//                        TSC.getSelected().setRemQty(f);
//                        TSC.update();
                        TSC.setdetails(c.getSId(), c.getMeta(), c.getItmId(), f, c.getMinQty(), c.getRate());
                   
//                        selectedStock.setSId(c.getSId());
//                        selectedStock.setItmId(c.getItmId());
//                        selectedStock.setMeta(c.getMeta());
//                        selectedStock.setMinQty(c.getMinQty());
//                        selectedStock.setRate(c.getRate());
//                        selectedStock.setRemQty(f);
//                        TSC.setSelected(selectedStock);
                        TSC.update();
//                        TSC= new TblStockController(selectedStock);
//                        TSC.update();
//                        stockinging(selectedStock);
                        System.out.println("Sucess");
                       
                        
               }else{
                   
               }
             }
            }
        }
        }
        
        
        }
    }
    private void stockinging(TblStock stock){
        ejbStock.edit(stock);
    }
     public void create() {
         Operation();
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TblIssueCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
//        stocking();
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

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }
}
