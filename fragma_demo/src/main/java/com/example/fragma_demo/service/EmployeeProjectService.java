package com.example.fragma_demo.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fragma_demo.dao.EmployeeProjectRepository;
import com.example.fragma_demo.dao.EmployeeRepository;
import com.example.fragma_demo.dao.ProjectRepository;
import com.example.fragma_demo.dto.EmployeeProjectDto;
import com.example.fragma_demo.entity.Employee;
import com.example.fragma_demo.entity.Employee_Project;
import com.example.fragma_demo.entity.Project;

@Service
@Transactional
public class EmployeeProjectService implements IEmployeeProject {

	@Autowired
	private EmployeeProjectRepository employeeprojectRepo;

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private ProjectRepository proRepo;

	@Override
	public boolean isAssignProjecttoEmployee(EmployeeProjectDto employeeProjectDto) throws Exception {
		// TODO Auto-generated method stub
		try {

			Employee employee = empRepo.getEmployeeById(employeeProjectDto.getEmployeeId());

			if (employee == null)
				throw new Exception("Employee Record not found");

			Project projectOrm = proRepo.getProjectById(employeeProjectDto.getProjectId());

			if (projectOrm == null)
				throw new Exception("project record not found");

			Employee_Project employeeProject = new Employee_Project();

			employeeProject.setCreatedDate(new Date());
			employeeProject.setEmployeeId(employee);
			employeeProject.setProjectId(projectOrm);
			employeeProject.setStatus(true);
			employeeProject.setStartDate(
					employeeProjectDto.getStartDate() != null ? new Date(employeeProjectDto.getStartDate()) : null);
			employeeProject.setEndDate(
					employeeProjectDto.getEndDate() != null ? new Date(employeeProjectDto.getEndDate()) : null);

			employeeprojectRepo.save(employeeProject);

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean isReleaseProjecttoEmployee(EmployeeProjectDto employeeProjectDto) throws Exception {
		// TODO Auto-generated method stub
		try {

			Employee_Project employeeProject = employeeprojectRepo
					.getEmployeeProjectbyId(employeeProjectDto.getEmployeeProjectId());

			if (employeeProject == null)
				throw new Exception("Record not found");

			employeeProject.setEndDate(new Date(employeeProjectDto.getEndDate()));
			employeeProject.setStatus(false);
			employeeprojectRepo.save(employeeProject);

			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Employee_Project getEmployeeProjectDetail(Long id) throws Exception {
		// TODO Auto-generated method stub
		Employee_Project employee_Project = employeeprojectRepo.findById(id).get();
		
		return employee_Project;
	}

}
