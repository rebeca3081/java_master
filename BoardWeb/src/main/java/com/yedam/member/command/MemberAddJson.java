package com.yedam.member.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberAddJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 한글 인코딩
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/json;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 등록
		// POST 방식 요청일 때 (file upload 포함)
		String saveLoc = req.getServletContext().getRealPath("images"); // getServletContext():프로젝트명.getRealPath(실제경로)
		int maxSize = 1024 * 1024 * 5; // 5MB, 기본 byte단위
		MultipartRequest mr = null;

		// 1.request (요청정보) 2. saveLoc(실제경로) 3.maxSize 4.인코딩방식 5.리네임 정책(이전파일과 이름이 같으면 새파일에 숫자를 붙여줌)
		try {
			mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String image = mr.getFilesystemName("image");
			String responsibility = "User";  // 기본값 "User로 넣기"
			
			// 데이터 담기
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPw(pw);
			vo.setName(name);
			vo.setResponsibility(responsibility);
			vo.setImage(image);
			
			MemberService svc = new MemberServiceImpl();
			
			Map<String, Object> map = new HashMap<>();
			
			if(svc.addMember(vo)) {
				map.put("retCode", "OK");
				map.put("vo", vo);
			} else {
				map.put("retCode", "FAIL");
				
			};
			Gson gson = new GsonBuilder().create();
			
			resp.getWriter().print(gson.toJson(map));
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
