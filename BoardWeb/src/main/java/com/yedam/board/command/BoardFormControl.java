package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class BoardFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 등록화면 open.

		// 페이지를 이동(forward)
		// 사용자가 URL을 입력시 "board/addBoardForm.tiles"페이지 재이동
		RequestDispatcher rd = req.getRequestDispatcher("board/addBoardForm.tiles");
		try {
			rd.forward(req, resp); // 요청을 재지정하겠습니다.
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
