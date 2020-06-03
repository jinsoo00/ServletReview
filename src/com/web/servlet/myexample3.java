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
	  	(1) ServletContext, HttpSession, HttpServletRequest, Cookie 중에서 다음 질문에 답해주세요.
	  	
		   - 서버 사이드 저장 기술은 어느것들인가?
		   		 ServletContext, HttpSession, HttpServletRequest
		   		 
		   - ServletContext와 HttpSession의 차이?
		   		 ServletContext은 웹 어플리케이션 단위로서 웹 어플리케이션이 유지되는 동안 데이터가  유지되고 모든 서블릿이 공유 가능하다.
		   		 HttpSession은 클라이언트 단위로서 클라이언트마다 세션이 생성되서 데이터가 유지되고 같은 세션ID끼리 공유가능하다.
		   		 ex)익스플로러와 크롬으로 접속시 Context는 데이터가 공유되나 Session은 세션ID가 달라지므로 공유가 안된다.
		   		 
		   - HttpSession 키는 어디에 저장되어 있는지?
		   		 쿠키 - JSESSIONID
		   		 
		   - Cookie의 옵션 중 Path와 MaxAge 기능 설명
		   		 Path 기능 - setPath()를 통해서 해당 경로로 데이터를 주고받을때만 쿠키를 생성할 수 있다,  쿠키를 효율적으로 관리할 수  있다.
		   		 MaxAge 기능 - setMaxAge()를 통해서 쿠키저장 기간을 지정할 수 있다,  쿠키를 효율적으로 관리할 수  있다.
		   		 
		   - 서버 사이드 저장 기술 대비 클라이언트 사이드 저장 기술의 장점?
	  			 특정 url에서만 정보를 유지할 수 있어서 효율적이고 유지 기간도 설정할 수 있어서 브라우저가 종료되도 클라이언트에서 정보를 유지할 수 있다.
	  			 서버 사이드 저장 기술은 서버에 자원이 낭비될 수 있지만 클라이언트 사이드 저장 기술은 서버의 자원을 아낄 수 있다.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		String value = req.getParameter("value");
		int v = Integer.parseInt(value);
		String op = req.getParameter("operator");	
		
		//ServletContext 이용해서 구현 
		ServletContext application = req.getServletContext();
		//HttpSession 이용해서 구현 
		HttpSession session = req.getSession();
		//Cookie 이용해서 구현
		Cookie[] cookies = req.getCookies();
		
		int result = 0;
		if(op.equals("=")) {
			//ServletContext 이용해서 구현 
			int v2 = (int) application.getAttribute("value");
			String op2 = (String) application.getAttribute("operator");
			
//			//HttpSession 이용해서 구현 
//			int v2 = (int) session.getAttribute("value");
//			String op2 = (String) session.getAttribute("operator");
//			
//			//Cookie 이용해서 구현
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
			//ServletContext 이용해서 구현 
			application.setAttribute("value", v);
			application.setAttribute("operator", op);
			
//			//HttpSession 이용해서 구현 
//			session.setAttribute("value", v);
//			session.setAttribute("operator", op);
//			
//			//Cookie 이용해서 구현
//			Cookie valueCookie = new Cookie("value", String.valueOf(v));
//			Cookie operatorCookie = new Cookie("operator", op);
//			resp.addCookie(valueCookie);
//			resp.addCookie(operatorCookie);
			
			resp.sendRedirect("Calculator2.html");
		}
	}
}