package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 컨트롤러 : url -> 서블릿 실행을 정해주는 역할
//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	// 톰캣에서 정한 규칙
	// 생명주기 : 생성자 -> init() -> service() -> destroy()
	
	Map<String, Control> map;

	public FrontController() {
		System.out.println("생성자 호출");
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
		map.put("/main.do", new MainControl()); //(key, value)
		map.put("/sub.do", new SubControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() 호출");
		String url = req.getRequestURI(); // url에서 서버정보 빼고, /프로젝트명/main.do
		String context = req.getContextPath(); // /프로젝트명
		String page = url.substring(context.length()); // /main.do
		System.out.println(page);
		
		Control ctrl = map.get(page);
		ctrl.execute(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}

}
