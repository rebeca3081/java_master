package chap13;

import lombok.Data;

@Data //getter setter
public class Member {

	//필드
	private String memberNo;
	private String memberName;
	private int point;
	
	//생성자
	Member(String memberNo, String memberName, int point){
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.point = point;
	}
	
	// 메소드
	
	
} //end of class
