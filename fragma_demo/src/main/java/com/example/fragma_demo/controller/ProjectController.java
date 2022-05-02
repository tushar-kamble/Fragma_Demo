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

import com.example.fragma_demo.dto.FragmaResponse;
import com.example.fragma_demo.dto.FragmaResult;
import com.example.fragma_demo.dto.ProjectDto;
import com.example.fragma_demo.service.IProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private IProjectService projectService;

	@PostMapping(value = "/addProject")
	public FragmaResponse<Boolean> addProject(@RequestBody ProjectDto projectDto, HttpServletRequest httpRequest,
			@RequestHeader HttpHeaders headers) {

		FragmaResponse<Boolean> fragmaResponse = new FragmaResponse<>();
		FragmaResult<Boolean> fragmaResult = new FragmaResult<>();
		try {

			boolean isSave = projectService.isSaveproject(projectDto);

			fragmaResult.setResult(isSave);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.OK.value());
			fragmaResponse.setStatusMessage(
					projectDto.getProjectId() != null ? "Update project successfully" : "Add project successfully");

			return fragmaResponse;

		} catch (Exception e) {

			fragmaResult.setResult(false);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			fragmaResponse.setStatusMessage(e.getMessage());

			return fragmaResponse;
		}
	}

	@GetMapping(value = "/getProjectById/{id}")
	public FragmaResponse<ProjectDto> getProjectById(@PathVariable Long id, HttpServletRequest httpRequest,
			@RequestHeader HttpHeaders headers) {

		FragmaResponse<ProjectDto> fragmaResponse = new FragmaResponse<>();
		FragmaResult<ProjectDto> fragmaResult = new FragmaResult<>();
		try {

			ProjectDto projectDto = projectService.getProjectById(id);

			fragmaResult.setResult(projectDto);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.OK.value());
			fragmaResponse.setStatusMessage("get project details successfully");

			return fragmaResponse;

		} catch (Exception e) {

			fragmaResult.setResult(null);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			fragmaResponse.setStatusMessage(e.getMessage());

			return fragmaResponse;
		}
	}

	@GetMapping(value = "/getAllProject")
	public FragmaResponse<List<ProjectDto>> getAllProject(@RequestHeader HttpHeaders headers) {

		FragmaResponse<List<ProjectDto>> fragmaResponse = new FragmaResponse<>();
		FragmaResult<List<ProjectDto>> fragmaResult = new FragmaResult<>();
		try {

			List<ProjectDto> projectDtos = projectService.getAllProject();

			fragmaResult.setResult(projectDtos);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.OK.value());
			fragmaResponse.setStatusMessage("get project details successfully");

			return fragmaResponse;

		} catch (Exception e) {

			fragmaResult.setResult(null);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			fragmaResponse.setStatusMessage(e.getMessage());

			return fragmaResponse;
		}
	}

	@GetMapping(value = "/getAllAciveProject")
	public FragmaResponse<List<ProjectDto>> getAllAciveProject(@RequestHeader HttpHeaders headers) {

		FragmaResponse<List<ProjectDto>> fragmaResponse = new FragmaResponse<>();
		FragmaResult<List<ProjectDto>> fragmaResult = new FragmaResult<>();
		try {

			List<ProjectDto> projectDtos = projectService.getAllAciveProject();

			fragmaResult.setResult(projectDtos);
			fragmaResponse.setFragmaResult(fragmaResult);
			fragmaResponse.setStatusCode(HttpStatus.OK.value());
			fragmaResponse.setStatusMessage("get project details successfully");

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
