package chap13;

import java.util.ArrayList;
import java.util.List;

public class ListExe {

	public static void main(String[] args) {
		// 일반배열 : 같은 타입만 가능
		String[] strs = {"Mon", "Tue", "10"};
		strs[0] = "Wed";
		strs[1] = null; //배열삭제
		
		for(int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
		
		// 컬렉션 프레임워크 : 인터페이스(List)
		List<String> list = new ArrayList<String>(); // 선언
		list.add("Apple"); // 입력.
		list.add("Banana");
		list.add("Cherry");
		
		list.remove(0); //삭제. 인덱스 번호 (빈공간을 자동으로 없애줌)
		list.remove("Banana");
		
		list.set(0, "바나나"); // 변경.
		list.clear(); // 전체 요소 삭제
		
		for(int i = 0; i < list.size(); i++) { //.size() 크기 
			System.out.println(list.get(i)); // 출력 : .get(인덱스번호)
		}
		
		// 컬렉션의 크기 변경.
		for(int i = 0; i < 100; i++) {
			list.add("" + i);
		}
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		// 이름저장 컬렉션
		List<String> names = new ArrayList<String>();
		names.add("홍길동"); // 0인덱스 : 첫번째
		names.add("김길동"); // 1인덱스 : 두번째
		names.add("박철수"); // 2인덱스 : 세번째
		
		String search = "길동";
		int cnt = 0;
		for(int i = 0; i < names.size(); i++) {
			if(names.get(i).indexOf(search) != -1) { //.equals()는 문자열이 완전히 동일해야함..
				cnt++;
			}
		}
		System.out.println(search + "은 " + cnt + "명 입니다.");
		
		

	}

}
