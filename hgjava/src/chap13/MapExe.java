package chap13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExe {

	public static void main(String[] args) {
		// Map - 키:값 쌍으로 구성
		Map<String , Integer> map = new HashMap<String, Integer>();
		
		// 추가 - .put()
		map.put("홍길동", 80); // .put(key, value) => Entry
		map.put("김길동", 85);
		map.put("장효은", 90);
		map.put("홍길동", 90);
		
		//
		Integer result = map.get("홍길동"); //key에 해당하는 value를 반환
		
		// 전체목록
		Set<String> set = map.keySet(); // key값만 가져옴
		for(String key : set) {
			System.out.println("key :" + key + ", value: " + map.get(key));
		}

	}

}
