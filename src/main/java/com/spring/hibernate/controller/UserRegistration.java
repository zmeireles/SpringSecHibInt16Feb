package com.spring.hibernate.controller;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.hibernate.model.User;
import com.spring.hibernate.service.DepartmentService;
import com.spring.hibernate.service.UserService;


@Controller
public class UserRegistration {
			
			@Autowired
			private UserService userService;
			
			@Autowired
			private DepartmentService departmentService;
			
			private static final Logger logger = Logger.getLogger(UserRegistration.class);
	
			@RequestMapping(value="/userRegistration",method=RequestMethod.GET)
			public String loadUserRegistration(Model map){
				
				map.addAttribute("Msg", "This is used to Create User Loading Page");
				map.addAttribute("user", new User());
				map.addAttribute("departments",departmentService.getDepartments());
				
				//Load The Department From The Table will be displayed in UI in combo box
				//Load The Project From The Table will be displayed in UI in combo box
				//Load The Location From The Table will be displayed in UI in combo box
				
				return "user/registerUser";
			}
			
			@RequestMapping(value="/editUser",method=RequestMethod.GET)
			public String editUser(Model map,@RequestParam(value="id") int id){
				
				map.addAttribute("Msg", "Edit User");
				map.addAttribute("user", userService.getUser(id));
				map.addAttribute("departments",departmentService.getDepartments());
				
				//Load The Department From The Table will be displayed in UI in combo box
				//Load The Project From The Table will be displayed in UI in combo box
				//Load The Location From The Table will be displayed in UI in combo box
				
				return "user/registerUser";
			}
			
			@RequestMapping(value="/insertUser",method=RequestMethod.POST)
			public String insertUser(@ModelAttribute(value="user") User user,BindingResult result){
				
				// Calling the Service Layer ...-> DAO layer ..
				
				// We need to make sure the Default Values are Managed and Setter Methods of the Model Class Called to provide the values ..
				System.out.println("user id:"+user.getUserId());
				System.out.println("user department:"+user.getDepartment());
				if(user.getUserId()==0)
					userService.insertUser(user);
				else
					userService.updateUser(user);
				return "redirect:/userViewList";
			}
	
			@RequestMapping(value="/userViewList",method=RequestMethod.GET)
			public String viewUser(Model map){
				map.addAttribute("userList", userService.getUserView());
				return "user/viewUser";
			}
			
			@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
			public String deleteUser(Model map,@RequestParam(value="id") int id){
				userService.deleteUser(id);
				return "redirect:/userViewList";
			}
			
			

}
