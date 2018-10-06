package com.revature.beans;

import java.sql.Date;
import java.sql.Time;

public class ReimbursementForm {

	private int id;
	private int employeeId;
	private int gradeId;
	private int coverageId;
	private Date dateSubmit;
	private Time timeSubmit;
	private Float cost;
	private String grade;
	private String city;
	private String state;
	private String comments;
	
	public ReimbursementForm() {
		super();
	}
	//without comments and id, when building from program
	public ReimbursementForm(int employeeId, int gradeId, int coverageId, Date dateSubmit, Time timeSubmit, Float cost,
			String grade, String city, String state) {
		super();
		this.employeeId = employeeId;
		this.gradeId = gradeId;
		this.coverageId = coverageId;
		this.dateSubmit = dateSubmit;
		this.timeSubmit = timeSubmit;
		this.cost = cost;
		this.grade = grade;
		this.city = city;
		this.state = state;
	}
	//with comments and id, building from db
	public ReimbursementForm(int id, int employeeId, int gradeId, int coverageId, Date dateSubmit, Time timeSubmit, Float cost,
			String grade, String city, String state, String comments) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.gradeId = gradeId;
		this.coverageId = coverageId;
		this.dateSubmit = dateSubmit;
		this.timeSubmit = timeSubmit;
		this.cost = cost;
		this.grade = grade;
		this.city = city;
		this.state = state;
		this.comments = comments;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getCoverageId() {
		return coverageId;
	}
	public void setCoverageId(int coverageId) {
		this.coverageId = coverageId;
	}
	public Date getDateSubmit() {
		return dateSubmit;
	}
	public void setDateSubmit(Date dateSubmit) {
		this.dateSubmit = dateSubmit;
	}
	public Time getTimeSubmit() {
		return timeSubmit;
	}
	public void setTimeSubmit(Time timeSubmit) {
		this.timeSubmit = timeSubmit;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "ReimbursmentForm [id=" + id + ", employeeId=" + employeeId + ", gradeId=" + gradeId + ", coverageId="
				+ coverageId + ", dateSubmit=" + dateSubmit + ", timeSubmit=" + timeSubmit + ", cost=" + cost
				+ ", grade=" + grade + ", city=" + city + ", state=" + state + ", comments=" + comments + "]";
	}
	
	
	
	
	
	
}
