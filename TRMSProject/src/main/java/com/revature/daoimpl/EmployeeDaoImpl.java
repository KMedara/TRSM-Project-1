package com.revature.daoimpl;

import java.awt.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createEmployee(Employee emp) throws SQLException {
		Connection conn = cf.getConnection();
		String query = "call PR_INSERTEMPLOYEE( ?,?,?,?,?,?,?)";
		CallableStatement caller = conn.prepareCall(query);
		caller.setInt(1, emp.getRoleId());
		caller.setString(2, emp.getFirstName());
		caller.setString(3, emp.getLastName());
		caller.setString(4, emp.getUsername());
		caller.setString(5, emp.getPassword());
		caller.setString(6, emp.getEmail());
		caller.setInt(7, emp.getReportsTo());
		caller.execute();
		caller.close();
		conn.close();

	}

	public List getAllForms() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee getEmployeeByLogin(String uname) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(int empId) throws SQLException {
		// TODO Auto-generated method stub

	}

}