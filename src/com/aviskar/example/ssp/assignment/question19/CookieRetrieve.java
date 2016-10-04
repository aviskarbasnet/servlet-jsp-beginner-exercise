package com.aviskar.example.ssp.assignment.question19;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/question19/CookieRetrieve")
public class CookieRetrieve extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		Cookie[] cookies = request.getCookies();
		pw.print("Cookie Retrieve Example");
		pw.print("<br><br>");
		for (Cookie tempCookie : cookies) {
			pw.print(tempCookie.getName() + " :: " + tempCookie.getValue());
			pw.print("<br>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
