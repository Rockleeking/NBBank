/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rabin
 */
public class GeneralFilter implements Filter {
   
    
    public GeneralFilter() {
    }    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
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
            if(req.getSession().getAttribute("meta").equals('G')){
        chain.doFilter(request, response);
            }else{
            res.sendRedirect(loginURL);
            }
            
        }else if(req.getSession()==null){
            res.sendRedirect(loginURL);
            }
        
       
    }

    @Override
    public void destroy() {
    }
    
}