package com.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Rabin
 */

@ManagedBean(name = "guc")
@SessionScoped
public class GeneralUserContrtoller {
    private String str="../welcome.xhtml";
    GrowlView g = new GrowlView();
    private String currentHeader;
    private String currentPage;
    private String currentSideBar;
    @PostConstruct
    public void init(){
        currentHeader="header.xhtml";
        currentPage= str;
        g.init();
        g.saveMessage();
    }
    public void viewRequest(){
        currentPage="Request.xhtml";
    }
      public void branches(){
        currentPage="view_Branch.xhtml";
    }
    public void memorandum(){
        currentPage="memo.xhtml";
    }
    public void home(){
        currentPage="../welcome.xhtml";
    }
    public void viewStock(){
        currentPage="view_Stock.xhtml";
    }
  

    public String getCurrentHeader() {
        return currentHeader;
    }

    public void setCurrentHeader(String currentHeader) {
        this.currentHeader = currentHeader;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getCurrentSideBar() {
        return currentSideBar;
    }

    public void setCurrentSideBar(String currentSideBar) {
        this.currentSideBar = currentSideBar;
    }
}