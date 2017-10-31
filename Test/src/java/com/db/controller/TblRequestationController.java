package com.db.controller;

import com.db.entity.TblRequestation;
import com.db.controller.util.JsfUtil;
import com.db.controller.util.JsfUtil.PersistAction;
import com.db.entity.TblItems;
import com.db.logic.TblRequestationFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "tblRequestationController")
@SessionScoped
public class TblRequestationController implements Serializable {

    @EJB
    private com.db.logic.TblRequestationFacade ejbFacade;
    private List<TblRequestation> items = null;
    public TblRequestation selected,caught;

    private String ItmName;
    
    public TblRequestationController() {
        
    }

    public TblRequestation getSelected() {
        
        
        return selected;
    }
     public void getName(){
         caught=selected;
       ItmName = (String)ejbFacade.view(caught.getItmId());
       
        }
     
    public void setSelected(TblRequestation selected) {
        
        this.selected = selected;
        
        
        
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TblRequestationFacade getFacade() {
        return ejbFacade;
    }

    public TblRequestation prepareCreate() {
        selected = new TblRequestation();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TblRequestationCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TblRequestationUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TblRequestationDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    public List<TblRequestation> getItems() {
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

    public List<TblRequestation> getItemsAvailableSelectMany() {
       
        return getFacade().findAll();
    }

    public List<TblRequestation> getItemsAvailableSelectOne() {
         
        return getFacade().findAll();
    }

    public com.db.logic.TblRequestationFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(com.db.logic.TblRequestationFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public String getItmName() {
        return ItmName;
    }

    public void setItmName(String ItmName) {
        this.ItmName = ItmName;
    }

    @FacesConverter(forClass = TblRequestation.class)
    public static class TblRequestationControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TblRequestationController controller = (TblRequestationController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblRequestationController");
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
            if (object instanceof TblRequestation) {
                TblRequestation o = (TblRequestation) object;
                return getStringKey(o.getReqId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TblRequestation.class.getName()});
                return null;
            }
        }

    }

}
