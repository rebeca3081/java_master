package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.command.AddBoardControl;
import com.yedam.board.command.BoardFormControl;
import com.yedam.board.command.BoardListControl;
import com.yedam.board.command.GetBoardControl;
import com.yedam.board.command.ModifyBoardControl;
import com.yedam.board.command.ModifyFormControl;
import com.yedam.board.command.RemoveBoardControl;
import com.yedam.board.command.RemoveFormControl;
import com.yedam.member.command.LoginControl;
import com.yedam.member.command.LoginFormControl;
import com.yedam.student.command.StudentInfoControl;
import com.yedam.student.command.StudentListControl;

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
		// 게시판 관련
		map.put("/boardList.do", new BoardListControl()); // 목록조회
		map.put("/boardForm.do", new BoardFormControl()); // 등록
		map.put("/addBoard.do", new AddBoardControl()); // 추가-> 다시 목록
		map.put("/getBoard.do", new GetBoardControl()); // 상세조회
		map.put("/modifyForm.do", new ModifyFormControl()); // 수정화면
		map.put("/modifyBoard.do", new ModifyBoardControl()); // 수정처리 -> 다시 목록
		map.put("/removeForm.do", new RemoveFormControl()); // 삭제화면
		map.put("/removeBoard.do", new RemoveBoardControl()); // 삭제처리
		
		// 회원 관련
		map.put("/loginForm.do", new LoginFormControl()); // 로그인화면
		map.put("/login.do", new LoginControl()); // 로그인 처리
		map.put("/logout.do", new LogoutControl()); // 로그아웃 처리
		
		// tiles 관련
		map.put("/studentList.do", new StudentListControl()); // 학생 목록
		map.put("/studentInfo.do", new StudentInfoControl()); // 학생 단건조회 ?sno=23-001
		
		
		
		// map.put("/main.do", new MainControl()); //(key, value)
		// map.put("/sub.do", new SubControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 요청정보에 한글 인코딩
		
		System.out.println("service() 호출");
		String url = req.getRequestURI(); // url에서 서버정보 빼고, /프로젝트명/main.do
		String context = req.getContextPath(); // /프로젝트명
		String page = url.substring(context.length()); // /main.do, context.length()+1 ->main.do
		System.out.println(page);
		
		Control ctrl = map.get(page);
		ctrl.execute(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}

}
