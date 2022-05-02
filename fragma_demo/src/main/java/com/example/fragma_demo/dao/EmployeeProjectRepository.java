package com.example.fragma_demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.fragma_demo.entity.Employee_Project;

@Component
public interface EmployeeProjectRepository extends CrudRepository<Employee_Project, Long> {

	@Query("SELECT p FROM Employee_Project p Where p.id =:id")
	public Employee_Project getEmployeeProjectbyId(Long id) throws Exception;

}
