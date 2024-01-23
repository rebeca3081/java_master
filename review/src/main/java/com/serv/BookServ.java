package com.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookServ
 */
@WebServlet("/BookServ") // URL요청주소
public class BookServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BookServ() {
        super();
    }

    // GET, POST 둘다
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.setContentType("text/html; charset=UTF-8"); // 응답결과에 ContentType(mimetype)을 설정
		String[] list = new String[] {"스프링", "html", "java", "boot"};
		request.setAttribute("list", list);
		request.getRequestDispatcher("book.jsp").forward(request, response); // 데이터 및 페이지 이동
	}

}
