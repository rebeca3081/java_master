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
import com.yedam.member.command.GetMemberControl;
import com.yedam.member.command.LoginControl;
import com.yedam.member.command.LoginFormControl;
import com.yedam.member.command.MemberListControl;
import com.yedam.reply.command.AddReplyJson;
import com.yedam.reply.command.ChartForm;
import com.yedam.reply.command.Covid19Form;
import com.yedam.reply.command.DelReplyJson;
import com.yedam.reply.command.MapForm;
import com.yedam.reply.command.PagingListJson;
import com.yedam.reply.command.ReplyCountJson;
import com.yedam.reply.command.ReplyListJson;
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
		
		// 관리자
		map.put("/memberList.do", new MemberListControl()); // 회원 목록
		map.put("/getMember.do", new GetMemberControl()); // 회원 상세
		
		// tiles 관련
		map.put("/studentList.do", new StudentListControl()); // 학생 목록
		map.put("/studentInfo.do", new StudentInfoControl()); // 학생 단건조회 ?sno=23-001
		
		// 댓글 관련 (json 포맷의 데이터를 생성해서 반환)
		map.put("/replyListJson.do", new ReplyListJson()); // 댓글 목록
		map.put("/delReplyJson.do", new DelReplyJson()); // 댓글 삭제
		map.put("/addReplyJson.do", new AddReplyJson()); // 댓글 등록
		// 댓글 페이지 생성을 위한 json.
		map.put("/pagingListJson.do", new PagingListJson());
		
		// 차트관련
		map.put("/chart.do", new ChartForm()); // 차트화면
		map.put("/replyCountJson.do", new ReplyCountJson());
		
		// 코로나19 관련
		map.put("/covid19.do", new Covid19Form());
		
		// 지도관련
		map.put("/map.do", new MapForm());
		
		
		// map.put("/main.do", new MainControl()); //(key, value)
		// map.put("/sub.do", new SubControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 요청정보에 한글 인코딩
		
		System.out.println("service() 호출");
		String url = req.getRequestURI(); // URL에서 서버정보 빼고, /프로젝트명/main.do
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
