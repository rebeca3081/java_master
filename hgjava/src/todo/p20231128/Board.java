package todo.p20231128;

import java.text.SimpleDateFormat;

import java.util.Date;

import lombok.Data;
//getter, setter
@Data

public class Board {
	// 필드
	private int boardNo; // 오라클: boardNo, board_no로 구분하는 규칙
	private String title; //자바게시판입니다
	private String writer; //user01
	private String content; // 오늘은~
	private String date; //2023-11-28
	
	//기본 생성자
	Board(){
		
	}
	// data 매개변수 없는 생성자 자동으로 생성될 수 있게 해줌
	public Board(int boardNo, String title, String writer, String content) {
		Date today = new Date(); //시스템시간을 기준으로 생성
		// Date -> String -> Data;
		// 시:분:초 HH:mm:ss
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.boardNo = boardNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.date = sdf.format(today);
	}
	
	public Board(int boardNo, String title, String writer, String content, String date){
		// this(); // 기본생성자
		this(boardNo, title, writer, content); //this ->인스턴스 Board(){} 생성자
		this.date = date;
	}
	
	// 메소드
	public String showInfo() {
		return boardNo + "\t" + title + " \t" + writer + " \t" + date;
	}
	// 상세조회
	public String showDetailInfo() {
		String result = "번호: "+ boardNo + "/ 제목: "+ title;
		result += "\n작성자: "+ writer;
		result += "\n내용: "+ content;
		result += "\n일시: "+ date;
		return result;
	}
		
	
} //end of class
