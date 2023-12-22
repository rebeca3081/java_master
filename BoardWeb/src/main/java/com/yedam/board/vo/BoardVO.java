package com.yedam.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	// 필드
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int clickCnt;
	private String image;
	
	// 생성자

	// 메소드
}
