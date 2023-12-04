package remind7;

import lombok.Data;

// 컬렉션으로 바꿔서 해보기
@Data
public class Student {
	// 필드
	private String studentNo; // 23-001
	private String studentName;
	private int scoreEng;
	private int scoreMath;
	
	// 생성자
	// 기본생성자
	Student(){
		
	}
	Student(String studentNo, String studentName, int scoreEng, int scoreMath){
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.scoreEng = scoreEng;
		this.scoreMath = scoreMath;
	}
	
	// 메소드 기능
	// 조회
	public void showInfo() {
		System.out.println("이름은 " + studentName + ", 영어는 " + scoreEng + "점, 수학은 " + scoreMath + "점입니다.");
	}
	
	

}
