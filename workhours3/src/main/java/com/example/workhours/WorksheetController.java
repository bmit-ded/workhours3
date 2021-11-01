package com.example.workhours;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorksheetController {

	@RequestMapping("/worksheet")
	public String showWorksheet(@ModelAttribute("worksheet") Worksheet worksheet, BindingResult result,
			ModelMap model) {
		model.addAttribute("worksheets", Service.getAllWorksheets());
		model.addAttribute("users", Service.getAllUsers());
		return "showWorksheets";
	}
	
	@PostMapping("/registerWorksheet")
	public String submitEntry(@RequestParam(value = "userValue") int user, Model model) {
		Service.addWorksheet(model, user);
		
		//return site erstellen
		return "register_success_worksheet";
	}

	
	@GetMapping("/deleteWorksheet")
	public String deleteWorksheet(String id) throws SQLException {
		String table = "worksheet";
		String entity = "id_worksheet";

		Service.delete(id, table, entity);

		return "deleteWorksheet";
	}
	
	@GetMapping("/updateWorksheet")
	public String getUpdateWorksheet(String id, @ModelAttribute("worksheet") Worksheet worksheet, BindingResult result,
			ModelMap model) {
		Service.updateWorksheet(model, id);
		model.addAttribute("users", Service.getAllUsers());

		return "updateWorksheet";
	}
	
	@PostMapping("/updateWorksheetfinal")
	public String updateWorksheet(@RequestParam(value = "userValue") int user, @RequestParam(value = "id") String id, Model model) {
		Service.saveUpdatedWorksheet(model, user, id);

		return "updateWorksheetfinal";
	}

}
