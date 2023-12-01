package chap11.object;

public class ObjectExe {
	public static void main(String[] args) {
		// equals
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		// 객체의 주소값을 비교 -> false
		System.out.println(obj1.equals(obj2));
		
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		
		// 문자열이 같은지 아닌지 비교 -> true
		System.out.println(str1.equals(str2));
		
		Member mem1 = new Member("홍길동", 20);
		Member mem2 = new Member("장길동", 20);
		System.out.println(mem1.equals(mem2)); // 오버라이딩한 equal메소드를 사용함
		
		
		
	}
}
