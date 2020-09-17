package com.htc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.htc.beans.Employee;
import com.htc.dao.EmployeeDAO;

@Service
public class EmployeeServiceImplementation implements EmployeeService
{
	
	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public boolean addEmployeeService(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployeesService() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}

	@Override
	public boolean removeEmployeeService(String employeeId) {
		// TODO Auto-generated method stub
		return employeeDAO.removeEmployee(employeeId);
	}

	@Override
	public boolean updateEmployeeService(String employeeId, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(employeeId, employee);
	}
	
}
