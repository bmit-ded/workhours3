package com.example.workhours;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
public class EntryController {

	@RequestMapping("/userSelect")
	public String showEntries(@ModelAttribute("entry") Entry entry, BindingResult result, ModelMap model) {
		model.addAttribute("entries", Service.getAllEntries());
		model.addAttribute("projects", Service.getAllProjects());
		model.addAttribute("worksheets", Service.getAllWorksheets());

		return "showEntries";
	}

	@PostMapping("/registerEntry")
	public String submitEntry(@RequestParam(value = "hours") double hours, @RequestParam(value = "worksheetValue") int worksheet, @RequestParam(value = "projectValue") int project,
			@RequestParam(value = "date") String date,  Model model) {
		Service.addEntry(model, hours, project, date, worksheet);

		return "register_success_entry";
	}

	@GetMapping("/deleteEntry")
	public String deleteEntry(String id) throws SQLException {
		String table = "entry";
		String entity = "id_entry";

		Service.delete(id, table, entity);

		return "deleteEntry";
	}

	@GetMapping("/updateEntry")
	public String getUpdateEntry(String id, @ModelAttribute("entry") Entry entry, BindingResult result,
			ModelMap model) {
		Service.updateEntry(model, id);
		model.addAttribute("worksheets", Service.getAllWorksheets());
		model.addAttribute("projects", Service.getAllProjects());
		

		return "updateEntry";
	}

	@PostMapping("/updateEntryfinal")
	public String updateEntry(@RequestParam(value = "hours") double hours, @RequestParam(value = "projectValue") int project, @RequestParam(value = "worksheetValue") int worksheet,
			@RequestParam(value = "date") String date,
			@RequestParam(value = "id") String id, Model model) {
		Service.saveUpdatedEntry(model, hours, project, date, worksheet, id);

		return "updateEntryfinal";
	}

}
