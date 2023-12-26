package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class RemoveFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 글 번호 조회.
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceMybatis();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));

		req.setAttribute("vo", vo);

		// 페이지를 이동(forward)
		// 사용자가 URL을 입력시 "board/remBoardForm.jsp"페이지 재이동
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/board/remBoardForm.jsp");
		try {
			rd.forward(req, resp); // 요청을 재지정하겠습니다.
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
