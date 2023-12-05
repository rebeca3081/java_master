package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExe2 {

	public static void main(String[] args) {
		Map<Member, String> map;
		map = new HashMap<>();
		
		// 추가
		map.put(new Member("M001", "홍길동", 100), "경기도 100번지");
		map.put(new Member("M002", "김민수", 90), "서울시 200번지");
		map.put(new Member("M003", "박씨", 80), "대전시 300번지");
		map.put(new Member("M001", "홍길동", 100), "경기도 200번지");
		
		// 삭제
		map.remove(new Member("M001", "홍길동", 100));
		
		// 출력 1) key를 Set컬렉션에 저장
		// Set은 중복을 허용하지 않음
		Set <Member> set = map.keySet(); // key모음을 Set 컬렉션에 넣어줌
		for(Member member : set) {
			System.out.println("key: " + member + ", value: " + map.get(member));
		}
		
		// 출력 2) key, value => Set에 저장
		Set<Entry<Member, String>> entry = map.entrySet();
		for(Entry<Member, String> ent : entry) {
			System.out.println("Key: " + ent.getKey() + ", Val: " + ent.getValue());
		}

	}//end of main

}
