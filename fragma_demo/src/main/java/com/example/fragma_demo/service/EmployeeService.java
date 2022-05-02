package com.example.fragma_demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fragma_demo.dao.EmployeeRepository;
import com.example.fragma_demo.dto.EmployeeDto;
import com.example.fragma_demo.entity.Employee;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public boolean isSaveEmployee(EmployeeDto employeeDto) throws Exception {
		// TODO Auto-generated method stub
		try {

			Employee employee = new Employee();

			employee.setEmployeeId(employeeDto.getEmployeeId() != null ? employeeDto.getEmployeeId() : null);
			employee.setAddress(employeeDto.getAddress());
			employee.setCity(employeeDto.getCity());
			employee.setCountry(employeeDto.getCountry());
			employee.setDesignation(employeeDto.getDesignation());
			employee.setEmail(employeeDto.getEmail());
			employee.setEmployeeName(employeeDto.getEmployeeName());
			employee.setGender(employeeDto.getGender());
			employee.setJoiningDate(
					employeeDto.getJoiningDate() != null ? new Date(employeeDto.getJoiningDate()) : null);
			employee.setMobileNumber(employeeDto.getMobileNumber());
			employee.setState(employeeDto.getState());
			employee.setCreatedDate(new Date());
			employee.setStatus(true);

			employeeRepo.save(employee);

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) throws Exception {
		// TODO Auto-generated method stub
		try {

			Employee employee = employeeRepo.getEmployeeById(employeeId);
			// Optional<Employee> employee = employeeRepo.findById(employeeId);

			if (employee == null)
				throw new Exception("Record not found");

			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setAddress(employee.getAddress());
			employeeDto.setCity(employee.getCity());
			employeeDto.setCountry(employee.getCountry());
			employeeDto.setDesignation(employee.getDesignation());
			employeeDto.setEmail(employee.getEmail());
			employeeDto.setEmployeeId(employee.getEmployeeId());
			employeeDto.setEmployeeName(employee.getEmployeeName());
			employeeDto.setGender(employee.getGender());
			employeeDto.setMobileNumber(employee.getMobileNumber());
			employeeDto.setJoiningDate(employee.getJoiningDate() != null ? employee.getJoiningDate().getTime() : null);
			employeeDto.setState(employee.getState());

			return employeeDto;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<EmployeeDto> getAllEmployeedetails() throws Exception {
		// TODO Auto-generated method stub
		try {

			List<Employee> employees = employeeRepo.getAllEmployee();

			if (employees == null || employees.isEmpty())
				throw new Exception("Records not found");

			return this.convertOrmToDtoEmployee(employees);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<EmployeeDto> getActiveEmployees() throws Exception {
		// TODO Auto-generated method stub
		try {

			List<Employee> employees = employeeRepo.getAllAciveEmployee();

			if (employees == null || employees.isEmpty())
				throw new Exception("Records not found");

			return this.convertOrmToDtoEmployee(employees);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	public List<EmployeeDto> convertOrmToDtoEmployee(List<Employee> employees) {

		List<EmployeeDto> employeeDtos = new ArrayList<>();

		for (Employee employee : employees) {

			EmployeeDto employeeDto = new EmployeeDto();

			employeeDto.setAddress(employee.getAddress());
			employeeDto.setCity(employee.getCity());
			employeeDto.setCountry(employee.getCountry());
			employeeDto.setDesignation(employee.getDesignation());
			employeeDto.setEmail(employee.getEmail());
			employeeDto.setEmployeeId(employee.getEmployeeId());
			employeeDto.setEmployeeName(employee.getEmployeeName());
			employeeDto.setGender(employee.getGender());
			employeeDto.setMobileNumber(employee.getMobileNumber());
			employeeDto.setJoiningDate(employee.getJoiningDate() != null ? employee.getJoiningDate().getTime() : null);
			employeeDto.setState(employee.getState());

			employeeDtos.add(employeeDto);
		}

		return employeeDtos;
	}
}
