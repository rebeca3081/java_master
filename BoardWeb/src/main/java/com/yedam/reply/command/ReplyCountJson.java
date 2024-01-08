package com.yedam.reply.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;

public class ReplyCountJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 누가누가 댓글 많이썻나
		ReplyService svc = new ReplyServiceImpl();
		List<HashMap<String, Object>> list = svc.chatData();
		
		Gson gson = new GsonBuilder().create();
		resp.setContentType("text/json;charset=utf-8");
		
		try {
			resp.getWriter().print(gson.toJson(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
