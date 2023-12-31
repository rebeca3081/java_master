package remind7;

import java.util.ArrayList;
import java.util.List;

public class StudentExe {
	// 컬렉션으로 바꿔서 해보기
	// 컬렉션 배열 필드
	List<Student> students;

	// 생성자
	StudentExe() {
		students = new ArrayList<>();
	}

	// 기능1: 추가 -> Student 인스턴스를 가져와서 매개값으로 사용 -> 컬렉션배열에 인스턴스 추가
	boolean addStudent(Student stut) {
		return students.add(stut);
	}

	// 기능2: 목록반환
	List<Student> getStudentList() {
		return students;
	}

	// 기능3: 단건조회
	Student getStudent(String no) {
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getStudentNo().equals(no)) {
				return students.get(i);
			}
		}
		return null;
	}

	// 기능4: 점수수정
	boolean modifyStudent(String no, int eng, int math) {
		for(int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentNo().indexOf(no) != -1) {
				students.get(i).setScoreEng(eng);
				students.get(i).setScoreMath(math);
				return true;
			}
		}
		return false;
	}

	// 기능5: 삭제
	boolean removeStudent(String name){
		for(int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentName().indexOf(name) != -1) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}

}
