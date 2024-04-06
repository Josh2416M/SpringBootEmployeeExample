package com.infy.dto;

import java.util.Date;
import java.util.Objects;

import jakarta.validation.constraints.NotNull;


public class EmployeeDTO {
	
	private String employeeName;
	
	
	private Integer employeeId;
	

	private Date doj;
	
	
	private String technology;
	
	
	private Integer experience;


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public Date getDoj() {
		return doj;
	}


	public void setDoj(Date doj) {
		this.doj = doj;
	}


	public String getTechnology() {
		return technology;
	}


	public void setTechnology(String technology) {
		this.technology = technology;
	}


	public Integer getExperience() {
		return experience;
	}


	@Override
	public int hashCode() {
		return Objects.hash(doj, employeeId, employeeName, experience, technology);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		return Objects.equals(doj, other.doj) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(employeeName, other.employeeName) && Objects.equals(experience, other.experience)
				&& Objects.equals(technology, other.technology);
	}


	@Override
	public String toString() {
		return "EmployeeDTO [employeeName=" + employeeName + ", employeeId=" + employeeId + ", doj=" + doj
				+ ", technology=" + technology + ", experience=" + experience + "]";
	}


	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	
	
}
