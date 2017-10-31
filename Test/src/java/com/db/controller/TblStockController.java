package com.db.controller;

import com.db.entity.TblStock;
import com.db.controller.util.JsfUtil;
import com.db.controller.util.JsfUtil.PersistAction;
import com.db.entity.TblItems;
import com.db.entity.TblStockGenere;
import com.db.logic.TblStockFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "tblStockController")
@SessionScoped
public class TblStockController implements Serializable {

    @EJB
    private com.db.logic.TblStockFacade ejbFacade;
    private List<TblStock> items = null;
    private TblStock selected;

    public TblStockController() {
    }

    public TblStockController(TblStock selected) {
        this.selected = selected;
        this.selected.setItmId(selected.getItmId());
        this.selected.setMeta(selected.getMeta());
        this.selected.setMinQty(selected.getMinQty());
        this.selected.setRate(selected.getRate());
        this.selected.setRemQty(selected.getRemQty());
        this.selected.setSId(selected.getSId());
    }
    
    public void setdetails(Integer i, TblStockGenere g, TblItems it, double q, double min, double r){
       try{
        selected.getItmId().setItmId(it.getItmId());
        selected.getMeta().setMeta(g.getMeta());
        selected.setMinQty(min);
        selected.setRate(r);
        selected.setRemQty(q);
        selected.setSId(i);
       }catch(NullPointerException e){
           System.err.printf("error", e);
       }
        
    }

    public TblStock getSelected() {
        return selected;
    }

    public void setSelected(TblStock selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TblStockFacade getFacade() {
        return ejbFacade;
    }

    public TblStock prepareCreate() {
        selected = new TblStock();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TblStockCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TblStockUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TblStockDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TblStock> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
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

    public List<TblStock> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TblStock> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TblStock.class)
    public static class TblStockControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TblStockController controller = (TblStockController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblStockController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TblStock) {
                TblStock o = (TblStock) object;
                return getStringKey(o.getSId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TblStock.class.getName()});
                return null;
            }
        }

    }

}
