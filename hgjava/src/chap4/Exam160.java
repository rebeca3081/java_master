package chap4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		// 문제2 : 3의 배수 합
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("1부터 100까지 3의 배수의 합은 : " + sum);
		
		// 문제3
		// 1. while(true)
		int hap = 0;
		while(true) {
			// 2. 주사위 2개 발생
			int num1 = (int)(Math.random()*6) + 1;
			int num2 = (int)(Math.random()*6) + 1;
			System.out.printf("(%d, %d)\n", num1, num2);
			hap = num1 + num2;
			if(hap == 5) {
				break;
			}
		}
		// 3. 출력
		System.out.println("종료");
		
		// 문제4
		//x를 1~10까지
		int result = 0;
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				result = 4 * x + 5 * y;
				if(result == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}
		
		// 문제5 : 별찍기
		String stars = "";
		for(int i = 1; i <= 4; i++) {
			for(int s = 1; s <= i; s++) {
				stars += "*";
			}
			stars += "\n";
			
		}
		System.out.println(stars);
		
		
		// 문제6 : 별찍기2
		String stars2 = "";
		for(int i = 1; i <= 4; i++) {
			for(int b = 1; b <= 5 - i; b++) {
				stars2 += " ";
			}
			for(int s = 1; s <= i; s++) {
				stars2 += "*";
			}
			stars2 += "\n";
		}
		System.out.println(stars2);
		
		// 문제7 : 예금 출금 잔고 종료
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		int money = 0;
		
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");
			System.out.print("선택> ");
			int inputNum = sc.nextInt();
			switch(inputNum) {
			case 1 :
				System.out.print("예금액> ");
				money = sc.nextInt();
				balance += money;
				break;
			case 2 :
				System.out.print("출금액> ");
				money = sc.nextInt();
				if(balance < money) {
					System.out.println("잔고가 부족합니다");
				}else {
					balance -= money;
				}
				break;
			case 3 :
				System.out.println("잔고> " + balance);
				break;
			default :
				System.out.println("프로그램 종료");
				run = false; // run을 false해줘야 while을 완전히 빠져나오게 됨
			}
		
	
			
			
			
			
			
		}

	}// end main

}// end class
