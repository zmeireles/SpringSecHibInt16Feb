package com.spring.hibernate.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.hibernate.model.Role;
import com.spring.hibernate.model.User;
import com.spring.hibernate.service.RoleService;

@Controller
@RequestMapping
public class RoleController {

	@Autowired
	private RoleService roleService;
	private static final Logger logger = Logger.getLogger(RoleController.class);

	@RequestMapping(value = "/searchrole", method = RequestMethod.GET)
	public String loadSearchRole(Model map) {
		logger.info("inside RoleControllerr:loadSearchRole");
		map.addAttribute("Msg", "This is used to Create Role Loading Page");
		map.addAttribute("role", new Role());
		return "role/roleView";

	}

	@RequestMapping(value = "/searchrole", method = RequestMethod.POST)
	public ModelAndView performRoleSearch(
			@ModelAttribute(value = "role") Role role, BindingResult result) {
		ModelAndView mavObj = new ModelAndView();
		logger.info("inside RoleControllerr:performRoleSearch");
		mavObj.setViewName("role/roleView");
		mavObj.addObject("roleList",
				roleService.findRoleByName(role.getName()));
		logger.info("exiting RoleControllerr:performRoleSearch"
				+ roleService.findRoleByName(role.getName()).size());

		return mavObj;
	}

	@RequestMapping(value = "/createrole", method = RequestMethod.GET)
	public String createRole(Model map) {
		map.addAttribute("Msg", "This is used to Create User Loading Page");
		map.addAttribute("role", new Role());
		logger.info("inside RoleControllerr:createRole");

		return "role/roleCreation";
	}

	@RequestMapping(value = "/insertRole", method = RequestMethod.POST)
	public String performInsertRole(
			@ModelAttribute(value = "role") Role role, BindingResult result) {
		roleService.createRole(role);
		logger.info("inside RoleControllerr:performInsertRole");
		return "role/success";
	}
	
	@RequestMapping(value="/roleViewList",method=RequestMethod.GET)
	public String viewUser(Model map){
		logger.info("inside RoleControllerr:viewUser");
		map.addAttribute("roleList", roleService.getRoleView());
		return "role/roleView";
	}
	@RequestMapping(value="/deleterole", method=RequestMethod.GET)
	public String deleteRoleByName(Model map){
		logger.info("inside RoleControllerr:deleteRoleByName");
		map.addAttribute("role", new Role());
		return "role/deleteRole";
	}
	
	@RequestMapping(value="/deleterole", method=RequestMethod.POST)
	public ModelAndView deleteRole(@ModelAttribute(value="role") Role role, BindingResult result){
		logger.info("inside RoleControllerr:deleteRole"+role.getName());
		ModelAndView mavobj = new ModelAndView();
		
		mavobj.setViewName("role/success");
		roleService.deleteRole(role.getName());
		return mavobj;
	}

}
