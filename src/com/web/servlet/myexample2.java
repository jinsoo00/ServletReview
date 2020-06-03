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


@WebServlet("/my2")
public class myexample2 extends HttpServlet  {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String pwd =  req.getParameter("pwd");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String dept = req.getParameter("dept");
		String gender = req.getParameter("gender");
		String birth = req.getParameter("birth");
		String introduction = req.getParameter("introduction");
		
		out.print("<h1> id : "+id+"<br> pwd : "+pwd+"<br> name : "+name+"<br> tel : "+tel+"<br> email : "+email+"<br> dept : "+dept+
				"<br> gender : "+gender+"<br> birth : "+birth+"<br> introduction : "+introduction);
		out.print("</h1>");
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
