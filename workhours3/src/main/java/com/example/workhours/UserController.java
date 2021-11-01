package com.example.workhours;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(path = "/showUser")
	public String showUser(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		model.addAttribute("users", Service.getAllUsers());
		return "templatetest";
	}

	@PostMapping("/register")
	public String submitForm(@RequestParam(value = "firstname") String firstname,
			@RequestParam(value = "lastname") String lastname, Model model) {
		Service.addUser(model, firstname, lastname);

		return "register_success";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(String id) throws SQLException {
		String table = "user";
		String entity = "id_user";
		Service.delete(id, table, entity);

		return "deleteUser";
	}

	@GetMapping("/updateUser")
	public String getUpdateUser(String id, @ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		Service.updateUser(model, id);

		return "updateUser";
	}

	@PostMapping("/updateUserfinal")
	public String updateUser(@RequestParam(value = "firstname") String firstname,
			@RequestParam(value = "lastname") String lastname, @RequestParam(value = "id") String id, Model model) {
		Service.saveUpdatedUser(model, firstname, lastname, id);

		return "updateUserfinal";
	}

}
