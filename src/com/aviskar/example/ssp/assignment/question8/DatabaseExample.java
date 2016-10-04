package com.aviskar.example.ssp.assignment.question8;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/question8/DatabaseExample")
public class DatabaseExample extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String studentId = request.getParameter("studentId");
		String science = request.getParameter("science");
		String math = request.getParameter("math");
		String english = request.getParameter("english");
		String nepali = request.getParameter("nepali");
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "mysql");
			Statement statement = conn.createStatement();
			result = statement.executeUpdate("INSERT INTO marks (student_id, science, math, english, nepali) VALUES ("
					+ studentId + ", " + science + ", " + math + ", " + english + ", " + nepali + ")");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result != 1) {
			pw.print("Cannot insert a record.");
		} else {
			pw.print("Record inserted.");
		}
	}
}
