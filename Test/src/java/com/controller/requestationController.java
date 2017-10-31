
package com.controller;

import com.db.controller.TblRequestationController;
import com.db.entity.TblDept;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import com.db.entity.TblItems;
import com.db.entity.TblRequestation;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "rc")
@SessionScoped
public class requestationController {

private com.db.logic.TblDeptFacade ejbDeptFacade;
private com.db.logic.TblItemsFacade ejbItemsFacade;
   private Date date;
   private double quantity;
   private TblItems ItmId;
   private TblDept DeptId;
   private TblItems ItmName;
   private TblDept DeptName;
   List list;
    TblRequestationController req = new TblRequestationController();
  
    public requestationController() {
    }
    @PostConstruct
    public void init(){
        list= new LinkedList();
    }
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public TblItems getItmId() {
        return ItmId;
    }

    public void setItmId(TblItems ItmId) {
        this.ItmId= ItmId;
                //ejbItemsFacade.itemsid(ItmName.getItmName());
    }

    public TblDept getDeptId() {
        return DeptId;
    }

    public void setDeptId(TblDept DeptId) {
        this.DeptId=DeptId;
      //  this.DeptId = ejbDeptFacade.deptsid(DeptName.getDeptName());
    }

    public TblItems getItmName() {
        return ItmName;
    }

    public void setItmName(TblItems ItmName) {
        this.ItmName = ItmName;
    }

    public TblDept getDeptName() {
        return DeptName;
    }
    public List getDeptIdList() {
        list = ejbDeptFacade.deptId();
        return list;
    }
    public List getDeptNameList() {
        list=ejbDeptFacade.deptName();
        return list;
    }
    public List getItemsIdList() {
        list= ejbItemsFacade.itemsId();
    return list;
    }
    public List getItemsNameList() {
        list= ejbItemsFacade.itemsName();
        return list;
    }

    public void setDeptName(TblDept DeptName) {
        this.DeptName = DeptName;
    }
    public void onsubmit(){
    req.selected.setDeptId(DeptId);
    req.selected.setItmId(ItmId);
    req.selected.setQty(quantity);
    req.selected.setReqDate(date);
    req.create();
    FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Data Selected", "sucessfully updated"));
    requestationController requestationController = new requestationController();
    } 
}
