package com.yedam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	// 필드
	private int boardNo;
	private String boardContent;
	private String boardWriter;
	private String boardDate;
	
	// 생성자
	public Board() {
		
	}
	// date 매개변수 없는 생성자 -> 자동으로 생성될 수 있게 해줌
	public Board(int boardNo, String boardContent, String boardWriter) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		
		this.boardNo = boardNo;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.boardDate = sdf.format(today); // format() : Date -> String
	}
	
	public Board(int boardNo, String boardContent, String boardWriter, String boardDate) {
		this(boardNo, boardContent, boardWriter); //this ->인스턴스 Board(){} 생성자
		this.boardDate = boardDate;
	}
	
	public Board(int boardNo, String boardContent) {
		this.boardNo = boardNo;
		this.boardContent = boardContent;
	}
	
	// 메소드
	public void showBoardInfo() {
		System.out.printf("%4d \t %s \t %s \t %s\n", boardNo, boardContent, boardWriter, boardDate);
	}
	
	
	// getter,setter
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
		
	
	
}// end of class
