package common;

public class Student {
	// 필드
	private String studentNo; // 23-001, 23-002 //오라클: 컬럼이름 -> student_no 
	private String studentName;
	private int scoreEng;
	private int scoreMath;
	
	// 생성자
	Student(){
		
	}
	public Student(String studentNo, String studentName, int scoreEng, int scoreMath){
		this.studentNo = studentNo; // 이름이 같아서 this.필드로 구분
		this.studentName = studentName;
		this.scoreEng = scoreEng;
		this.scoreMath = scoreMath;
	}
	
	//메소드 기능
	public void showInfo() {
		System.out.println("이름은 " + studentName + ", 영어는 " + scoreEng + "점, 수학은 " + scoreMath + "점입니다.");
	}
	
	//setter
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setScoreEng(int scoreEng) {
		this.scoreEng = scoreEng;
	}
	public void setScoreMath(int scoreMath) {
		this.scoreMath = scoreMath;
	}
	
	//getter
	public String getStudentNo() {
		return studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public int getScoreEng() {
		return scoreEng;
	}
	public int getScoreMath() {
		return scoreMath;
	}
	
	
	
	
}// end of class
