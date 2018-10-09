package com.revature.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDaoImpl;


public class LoginController {

	public static String Login(HttpServletRequest request) throws SQLException {
		if (request.getMethod().equals("GET")) {
			return "/html/Login.html";
		}

		String username = request.getParameter("username");
		String type = request.getParameter("password");

		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		Employee emp = new Employee();

		emp = edi.getEmployeeByLogin(username);
		
		if (username.equals(emp.getUsername()) && type.equals(emp.getPassword())) {
			request.getSession().setAttribute("Employee", emp);
			System.out.println(emp + "in the if statement to login");
			return "/html/Home.html";
		} else {
			return "sorry";
		}
		
	}
}
