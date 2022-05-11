package com.example.fragma_demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
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

	Page<Employee> findAll(org.springframework.data.domain.Pageable pageable);

	public List<Employee> findByEmployeeName(String employeeName);

	public List<Employee> findByEmail(String email);

	public List<Employee> findByDesignation(String designation);

	@Query("SELECT e FROM Employee e where e.employeeName like %:id% ")
	public List<Employee> getFilteredEmployeeByName(String id) throws Exception;

	@Query("SELECT e FROM Employee e where e.email like %:id% ")
	public List<Employee> getFilteredEmployeeByEmail(String id) throws Exception;

	@Query("SELECT e FROM Employee e where e.designation like %:id% ")
	public List<Employee> getFilteredEmployeeByDesignation(String id) throws Exception;

	// Page<Employee> findByFirstName(String firstName, Pageable pageable);

	// Slice<Employee> findByFirstNameAndLastName(String firstName, String lastName,
	// Pageable pageable);
}
