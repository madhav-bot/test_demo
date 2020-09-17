package com.htc.dao;

import java.util.List;

import com.htc.beans.Employee;

public interface EmployeeDAO 
{
	public boolean addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public boolean removeEmployee(String employeeId);
	public boolean updateEmployee(String employeeId,Employee employee);
}
