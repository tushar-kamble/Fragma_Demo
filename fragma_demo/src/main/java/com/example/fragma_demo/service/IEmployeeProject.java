package com.example.fragma_demo.service;

import com.example.fragma_demo.dto.EmployeeProjectDto;
import com.example.fragma_demo.entity.Employee_Project;

public interface IEmployeeProject {

	public boolean isAssignProjecttoEmployee(EmployeeProjectDto employeeProjectDto)throws Exception;
	
	public boolean isReleaseProjecttoEmployee(EmployeeProjectDto employeeProjectDto)throws Exception;
	
	public Employee_Project getEmployeeProjectDetail(Long id)throws Exception;
}
