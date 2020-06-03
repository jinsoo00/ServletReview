package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/my3")
public class myexample3 extends HttpServlet  {
	/*
	  	(1) ServletContext, HttpSession, HttpServletRequest, Cookie �߿��� ���� ������ �����ּ���.
	  	
		   - ���� ���̵� ���� ����� ����͵��ΰ�?
		   		 ServletContext, HttpSession, HttpServletRequest
		   		 
		   - ServletContext�� HttpSession�� ����?
		   		 ServletContext�� �� ���ø����̼� �����μ� �� ���ø����̼��� �����Ǵ� ���� �����Ͱ�  �����ǰ� ��� ������ ���� �����ϴ�.
		   		 HttpSession�� Ŭ���̾�Ʈ �����μ� Ŭ���̾�Ʈ���� ������ �����Ǽ� �����Ͱ� �����ǰ� ���� ����ID���� ���������ϴ�.
		   		 ex)�ͽ��÷η��� ũ������ ���ӽ� Context�� �����Ͱ� �����ǳ� Session�� ����ID�� �޶����Ƿ� ������ �ȵȴ�.
		   		 
		   - HttpSession Ű�� ��� ����Ǿ� �ִ���?
		   		 ��Ű - JSESSIONID
		   		 
		   - Cookie�� �ɼ� �� Path�� MaxAge ��� ����
		   		 Path ��� - setPath()�� ���ؼ� �ش� ��η� �����͸� �ְ�������� ��Ű�� ������ �� �ִ�,  ��Ű�� ȿ�������� ������ ��  �ִ�.
		   		 MaxAge ��� - setMaxAge()�� ���ؼ� ��Ű���� �Ⱓ�� ������ �� �ִ�,  ��Ű�� ȿ�������� ������ ��  �ִ�.
		   		 
		   - ���� ���̵� ���� ��� ��� Ŭ���̾�Ʈ ���̵� ���� ����� ����?
	  			 Ư�� url������ ������ ������ �� �־ ȿ�����̰� ���� �Ⱓ�� ������ �� �־ �������� ����ǵ� Ŭ���̾�Ʈ���� ������ ������ �� �ִ�.
	  			 ���� ���̵� ���� ����� ������ �ڿ��� ����� �� ������ Ŭ���̾�Ʈ ���̵� ���� ����� ������ �ڿ��� �Ƴ� �� �ִ�.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		String value = req.getParameter("value");
		int v = Integer.parseInt(value);
		String op = req.getParameter("operator");	
		
		//ServletContext �̿��ؼ� ���� 
		ServletContext application = req.getServletContext();
		//HttpSession �̿��ؼ� ���� 
		HttpSession session = req.getSession();
		//Cookie �̿��ؼ� ����
		Cookie[] cookies = req.getCookies();
		
		int result = 0;
		if(op.equals("=")) {
			//ServletContext �̿��ؼ� ���� 
			int v2 = (int) application.getAttribute("value");
			String op2 = (String) application.getAttribute("operator");
			
//			//HttpSession �̿��ؼ� ���� 
//			int v2 = (int) session.getAttribute("value");
//			String op2 = (String) session.getAttribute("operator");
//			
//			//Cookie �̿��ؼ� ����
//			int v2 = 0;
//			String op2 = "";
//			for(Cookie c : cookies) {
//				if(c.getName().equals("value")) {
//					v2 = Integer.parseInt(c.getValue());
//				}
//				if(c.getName().equals("operator")){
//					op2 = c.getValue();
//				}
//			}
			
			if(op2.equals("+")) {
				result = v2 + v;
			} else if(op2.equals("-")) {
				result = v2 - v;
			}
			out.printf("Result is %d\n", result);
			
		} else {
			//ServletContext �̿��ؼ� ���� 
			application.setAttribute("value", v);
			application.setAttribute("operator", op);
			
//			//HttpSession �̿��ؼ� ���� 
//			session.setAttribute("value", v);
//			session.setAttribute("operator", op);
//			
//			//Cookie �̿��ؼ� ����
//			Cookie valueCookie = new Cookie("value", String.valueOf(v));
//			Cookie operatorCookie = new Cookie("operator", op);
//			resp.addCookie(valueCookie);
//			resp.addCookie(operatorCookie);
			
			resp.sendRedirect("Calculator2.html");
		}
	}
}