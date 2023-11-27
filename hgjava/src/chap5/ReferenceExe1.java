package chap5;

// �������� ������ ������ ������ �Ҷ� class�� ���
class Friend{
	String name; // �ʵ�
	int age; // �ʵ�
	double height; // �ʵ�
}
public class ReferenceExe1 {
	public static void main(String[] args) {
		
		// ��������: ���� '��'�� ��°� (X) -> �������� '�ּ�'�� ��� ����
		Friend myFriend = new Friend(); // new : ��ü ����
		myFriend.name = "��ö��";
		myFriend.age = 20;
		myFriend.height = 178.3;
		
//		Friend ourFriend = myFriend; // �����ּҰ��� ����(�ٶ󺸰�)�ϰ� ����
		
//		myFriend.name = "ȫ�浿";
//		
//		System.out.println(ourFriend.name);
//		System.out.println(ourFriend.age);
//		System.out.println(ourFriend.height);
		
		Friend yourFriend = new Friend(); // new : ��ü ����
		yourFriend.name = "��ö��";
		yourFriend.age = 20;
		yourFriend.height = 178.3;
		
		System.out.println(myFriend == yourFriend); // �ּҰ��� ��: false
		
		yourFriend = null; // �������� ����
		System.out.println(myFriend.name);
		try { // ����ó��
			System.out.println(yourFriend.name); //NullPointerException	
		}catch(Exception e) { // catch ������ �����ϰ� ������ ����
			System.out.println("null���� �����մϴ�");
		}
		
		// �⺻Ÿ��
		int a = 10;
		int b = a;
		
		a = 20;
		
		// ����Ÿ��: �ּҰ��� ������ ����
		String name = "�ſ��"; //23dbdae34334(�ּҰ�)
		String hobby = "����";
		
		String name1 = "�ſ��"; // String name1 = new String("�ſ��");
		System.out.println("name: " + name);
		System.out.println("name1: " + name1);
		
		System.out.println(name == name1); // 'true' ���ڿ���~
		System.out.println(name.equals(name1)); // == -> equals()�޼ҵ� Ȱ���ϱ�!
	}
}
