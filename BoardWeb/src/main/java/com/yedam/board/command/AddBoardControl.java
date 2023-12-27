package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// parameter(3개), DB insert, 목록페이지.
		BoardVO vo = new BoardVO(); // 기본생성자 호출
		if (req.getMethod().equals("GET")) {
			// GET 방식 요청일 때
			// 3개 : title=테스트&content=입력내용&writer=홍길동
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");

			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);

		} else if (req.getMethod().equals("POST")) {
			// POST 방식 요청일 때 (file upload 포함)
			String saveLoc = req.getServletContext().getRealPath("images"); // getServletContext():프로젝트명.getRealPath(실제경로)
			int maxSize = 1024 * 1024 * 5; // 5MB, 기본 byte단위
			MultipartRequest mr = null;

			// 1.request (요청정보) 2. saveLoc(실제경로) 3.maxSize 4.인코딩방식 5.리네임 정책(이전파일과 이름이 같으면 새파일에 숫자를 붙여줌)
			try {
				mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());
				String title = mr.getParameter("title");
				String content = mr.getParameter("content");
				String writer = mr.getParameter("writer");
				String image = mr.getFilesystemName("image");

				vo = new BoardVO(); // 기본생성자 호출
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setImage(image);

			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end of if

		// BoardService svc : addBoard()
		BoardService svc = new BoardServiceMybatis();
		try {
			// boolean addBoard(BoardVO vo);
			if (svc.addBoard(vo)) {
				resp.sendRedirect("boardList.do"); // 목록조회
			} else {
				resp.sendRedirect("boardForm.do"); // 등록
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of execute()

}
