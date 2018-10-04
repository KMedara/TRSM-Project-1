package com.revature.beans;

public class Employee {

	private int id;
	private int roleId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private int reportsTo;
	
	public Employee() {
		super();
	}
	
	//without id, when building from program
	public Employee(int roleId, String first, String last, String username, 
			String password, String email, int reportsTo) {
		
		this.roleId = roleId;
		this.firstName = first;
		this.lastName = last;
		this.username = username;
		this.password = password;
		this.email = email;
		this.reportsTo = reportsTo;
	}
	
	//with id, when building from db
	public Employee(int id,int roleId, String first, String last, String username, 
			String password, String email, int reportsTo) {
		
		this.roleId = roleId;
		this.firstName = first;
		this.lastName = last;
		this.username = username;
		this.password = password;
		this.email = email;
		this.reportsTo = reportsTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", roleId=" + roleId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + ", email=" + email + ", reportsTo=" + reportsTo
				+ "]";
	}
	
}
