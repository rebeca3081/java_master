package chap4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		// ����2 : 3�� ��� ��
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("1���� 100���� 3�� ����� ���� : " + sum);
		
		// ����3
		// 1. while(true)
		int hap = 0;
		while(true) {
			// 2. �ֻ��� 2�� �߻�
			int num1 = (int)(Math.random()*6) + 1;
			int num2 = (int)(Math.random()*6) + 1;
			System.out.printf("(%d, %d)\n", num1, num2);
			hap = num1 + num2;
			if(hap == 5) {
				break;
			}
		}
		// 3. ���
		System.out.println("����");
		
		// ����4
		//x�� 1~10����
		int result = 0;
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				result = 4 * x + 5 * y;
				if(result == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}
		
		// ����5 : �����
		String stars = "";
		for(int i = 1; i <= 4; i++) {
			for(int s = 1; s <= i; s++) {
				stars += "*";
			}
			stars += "\n";
			
		}
		System.out.println(stars);
		
		
		// ����6 : �����2
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
		
		// ����7 : ���� ��� �ܰ� ����
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		int money = 0;
		
		while(run) {
			System.out.println("------------------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("------------------------------");
			System.out.print("����> ");
			int inputNum = sc.nextInt();
			switch(inputNum) {
			case 1 :
				System.out.print("���ݾ�> ");
				money = sc.nextInt();
				balance += money;
				break;
			case 2 :
				System.out.print("��ݾ�> ");
				money = sc.nextInt();
				if(balance < money) {
					System.out.println("�ܰ� �����մϴ�");
				}else {
					balance -= money;
				}
				break;
			case 3 :
				System.out.println("�ܰ�> " + balance);
				break;
			default :
				System.out.println("���α׷� ����");
				run = false; // run�� false����� while�� ������ ���������� ��
			}
		
	
			
			
			
			
			
		}

	}// end main

}// end class
