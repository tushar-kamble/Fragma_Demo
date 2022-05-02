package com.example.fragma_demo.dto;

public class EmployeeProjectDto {

	public Long employeeProjectId;
	public Long projectId;
	public Long employeeId;
	public Long startDate;
	public Long endDate;
	public Boolean status;

	public Long getEmployeeProjectId() {
		return employeeProjectId;
	}

	public void setEmployeeProjectId(Long employeeProjectId) {
		this.employeeProjectId = employeeProjectId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getStartDate() {
		return startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
