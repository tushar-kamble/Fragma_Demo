package com.example.fragma_demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.fragma_demo.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e Where e.employeeId =:id")
	public Employee getEmployeeById(Long id) throws Exception;

	@Query("SELECT e FROM Employee e ")
	public List<Employee> getAllEmployee() throws Exception;
	
	@Query("SELECT e FROM Employee e where isStatus = 1")
	public List<Employee> getAllAciveEmployee() throws Exception;
}
