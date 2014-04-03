package com.spring.hibernate.controller;

import org.apache.log4j.Logger;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.hibernate.model.SearchUser;
import com.spring.hibernate.model.User;
import com.spring.hibernate.service.AdminService;
import com.spring.hibernate.service.UserService;

@Controller
public class AdminController {
	private static final Logger logger = Logger.getLogger(AdminController.class);
			@Autowired
			private AdminService adminService;
	
			@RequestMapping(value="/adminService",method=RequestMethod.GET)
			public String loadSearchUser(Model map,@RequestParam ("message")  String msg){
				logger.info("inside AdminController:adminService:GET");
				
				map.addAttribute("message", msg);
				map.addAttribute("searchUser", new SearchUser());
				map.addAttribute("userList", adminService.getUserView());
				
				logger.info("outside AdminController:adminService:GET");
				
				return "admin/searchUser";
			
			}

			@RequestMapping(value="/resetUser",method=RequestMethod.GET)
			public ModelAndView restUser(@RequestParam ("userId")  int userId){
				logger.info("inside AdminController:restUser:GET");
				
				ModelAndView mav = new ModelAndView();
				mav.setViewName("admin/resetUser");
				mav.addObject("user", adminService.findUserByUserId(userId));

				logger.info("outside AdminController:restUser:GET");
				
				return mav;
			
			}

			@RequestMapping(value="/resetUser",method=RequestMethod.POST)
			public String resetUser(Model model,@ModelAttribute(value="user") User user,BindingResult result){
				logger.info("inside AdminController:resetUser:POST");
				
				adminService.resetPassword(user.getUserName(),user.getPassword());
				model.addAttribute("message", "Password reset successfully");
				
				logger.info("outside AdminController:resetUser:POST");

				return "redirect:/adminService";
			
			}
			
			@RequestMapping(value="/adminService",method=RequestMethod.POST)
			public ModelAndView performUserSearch(@ModelAttribute(value="searchUser") SearchUser searchUser,BindingResult result){
				logger.info("inside AdminController:performUserSearch:adminService:POST");

				ModelAndView mav = new ModelAndView();
				mav.setViewName("admin/searchUser");
				mav.addObject("userList", adminService.findUserByEmailId(searchUser.getEmailId()));
				mav.addObject("message", "Please see below search result");
				
				logger.info("outside AdminController:performUserSearch:adminService:POST");

				return mav;
			}
			
			@RequestMapping(value="/activateUser",method=RequestMethod.POST)
			public String activeUser(Model model,@RequestParam ("userId")  int userId){
				logger.info("inside AdminController:activeUser:POST");
				
				// Calling the Service Layer ...-> DAO layer ..
				
				// We need to make sure the Default Values are Managed and Setter Methods of the Model Class Called to provide the values ..
				adminService.activateUser(userId);
				model.addAttribute("message", "User activated successfully");

				logger.info("outside AdminController:activeUser:POST");

				return "redirect:/adminService";
			}
			
			@RequestMapping(value="/deactivateUser",method=RequestMethod.POST)
			public String deactiveUser(Model model,@RequestParam ("userId")  int userId){
				logger.info("inside AdminController:deactiveUser:POST");
				
				// Calling the Service Layer ...-> DAO layer ..
				
				// We need to make sure the Default Values are Managed and Setter Methods of the Model Class Called to provide the values ..
				adminService.deactivateUser(userId);
				model.addAttribute("message", "User deactivated successfully");
				
				logger.info("outside AdminController:deactiveUser:POST");

				return "redirect:/adminService";
			}
	
			@RequestMapping(value="/adminUserView",method=RequestMethod.GET)
			public String viewUser(Model map){
				logger.info("inside AdminController:adminUserView:GET");
				
				map.addAttribute("userList", adminService.getUserView());
				
				logger.info("outside AdminController:adminUserView:GET");
				
				return "admin/adminUserView";
			}
			
			

}
