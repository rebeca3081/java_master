package common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getStudentServlet") // url
public class GetStudentServlet extends HttpServlet {
	// 생성자 -> 기본생성자

	// 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ?sno=23-010
		resp.setContentType("text/html;charset=utf-8");
		String sno = req.getParameter("sno");

		StudentDAO dao = new StudentDAO();
		Student std = dao.getStudent(sno);

		String str = "<table border='1'>";
		str += "<caption>학생정보</caption>";
		str += "<tr><th>학번</th><td>" + std.getStudentNo() + "</td></tr>";
		str += "<tr><th>이름</th><td>" + std.getStudentName() + "</td></tr>";
		str += "<tr><th>영어</th><td>" + std.getScoreEng() + "</td></tr>";
		str += "<tr><th>수학</th><td>" + std.getScoreMath() + "</td></tr>";
		str += "</table>";
		str += "<br><a href='modifyStudent?sno=" + std.getStudentNo() + "'>수정화면</a>";
		str += "<br><a href='studentList'>목록</a>";

		// 사용자 페이지로 출력
		resp.getWriter().print(str);

	}
}
