/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.DAO.SalesDAO;
import com.me.pojo.Sales;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Avanish
 */
public class CsvController extends AbstractController {

    private SalesDAO salesDAO;

    ArrayList<Sales> sList = null;
    static int count = 0;
    int numberOfrows = 0;

    Integer totalPages = 0;
    int pagesToShow = 10;

    public CsvController(SalesDAO salesDAO) {

        this.salesDAO = salesDAO;

    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        HttpSession session = hsr.getSession();
        String action = hsr.getParameter("action");

        if (action.equalsIgnoreCase("display")) {
            int page = 1;
            mv = new ModelAndView();

            if (hsr.getParameter("page") != null) {
                page = Integer.parseInt(hsr.getParameter("page"));
            }
            //currentPage=currentPage+1;
            sList = salesDAO.getDetailsFromCsv(page * 100);
            totalPages = salesDAO.getnoOfRecords() / 100;

            System.out.println("page number clicked" + page);
            hsr.setAttribute("sList", sList);
            if (page >= 1 && page < 10) {
                pagesToShow = 10;
                hsr.setAttribute("totalPages", pagesToShow);
            } else if (page >= 10 && page < totalPages) {

                pagesToShow = page + 10;
                hsr.setAttribute("totalPages", pagesToShow);
            }
            //hsr.setAttribute("totalPages", totalPages);
            hsr.setAttribute("currentPage", page);
            mv.setViewName("index");

        } else if (action.equalsIgnoreCase("addToDb")) {
            mv = new ModelAndView();
            numberOfrows = sList.size();

            System.out.println("inside add to db");
            
            Enumeration vals = hsr.getParameterNames();
            ArrayList<String> str = new ArrayList();
            
            while(vals.hasMoreElements()){
                
                
                String par = hsr.getParameter((String)vals.nextElement());
                if(!par.equalsIgnoreCase("addToDb"))
                str.add(par);
            }
            
            salesDAO.addToDb(str);
            session.setAttribute("numberOfrows", numberOfrows);
            mv.setViewName("index");
        }

        return mv;
    }

}
