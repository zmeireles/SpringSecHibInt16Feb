package com.spring.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.hibernate.service.UtilService;

@Controller
public class UtilityController {
	
	@Autowired
	private UtilService utilService;

	@RequestMapping(value="/util",method=RequestMethod.GET)
	public String loadUtilPage(Model map){
		
		return "utilPage";
	}
	
	@RequestMapping(value="/initUsers",method=RequestMethod.GET)
	public String initUsers(){
		System.out.println("Init users");
		utilService.initUsers();
		return "utilPage";
	}
	
	@RequestMapping(value="/initDepartments",method=RequestMethod.GET)
	public String initDepartments(){
		System.out.println("Init departpments");
		utilService.initDepartments();
		return "utilPage";
	}
}
