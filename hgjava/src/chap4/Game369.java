package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		// 369게임
		// 1 ~ 50까지
		// 3, 6, 9의 갯수 체크 변수
		int count = 0;
		// 숫자는 1 ~ 50 반복문
		for(int i = 1; i <= 50; i++) {
			count = 0; // 다음 수를 위한 초기화
			// 일의 자리에 3,6,9 갯수체크 
			if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				count++;
			}
			// 십의 자리에 3,6,9 갯수체크 
			if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
				count++;
			}
			switch(count) {
			case 0:
				System.out.print(i + "\t"); break;
			case 1:
				System.out.print("♥\t"); break;
			case 2:
				System.out.print("♥♥\t");
			}
			// 한줄에 출력
			if(i % 10 == 0) {
				System.out.println(); // 줄바꿈
			}	
		}
		
		// 동전 교환
		Scanner sc = new Scanner(System.in);
		System.out.print("##교환할 금액 : ");
		int money = sc.nextInt();
		int Num500 = money / 500; // 500원짜리 갯수
		int chage = money - (500 * Num500);
		
		int Num100 = chage / 100;
		int chage2 = chage - (100 * Num100);
		
		int Num50 = chage2 / 50;
		int chage3 = chage2 - (50 * Num50);
		
		int Num10 = chage3 / 10;
		int chage4 = chage3 - (10 * Num10);
		System.out.printf("500원짜리 : %d개\n", Num500);
		System.out.printf("100원짜리 : %d개\n", Num100);
		System.out.printf("50원짜리 : %d개\n", Num50);
		System.out.printf("10원짜리 : %d개\n", Num10);
		System.out.println("교환 금액 : " + (int)((500*Num500) + (100*Num100) + (50*Num50) + (10*Num10)) + "원");
		System.out.println("남은 금액 : " + chage4 + "원");
		
		// 다시
		System.out.print("##교환할 금액 : ");
		int myMoney = sc.nextInt();
		System.out.println("500원 짜리 : " + (int)(myMoney / 500) + "개");
		
		int reMoney = myMoney % 500;
		System.out.println("100원 짜리 : " + (int)(reMoney / 100) + "개");
		
		reMoney = myMoney % 100;
		System.out.println("50원 짜리 : " + (int)(reMoney / 50) + "개");
		
		reMoney = myMoney % 50;
		System.out.println("10원 짜리 : " + (int)(reMoney / 10) + "개");
		
		// System.out.println("교환 금액 : " + );
		
		
		// 3. 숫자 추측 게임
		// 1~100까지 수를 발생
		int com = (int)(Math.random() * 100) + 1;
		while(true) {
			System.out.print("숫자 입력 : ");
			//내 숫자받기
			int myNumber = sc.nextInt();
			// if (내숫자 == com) -> 축하합니다 break;
			if(myNumber == com) {
				System.out.println("축하합니다~!!");
				break;
			}else {
				// if(내숫자 > com) -> 다운하세요 / 업하세요
				if(myNumber > com) {
					System.out.println("down하세요");
				}else {
					System.out.println("up하세요");
				}
			}
		}
		
		
		
		
		
		
		
		
		

	}// end main

}// end class
