package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ReimbursementForm;
import com.revature.dao.ReimbursementFormDao;

public class ReimbursementFormDaoImpl implements ReimbursementFormDao {

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
	 * Create a reimbursementForm with fields filled out in webpage
	 * 
	 * @param form ReimbursementForm to create in DB
	 * @return void
	 */
	@Override
	public void createReimbursement(ReimbursementForm form) throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		CallableStatement caller = conn.prepareCall("call PR_INSERTFORM( ?,?,?,?,?,?)");
		caller.setInt(1, form.getEmployeeId());
		caller.setDate(2, form.getDateSubmit());
		caller.setTime(3, form.getTimeSubmit());
		caller.setFloat(4, form.getCost());
		caller.setString(5, form.getCity());
		caller.setString(6, form.getState());
		caller.execute();
		caller.close();
		conn.close();
	}

	/**
	 * Gets specified reimbursement form by its id
	 * 
	 * @param id ID of form to return
	 * @return form ReimbursementForm with that id
	 */
	@Override
	public ReimbursementForm getFormById(int id) throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		ReimbursementForm form = null;
		String sql = "SELECT * FROM REIMBURSEMENT_FORM WHERE FORM_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			form = new ReimbursementForm(rs.getInt("FORM_ID"), rs.getInt("EMPLOYEE_ID"), rs.getInt("GRADETYPE_ID"),
					rs.getInt("COVERAGE_ID"), rs.getDate("DATE_SUBMITTED"), rs.getTime("TIME_SUBMITTED"),
					rs.getFloat("COSTOF"), rs.getString("GRADE"), rs.getString("CITY"), rs.getString("STATE"),
					rs.getString("COMMENTS"));
		}
		return form;
	}

	/**
	 * Returns list of reimbursement forms filled out by specified employee
	 * 
	 * @param empId Id of employee that filled out the forms
	 * @return forms list of forms filled out by that employee
	 */
	@Override
	public List<ReimbursementForm> getFormsByEmployee(int empId) throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		ReimbursementForm form;
		List<ReimbursementForm> forms = new ArrayList<ReimbursementForm>();
		String sql = "SELECT * FROM REIMBURSEMENT_FORM WHERE EMPLOYEE_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, empId);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			form = new ReimbursementForm(rs.getInt("FORM_ID"), rs.getInt("EMPLOYEE_ID"), rs.getInt("GRADETYPE_ID"),
					rs.getInt("COVERAGE_ID"), rs.getDate("DATE_SUBMITTED"), rs.getTime("TIME_SUBMITTED"),
					rs.getFloat("COSTOF"), rs.getString("GRADE"), rs.getString("CITY"), rs.getString("STATE"),
					rs.getString("COMMENTS"));
			forms.add(form);
		}
		ps.close();
		rs.close();
		conn.close();
		return forms;
	}

	/**
	 * Update grade of specified reimbursement form
	 * 
	 * @param formId Form to update
	 * @param grade  new grade for form
	 * @return void
	 */
	@Override
	public void updateFormGrade(int formId, String grade) throws SQLException {
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "UPDATE ReimbursementForm SET GRADE = ? WHERE FORM_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, grade);
		ps.setInt(2, formId);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
}
