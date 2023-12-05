package chap13;

import java.util.HashSet;
import java.util.Set;

public class SetExe2 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();

		// 추가
		set.add("java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("java");
		set.add("iBATIS");

		// 객체수
		int setSize = set.size();
		System.out.println("총 객체수: " + setSize + "개");
		
		// 출력
		for(String str : set) { // 확장 for문(타입 요소가 될 변수명 : 배열명)
			System.out.println(str);
		}
		
		set.clear(); // 모든 객체를 제거하고 비움
		if(set.isEmpty()) { // isEmpty():비었는지 확인
			System.out.println("비어있음");
		} 
	}

}
