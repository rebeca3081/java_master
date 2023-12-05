package chap13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("홍길동");
		set.add("신용권");
		set.add("홍길동");
		set.add("강용권");
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String str = iterator.next();
			System.out.println(str);
		}
		
		

	}

}
