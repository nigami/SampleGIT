package com.project.trading.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class investorWorkAreaController {

	@RequestMapping(value="/investorWorkspace.htm", method=RequestMethod.GET)
	public String investorWorkarea()
	{
		return "success";
	}
}
