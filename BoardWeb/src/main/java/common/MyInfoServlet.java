package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyInfoServlet")
public class MyInfoServlet extends HttpServlet { // HttpServlet을 상속을 받아야 기능을 오버라이딩해서 사용이 가능함
	private static final long serialVersionUID = 1L;

	// 기본 생성자
	public MyInfoServlet() {
		super();

	}

	// 메소드 : doGet()
	// request : 사용자(웹브라우저)의 요청정보(톰캣이 처리해줌)
	// response : 응답정보
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8"); // content 타입 : txt, html, json인지 type을 알려줘야함

		// 파라미터 확인.
		// ?sno=23-010&sname=황철수&escore=80&mscore=85
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String escore = request.getParameter("escore");
		String mscore = request.getParameter("mscore");

		System.out.println("son : " + sno + ", sname : " + sname + ", escore: " + escore + ", mscore: " + mscore);

		// db 저장.
		Student std = new Student(sno, sname, Integer.parseInt(mscore), Integer.parseInt(escore));
		StudentDAO dao = new StudentDAO();
		boolean done = dao.addStudent(std);

		PrintWriter out = response.getWriter(); // getWriter() : 출력스트림
		// out.append("Served at: ").append(request.getContextPath());
		// //getContextPath() : 프로젝트 정보를 보여줌
		out.println("<h3>Welcom Servlet, 안녕하세요</h3>");
		out.println("<a href='index.html'>인덱스 이동</a>");

		if (done) {
			out.print("<script>alert('OK'); location.href='student/studentList.jsp';</script>");
		} else {
			out.print("<script>alert('Fail'); location.href='index.html';</script>");
		}

	}

	// 메소드 :doPost()
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
