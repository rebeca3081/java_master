package todo.p20231127;

import java.util.Scanner;

public class FriendApp {

	public static void main(String[] args) {
		// ģ���� ������ 1.ģ���� 2.�Է� 3.��� 4.���� 5.���� (FriendApp)
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Friend[] friends = null;
		
		while(run) {
			System.out.println("1.ģ���� 2.�Է� 3.��� 4.���� 5.����");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				System.out.print("ģ���� �Է�>> ");
				int friendNum = sc.nextInt();
				sc.nextLine();
				friends = new Friend[friendNum];
				break;
			case 2:
				System.out.println("ģ�� ���� �Է�>> ");
				for(int i = 0; i < friends.length; i++) {
					Friend friend = new Friend();
					System.out.println("ģ�� �̸� �Է�>> ");
					friend.name = sc.nextLine();
					System.out.println("ģ�� �ڵ�����ȣ(-����) �Է�>> ");
					friend.phone = sc.nextLine();
					System.out.println("ģ�� ������(A/B/O/AB) �Է�>> ");
					friend.bloodType = sc.nextLine();
					
					friends[i] = friend;
				}
				break;
			case 3:
				// ��� ���
				System.out.println("ģ�� ��� ���>> ");
				for(Friend frnd : friends) {
					System.out.println("�̸�: "+ frnd.name + ", ��ȭ��ȣ: " + frnd.phone + ", ������: " + frnd.bloodType);
				}
				// ��ȸ
				/* System.out.println("��ȸ�� �̸� �Է�>> ");
				String name = sc.nextLine();
				boolean exists = false;
				for(Friend fnd : friends) {
					if(name.equals(fnd.name)) {
						System.out.println("�̸���" + fnd.name + ", ��ȭ��ȣ�� " + fnd.phone + ", �������� " + fnd.bloodType);
						exists = true;
					}
				}
				if(!exists) {
					System.out.println("ã�� �̸��� �����ϴ�.");
				} */
				break;
			case 4:
				System.out.println("��ϼ��� >> ");
				System.out.println("��ȭ��ȣ�� ������ �̸� �Է� >> ");
				String name = sc.nextLine();
				System.out.println("��ȭ��ȣ �Է�>> ");
				String phone = sc.nextLine();
				boolean exists = false;
				for(int i = 0; i < friends.length; i++) {
					if(name.equals(friends[i].name)) {
						friends[i].phone = phone;
						System.out.println("��ȭ��ȣ �����Ϸ�!");
						exists = true;
					}
				}
				if(!exists) {
					System.out.println("ã�� �̸��� �����ϴ�.");
				}
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				run = false;				
			}//end of switch
		}//end of while
	}// end of main()
}// end of class
