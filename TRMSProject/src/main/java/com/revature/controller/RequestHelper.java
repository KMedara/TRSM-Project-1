package com.revature.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestHelper {


	public static String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		
		case "/TRMSProject/html/Login.do": 
			System.out.println("in Login.do case");
			return LoginController.Login(request);
			
		case "/TRMSProject/html/Home.do":
			System.out.println("in Home.do case");
			return HomeController.Home(request);
			
		case "/TRMSProject/html/Register.do":
			System.out.println("in Register.do");
			return RegisterController.Register(request);
			
		case "/TRMSProject/html/EmployeeJSON.do":
			System.out.println("in EmployeeJSON.do");
			return HomeController.EmployeeJSON(request, response);
		
		default:
			return "/html/Login.html"; 
		}
	}
}
