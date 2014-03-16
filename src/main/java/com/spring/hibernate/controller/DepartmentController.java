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
import org.springframework.web.servlet.ModelAndView;

import com.spring.hibernate.model.Department;
import com.spring.hibernate.service.DepartmentService;

@Controller
@RequestMapping
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private static final Logger logger = Logger
			.getLogger(DepartmentController.class);

	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public String departmentsHome(Model map) {
		map.addAttribute("depList", departmentService.getDepartments());
		logger.info("Deparments count:"
				+ departmentService.getDepartments().size());
		return "department/departmentsHome";
	}

	@RequestMapping(value = "/createDepartment", method = RequestMethod.GET)
	public String createDepartment(Model map) {

		map.addAttribute("msg", "New Department");
		map.addAttribute("action", "insertDepartment");
		map.addAttribute("department", new Department());
		return "department/editDepartment";
	}

	@RequestMapping(value = "/editDepartment", method = RequestMethod.GET)
	public String updateDepartment(Model map, @RequestParam(value = "id") int id) {

		logger.info("updateDepartment: id:" + id);
		map.addAttribute("msg", "Edit Department");
		map.addAttribute("action", "editDepartment");
		map.addAttribute("department", departmentService.getDepartment(id));
		return "department/editDepartment";
	}

	@RequestMapping(value = "/editDepartment", method = RequestMethod.POST)
	public String editDepartment(
			@ModelAttribute(value = "department") Department dep,
			BindingResult result) {

		System.out.println("editDepartment - Department name:" + dep.getName() + " id:" + dep.getId());
		departmentService.updateDepartment(dep);
		return "redirect:/departments";
	}

	@RequestMapping(value = "/insertDepartment", method = RequestMethod.POST)
	public String insertDepartment(
			@ModelAttribute(value = "department") Department dep,
			BindingResult result) {

		departmentService.insertDepartment(dep);
		return "redirect:/departments";
	}

	@RequestMapping(value = "/deleteDepartment", method = RequestMethod.GET)
	public String deleteDepartment(Model map, @RequestParam(value = "id") int id) {
		departmentService.deleteDepartment(id);
		return "redirect:/departments";
	}

}
