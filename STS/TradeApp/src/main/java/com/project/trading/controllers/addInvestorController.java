package com.project.trading.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.trading.DAO.InvestorDAO;
import com.project.trading.exception.AdException;
import com.project.trading.pojo.Investor;
import com.project.trading.pojo.User;

@Controller

public class addInvestorController {
	
	@RequestMapping(value="/addinvestor.htm" , method=RequestMethod.GET)
	public ModelAndView initializeform(@ModelAttribute("investor") Investor investor, BindingResult result){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(value="/addinvestor.htm", method=RequestMethod.POST)
	public ModelAndView investorDetailsAdd(@ModelAttribute("investor") Investor investor, BindingResult result)
	{
		ModelAndView mv=new ModelAndView();
		InvestorDAO investorDAO=new InvestorDAO();
		investorDAO.createInvestor(investor.getfName(), investor.getlName(), investor.geteMailID(), investor.getUserName(), investor.getPassword(), investor.getContact(), investor.getPanCardNum(), investor.getAccountNum(),investor.getAddress());
		mv.setViewName("success");
		return mv;
	}
	@RequestMapping(value="/searchinvestor.htm",method=RequestMethod.POST)
	public void searchInvestor(HttpServletRequest request,HttpServletResponse response) throws AdException, IOException{
		
		System.out.println("inside search investor");
		try{
		InvestorDAO investorDAO=new InvestorDAO();
		String uname=request.getParameter("Username");
		String pword=request.getParameter("password");
		Investor i=investorDAO.findInvestor(uname,pword);
		PrintWriter out= response.getWriter();
		
		if(i!=null)
		{
			HttpSession sess=request.getSession();
			sess.setAttribute("InvestorObject", i);
			out.println("true");
		}
		else if(i==null)
		{
			out.println("false");
		}
		}
	catch(AdException e)
	{
			System.out.println("Exception: " + e.getMessage());
	}
	}
	
	@RequestMapping(value="/searchinvestor.htm" , method=RequestMethod.GET)
	public ModelAndView initialize(@ModelAttribute("user") User user, BindingResult result)throws AdException{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	

}
