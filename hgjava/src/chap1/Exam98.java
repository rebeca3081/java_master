package chap1;

import java.util.Scanner;

public class Exam98 {

	public static void main(String[] args) {
		// 1��
		String name = "���ڹ�";
		int age = 25;
		String tel1 = "010", tel2 = "123", tel3 = "4567";
		System.out.println("�̸�: " + name);
		System.out.print("����: " + age + "\n");
		System.out.printf("��ȭ��ȣ: %s-%s-%s", tel1, tel2, tel3);
		
		
		// 2��
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nù��° ��: ");
		String strNum1 = sc.nextLine();
		
		System.out.print("�ι�° ��: ");
		String strNum2 = sc.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("���� ���: " + result);
		

		// 3��
		System.out.println("[�ʼ� ���� �Է�]");
		System.out.print("1. �̸�: ");
		String userName = sc.nextLine();
		
		System.out.print("2. �ֹι�ȣ �� 6�ڸ�: ");
		String userYear = sc.nextLine();
		
		System.out.print("3. ��ȭ��ȣ: ");
		String phoneNum = sc.nextLine();
		
		System.out.println(userName);
		System.out.println(Integer.parseInt(userYear));
		System.out.println(phoneNum);
		
		
		
		sc.close();
	}// end main()

}//end Class
