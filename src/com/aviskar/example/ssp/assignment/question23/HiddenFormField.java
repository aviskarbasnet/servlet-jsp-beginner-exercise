package com.aviskar.example.ssp.assignment.question23;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/question23/HiddenFormField")
public class HiddenFormField extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		pw.print("Session Id :: " + session.getId());
		pw.print("<form action=\"DisplayServlet\" method=\"post\">");
		pw.print("<input type=\"hidden\" value=\"" + session.getId() + "\" name=\"sessionId\" />");
		pw.print("<input type=\"submit\" value=\"Click Me\" />");
		pw.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
