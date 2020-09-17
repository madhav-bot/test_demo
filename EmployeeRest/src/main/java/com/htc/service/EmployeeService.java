package com.htc.service;

import java.util.List;

import com.htc.beans.Employee;

public interface EmployeeService 
{
	public boolean addEmployeeService(Employee employee);
	public List<Employee> getAllEmployeesService();
	public boolean removeEmployeeService(String employeeId);
	public boolean updateEmployeeService(String employeeId,Employee employee);
}
