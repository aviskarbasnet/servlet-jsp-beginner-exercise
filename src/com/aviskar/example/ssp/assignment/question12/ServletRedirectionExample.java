package com.aviskar.example.ssp.assignment.question12;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/question12/ServletRedirectionExample")
public class ServletRedirectionExample extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username == null || password == null || !username.equals("aviskar") || !password.equals("pass")) {
			RequestDispatcher rd = request.getRequestDispatcher("/question12/ErrorServlet");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/question12/SuccessServlet");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
