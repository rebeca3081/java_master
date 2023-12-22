package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.vo.BoardVO;

// 테스트용
public class MainExe {
	public static void main(String[] args) {
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
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);
		// SqlSession session = DataSource.getInstance().openSession();
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		// 목록조회
		/*
		List<BoardVO> list = mapper.selectList();
		for(BoardVO vo : list) {
			System.out.println(vo.toString());
		}
		*/
		
		// 단건조회 해보기!!
		
		BoardVO one = mapper.selectOne(4);
			System.out.println(one.toString());
		
		
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
