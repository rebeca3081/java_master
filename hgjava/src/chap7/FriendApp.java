package chap7;

import java.util.Scanner;

public class FriendApp {
	static Scanner sc = new Scanner(System.in);
	// static Friend[] storage = new Friend[10];
	static FriendExe exe = new FriendExe();

	public static void main(String[] args) {
		// 1.등록 2.목록 3.단건조회
		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.조회 4.종료");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1: // 등록
				addFriend();
				break;
			case 2:// 목록
				friendList();
				break;
			case 3:// 단건조회
				getFriend();
				break;
			default:
				System.out.println("종료합니다.");
				run = false;
			} // end of switch
		} // end of while

	} // end of main()

	// 등록 메소드
	private static void addFriend() {
		System.out.println("1.친구 2.학교 3.회사 4.종료");
		int subMenu = Integer.parseInt(sc.nextLine());

		Friend friend = null; // 인스턴스를 받는 변수

		System.out.println("이름>>> ");
		String name = sc.nextLine();
		System.out.println("연락처>>> ");
		String phone = sc.nextLine();

		if (subMenu == 1) { // 친구 : 이름, 연락처
			friend = new Friend(name, phone); // Friend 인스턴스
		} else if (subMenu == 2) { // 학교 : 이름, 연락처, 학교, 전공
			System.out.println("학교>>> ");
			String univ = sc.nextLine();
			System.out.println("전공>>> ");
			String major = sc.nextLine();
			friend = new UnivFriend(name, phone, univ, major); // 부모는 자식의 인스턴스를 담을 수 있음(자동형변환)
		} else if (subMenu == 3) { // 회사 : 이름, 연락처, 회사, 부서
			System.out.println("회사>>> ");
			String comp = sc.nextLine();
			System.out.println("부서>>> ");
			String dept = sc.nextLine();
			friend = new CompFriend(name, phone, comp, dept);
		}
		if (exe.addFriend(friend)) {
			System.out.println("저장완료!");
		} else {
			System.out.println("저장실패...");
		}
	} // end of addFriend()

	// 목록 메소드
	private static void friendList() {
		for (Friend fnd : exe.friendList()) {
			if (fnd != null) {
				System.out.println(fnd.showInfo());
			}
			continue;
		}
	}

	// 단건조회 메소드
	private static void getFriend() {
		String searchCond = "";
		// 이름조회, 연락처 조회
		System.out.println("1.이름 2.연락처");
		int subMenu = Integer.parseInt(sc.nextLine());
		if (subMenu == 1) {
			System.out.println("이름조회>> ");
			searchCond = sc.nextLine();
			for (Friend frd : exe.searchFriend(searchCond)) {
				if (frd != null) {
					System.out.println(frd.showInfo());
				}
				continue;
			}
		} else if (subMenu == 2) {
			System.out.println("연락처조회>> ");
			searchCond = sc.nextLine();
			System.out.println(exe.searchPhone(searchCond).showInfo());
		} else {
			System.out.println("1 또는 2 선택하세요");
		}
	}

	// 백업
	void backup() {
		Friend parent = new Friend();
		parent.setName("홍길동");
		parent.setPhone("010-1111");
		System.out.println(parent.toString()); // 부모클래스.메소드()

		UnivFriend child = new UnivFriend();
		child.setName("김철수");
		child.setPhone("010-2222");
		child.setUniv("구미대학교");
		child.setMajor("컴퓨터공학과");
		System.out.println(child.showInfo());

		Friend[] friends = new Friend[100];
		friends[0] = parent;
		friends[1] = child; // 상속의 관계라서 배열에 담김
	} // end of backup()

}
