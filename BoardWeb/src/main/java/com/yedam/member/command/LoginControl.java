package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.board.service.MemberService;
import com.yedam.board.serviceImpl.MemberServiceImpl;
import com.yedam.common.Control;
import com.yedam.member.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// id, pw 	-> 정상 	-> 목록.
		//			-> 비정상	-> 로그인화면.
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberService svc = new MemberServiceImpl();
		
		MemberVO vo = svc.login(id, pw);
		
		if(vo != null) {
			// 세션객체에 로그인정보 저장
			HttpSession session = req.getSession();
			session.setAttribute("logId", vo.getId()); // 세션객체에 로그인아이디 값을 넘김
			session.setAttribute("logName", vo.getName()); // 세션객체에 사용자명 값을 넘김
			
			try {
				resp.sendRedirect("boardList.do"); //매개값 X
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			req.setAttribute("message", "아이디와 비밀번호를 확인하세요 :(");
			try {
				req.getRequestDispatcher("loginForm.do").forward(req, resp);//매개값 O
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	}

}
