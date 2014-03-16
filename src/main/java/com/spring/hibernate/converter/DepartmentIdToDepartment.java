package com.spring.hibernate.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.spring.hibernate.model.Department;
import com.spring.hibernate.service.DepartmentService;

public final class DepartmentIdToDepartment implements Converter<Integer, Department>{
	
	@Autowired
	DepartmentService departmentService;

	@Override
	public Department convert(Integer source) {
		return departmentService.getDepartment(source);
	}
	

}
