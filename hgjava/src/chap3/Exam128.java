package chap3;

import java.util.*; // * : ���ֵ� �ҷ���

public class Exam128 {

	public static void main(String[] args) {
		// ����4
		int penNum = 534;
		int stuNum = 30;
		
		int pssNum = penNum / stuNum;
		int rempNum = penNum % stuNum;
		
		System.out.printf("�л��� ���� �� : %d, ���� ���� �� : %d \n", pssNum, rempNum);
		
		// ����5 -> ���� Ÿ�Ժ�ȯ
		
		// ����6
		int value = 356;
		System.out.println(value / 100*100);
		
		// ����7 -> �ε��Ҽ��� ǥ�� ��� 0.1�� 0.1���� ū��
		// ����Ÿ�Ժ�ȯ (float)0.1
		
		// ����8 
		// ��ٸ����� �ʺ� = (���� + �Ʒ���) * ���� / 2
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop + lengthBottom) * height / 2.0; //������ 2.0�ؼ� double�� �����
		System.out.println(area);
		
		// ����9
		//����Ű : syso (ctrl+space) / ctrl + alt + ����Ű(�ٺ���) / ctrl + d (�ٻ���)
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° �� : ");
		double num1 = sc.nextDouble();
		
		System.out.print("�ι��� �� : ");
		double num2 = sc.nextDouble();
		
		System.out.println("---------------");
		double result = num1 / num2;
		if(num2 == 0.0) { // 0�� ����� ������ 0���� ��
			System.out.println("��� : ���Ѵ�");
		}else {
			System.out.println("��� : " + result);
		}
		
		// ����10
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("���� ���� : " + var4);
		
		// ���� 11
		System.out.print("���̵� : ");
		String name = sc.next();
		
		System.out.print("��й�ȣ : ");
		String strPassword = sc.next();
		int password = Integer.parseInt(strPassword);
		
		String namecheck = "java";
		
		if(name.equals(namecheck)) {
			if(password == 12345) {
				System.out.println("�α��� ����!");
			}else {
				System.out.println("�α��� ���� : �н����尡 Ʋ��");
			}
		}else {
			System.out.println("�α��� ���� : ���̵� �������� ����");
		}
		sc.close();

	}// end main()

}// end Class
