package com.yedam.student.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceMybatis;
import com.yedam.student.vo.Student;

@WebServlet("/studentList") // URL
public class StudentListSetv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentListSetv() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // 출력스트림
		
		// 목록 페이지
		StudentService dao = new StudentServiceMybatis();
		List<Student> list = dao.studentList();
		System.out.println(list);
		//out.println("<table border='1'>");
		String str = "<table border='1'>";
		str += "<thead><tr><th>학생번호</th><th>학생이름</th><th>영어점수</th><th>수학점수</th></tr></thead>";
		str += "<tbody>";
		for(Student std : list) {
			str += "<tr><td><a href='getStudentServlet?sno="+ std.getStudentNo() +"'>" + std.getStudentNo() + "</a></td><td>" + std.getStudentName() 
					+ "</td><td>" + std.getScoreEng() + "</td><td>" + std.getScoreMath() 
					+ "</td></tr>";
		}
		str += "</tbody></table>";
		
		out.println(str);
		
		out.println("<br><a href='student/inform.html'>학생 등록으로 이동</a>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
