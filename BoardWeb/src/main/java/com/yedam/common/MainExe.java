package com.yedam.common;

import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;

// 테스트용
public class MainExe {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		List<HashMap<String, Object>> list = svc.chatData();
		
		Gson gson = new GsonBuilder().create();
		System.out.println(gson.toJson(list));
		
		/*
		ReplyService svc = new ReplyServiceImpl();
		svc.replyListPaging(4, 1).forEach(reply -> System.out.println(reply));
		*/
		
		/*
		int total = 70;
		PageDTO dto = new PageDTO(13, total);
		
		System.out.println(dto.toString());
		*/
		
		/*
		// Member 로그인 테스트
		MemberService svc = new MemberServiceImpl();
		MemberVO vo = svc.login("user1", "1111");
		
		if(vo != null) {
			System.out.println(vo);
			System.out.println(vo.getName() + "님, 환영합니다. 권한은 " +vo.getResponsibility());
		}else {
			System.out.println("id, pw 확인");
		}
		*/
		
		
		
		/* StudentService svc = new StudentServiceMybatis();
		String sno = "23-001";

		// SM.xml -> 추가
		if (svc.remStudent(sno)) {
			System.out.println("삭제됨.");
		} else {
			System.out.println("삭제실패.");
		} */
		
		
		// Board 테스트
		
		// JDBC vs Mybatis
		/*
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);
		// SqlSession session = DataSource.getInstance().openSession();
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		*/
		
		
		// 목록조회
		/*
		List<BoardVO> list = mapper.selectList();
		for(BoardVO vo : list) {
			System.out.println(vo.toString());
		}
		*/
		
		// 단건조회 해보기!!
		/*
		BoardVO one = mapper.selectOne(1);
			System.out.println(one.toString());
		*/
	
		// 입력
		/*
		BoardVO vo = new BoardVO();
		vo.setTitle("ttttttt");
		vo.setContent("cccccccccccc");
		vo.setWriter("김영민");
		vo.setBoardNo(4);
		
		
		if(mapper.insertBoard(vo) == 1) {
			System.out.println("추가성공");
		}else {
			System.out.println("추가실패");
		}
		*/
		
		// 수정
		/*
		BoardVO vo = new BoardVO();
		vo.setBoardNo(4);
		vo.setContent("cdcdcdcdcd");
		
		if(mapper.updateBoard(vo) == 1) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
		*/
		
		// 삭제
		/*
		if(mapper.deleteBoard(2) == 1) {
			System.out.println("삭제 완료");
		}else {
			System.out.println("삭제 실패");
		}
		*/
		
		// 조회수
		/*
		if(mapper.updateCnt(3) == 1) {
			System.out.println("조회수 1 증가");
		}else {
			System.out.println("조회수 증가 실패");
		}
		*/
		
	}
}
