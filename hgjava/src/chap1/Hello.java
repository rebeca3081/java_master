package chap1;

import java.io.IOException;
import java.util.Scanner; // ctrl + shift + O ����Ű

public class Hello {

	public static void main(String[] args) throws IOException { // ���ܹ߻� �� ȣ�⿡�� ó������
		System.out.println("hello java~!");
		
		int x = 5;
		int y = x + 10;
		System.out.println(y);
		
		double z = 3.5;
		System.out.println(z);
		System.out.println("y = " + y);
		
		// ������ �� ��ȯ
		x = 3;
		y = 10;
		int temp = x;
		x = y;
		y = temp;
		
		// ���
		System.out.println("x = " + x + ", y = " + y);
		
		// �⺻ Ÿ��
		// ũ�� ���� byte < short < char(����x) < int < long
		
		char charData = 'A'; // 65
		int intData = charData; // 65�� ����
		System.out.println("char : " + charData + " int : " + intData);
		
		
		char c1 = 'a';
		int c2 = c1 + 2; // �ڵ�Ÿ�� ��ȯ
		char c3 = (char) c2; // ����Ÿ�� ��ȯ
		System.out.printf("c2���� : %-6d, c3���� : %3s\n", c2, c3);
		
		x = 5;
		y = 2;
		double result = (double) x / y;
		System.out.println(result);
		
		double v1 = 3.5;
		double v2 = 2.7;
		int result2 = (int) (v1 + v2); // +���� ������ �� int�� ��ȯ
		System.out.println(result2);
		
		// Ȯ�ι��� 9
		long var1 = 2l;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		int result3 = (int) (var1 + var2 + var3) + (int) (Double.parseDouble(var4));
		System.out.println(result3);
		
		// ǥ���Է� Ű���� = > System.in.read()
		// �ϳ��� ���ڸ� �о�帲
//		int keyCode;
//		
//		while(true) {
//			keyCode = System.in.read();
//			System.out.println("keyCode : " + keyCode);
//			if(keyCode == 113) {
//				break;
//			}
//		}
//		System.out.println("����");
		
		
		// ���ڿ� �Է� -> Scanner Ŭ�����̿� -> ��ü�� ���� �ؼ� ���
		String scinput;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("�̸� �Է� : ");
			scinput = sc.nextLine();
			if(scinput.equals("q")){
				break;
			}
			System.out.println("�� �̸��� " + scinput);
		}
		System.out.println("����");
		
		System.out.print("�� �Է� : ");
		scinput = sc.nextLine();
		System.out.println(Integer.parseInt(scinput) + 10); // �⺻�� String -> ������ ��ȯ������
		
		
		
		sc.close(); // scanner.close()
		
		
		
	} // end main()
	

} // end Class
