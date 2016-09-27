package com.aviskar.example.ssp.assignment.question3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/question3/ProductServlet")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.print("Search Product:");
		pw.print("<form action=\"ProductProcessServlet\" method=\"get\">");
		pw.print("Product Id : <input type=\"text\" name=\"pId\" /><br>");
		pw.print("<input type=\"submit\" value=\"Search\" />");
		pw.print("</form>");
		pw.print("<br><br>");
		pw.print("Add Product:<br>");
		pw.print("<form action=\"ProductProcessServlet\" method=\"post\">");
		pw.print("Product Id : <input type=\"text\" name=\"pId\" /><br>");
		pw.print("Product Name : <input type=\"text\" name=\"pName\" /><br>");
		pw.print("Product Price : <input type=\"text\" name=\"pPrice\" /><br>");
		pw.print("<input type=\"reset\" value=\"Reset\" />");
		pw.print("<input type=\"submit\" value=\"Submit\" />");
		pw.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
