package com.yedam.student.vo;

import lombok.Data;

@Data
public class Student {
	// 필드
	private String studentNo; // 23-001, 23-002 //오라클: 컬럼이름 -> student_no
	private String studentName;
	private int scoreEng;
	private int scoreMath;

	// 생성자
	public Student() {

	}

	public Student(String studentNo, String studentName, int scoreEng, int scoreMath) {
		this.studentNo = studentNo; // 이름이 같아서 this.필드로 구분
		this.studentName = studentName;
		this.scoreEng = scoreEng;
		this.scoreMath = scoreMath;
	}

}// end of class
