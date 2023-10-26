package com.cleancode.demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

public class EmployeeBuilder {
	
	private Department dept;
	
	public EmployeeBuilder setDepartment(Department dept) {
		this.dept = dept;
		return this;
	}

	public Map<String, String> buildMap() throws EmptyDepartmentException {
		if(ObjectUtils.isEmpty(dept))
			throw new EmptyDepartmentException();
		
		if (CollectionUtils.isEmpty(dept.getEmployees())) {
			return Collections.emptyMap();
		}

		Map<String, String> empMap = new HashMap<>();
		for (Employee emp : dept.getEmployees()) {
			empMap.put(emp.getMobileNo(), emp.getInfo());
		}

		return empMap;
	}
	
}
