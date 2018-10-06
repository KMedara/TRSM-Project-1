package com.revature.dao;

import com.revature.beans.*;
import java.awt.List;
import java.sql.SQLException;

public interface EmployeeDao {

	public void createEmployee(Employee emp) throws SQLException;
	public List getAllForms() throws SQLException;
//	public List getFormsByEmployee(int empId) throws SQLException;
	public Employee getEmployeeByLogin(String uname) throws SQLException;
	public void updateEmployee(int empId) throws SQLException;
}