package com.yedam.board.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // .builder().boardNo(2) => 인스턴스 생성없이 바로 만들 수 있게 해주는 메소드 역할
@NoArgsConstructor // 기본생성자 생성
@AllArgsConstructor // 모든 argument에 대한 생성자 생성
public class BoardVO {
	// 필드
	private int boardNo;
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int clickCnt;
	private String image;
}
