package com.yedam.board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

// 데이터를 가져와서 값 실어보내기 / 페이지 재지정 : url 지정
public class BoardListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 게시글 목록 => boardList.jsp로 전달
		BoardService svc = new BoardServiceMybatis();
		List<BoardVO> list = svc.boardList();
		//req에(요청정보에) 참조값(주소값) 실어 보내기
		req.setAttribute("boardList", list);

		// 페이지를 이동(forward)
		// 사용자가 URL을 입력시 "board/boardList.tiles"페이지 재이동
		RequestDispatcher rd = req.getRequestDispatcher("board/boardList.tiles");
		try {
			rd.forward(req, resp); // 요청을 재 지정하겠습니다.
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
