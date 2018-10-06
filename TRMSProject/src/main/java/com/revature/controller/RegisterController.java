package com.revature.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDaoImpl;


public class RegisterController {

	public static String Register(HttpServletRequest request) throws SQLException {
		if (request.getMethod().equals("GET")) {
			return "/html/Login.html";
		}
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		String reportsto = request.getParameter("reportsto");
		//String type = request.getParameter("type");
		
		Employee emp = new Employee();
		
		emp.setFirstName(firstname);
		emp.setLastName(lastname);
		emp.setUsername(username);
		emp.setPassword(password);
		emp.setEmail(email);
		emp.setRoleId(Integer.parseInt(role));
		emp.setReportsTo(Integer.parseInt(reportsto));
		
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		edi.createEmployee(emp);
		return "/html/Login.html";
	}


}


