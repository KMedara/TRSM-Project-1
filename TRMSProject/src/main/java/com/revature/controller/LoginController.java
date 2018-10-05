package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.dao.PetDaoImpl;
import com.revature.beans.Pet;


public class LoginController {

	public static String Login(HttpServletRequest request) {
		if (request.getMethod().equals("GET")) {
			return "/html/Login.html";
		}

		String name = request.getParameter("name");
		String type = request.getParameter("type");

		PetDaoImpl petDaoImpl = new PetDaoImpl();
		Pet pet = new Pet();

		pet = petDaoImpl.selectPetByName(name);

		if (name.equals(pet.getName()) && type.equals(pet.getType())) {
			request.getSession().setAttribute("Pet", pet);
			System.out.println(pet + "in the if statement to login");
			return "/html/Home.html";

		} else {
			return "sorry";
		}
		
	}
}
