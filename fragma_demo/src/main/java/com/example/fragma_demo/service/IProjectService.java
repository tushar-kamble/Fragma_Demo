package com.example.fragma_demo.service;

import java.util.List;

import com.example.fragma_demo.dto.ProjectDto;

public interface IProjectService {

	public boolean isSaveproject(ProjectDto projectdto) throws Exception;

	public ProjectDto getProjectById(Long projectId) throws Exception;

	public List<ProjectDto> getAllProject() throws Exception;

	public List<ProjectDto> getAllAciveProject() throws Exception;

	public List<ProjectDto> getPagableProject(Long id) throws Exception;

	public List<ProjectDto> getFilterProjectDetails(String key, String id) throws Exception;

}
