package chap5;

import java.util.Scanner;

public class StudentApp2 {
	// static : class �������� ������ ����ϱ� ����
	static Scanner sc = new Scanner(System.in);
	static Student[] students = null; //Ŭ���� �迭 �ʱ�ȭ
	
	public static void addStudent() {
		System.out.println("�л����� �Է�>> ");
		for(int i = 0; i < students.length; i++) {
			Student student = new Student(); // Student:������Ÿ��, student:������
			// student �ν��Ͻ��� �Ӽ� name, score, gender
			System.out.println("�л� �̸� �Է�>> ");
			student.name = sc.nextLine();
			System.out.println("�л� ���� �Է�>> ");
			student.score = Integer.parseInt(sc.nextLine());
			System.out.println("��/�� �Է�>> ");
			student.gender = sc.nextLine();
			
			students[i] = student;
		}
	} //end of addStudent()
	
	public static void searchStudent() {
		System.out.println("��ȸ�� �̸� �Է�>> ");
		String name = sc.nextLine();
		boolean exists = false;
		// �л� �̸� - ���� ���
		for(Student stdn : students) {
			if(name.equals(stdn.name)) { // �Է¹��� �̸��̶� �迭�� �̸��̶� ���� �� ��
				System.out.println("�̸��� " + stdn.name + ", ������ " + stdn.score);						
				exists = true;
			}
		}
		// ã�� �̸��� ���翩�� : exists�� Ȯ��
		if(!exists) {
			System.out.println("ã�� �̸��� �����ϴ�.");
		}		
	} //end of searchStudent()
	
	public static void analysis() {
		int sumOfMen = 0, cntOfMen = 0;
		int sumOfWomen = 0, cntOfWomen = 0;
		for(Student stn : students) {
			// ���л� ���
			if(stn.gender.equals("��")) {
				sumOfMen += stn.score;
				cntOfMen++;
			// ���л� ���
			}else if(stn.gender.equals("��")) {
				sumOfWomen += stn.score;
				cntOfWomen++;
			}
		}
		System.out.println("���л��� ���: " + (sumOfMen * 1.0 / cntOfMen));
		System.out.println("���л��� ���: " + (sumOfWomen * 1.0 / cntOfWomen));
	} //end of analysis();
	
	public static void modify() {
		// �̸� �Է� -> ��������
		System.out.println("��ȸ�� �̸� �Է�>> ");
		String name = sc.nextLine();
		System.out.println("�ٲ� �̸� �Է�>> ");
		String reName = sc.nextLine();
		boolean exists = false;
		
		for(int i = 0; i < students.length; i++) {
			// �����߰� => �������� �Է�
			if(name.equals(students[i].name)) {
				students[i].name = reName;
				System.out.println(name + "->" + students[i].name + " �����Ϸ�!");				
				exists = true;
			}
		}
		// ã�� �̸� ����
		if(!exists) {
			System.out.println("ã�� �̸��� �����ϴ�.");
		}
	} //end of modify()
	
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		
		while(run) {
			System.out.println("1.�л��� 2.�����Է� 3.������ 4.�м�(�ְ�����, ���) 5.���� 6.����");
			int menu = sc.nextInt(); // 3 Enter
			sc.nextLine();
			
			switch(menu) {
			case 1:
				System.out.println("�л��� �Է�>> ");
				studentNum = Integer.parseInt(sc.nextLine()); // ����ȯ "3" -> 3
				students = new Student[studentNum];
				break;
			case 2:
				addStudent(); // �߰� ���
				break;
			case 3:
				searchStudent(); // ��ȸ ���
				break;
			case 4:
				analysis(); // �м� ���
				break;
			case 5:
				modify();
				break;
			case 6:
				System.out.println("�����մϴ�.");
				run = false;
			} //end switch
		} //end while
	} //end main()
} // end class
