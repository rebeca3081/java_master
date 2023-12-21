package common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modifyStudent")
public class ModifyStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModifyStudent() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글처리
		response.setContentType("text/html;charset=utf-8");

		// 파라미터 활용해서 조회.
		String sno = request.getParameter("sno");

		StudentDAO dao = new StudentDAO();
		Student std = dao.getStudent(sno);

		String str = "<form action='updateStudent'>";
		str += "<table border='1'><caption>학생정보</caption>";
		str += "<tr><th>학번</th><td><input type='text'" + " readonly name='sno' value='" + std.getStudentNo()
				+ "'></td></tr>";
		str += "<tr><th>이름</th><td>" + std.getStudentName() + "</td></tr>";
		str += "<tr><th>영어</th><td><input type='number' name='escore' value='" + std.getScoreEng() + "'></td></tr>";
		str += "<tr><th>수학</th><td><input type='number' name='mscore' value='" + std.getScoreMath() + "'></td></tr>";
		str += "<tr><td><input type='submit' value='수정'></tr></td>";

		str += "</form>";

		response.getWriter().print(str);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
