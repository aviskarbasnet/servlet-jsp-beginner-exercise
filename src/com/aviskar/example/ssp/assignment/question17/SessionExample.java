package com.aviskar.example.ssp.assignment.question17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/question17/SessionExample")
public class SessionExample extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		if (session.getAttribute("hitCount") == null) {
			session.setAttribute("hitCount", 0);
		}
		int hitCount = (int) session.getAttribute("hitCount");
		hitCount++;
		session.setAttribute("hitCount", hitCount);
		pw.print("Hit count :: " + hitCount);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
