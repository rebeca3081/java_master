package com.yedam.reply.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;
import com.yedam.reply.vo.ReplyVO;

public class AddReplyJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/json;charset=utf-8");
		// insert...
		String bno = req.getParameter("bno");
		String reply = req.getParameter("reply");
		String replyer= req.getParameter("replyer");
		
		ReplyVO vo = new ReplyVO();
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setReply(reply);
		vo.setReplyer(replyer);
		
		Gson gson = new GsonBuilder().create(); // 자바 객체 -> 문자열
		
		Map<String, Object> map = new HashMap<>();
		
		String json = null; // gson.toJson(문자열로 만들고 싶은 객체를 넣어줌)
		
		ReplyService svc = new ReplyServiceImpl();
		try {
			if(svc.addReply(vo)) {
				// {"retCode": "OK"}
				vo = svc.getReply(vo.getReplyNo());
				
				map.put("retCode", "OK");
				map.put("vo", vo);
				json = gson.toJson(map);
				resp.getWriter().print(json);
			} else {
				// {"retCode": "NG"}
				map.put("retCode", "NG");
				json = gson.toJson(map);
				// resp.getWriter().print("{\"retCode\": \"NG\"}");
				resp.getWriter().print(json);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
