package com.htc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;
import com.htc.beans.Employee;
import com.htc.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders="*")
public class EmployeeController 
{
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> addEmployee(@RequestBody Employee employee)
	{
		boolean status=employeeService.addEmployeeService(employee);
		System.out.println(employee);
		HttpHeaders httpHeaders=new HttpHeaders();
		return new ResponseEntity<Boolean>(status,httpHeaders,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllBooks()
	{
		List<Employee> list=employeeService.getAllEmployeesService();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/removeEmployee/{employeeId}")
	public ResponseEntity<Boolean> removeEmployee(@PathVariable String employeeId)
	{
		boolean status=employeeService.removeEmployeeService(employeeId);
		System.out.println(status);
		HttpHeaders httpHeaders=new HttpHeaders();
		return new ResponseEntity<Boolean>(status,httpHeaders,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/updateEmployee/{employeeId}")
	public ResponseEntity<Boolean> updateEmployee(@PathVariable String employeeId,@RequestBody Employee employee)
	{
		boolean status=employeeService.updateEmployeeService(employeeId, employee);
		System.out.println(status);
		HttpHeaders httpHeaders=new HttpHeaders();
		return new ResponseEntity<Boolean>(status,httpHeaders,HttpStatus.CREATED);
	}
	
}
