package com.example.fragma_demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fragma_demo.dto.EmployeeProjectDto;
import com.example.fragma_demo.dto.FragmaResponse;
import com.example.fragma_demo.dto.FragmaResult;
import com.example.fragma_demo.entity.Employee_Project;
import com.example.fragma_demo.service.IEmployeeProject;

@RestController
@RequestMapping("/employee_project")
public class EmployeeProjectController {

	@Autowired
	private IEmployeeProject employeeProject;

	@PostMapping(value = "/assignProject")
	public FragmaResponse<Boolean> assignProject(@RequestBody EmployeeProjectDto employeeProjectDto,
			HttpServletRequest httpRequest, @RequestHeader HttpHeaders headers) {

		FragmaResponse<Boolean> fragmaResponse = new FragmaResponse<>();
		FragmaResult<Boolean> fragmaResult = new FragmaResult<>();
		try {

			boolean isSave = employeeProject.isAssignProjecttoEmployee(employeeProjectDto);

			fragmaResult.setResult(isSave);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.OK.value());
			fragmaResponse.setStatusMessage("Assign project successfully");

			return fragmaResponse;

		} catch (Exception e) {

			fragmaResult.setResult(false);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			fragmaResponse.setStatusMessage(e.getMessage());

			return fragmaResponse;
		}
	}

	@PostMapping(value = "/releaseProject")
	public FragmaResponse<Boolean> releaseProject(@RequestBody EmployeeProjectDto employeeProjectDto,
			HttpServletRequest httpRequest, @RequestHeader HttpHeaders headers) {

		FragmaResponse<Boolean> fragmaResponse = new FragmaResponse<>();
		FragmaResult<Boolean> fragmaResult = new FragmaResult<>();
		try {

			Boolean isRelease = employeeProject.isReleaseProjecttoEmployee(employeeProjectDto);

			fragmaResult.setResult(isRelease);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.OK.value());
			fragmaResponse.setStatusMessage("Release employee successfully");

			return fragmaResponse;

		} catch (Exception e) {

			fragmaResult.setResult(false);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			fragmaResponse.setStatusMessage(e.getMessage());

			return fragmaResponse;
		}
	}

	@GetMapping(value = "/getEmployeeProjectDetail/{id}")
	public FragmaResponse<Employee_Project> getProjectById(@PathVariable Long id, HttpServletRequest httpRequest,
			@RequestHeader HttpHeaders headers) {

		FragmaResponse<Employee_Project> fragmaResponse = new FragmaResponse<>();
		FragmaResult<Employee_Project> fragmaResult = new FragmaResult<>();
		try {

			Employee_Project employee = employeeProject.getEmployeeProjectDetail(id);

			fragmaResult.setResult(employee);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.OK.value());
			fragmaResponse.setStatusMessage("get employee details successfully");

			return fragmaResponse;

		} catch (Exception e) {

			fragmaResult.setResult(null);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			fragmaResponse.setStatusMessage(e.getMessage());

			return fragmaResponse;
		}
	}
}
