/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;


import com.me.DAO.AddBooksDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Avanish
 */
public class AddToDb extends AbstractController{

    
    private AddBooksDAO addBooksDAO;
    
    public AddToDb(AddBooksDAO addBooksDAO){
        
        this.addBooksDAO=addBooksDAO;
        
        
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
    
        
        ModelAndView mv = new ModelAndView();
        
            String[] isbnVal = (String[])hsr.getParameterValues("isbn");
            String[] titleVal = (String[])hsr.getParameterValues("bookTitle");
            String[] authorVal = (String[])hsr.getParameterValues("author");
            String[] priceVal = (String[])hsr.getParameterValues("price");
        
            addBooksDAO.addBook(isbnVal,titleVal,authorVal,priceVal);
        
            mv.setViewName("Success");
            return mv;
    }
    
}
