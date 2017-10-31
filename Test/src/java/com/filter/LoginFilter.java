/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filter;

import com.db.controller.TblLoginController;
import com.db.entity.TblLogin;
import com.db.entity.TblLoginGenere;
import com.db.logic.TblLoginFacade;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author Rabin
 */
public class LoginFilter implements Filter {
    
    private TblLoginGenere tg ;
    public LoginFilter() {
    }    
    
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse res= (HttpServletResponse) response;
        String loginURL = req.getContextPath();
        if(req.getSession().getAttribute("username")==null){
                System.out.println("user log in not done so forwarding to login");
                res.sendRedirect(loginURL);
        }else if(!(req.getSession().getAttribute("username")==null)){
            if(req.getSession().getAttribute("meta").equals('C')){
        chain.doFilter(request, response);
            }else{
            res.sendRedirect(loginURL);
            }
            
        }else if(req.getSession()==null){
            res.sendRedirect(loginURL);
            }
        
       
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    
}
