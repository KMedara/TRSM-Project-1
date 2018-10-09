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
		String roleId = request.getParameter("role");
		
		Employee emp = new Employee(Integer.parseInt(roleId),firstname, lastname, username,password,email,1);
		System.out.println("In Register Controller" + emp);
		EmployeeDaoImpl edi = new EmployeeDaoImpl();
		System.out.println("REGISTER CONTROLLER" + emp);
		edi.createEmployee(emp);
		return "/html/Login.html";
	}


}


