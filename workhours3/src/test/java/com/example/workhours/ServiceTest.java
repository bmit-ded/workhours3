package com.example.workhours;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.Test;

class ServiceTest {
	
	//will be always right. 
	@Test
	public void test_JUnit() {
        System.out.println("This is the testcase in this class");
        String str1="This is the testcase in this class";
        assertEquals("This is the testcase in this class", str1);
    }
	
	
	@Test
	void testLogin() {
		Connection con = Service.login();
		assertNotNull(con);
	}

	@Test
	void testGetAllUsers() {
		List<User> users = Service.getAllUsers();
		assertNotNull(users);
	}

	@Test
	void testGetAllProjects() {
		List<Project> projects = Service.getAllProjects();
		assertNotNull(projects);
	}

}
