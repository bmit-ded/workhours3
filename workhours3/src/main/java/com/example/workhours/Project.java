package com.example.workhours;

public class Project{
	private int id;
	private String name;
	private int worktime;
	
	public Project(int i, String name, int worktime) {
		// TODO Auto-generated constructor stub
    	this.id = i;
    	this.name = name;
    	this.worktime = worktime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWorktime() {
		return worktime;
	}
	public void setWorktime(int worktime) {
		this.worktime = worktime;
	}
	
	
	
	
	
}
