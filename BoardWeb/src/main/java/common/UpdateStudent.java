package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateStudent() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		// 파라미터 확인
		// ?sno=23-012&escore=50&mscore=40
		String sno = request.getParameter("sno");
		String escore = request.getParameter("escore");
		String mscore = request.getParameter("mscore");
		
		StudentDAO dao = new StudentDAO();
		boolean done = dao.modifyStudent(sno, Integer.parseInt(escore), Integer.parseInt(mscore));
		
		// 출력 스트림
		PrintWriter out = response.getWriter();
		
		if(done) {
			out.print("<script>alert('OK'); location.href='studentList';</script>");
		} else {
			out.print("<script>alert('Fail'); location.href='index.html';</script>");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
