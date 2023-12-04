package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListExe3 {

	public static void main(String[] args) {
		// 회원등록(회원번호, 회원이름, 포인트)
		// 1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료
		//2-> "길동"도 조회가능
		// 회원번호와 포인트 단건 수정, 삭제
		// 컬렉션으로
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int menu = 0;
		boolean exists = false;
		
		// 배열객체
		List<Member> members = new ArrayList<>();
		members.add(new Member("M-001", "홍길동", 1000));
		members.add(new Member("M-002", "김길동", 1500));
		members.add(new Member("M-003", "최인수", 2000));
		
		while(run) {
			System.out.println("1.등록 2.이름조회 3.포인트변경 4.삭제 5.종료");
			menu = Integer.parseInt(sc.nextLine());
			switch(menu) {
			case 1:
				System.out.println("회원번호 이름 포인트");
				String input = sc.nextLine();
				String[] inAry = input.split(" ");
				String num = inAry[0];
				String name = inAry[1];
				int point = Integer.parseInt(inAry[2]);
				
				members.add(new Member(num, name, point));
				System.out.println("등록 완료!");
				break;
			case 2:
				exists = false;
				System.out.println("회원이름 조회>>> ");
				name = sc.nextLine();
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberName().indexOf(name) != -1) {
						System.out.println("이름은 " + members.get(i).getMemberName()
								+ ", 회원번호는 " + members.get(i).getMemberNo()
								+ ", 포인트는 " + members.get(i).getPoint());
						exists = true;
					}
				}
				if(!exists) {
					System.out.println("조회실패...");
				}
				break;
			case 3:
				exists = false;
				System.out.println("회원번호 조회>>> ");
				num = sc.nextLine();
				System.out.println("변경할 포인트 입력>>> ");
				point = Integer.parseInt(sc.nextLine());
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberNo().indexOf(num) != -1) {
						members.get(i).setPoint(point);
						System.out.println(point + "로 변경되었습니다.");
						exists = true;
					}
				}
				if(!exists) {
					System.out.println("변경실패...");
				}
				break;
			case 4:
				exists = false;
				System.out.println("삭제할 회원번호 조회>>> ");
				num = sc.nextLine();
				for(int i = 0; i < members.size(); i++) {
					if(members.get(i).getMemberNo().indexOf(num) != -1) {
						members.remove(i);
						System.out.println("삭제완료!");
						exists = true;
					}
				}
				if(!exists) {
					System.out.println("삭제실패...");
				}
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			} //end of switch
			
		} //end of while
		System.out.println("end of prog");
		
	}
	
	
	

}
