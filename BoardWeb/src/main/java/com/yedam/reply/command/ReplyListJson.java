package com.yedam.reply.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;
import com.yedam.reply.vo.ReplyVO;

public class ReplyListJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// Json 데이터를 생성해서 반환.
		// JSON = [{"replyNo":4, "boardNo":2, "reply":"아자아자! 빠쑝!", "replyer":"user1",
		// ...},{},...{}]
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		page = page == null ? "1" : page; // page값 없으면 "1" 있으면 page값

		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyListPaging(Integer.parseInt(bno), Integer.parseInt(page));

		int cnt = list.size(); // 데이터 건수
		// {"page": page},
		String json = "[";
		for (int i = 0; i < cnt; i++) {
			json += "{\"replyNo\":" + list.get(i).getReplyNo() + ",\"boardNo\":" + list.get(i).getBoardNo()
					+ ",\"reply\":\"" + list.get(i).getReply() + "\",\"name\":\"" + list.get(i).getName() + "\"}";
			if (i != cnt - 1) { // 마지막 건수가 아니면 ',' 반복해서 달기, 마지막이면 안달기
				json += ",";
			}
		}
		json += "]";

		// 출력스트림
		try {
			resp.getWriter().print(json); // 웹브라우저에 그려주겠습니다
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
