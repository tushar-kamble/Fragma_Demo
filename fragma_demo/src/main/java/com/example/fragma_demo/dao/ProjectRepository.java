package com.example.fragma_demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.fragma_demo.entity.Project;

@Component
public interface ProjectRepository extends CrudRepository<Project, Long>{

	
	//public void isSaveproject(Project projectdto) throws Exception;

	@Query("SELECT p FROM Project p Where p.projectId =:projectId")
	public Project getProjectById(Long projectId) throws Exception;

	@Query("SELECT p FROM Project p ")
	public List<Project> getAllProject() throws Exception;
	
	@Query("SELECT p FROM Project p where isStatus = 1")
	public List<Project> getAllAciveProject() throws Exception;
}
