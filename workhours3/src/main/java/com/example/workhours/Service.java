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

public class Service {

	public static Connection login() {

		String url = "jdbc:mysql://localhost:3306/workhours2";
		String user = "root";
		String password = "";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	public static void delete(String id, String table, String entity) throws SQLException {

		try (Connection conn = Service.login();) {

			String query = "DELETE FROM `" + table + "` WHERE " + table + "." + entity + " = " + id;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		}
	}

	public static List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();

		try (Connection conn = Service.login();) {
			String query = "SELECT * FROM project Order by id_project ASC";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Fetch each row from the result set
			while (rs.next()) {
				int i = rs.getInt("id_project");
				String name = rs.getString("name");
				int bool = rs.getInt("worktime");

				Project newProject = new Project(i, name, bool);

				projects.add(newProject);
				System.out.print(name);
			}
			rs.close();
			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return projects;

	}

	public static List<Worksheet> getAllWorksheets() {
		List<Worksheet> worksheets = new ArrayList<>();

		try (Connection conn = Service.login();) {
			String query = "SELECT * FROM worksheet INNER JOIN user ON worksheet.id_user = user.id_user Order by id_worksheet ASC";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				int i = rs.getInt("id_worksheet");
				int user = rs.getInt("id_user");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");

				Worksheet newWorksheet = new Worksheet(i, user, firstname, lastname);

				worksheets.add(newWorksheet);

			}
			rs.close();
			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return worksheets;
	}

	public static List<User> getAllUsers() {
		List<User> users = new ArrayList<>();

		try (Connection conn = Service.login();) {
			String query = "SELECT * FROM user Order by id_user ASC";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Fetch each row from the result set
			while (rs.next()) {
				int i = rs.getInt("id_user");
				String first = rs.getString("firstname");
				String last = rs.getString("lastname");

				User newUser = new User(i, first, last);

				users.add(newUser);
				System.out.print(first);
			}
			rs.close();
			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return users;
	}

	public static List<Entry> getAllEntries() {
		List<Entry> entries = new ArrayList<>();

		try (Connection conn = Service.login();) {

			// ausgabe
			String query = "SELECT * FROM entry INNER JOIN project ON entry.id_project = project.id_project;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Fetch each row from the result set
			while (rs.next()) {
				int i = rs.getInt("id_entry");
				double hours = rs.getDouble("hours");
				int project = rs.getInt("id_project");
				int worktime = rs.getInt("worktime");
				String projectname = rs.getString("name");
				Date date = rs.getDate("date");
				int worksheet = rs.getInt("id_worksheet");

				Entry newEntry = new Entry(i, hours, project, projectname, worktime, date, worksheet);

				entries.add(newEntry);
			}
			rs.close();
			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return entries;
	}

	public static List<Project> updateProject(ModelMap model, String id) {
		List<Project> projects = new ArrayList<>();
		try (Connection conn = Service.login();) {

			String query = "SELECT * FROM `project` WHERE project.id_project = " + id;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Fetch each row from the result set
			while (rs.next()) {
				int i = rs.getInt("id_project");
				String name = rs.getString("name");
				int worktime = rs.getInt("worktime");

				Project newProject = new Project(i, name, worktime);

				projects.add(newProject);
				System.out.print(name);
			}
			model.addAttribute("projects", projects);
			rs.close();
			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return projects;
	}
	
	public static List<Worksheet> updateWorksheet(ModelMap model, String id) {
		List<Worksheet> worksheets = new ArrayList<>();
		try (Connection conn = Service.login();) {

			String query = "SELECT * FROM `worksheet` INNER JOIN user ON worksheet.id_user = user.id_user WHERE worksheet.id_worksheet = " + id;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Fetch each row from the result set
			while (rs.next()) {
				int ids = rs.getInt("id_worksheet");
				int id_user = rs.getInt("id_user");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");

				Worksheet newWorksheet = new Worksheet(ids, id_user, firstname, lastname);

				worksheets.add(newWorksheet);
			}
			model.addAttribute("worksheets", worksheets);
			rs.close();
			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return worksheets;
	}

	public static List<User> updateUser(ModelMap model, String id) {
		List<User> users = new ArrayList<>();
		try (Connection conn = Service.login();) {

			// ausgabe
			String query = "SELECT * FROM `user` WHERE user.id_user = " + id;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Fetch each row from the result set
			while (rs.next()) {
				int i = rs.getInt("id_user");
				String first = rs.getString("Firstname");
				String last = rs.getString("Lastname");

				User newUser = new User(i, first, last);

				users.add(newUser);
			}
			model.addAttribute("users", users);
			rs.close();
			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return users;
	}
	
	public static List<Entry> updateEntry(ModelMap model, String id) {
		List<Entry> entries = new ArrayList<>();
		try (Connection conn = Service.login();) {

			// ausgabe
			String query = "SELECT * FROM `entry` INNER JOIN project ON entry.id_project = project.id_project WHERE entry.id_entry = "
					+ id;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Fetch each row from the result set
			while (rs.next()) {
				int i = rs.getInt("id_entry");
				double hours = rs.getDouble("hours");
				int project = rs.getInt("id_project");
				int worktime = rs.getInt("worktime");
				String projectname = rs.getString("name");
				Date date = rs.getDate("date");
				int worksheet = rs.getInt("id_worksheet");

				Entry newEntry = new Entry(i, hours, project, projectname, worktime, date, worksheet);

				entries.add(newEntry);
			}
			model.addAttribute("entries", entries);
			rs.close();
			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return entries;
	}

	public static void saveUpdatedProject(Model model, String projectname, int worktime, String id) {
		try (Connection conn = Service.login();) {
			String query = "UPDATE `project` SET `name` = '" + projectname + "', `Worktime` = '" + worktime
					+ "' WHERE `project`.`id_project` =" + id;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public static void saveUpdatedUser(Model model, String firstname, String lastname, String id) {
		try (Connection conn = Service.login();) {

			String query = "UPDATE `user` SET `Firstname` = '" + firstname + "', `Lastname` = '" + lastname
					+ "' WHERE `user`.`id_user` =" + id;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void saveUpdatedWorksheet(Model model, int user, String id) {
		try (Connection conn = Service.login();) {

			String query = "UPDATE `worksheet` SET `id_user` = '" + user +  "' WHERE `worksheet`.`id_worksheet` =" + id;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void saveUpdatedEntry(Model model, double hours, int project, String date, int worksheet, String id) {
		try (Connection conn = Service.login();) {
			String query = "UPDATE `entry` SET `hours` = '" + hours + "', `id_project` = '" + project + "', `date` = '" + date + "', `id_worksheet` = '" + worksheet + "' WHERE `entry`.`id_entry` =" + id;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public static void addProject(Model model, String projectname, int worktime) {
		try (Connection conn = Service.login();) {
			String query = "INSERT INTO `project` (`id_project`, `name`, `worktime`) VALUES (NULL, '" + projectname
					+ "', '" + worktime + "')";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		Project newProject = new Project(0, projectname, worktime);
		model.addAttribute("projects", newProject);
	}

	public static void addUser(Model model, String firstname, String lastname) {
		try (Connection conn = Service.login();) {

			// ausgabe
			String query = "INSERT INTO `user` (`id_user`, `Firstname`, `Lastname`) VALUES (NULL, '" + firstname
					+ "', '" + lastname + "')";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		User newUser = new User(0, firstname, lastname);
		model.addAttribute("users", newUser);
	}
	
	public static void addWorksheet(Model model, int user) {
		try (Connection conn = Service.login();) {

			// ausgabe
			String query = "INSERT INTO `worksheet` (`id_worksheet`, `id_user`) VALUES (NULL, '" + user + "')";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		Worksheet newWorksheet = new Worksheet(0, user, null, null);
		model.addAttribute("worksheets", newWorksheet);
	}
	
	public static void addEntry(Model model, double hours, int project, String date, int worksheet) {
		try (Connection conn = Service.login();) {

			// ausgabe
			String query = "INSERT INTO `entry` (`id_entry`, `hours`, `date`, `id_project`, `id_worksheet`) VALUES (NULL, '"
					+ hours + "', '" + date + "', '" + project + "', '" + worksheet + "')";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);

			stmt.close();

		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}

}
