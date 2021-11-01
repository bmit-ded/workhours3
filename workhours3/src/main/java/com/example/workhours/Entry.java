package com.example.workhours;

import java.util.Date;

public class Entry {
	private int id;
	private double hours;
	private int project;
	private int worksheet;
	private Date date;
	private String projectname;
	private int worktime;
	
	public Entry(int i, double hours2, int project2, String projectname, int worktime, Date date, int worksheet2) {
		// TODO Auto-generated constructor stub
		this.id = i;
		this.hours = hours2;
		this.project = project2;
		this.date = date;
		this.worksheet = worksheet2;
		this.projectname = projectname;
		this.worktime = worktime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		this.hours = hours;
	}
	public int getWorksheet() {
		return worksheet;
	}
	public void setWorksheet(int worksheet) {
		this.worksheet = worksheet;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public int getWorktime() {
		return worktime;
	}
	public void setWorktime(int worktime) {
		this.worktime = worktime;
	}
	

}
