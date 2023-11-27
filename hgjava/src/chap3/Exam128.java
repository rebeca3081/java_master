package chap3;

import java.util.*; // * : 모든애들 불러왕

public class Exam128 {

	public static void main(String[] args) {
		// 문제4
		int penNum = 534;
		int stuNum = 30;
		
		int pssNum = penNum / stuNum;
		int rempNum = penNum % stuNum;
		
		System.out.printf("학생당 연필 수 : %d, 남은 연필 수 : %d \n", pssNum, rempNum);
		
		// 문제5 -> 강제 타입변환
		
		// 문제6
		int value = 356;
		System.out.println(value / 100*100);
		
		// 문제7 -> 부동소수점 표현 방식 0.1은 0.1보다 큰값
		// 강제타입변환 (float)0.1
		
		// 문제8 
		// 사다리꼴의 너비 = (윗변 + 아랫변) * 높이 / 2
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop + lengthBottom) * height / 2.0; //나누기 2.0해서 double로 만들기
		System.out.println(area);
		
		// 문제9
		//단축키 : syso (ctrl+space) / ctrl + alt + 방향키(줄복사) / ctrl + d (줄삭제)
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수 : ");
		double num1 = sc.nextDouble();
		
		System.out.print("두번쨰 수 : ");
		double num2 = sc.nextDouble();
		
		System.out.println("---------------");
		double result = num1 / num2;
		if(num2 == 0.0) { // 0은 결과는 어차피 0으로 됨
			System.out.println("결과 : 무한대");
		}else {
			System.out.println("결과 : " + result);
		}
		
		// 문제10
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("원의 넓이 : " + var4);
		
		// 문제 11
		System.out.print("아이디 : ");
		String name = sc.next();
		
		System.out.print("비밀번호 : ");
		String strPassword = sc.next();
		int password = Integer.parseInt(strPassword);
		
		String namecheck = "java";
		
		if(name.equals(namecheck)) {
			if(password == 12345) {
				System.out.println("로그인 성공!");
			}else {
				System.out.println("로그인 실패 : 패스워드가 틀림");
			}
		}else {
			System.out.println("로그인 실패 : 아이디가 존재하지 않음");
		}
		sc.close();

	}// end main()

}// end Class
