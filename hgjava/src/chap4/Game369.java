package chap4;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		// 369����
		// 1 ~ 50����
		// 3, 6, 9�� ���� üũ ����
		int count = 0;
		// ���ڴ� 1 ~ 50 �ݺ���
		for(int i = 1; i <= 50; i++) {
			count = 0; // ���� ���� ���� �ʱ�ȭ
			// ���� �ڸ��� 3,6,9 ����üũ 
			if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				count++;
			}
			// ���� �ڸ��� 3,6,9 ����üũ 
			if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
				count++;
			}
			switch(count) {
			case 0:
				System.out.print(i + "\t"); break;
			case 1:
				System.out.print("��\t"); break;
			case 2:
				System.out.print("����\t");
			}
			// ���ٿ� ���
			if(i % 10 == 0) {
				System.out.println(); // �ٹٲ�
			}	
		}
		
		// ���� ��ȯ
		Scanner sc = new Scanner(System.in);
		System.out.print("##��ȯ�� �ݾ� : ");
		int money = sc.nextInt();
		int Num500 = money / 500; // 500��¥�� ����
		int chage = money - (500 * Num500);
		
		int Num100 = chage / 100;
		int chage2 = chage - (100 * Num100);
		
		int Num50 = chage2 / 50;
		int chage3 = chage2 - (50 * Num50);
		
		int Num10 = chage3 / 10;
		int chage4 = chage3 - (10 * Num10);
		System.out.printf("500��¥�� : %d��\n", Num500);
		System.out.printf("100��¥�� : %d��\n", Num100);
		System.out.printf("50��¥�� : %d��\n", Num50);
		System.out.printf("10��¥�� : %d��\n", Num10);
		System.out.println("��ȯ �ݾ� : " + (int)((500*Num500) + (100*Num100) + (50*Num50) + (10*Num10)) + "��");
		System.out.println("���� �ݾ� : " + chage4 + "��");
		
		// �ٽ�
		System.out.print("##��ȯ�� �ݾ� : ");
		int myMoney = sc.nextInt();
		System.out.println("500�� ¥�� : " + (int)(myMoney / 500) + "��");
		
		int reMoney = myMoney % 500;
		System.out.println("100�� ¥�� : " + (int)(reMoney / 100) + "��");
		
		reMoney = myMoney % 100;
		System.out.println("50�� ¥�� : " + (int)(reMoney / 50) + "��");
		
		reMoney = myMoney % 50;
		System.out.println("10�� ¥�� : " + (int)(reMoney / 10) + "��");
		
		// System.out.println("��ȯ �ݾ� : " + );
		
		
		// 3. ���� ���� ����
		// 1~100���� ���� �߻�
		int com = (int)(Math.random() * 100) + 1;
		while(true) {
			System.out.print("���� �Է� : ");
			//�� ���ڹޱ�
			int myNumber = sc.nextInt();
			// if (������ == com) -> �����մϴ� break;
			if(myNumber == com) {
				System.out.println("�����մϴ�~!!");
				break;
			}else {
				// if(������ > com) -> �ٿ��ϼ��� / ���ϼ���
				if(myNumber > com) {
					System.out.println("down�ϼ���");
				}else {
					System.out.println("up�ϼ���");
				}
			}
		}
		
		
		
		
		
		
		
		
		

	}// end main

}// end class
