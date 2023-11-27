package chap5;

// 복합적인 형태의 데이터 구조를 할때 class를 사용
class Friend{
	String name; // 필드
	int age; // 필드
	double height; // 필드
}
public class ReferenceExe1 {
	public static void main(String[] args) {
		
		// 참조변수: 실제 '값'을 담는것 (X) -> 실제값의 '주소'를 담고 있음
		Friend myFriend = new Friend(); // new : 객체 생성
		myFriend.name = "김철수";
		myFriend.age = 20;
		myFriend.height = 178.3;
		
//		Friend ourFriend = myFriend; // 같은주소값을 참조(바라보고)하고 있음
		
//		myFriend.name = "홍길동";
//		
//		System.out.println(ourFriend.name);
//		System.out.println(ourFriend.age);
//		System.out.println(ourFriend.height);
		
		Friend yourFriend = new Friend(); // new : 객체 생성
		yourFriend.name = "김철수";
		yourFriend.age = 20;
		yourFriend.height = 178.3;
		
		System.out.println(myFriend == yourFriend); // 주소값을 비교: false
		
		yourFriend = null; // 참조값이 없음
		System.out.println(myFriend.name);
		try { // 예외처리
			System.out.println(yourFriend.name); //NullPointerException	
		}catch(Exception e) { // catch 구문을 실행하고 진행을 유지
			System.out.println("null값을 참조합니다");
		}
		
		// 기본타입
		int a = 10;
		int b = a;
		
		a = 20;
		
		// 참조타입: 주소값을 변수에 저장
		String name = "신용권"; //23dbdae34334(주소값)
		String hobby = "독서";
		
		String name1 = "신용권"; // String name1 = new String("신용권");
		System.out.println("name: " + name);
		System.out.println("name1: " + name1);
		
		System.out.println(name == name1); // 'true' 문자열만~
		System.out.println(name.equals(name1)); // == -> equals()메소드 활용하기!
	}
}
