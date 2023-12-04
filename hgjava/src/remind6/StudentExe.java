package remind6;
// 저장공간: 배열
// 추가/수정/삭제/목록/단건조회

public class StudentExe {
	// 필드(배열인)
	// 배열:
	private Student[] students;
	
	
	// 생성자-> 클래스이름(){}
	// 메소드는 반환타입이 있어야함 void,String...
	StudentExe(){
		students = new Student[100]; //this.studnets
		students[0] = new Student("23-001", "홍길동", 77, 88);
		students[1] = new Student("23-002", "김철수", 82, 85);
	}
	
	// 기능1: 추가 
	// Student 라고하는 타입
	boolean addStudent(Student std) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = std;
				// break;
				return true; // 메소드에서 return문은 메소드의 끝. 
			}
		}
		return false; // 빈공간 없어요 -> false리턴
	}
	
	// 기능2: 목록반환
	Student[] getStudentList() {
		return students;
	}
	
	// 기능3: 단건조회
	Student getStudent(String no) {
		for(int i = 0; i < students.length; i++) {
			if(students[i] != null && students[i].getStudentNo().equals(no)) {
				return students[i];
			}
		}
		return null; // 찾아봤는데 없어요
	}
	
	// 기능4: 점수수정
	boolean modifyStudent(String no, int eng, int math) {
		for(int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStudentNo().equals(no)) {
				students[i].setScoreEng(eng);
				students[i].setScoreMath(math);
				return true;
			}
		}
		return false;
	}
	
	// 기능5: 삭제
	boolean removeStudent(String name){
		for(int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getStudentName().equals(name)) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
}
