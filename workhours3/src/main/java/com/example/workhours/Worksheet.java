package com.example.workhours;

public class Worksheet {
	private int id;
	private int user;
	private String firstname;
	private String lastname;

	public Worksheet(int id, int user, String firstname, String lastname) {
		this.id = id;
		this.user = user;
		this.firstname = firstname;
		this.lastname = lastname;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
