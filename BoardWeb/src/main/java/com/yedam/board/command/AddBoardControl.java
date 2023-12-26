package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// parameter(3개), DB insert, 목록페이지.
		// 3개 : title=테스트&content=입력내용&writer=홍길동
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardVO vo = new BoardVO(); // 기본생성자 호출
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		// BoardService svc : addBoard()
		BoardService svc = new BoardServiceMybatis();
		
		// boolean addBoard(BoardVO vo);
		if(svc.addBoard(vo)) {
			try {
				resp.sendRedirect("boardList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				resp.sendRedirect("boardForm.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
