package chap10;

public class NullExceptionExe {

	public static void main(String[] args) {
		// Null값을 참조할 경우 [주의]

		String name = "Hong";

		name = null;
		String menu = "2";
		int[] numAry = {1, 2, 3};

		// 예외처리
		try {
			name = "";
			System.out.println(name.toString()); // NullPointerException
			int num = Integer.parseInt(menu); // NumberFormatException
			System.out.println("입력값은 " + num);
			System.out.println(numAry[3]);
			
		} catch (NullPointerException | NumberFormatException e) { // (어떤예외)
			 System.out.println("Null예외발생. 010-1111-2222 전화해서 해결바람^^");
			// e.printStackTrace(); // NullPointerException클래스 변수e의 로그를 찍어보는 메소드()
		} /* catch (NumberFormatException ne) {
			System.out.println("숫자값을 입력하세요");
		} */catch(Exception ee) {
			System.out.println("알수 없는 예외가 발생");
			}
		

		System.out.println("end of prog");

	}

}
