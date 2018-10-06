package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;

public class HomeController {
	

	public static String Home(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Home.html";
		}
		
		
		return null;


}

	public static String EmployeeJSON(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in PetJSON method");
		Employee emp =(Employee)request.getSession().getAttribute("Employee");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(emp));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
