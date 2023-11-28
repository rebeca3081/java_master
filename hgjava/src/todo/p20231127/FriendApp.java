package todo.p20231127;

import java.util.Scanner;

public class FriendApp {

	public static void main(String[] args) {
		// 친구의 정보를 1.친구수 2.입력 3.목록 4.수정 5.종료 (FriendApp)
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		Friend[] friends = null;
		
		while(run) {
			System.out.println("1.친구수 2.입력 3.목록 4.수정 5.종료");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				System.out.print("친구수 입력>> ");
				int friendNum = sc.nextInt();
				sc.nextLine();
				friends = new Friend[friendNum];
				break;
			case 2:
				System.out.println("친구 정보 입력>> ");
				for(int i = 0; i < friends.length; i++) {
					Friend friend = new Friend();
					System.out.println("친구 이름 입력>> ");
					friend.name = sc.nextLine();
					System.out.println("친구 핸드폰번호(-포함) 입력>> ");
					friend.phone = sc.nextLine();
					System.out.println("친구 혈액형(A/B/O/AB) 입력>> ");
					friend.bloodType = sc.nextLine();
					
					friends[i] = friend;
				}
				break;
			case 3:
				// 목록 출력
				System.out.println("친구 목록 출력>> ");
				for(Friend frnd : friends) {
					System.out.println("이름: "+ frnd.name + ", 전화번호: " + frnd.phone + ", 혈액형: " + frnd.bloodType);
				}
				// 조회
				/* System.out.println("조회할 이름 입력>> ");
				String name = sc.nextLine();
				boolean exists = false;
				for(Friend fnd : friends) {
					if(name.equals(fnd.name)) {
						System.out.println("이름은" + fnd.name + ", 전화번호는 " + fnd.phone + ", 혈액형은 " + fnd.bloodType);
						exists = true;
					}
				}
				if(!exists) {
					System.out.println("찾는 이름이 없습니다.");
				} */
				break;
			case 4:
				System.out.println("목록수정 >> ");
				System.out.println("전화번호를 수정할 이름 입력 >> ");
				String name = sc.nextLine();
				System.out.println("전화번호 입력>> ");
				String phone = sc.nextLine();
				boolean exists = false;
				for(int i = 0; i < friends.length; i++) {
					if(name.equals(friends[i].name)) {
						friends[i].phone = phone;
						System.out.println("전화번호 수정완료!");
						exists = true;
					}
				}
				if(!exists) {
					System.out.println("찾는 이름이 없습니다.");
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				run = false;				
			}//end of switch
		}//end of while
	}// end of main()
}// end of class