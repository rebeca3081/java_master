package chap4;

public class Exam140 {

	public static void main(String[] args) {
		// �ֻ��� ��ȣ �̱�
		int num = (int)(Math.random() * 6) + 1;
		
		if(num == 1) {
			System.out.println("1�� ����");
		}else if(num == 2) {
			System.out.println("2�� ����");
		}else if(num == 3) {
			System.out.println("3�� ����");
		}else if(num == 4) {
			System.out.println("4�� ����");
		}else if(num == 5) {
			System.out.println("5�� ����");
		}else {
			System.out.println("6�� ����");
		}
		
		//switch
		switch(num) {
		case 1 : System.out.println("s1�� ����"); break;
		case 2 : System.out.println("s2�� ����"); break;
		case 3 : System.out.println("s3�� ����"); break;
		case 4 : System.out.println("s4�� ����"); break;
		case 5 : System.out.println("s5�� ����"); break;
		default : System.out.println("s6�� ����");
		}
		
		
		

	}// end main

}// end class
