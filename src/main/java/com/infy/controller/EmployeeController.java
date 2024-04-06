package com.infy.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entity.Employee;
import com.infy.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")


//   http://localhost:8080/employee/get/3456352
//		http://localhost:8080/employee/getbyname/vinod
//  		http://localhost:8080/employee/getall
//  			
//	 http://localhost:8080/employee/update/3456352
// 	http://localhost:8080/employee/delete/3456352
//	http://localhost:8080/employee/downolad-pdf



@CrossOrigin
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService serv;
	
	@GetMapping(value = "/getall")
	public ResponseEntity<List<Employee>> getALL()
	{
		return new ResponseEntity<List<Employee>>(serv.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping(value = "getbyname/{employeeName}")
	
	public ResponseEntity<Employee> getByname(@PathVariable String employeeName)

	{
		return new ResponseEntity<Employee>(serv.getByName(employeeName),HttpStatus.OK);
	}
	
	@GetMapping(value = "/get/{employeeId}")
	public ResponseEntity<String> getById( @PathVariable Integer employeeId)
	{
		try {
			
			
		Employee emp = serv.getById(employeeId).get();
		return new ResponseEntity<String>("Details of employee"+emp, HttpStatus.OK);
		
		
		}catch (Exception e) {
			return new ResponseEntity<String>("Employee Details not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<Employee> create(@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(serv.createEmployee(emp), HttpStatus.OK);
	}
	
	@PutMapping(value = "update/{id}")
	 public ResponseEntity<String> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee updatedEmployee)
	 {
		updatedEmployee.setDoj(updatedEmployee.getDoj());
		updatedEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
		updatedEmployee.setExperience(updatedEmployee.getExperience());
		updatedEmployee.setTechnology(updatedEmployee.getTechnology());
		serv.updateEmployee(updatedEmployee);
		
		return new ResponseEntity<String>("Employee with ID " + updatedEmployee.getTechnology() + " updated successfully", HttpStatus.OK);
		
	 }
	
	
	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) throws Exception{
		
		return new ResponseEntity<String>("Employee deleted successfully"+serv.deleteEmployee(id), HttpStatus.OK);
	}
	
	//      http://localhost:8080/employee/downolad-pdf
	@GetMapping(value = "/downolad-pdf")
	public ResponseEntity<InputStreamResource> downloadpdf() throws IOException
	{
		ByteArrayInputStream bis = serv.generatePdf();
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=employees_report.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
		
	}
	
	
}

