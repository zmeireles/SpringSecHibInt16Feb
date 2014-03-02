package com.spring.hibernate.controller;

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
			
			@Autowired
			private AdminService adminService;
	
			@RequestMapping(value="/adminService",method=RequestMethod.GET)
			public String loadSearchUser(Model map){
				
				map.addAttribute("Msg", "This is used to Create User Loading Page");
				map.addAttribute("searchUser", new SearchUser());
				
				//Load The Department From The Table will be displayed in UI in combo box
				//Load The Project From The Table will be displayed in UI in combo box
				//Load The Location From The Table will be displayed in UI in combo box
				
				return "admin/searchUser";
			
			}

			@RequestMapping(value="/resetUser",method=RequestMethod.GET)
			public ModelAndView restUser(@RequestParam ("userId")  int userId){
				
				ModelAndView mav = new ModelAndView();
				mav.setViewName("admin/resetUser");
				mav.addObject("user", adminService.findUserByUserId(userId));
				//Load The Department From The Table will be displayed in UI in combo box
				//Load The Project From The Table will be displayed in UI in combo box
				//Load The Location From The Table will be displayed in UI in combo box
				
				return mav;
			
			}

			@RequestMapping(value="/resetUser",method=RequestMethod.POST)
			public String restUser(@ModelAttribute(value="user") User user,BindingResult result){
				
				adminService.resetPassword(user.getUserName(),user.getPassword());
				return "redirect:/admin/adminUserView";
			
			}
			
			@RequestMapping(value="/adminService",method=RequestMethod.POST)
			public ModelAndView performUserSearch(@ModelAttribute(value="searchUser") SearchUser searchUser,BindingResult result){
				
				//map.addAttribute("Msg", "This is used to Create User Loading Page");
				//map.addAttribute("user", adminService.searchUser(userId));
				ModelAndView mav = new ModelAndView();
				//Load The Department From The Table will be displayed in UI in combo box
				//Load The Project From The Table will be displayed in UI in combo box
				//Load The Location From The Table will be displayed in UI in combo box
				//;
				mav.setViewName("admin/searchUser");
				mav.addObject("userList", adminService.findUserByEmailId(searchUser.getEmailId()));
				return mav;
			}
			
			@RequestMapping(value="/activateUser",method=RequestMethod.POST)
			public String activeUser(@RequestParam ("userId")  int userId){
				
				// Calling the Service Layer ...-> DAO layer ..
				
				// We need to make sure the Default Values are Managed and Setter Methods of the Model Class Called to provide the values ..
				adminService.activateUser(userId);
				return "redirect:/admin/adminUserView";
			}
			
			@RequestMapping(value="/deactivateUser",method=RequestMethod.POST)
			public String deactiveUser(@RequestParam ("userId")  int userId){
				
				// Calling the Service Layer ...-> DAO layer ..
				
				// We need to make sure the Default Values are Managed and Setter Methods of the Model Class Called to provide the values ..
				adminService.deactivateUser(userId);
				return "redirect:/admin/adminUserView";
			}
	
			@RequestMapping(value="/adminUserView",method=RequestMethod.GET)
			public String viewUser(Model map){
				map.addAttribute("userList", adminService.getUserView());
				return "admin/adminUserView";
			}
			
			

}
