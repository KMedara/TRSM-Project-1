package com.revature.dao;

import java.util.List;
import java.sql.SQLException;

import com.revature.beans.Employee;

public interface EmployeeDao {

	public Employee getEmployeeByLogin(String uname) throws SQLException;
	public void createEmployee(Employee emp) throws SQLException;
	public List<Employee> getAllEmployees() throws SQLException;
	public void updateEmployee(int empId) throws SQLException;
}