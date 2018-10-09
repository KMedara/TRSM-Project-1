package com.revature.daoimpl;

import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static String url = "jdbc:oracle:thin:@revaturepega.csmuygrnnolz.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "zramzan1231";
	private static String password = "M20055099!";

	/**
	 * Creates an employee in the database with object passed from controller
	 * 
	 * @param emp An employee object
	 * @return void
	 */
	public void createEmployee(Employee emp) throws SQLException {

		Connection conn = DriverManager.getConnection(url, username, password);

		CallableStatement caller = conn.prepareCall("call PR_INSERTEMPLOYEE( ?,?,?,?,?,?,?,?)");
		caller.setInt(1, emp.getRoleId());
		caller.setString(2, emp.getFirstName());
		caller.setString(3, emp.getLastName());
		caller.setString(4, emp.getUsername());
		caller.setString(5, emp.getPassword());
		caller.setString(6, emp.getEmail());
		if (emp.getRoleId() > 1) {
			caller.setInt(7, (emp.getRoleId() - 1)); // reports to anyone one level higher to them (like a PEGA work
														// queue)
		} else {
			caller.setObject(7, null);
		}
		caller.setDouble(8, emp.getBalance());
		caller.execute();
		caller.close();
		conn.close();

	}

	/**
	 * When called, queries the DB for list of all employees
	 * 
	 * @return employees Arraylist of employees
	 */
	@SuppressWarnings("null")
	public List<Employee> getAllEmployees() throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		Employee emp;
		Statement stmt = null;
		List<Employee> employees = new ArrayList<Employee>();
		String query = "SELECT * FROM EMPLOYEE_INFO";

		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			emp = new Employee(rs.getInt("EMPLOYEE_ID"), rs.getInt("ROLE_ID"), rs.getString("FIRST_NAME"),
					rs.getString("LAST_NAME"), rs.getString("USERNAME"), rs.getString("PASS"), rs.getString("EMAIL"),
					rs.getInt("REPORTS_TO"),rs.getDouble("BALANCE"));
			employees.add(emp);
		}
		stmt.close();
		rs.close();
		conn.close();
		return employees;
	}

	/**
	 * Returns a single employee object when logging to system
	 * 
	 * @param uname Employee username
	 * @return emp an employee object
	 */
	@SuppressWarnings("null")
	public Employee getEmployeeByLogin(String uname) throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		Employee emp = new Employee();
		String query = "SELECT * FROM EMPLOYEE_INFO WHERE USERNAME = (?)";

		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, uname);
		System.out.println("USERNAME" + uname);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			emp = new Employee(rs.getInt("EMPLOYEE_ID"), rs.getInt("ROLE_ID"), rs.getString("FIRST_NAME"),
					rs.getString("LAST_NAME"), rs.getString("USERNAME"), rs.getString("PASS"), rs.getString("EMAIL"),
					rs.getInt("REPORTS_TO"),rs.getDouble("BALANCE"));

			//System.out.println(emp);

		}
		return emp;
	}

	public void updateEmployee(int empId) throws SQLException {

	}

}