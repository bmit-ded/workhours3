package com.example.workhours;

public class User {
	private int id;
	private String firstname;
	private String lastname;
	
    public User(int i, String first, String last) {
		// TODO Auto-generated constructor stub
    	this.id = i;
    	this.firstname = first;
    	this.lastname = last;
    	
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
	
	
}
