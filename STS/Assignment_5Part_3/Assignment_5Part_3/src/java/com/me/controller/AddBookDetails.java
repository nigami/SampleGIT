/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import sun.misc.BASE64Decoder;

/**
 *
 * @author Avanish
 */
public class AddBookDetails extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        HttpSession session = hsr.getSession();
        ModelAndView mv = new ModelAndView();
        int val = (Integer.valueOf(hsr.getParameter("noOfBook")));

        session.setAttribute(
                "val", val);

        if (val
                > 0) {

            mv.setViewName("GetBookDetails");

        }

        return mv;
    }

}
