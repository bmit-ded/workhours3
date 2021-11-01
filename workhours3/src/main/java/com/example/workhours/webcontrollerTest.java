package com.example.workhours;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webcontrollerTest {
	
	@RequestMapping(value = "/test2")
	public String test1() {
		return "test2";
	}

}
