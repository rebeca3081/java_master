package todo.p20231205emp;

import java.util.ArrayList;

public class EmpExe {
	// 필드 : 배열선언 컬렉션으로 해보기
	ArrayList<Emp> emps;
	
	// 생성자
	EmpExe(){
		emps = new ArrayList<Emp>();
	}
	
	// 메소드
	//1. 추가
	boolean addEmp(Emp emp) {
		return emps.add(emp);
	}
	
	// 목록추가
	
}
