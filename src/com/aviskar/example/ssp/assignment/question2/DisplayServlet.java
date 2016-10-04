package com.aviskar.example.ssp.assignment.question2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/question2/DisplayServlet")
public class DisplayServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String registrationNo = request.getParameter("registrationNo");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		pw.print("Registration No. :: " + registrationNo);
		pw.print("<br>");
		pw.print("First Name:: " + firstName);
		pw.print("<br>");
		pw.print("Last Name :: " + lastName);
	}
}
