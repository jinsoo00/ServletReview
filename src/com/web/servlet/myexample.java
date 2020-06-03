package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class myexample extends HttpServlet  {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		out.print("<html><head><title>Servlet 실행결과</title></head>");
		out.print("<body>");
		out.print("<h1>(override)service 실행</h1>");
		super.service(req, res);
		out.print("</body></html>");
		out.close();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print("<h1>(override)doGet 실행</h1>");
		out.close();
	}
}
