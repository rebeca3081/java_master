package com.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReqServ")
public class ReqServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getRequestDispatcher("BookServ").forward(request, response); // (화면 이동시 사용) 주소 ReqServ?name=kim&age=20 화면 : book.jsp(마지막 페이지만 받아옴)
		response.sendRedirect("BookServ"); // 왔다갔다함 재요청 (서블릿 호출시 사용)
		
		/*
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append(request.getQueryString() + "<br>"); // 요청하는 클라이언트의 질의문자열
		out.append(request.getRemoteAddr() + "<br>"); // 요청하는 클라이언트의 주소
		out.append(request.getHeader("user-agent") + "<br>"); // 요청하는 헤더의 user-agent정보
		out.append(request.getParameter("name") + "<br>"); // 요청하는 파라미터 중 "name"
		out.append(request.getParameter("age") + "<br>"); // 요청하는 파라미터 중 "age"
		
		for(Cookie cookie : request.getCookies()) { // getCookies()는 배열이라 반복문으로 출력해줌
			out.append(cookie.getName() + ":" + cookie.getValue() +  "<br>"); // 요청하는 클라이언트의 쿠키정보
		}
		*/
	}

}
