package com.serv;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reviewAddAjaxServ")
public class ReviewAddAjaxServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 파라미터가 한글인 경우 인코딩해줌
		String name = request.getParameter("username");
		String content = request.getParameter("content");
		
		
		System.out.println(name + ":" + content);
		// response.setContentType("text/plain; charset=UTF-8"); // fetch의 .then의 형식을 지정
		// response.getWriter().append("success");
		
		response.setContentType("application/json;"); // fetch의 .then의 형식을 지정
		response.getWriter().append("{\"retCode\":\"success\"}"); 
		
		
		// JSON은 Gson으로 받아야함
		/*
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("retCode", "success");
		Gson gson = new GsonBuilder().create(); // 자바 객체 -> 문자열
		String str = gson.toJson(map); // vo, list, map ==> json string {, [시작
		response.getWriter().append(str);
		*/
	}

	
}
