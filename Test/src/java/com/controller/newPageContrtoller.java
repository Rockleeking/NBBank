/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.db.entity.TblStock;
import com.db.logic.TblStockFacade;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rabin
 */

@ManagedBean(name = "npc")
@SessionScoped
public class newPageContrtoller {
    private String str="../welcome.xhtml";
    GrowlView g = new GrowlView();
    private String currentHeader;
    private String currentPage;
    private String currentSideBar;
    @EJB
    private TblStockFacade ejbstock;
    
    @PostConstruct
    public void init(){
        currentHeader="header.xhtml";
        currentPage= str;
        g.init();
        g.saveMessage();
        checkStock();
    }

    public void checkStock(){
        for(TblStock tb: ejbstock.findAll()){
            int z=Double.compare(tb.getRemQty(),tb.getMinQty());
            if(z<0){
                System.out.println("found");
                System.out.println(tb.getRemQty()+""+tb.getMinQty());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Stock for items are getting low for stock id "+tb.getSId()+""));
            }
                        System.out.println(tb.getRemQty()+""+tb.getMinQty());

        }
        
    }
    
    public void branch(){
        
       currentPage= "List_Branch.xhtml";
       g.setMessage(currentPage);
        g.saveMessage();
        checkStock();
        
    }
    public void dept(){
        currentPage="List_Dept.xhtml";
        g.setMessage(currentPage);
        g.saveMessage();
        checkStock();
    }
    public void issue(){
        
        currentPage="List_Issue.xhtml";
        g.setMessage(currentPage);
        g.saveMessage();
        checkStock();
    }
    public void items(){
        
        currentPage="List_Items.xhtml";
        g.setMessage(currentPage);
        g.saveMessage();
        checkStock();
    }
    public void memo(){
       currentPage= "List_Memo.xhtml";
       g.setMessage(currentPage);
        g.saveMessage();
        checkStock();
    }
    public void order(){
        currentPage="List_Order.xhtml";
        g.setMessage(currentPage);
        g.saveMessage();
        checkStock();
    }
    public void requistation(){
         currentPage="List_Requestation.xhtml";
        g.setMessage(currentPage);
        g.saveMessage();
        checkStock();
    }
    public void stock(){
        
        currentPage="List_Stock.xhtml";
        g.setMessage(currentPage);
        g.saveMessage();
        checkStock();
    }
    public void stockGenere(){
       currentPage= "List_Stock_genere.xhtml";
       g.setMessage(currentPage);
        g.saveMessage();
        checkStock();
    }
    public void vendor(){
        currentPage="List_Vendor.xhtml";
        g.setMessage(currentPage);
        g.saveMessage();
        checkStock();
    }
    public newPageContrtoller() {
       
    }
    public void aa(){
        System.out.println("sui sui sui hunxa");
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    /**
     *
     */
    public void viewRequest(){
        currentPage="view_Requestation.xhtml";
        checkStock();
    }
    public void list(){
        currentPage="List_Items.xhtml";
    checkStock();
    }
    public void orderPage(){
        currentPage="order.xhtml";
    checkStock();
    }
    public void branches(){
        currentPage="view_Branch.xhtml";
    checkStock();
    }
    public void memorandum(){
        currentPage="view_Memo.xhtml";
    checkStock();
    }
    public void home(){
        currentPage="../welcome.xhtml";
    checkStock();
    }
    public void viewStock(){
        currentPage="view_Stock.xhtml";
    checkStock();
    }
    public void issued(){
        currentPage="issued.xhtml";
    checkStock();
    }
    
    public void logOut(){
            g.setMessage("Logged Out");
            g.saveMessage();
            init();
    checkStock();
    }
    public void loggedOut(){
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try {
            context.invalidateSession();
            context.redirect(context.getRequestContextPath());
        } catch (IOException ex) {
            System.out.println("cannot log out");
        }
    }

    public String getCurrentHeader() {
        return currentHeader;
    }

    public void setCurrentHeader(String currentHeader) {
        this.currentHeader = currentHeader;
    }

    public String getCurrentSideBar() {
        return currentSideBar;
    }

    public void setCurrentSideBar(String currentSideBar) {
        this.currentSideBar = currentSideBar;
    }
    
    
}
