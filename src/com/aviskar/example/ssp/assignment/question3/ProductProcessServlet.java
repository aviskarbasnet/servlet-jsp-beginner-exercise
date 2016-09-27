package com.aviskar.example.ssp.assignment.question3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/question3/ProductProcessServlet")
public class ProductProcessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Connection conn;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_db", "root", "mysql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String pId = request.getParameter("pId");
		ResultSet resultSet = null;
		try {
			Statement statement = conn.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM product WHERE p_id = " + pId);
			if (resultSet.next()) {
				pw.print("Product Id :: " + resultSet.getInt("p_id"));
				pw.print("<br>");
				pw.print("Product Name :: " + resultSet.getString("p_name"));
				pw.print("<br>");
				pw.print("Product Price :: " + resultSet.getString("p_price"));
			} else {
				pw.print("Product not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String pId = request.getParameter("pId");
		String pName = request.getParameter("pName");
		String pPrice = request.getParameter("pPrice");
		int result = 0;
		try {
			Statement statement = conn.createStatement();
			result = statement.executeUpdate("INSERT INTO product (p_id, p_name, p_price) VALUES (" + pId + ", '"
					+ pName + "', '" + pPrice + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result != 1) {
			pw.print("Product detail not inserted.");
		} else {
			pw.print("Product detail inserted.");
		}
	}
}
