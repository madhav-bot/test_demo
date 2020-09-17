package com.htc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.htc.beans.Employee;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO
{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		boolean status=false;
		String sql="INSERT INTO employee_react VALUES(?,?,?,?,?)";
		int output=jdbcTemplate.update(sql, employee.getEmployeeId(),employee.getEmployeeName(),employee.getEmployeeDesignation(),employee.getEmployeeSalary(),employee.getEmployeeLocation());
		if(output>0)
		{
			status=true;
		}
		return status;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		String sql="SELECT employee_id,employee_name,employee_designation,employee_salary,employee_city FROM employee_react";
		List<Employee> employees=jdbcTemplate.query(sql, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet resultSet, int rowNumCount) throws SQLException {
				// TODO Auto-generated method stub
				Employee employee=new Employee(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
				return employee;
			}
			
		});
		System.out.println("All Employees are:"+employees);
		return employees;
	}

	@Override
	public boolean removeEmployee(String employeeId) {
		// TODO Auto-generated method stub
		boolean status=false;
		String sql="DELETE FROM employee_react WHERE employee_id=?";
		int output=jdbcTemplate.update(sql, employeeId);
		if(output>0)
		{
			status=true;
		}
		return status;
	}

	@Override
	public boolean updateEmployee(String employeeId, Employee employee) {
		// TODO Auto-generated method stub
		boolean status=false;
		String sql="UPDATE employee_react SET employee_name=?,employee_designation=?,employee_salary=?,employee_city=? WHERE employee_id=?";
		int output=jdbcTemplate.update(sql, employee.getEmployeeName(),employee.getEmployeeDesignation(),employee.getEmployeeSalary(),employee.getEmployeeLocation(),employee.getEmployeeId());
		if(output>0)
		{
			status=true;
		}
		return status;
	}

}
