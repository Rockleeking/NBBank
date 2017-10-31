/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.db.entity.TblLogin;
import com.db.logic.TblLoginFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rabin
 */
@ManagedBean(name = "lc")
@SessionScoped
public class LoginController implements Serializable {
    private static long serialVersionUID = 1113799434508676095L;
    private TblLogin currentUser;
    private Boolean userStatus;
    List<TblLogin> userList;
    @EJB
    private TblLoginFacade userFacade;
    GrowlView g = new GrowlView();
    
private String regex1Text;
private String regexText;
public boolean loggedIn;
private boolean initial;
char corporate;
char general;
 FacesContext contex ;
    @PostConstruct
    public void init(){
        contex = FacesContext.getCurrentInstance();
        initial =Boolean.TRUE; 
        currentUser=new TblLogin();
        userList=new LinkedList<>();
        userStatus=false;
        corporate='C';
        general='G';
        
    }
    public boolean isInitial() {
        return initial;
    }

    public void setInitial(boolean initial) {
        this.initial = initial;
    }

    public LoginController() {
        
       
    }
      public void logOut(){
            g.setMessage("Logged Out");
            g.saveMessage();
            
    }

    public String submit(){
   
        String dbname="rocklee";
        String dbpwd="123456";
        String dname="Grishma";
        String dpwd="iloveyou";
        
        
           if (dbname.equals(regexText) && dbpwd.equals(regex1Text)) {
           loggedIn = true;
           setInitial(loggedIn);
          
           return ("webpages/Corporate/CorporateUser?faces-redirect=true");
            }
           else if (dname.equals(regexText) && dpwd.equals(regex1Text)) {
           loggedIn = true;
           setInitial(loggedIn);
           System.out.println("inside submit.if");
           return ("webpages/General/GeneralUser?faces-redirect=true");
           }
           loggedIn= false;
           setInitial(loggedIn);
           
           return "webpages/loginJsf.xhtml";
    }
    public String error(boolean a){
            
            if(a==false){
            return "Invalid cerditancial";
            }
            return "";
    }

    public String getRegex1Text() {
        return regex1Text;
    }

    public void setRegex1Text(String regex1Text) {
        this.regex1Text = regex1Text;
        currentUser.setPwd(regex1Text);
    }

    public String getRegexText() {
        return regexText;
    }

    public void setRegexText(String regexText) {
        this.regexText = regexText;
        currentUser.setUser(regexText);
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    public void checkUser(){
        userList=userFacade.findAll();
        System.out.println("from userList");
        for(int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getUser()+" "+userList.get(i).getPwd());;
        }

        
        for(TblLogin user : userList){
             
            System.out.println(user.getUser()+" "+user.getPwd()+" "+ user.getGenere().getGenere());
            System.out.println(currentUser.getUser()+" "+currentUser.getPwd());
        System.out.println("from user");
            if((user.getUser().equals(currentUser.getUser())) && (user.getPwd().equals(currentUser.getPwd()))){
                
                System.out.println("valid");
                userStatus=true;
                
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                try {
                   
                    
                HttpServletRequest request = (HttpServletRequest)context.getRequest();
                HttpSession httpSession = request.getSession(false);
                httpSession.setAttribute("username",user.getUser());
                httpSession.setAttribute("meta",user.getGenere().getGenere());
                if(user.getGenere().getGenere().equals(corporate)){
                    context.redirect(context.getRequestContextPath()+"/faces/webpages/Corporate/CorporateUser.xhtml");
                }else{
                    context.redirect(context.getRequestContextPath()+"/faces/webpages/General/GeneralUser.xhtml");

                }
                } catch (IOException ex) {
                    
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                System.out.println("Error Occured");
                 FacesContext context = FacesContext.getCurrentInstance(); 
                 context.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Username and password doesnot match!"));
            }
        }
    }
    public void userLogout(){
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try {
            context.invalidateSession();
            context.redirect(context.getRequestContextPath());
            
        } catch (IOException ex) {
            System.out.println("cannot log out");
        }
    }
  

    public TblLogin getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(TblLogin currentUser) {
        this.currentUser = currentUser;
    }

    public TblLoginFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(TblLoginFacade userFacade) {
        this.userFacade = userFacade;
    }
    
}
