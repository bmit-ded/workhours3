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
public class ProjectController {

	@RequestMapping(path = "/projects")
	public String showProject(@ModelAttribute("project") Project project, BindingResult result, ModelMap model) {
		model.addAttribute("projects", Service.getAllProjects());

		return "showProjects";
	}

	@PostMapping("/registerProject")
	public String submitForm(@RequestParam(value = "name") String projectname,
			@RequestParam(value = "worktime") int worktime, Model model) {
		Service.addProject(model, projectname, worktime);

		return "register_success_project";
	}

	@GetMapping("/deleteProject")
	public String deleteProject(String id) throws SQLException {
		String table = "project";
		String entity = "id_project";
		Service.delete(id, table, entity);

		return "deleteProject";
	}

	@GetMapping("/updateProject")
	public String getUpdateProject(String id, @ModelAttribute("project") Project project, BindingResult result,
			ModelMap model) {
		Service.updateProject(model, id);
		return "updateProject";
	}

	@PostMapping("/updateProjectfinal")
	public String updateProject(@RequestParam(value = "projectname") String projectname,
			@RequestParam(value = "worktime") int worktime, @RequestParam(value = "id") String id, Model model) {
		Service.saveUpdatedProject(model, projectname, worktime, id);
		return "updateProjectfinal";
	}

}
