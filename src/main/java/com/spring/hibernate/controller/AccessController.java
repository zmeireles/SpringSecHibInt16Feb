package com.spring.hibernate.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.hibernate.service.CustomUserDetailsService;

@Controller
@RequestMapping
public class AccessController {

	private static final Logger logger = Logger.getLogger(AccessController.class);
	
	@RequestMapping
	public String getHomePage() {
		return "home";
	}
	
	@RequestMapping(value="/user")
	public String getUserPage() {
		return "user";
	}
	
	@RequestMapping(value="/admin")
	public String getAdminPage() {
		return "admin";
	}
	
	@RequestMapping(value = "/role")
 	public String loadSearchRole() {		
		return "role";
	}
	
	@RequestMapping("/login")
	public String login(Model model, @RequestParam(required=false) String message) {
		logger.info("inside AccessController:login");
		model.addAttribute("message", message);
		logger.info("outside AccessController:login");
		return "access/login";
	}
	
	@RequestMapping(value = "/denied")
 	public String denied() {
		logger.info("inside AccessController:denied");
		return "access/denied";
	}
	
	
	@RequestMapping(value = "/login/failure")
 	public String loginFailure() {
		logger.info("inside AccessController:loginFailure");
		String message = "Login Failure!";
		
		return "redirect:/login?message="+message;
	}
	
	@RequestMapping(value = "/logout/success")
 	public String logoutSuccess() {
		logger.info("inside AccessController:logoutSuccess");
		String message = "Logout Success!";
		return "redirect:/login?message="+message;
	}
}