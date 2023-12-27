package com.yedam.student.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class StudentListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// tiles.xml -> WILDCARD:student/* -> student/{1}.jsp
			// {1} : 와일드 카드 1개를 받겠습니다~ 
			req.getRequestDispatcher("student/studentList.tiles").forward(req, resp); //.tiles로 끝나야함
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
