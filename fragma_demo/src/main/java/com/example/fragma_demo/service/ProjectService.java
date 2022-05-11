package com.example.fragma_demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fragma_demo.dao.ProjectRepository;
import com.example.fragma_demo.dto.ProjectDto;
import com.example.fragma_demo.entity.Project;

@Service
@Transactional
public class ProjectService implements IProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public ProjectDto getProjectById(Long projectId) throws Exception {
		// TODO Auto-generated method stub
		try {
			ProjectDto project = new ProjectDto();

			// Get the result by query
			Project projectOrm = projectRepository.getProjectById(projectId);

			// Use the existing JPA properties
			// Optional<Project> projectTest = projectRepository.findById(projectId);

			if (projectOrm == null)
				throw new Exception("record not found");

			project.setProjectId(projectOrm.getProjectId());
			project.setClientName(projectOrm.getClientName());
			project.setDescription(projectOrm.getDescription());
			project.setProjectName(projectOrm.getProjectName());
			project.setTeamSize(projectOrm.getTeamSize());

			project.setStartDate(projectOrm.getStartDate() != null ? projectOrm.getStartDate().getTime() : null);
			project.setEndDate(projectOrm.getEndDate() != null ? projectOrm.getEndDate().getTime() : null);

			return project;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<ProjectDto> getAllProject() throws Exception {
		// TODO Auto-generated method stub
		try {
			List<Project> projectList = projectRepository.getAllProject();

			if (projectList == null || projectList.isEmpty())
				throw new Exception("Records not found");
			// Use Existing JPA functionality
			// List<Project> projectList = (List<Project>) projectRepository.findAll();
			return this.convertProjectORMtoDTO(projectList);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean isSaveproject(ProjectDto projectdto) throws Exception {
		// TODO Auto-generated method stub
		try {
			Project project = new Project();

			project.setProjectId(projectdto.getProjectId() != null ? projectdto.getProjectId() : null);
			project.setClientName(projectdto.getClientName());
			project.setDescription(projectdto.getDescription());
			project.setProjectName(projectdto.getProjectName());
			project.setTeamSize(projectdto.getTeamSize());
			project.setStatus(true);
			project.setStartDate(projectdto.getStartDate() != null ? new Date(projectdto.getStartDate()) : null);
			project.setEndDate(projectdto.getEndDate() != null ? new Date(projectdto.getEndDate()) : null);

			projectRepository.save(project);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<ProjectDto> getAllAciveProject() throws Exception {
		// TODO Auto-generated method stub
		try {
			List<Project> projectList = projectRepository.getAllAciveProject();

			if (projectList == null || projectList.isEmpty())
				throw new Exception("Records not found");
			// Use Existing JPA functionality
			// List<Project> projectList = (List<Project>) projectRepository.findAll();
			return this.convertProjectORMtoDTO(projectList);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	public List<ProjectDto> convertProjectORMtoDTO(List<Project> projectList) {

		List<ProjectDto> projectdtoList = new ArrayList<>();

		for (Project projectOrm : projectList) {

			ProjectDto project = new ProjectDto();

			project.setProjectId(projectOrm.getProjectId());
			project.setClientName(projectOrm.getClientName());
			project.setDescription(projectOrm.getDescription());
			project.setProjectName(projectOrm.getProjectName());
			project.setTeamSize(projectOrm.getTeamSize());
			project.setStatus(projectOrm.isStatus());
			project.setStartDate(projectOrm.getStartDate() != null ? projectOrm.getStartDate().getTime() : null);
			project.setEndDate(projectOrm.getEndDate() != null ? projectOrm.getEndDate().getTime() : null);
			projectdtoList.add(project);
		}

		return projectdtoList;
	}

	@Override
	public List<ProjectDto> getPagableProject(Long id) throws Exception {
		// TODO Auto-generated method stub
		try {
			Pageable pageable = PageRequest.of(id.intValue(), 10, Sort.by("Email").ascending());
			Page<Project> page = projectRepository.findAll(pageable);

			if (page != null && page.getContent() != null)
				return this.convertProjectORMtoDTO(page.getContent());
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<ProjectDto> getFilterProjectDetails(String key, String id) throws Exception {
		// TODO Auto-generated method stub
		try {
			if (key != null && !key.isEmpty() && key.equalsIgnoreCase("clientname")) {
				List<Project> projects = projectRepository.getFilteredProjectByClientName(id);
			
				return this.convertProjectORMtoDTO(projects);
			}

			if (key != null && !key.isEmpty() && key.equalsIgnoreCase("projectname")) {
				List<Project> projects = projectRepository.getFilteredProjectByName(id);
				return this.convertProjectORMtoDTO(projects);
			}
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
}
