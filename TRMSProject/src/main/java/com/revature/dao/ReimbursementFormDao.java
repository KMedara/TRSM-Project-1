package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.ReimbursementForm;

public interface ReimbursementFormDao {

	public void createReimbursement(ReimbursementForm form) throws SQLException;
	public ReimbursementForm getFormById(int id) throws SQLException;
	public List<ReimbursementForm> getFormsByEmployee(int empId) throws SQLException;
	public void updateFormGrade(int formId, String grade) throws SQLException;
}
