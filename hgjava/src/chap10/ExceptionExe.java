package chap10;

public class ExceptionExe {
	public static void main(String[] args) {
		try {
			test();
		} catch (ClassNotFoundException e) {
			System.out.println("예외발생!");
			e.printStackTrace();
		}
		System.out.println("end of prog");
	
	}
	public static void test() throws ClassNotFoundException { //throws : 호출한 메소드로 책임을 넘길게요
		// 일반예외 : 예외를 처리해줘야 컴파일이 가능
		Class.forName("java.lang.String2");
		
	}
	
}
