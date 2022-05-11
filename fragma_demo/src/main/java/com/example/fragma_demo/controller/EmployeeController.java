package com.example.fragma_demo.controller;

import java.util.List;

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

import com.example.fragma_demo.dto.EmployeeDto;
import com.example.fragma_demo.dto.FragmaResponse;
import com.example.fragma_demo.dto.FragmaResult;
import com.example.fragma_demo.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping(value = "/registerEmployee")
	public FragmaResponse<Boolean> addProject(@RequestBody EmployeeDto employeeDto, HttpServletRequest httpRequest,
			@RequestHeader HttpHeaders headers) {

		FragmaResponse<Boolean> fragmaResponse = new FragmaResponse<>();
		FragmaResult<Boolean> fragmaResult = new FragmaResult<>();
		try {

			boolean isSave = employeeService.isSaveEmployee(employeeDto);

			fragmaResult.setResult(isSave);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.OK.value());
			fragmaResponse.setStatusMessage(
					employeeDto.getEmployeeId() != null ? "Update employee successfully" : "Add employee successfully");

			return fragmaResponse;

		} catch (Exception e) {

			fragmaResult.setResult(false);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			fragmaResponse.setStatusMessage(e.getMessage());

			return fragmaResponse;
		}
	}

	@GetMapping(value = "/getEmployeeById/{id}")
	public FragmaResponse<EmployeeDto> getProjectById(@PathVariable Long id, HttpServletRequest httpRequest,
			@RequestHeader HttpHeaders headers) {

		FragmaResponse<EmployeeDto> fragmaResponse = new FragmaResponse<>();
		FragmaResult<EmployeeDto> fragmaResult = new FragmaResult<>();
		try {

			EmployeeDto employee = employeeService.getEmployeeById(id);

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

	@GetMapping(value = "/getAllEmployeedetails")
	public FragmaResponse<List<EmployeeDto>> getAllEmployeedetails(@RequestHeader HttpHeaders headers) {

		FragmaResponse<List<EmployeeDto>> fragmaResponse = new FragmaResponse<>();
		FragmaResult<List<EmployeeDto>> fragmaResult = new FragmaResult<>();
		try {

			List<EmployeeDto> employeeDtos = employeeService.getAllEmployeedetails();

			fragmaResult.setResult(employeeDtos);
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

	@GetMapping(value = "/getActiveEmployees")
	public FragmaResponse<List<EmployeeDto>> getActiveEmployees(@RequestHeader HttpHeaders headers) {

		FragmaResponse<List<EmployeeDto>> fragmaResponse = new FragmaResponse<>();
		FragmaResult<List<EmployeeDto>> fragmaResult = new FragmaResult<>();
		try {

			List<EmployeeDto> employeeDtos = employeeService.getActiveEmployees();

			fragmaResult.setResult(employeeDtos);
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

	@GetMapping(value = "/page/getEmployees/{id}")
	public FragmaResponse<List<EmployeeDto>> getEmployees(@PathVariable Long id, @RequestHeader HttpHeaders headers) {

		FragmaResponse<List<EmployeeDto>> fragmaResponse = new FragmaResponse<>();
		FragmaResult<List<EmployeeDto>> fragmaResult = new FragmaResult<>();
		try {

			List<EmployeeDto> employeeDtos = employeeService.getPagableEmployee(id);

			fragmaResult.setResult(employeeDtos);
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

	@GetMapping(value = "/filter/getEmployees/{key}/{id}")
	public FragmaResponse<List<EmployeeDto>> getFilterEmployees(@PathVariable String key, @PathVariable String id,
			@RequestHeader HttpHeaders headers) {

		FragmaResponse<List<EmployeeDto>> fragmaResponse = new FragmaResponse<>();
		FragmaResult<List<EmployeeDto>> fragmaResult = new FragmaResult<>();
		try {

			List<EmployeeDto> employeeDtos = employeeService.getFilterEmployeedetails(key, id);

			fragmaResult.setResult(employeeDtos);
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
