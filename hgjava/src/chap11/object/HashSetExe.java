package chap11.object;

import java.util.HashSet;

public class HashSetExe {
	public static void main(String[] args) {
		// 배열 -> 컬렉션(List-인덱스로 비교, Set-주머니:중복담지x/순서x, Map-key:value)
		
		HashSet<String> set = new HashSet<String>(); // <Srting>만 담으세요
		set.add("Hong");
		set.add("Hwang");
		set.add("Park");
		set.add("Hong");
		// set.add(new Member("Hong", 20));
		
		//Set : 중복된 값은 제거함
		for(Object name : set) { //최상위가 Object
			System.out.println(name);
		}
		
		HashSet<Member> members = new HashSet<Member>();
		members.add(new Member("홍길동", 20));
		members.add(new Member("김길동", 21));
		members.add(new Member("박길동", 22));
		members.add(new Member("홍길동", 20));
		for(Member mem : members) {
			System.out.println(mem.toString());
		}
		
		
	}//end of main
}
