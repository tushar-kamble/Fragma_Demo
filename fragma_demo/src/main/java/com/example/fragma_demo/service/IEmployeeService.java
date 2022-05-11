package com.example.fragma_demo.service;

import java.util.List;

import com.example.fragma_demo.dto.EmployeeDto;

public interface IEmployeeService {

	public boolean isSaveEmployee(EmployeeDto employeeDto) throws Exception;

	public EmployeeDto getEmployeeById(Long employeeId) throws Exception;

	public List<EmployeeDto> getAllEmployeedetails() throws Exception;

	public List<EmployeeDto> getActiveEmployees() throws Exception;

	public List<EmployeeDto> getPagableEmployee(Long id) throws Exception;

	public List<EmployeeDto> getFilterEmployeedetails(String key, String id) throws Exception;
}
