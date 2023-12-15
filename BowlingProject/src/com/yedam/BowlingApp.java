package com.yedam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class BowlingApp {
	static Scanner sc = new Scanner(System.in);
	static MemberDAO mdao = new MemberDAO();

	public static void main(String[] args) throws Exception {
		boolean run = true;

		while (run) {
			System.out.println("'제로'볼링클럽 관리프로그램을 실행합니다.");
			System.out.println("메뉴를 선택해주세요 :)");
			System.out.println("1.관리자(회장) | 2.일반회원 | 3.종료");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1: // 1.관리자
				login(); // 관리자의 ID, PW확인 메소드
				boolean subRun = true;
				while(subRun) {
					System.out.println("1.회원관리 2.공지글 관리 3.계정 선택으로 돌아가기");
					int subMenu = Integer.parseInt(sc.nextLine());
					switch (subMenu) {
					case 1: // 회원관리
						//회원관리메뉴 메소드
						memManageMenu();
						break;
					case 2: // 공지글 관리
						// 공지글 관리 메소드
						boradManageMenu();
						break;
					case 3: // 돌아가기
						subRun = false;
					} // end of switch_subMenu									
				} // end of while_subRun
				break;									
			case 2: // 2.일반회원
				System.out.println("일반회원 전용 프로그램입니다.");
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}

		}
		System.out.println("SEE YOU AGAIN~");

	} // end of main()

	// 관리자의 ID, PW확인 메소드
	public static void login() {
		while (true) {
			UserExe uexe = new UserExe();
			
			System.out.println("관리자(회장) 전용 프로그램입니다.");
			System.out.println("id를 입력해주세요>>> ");
			String id = sc.nextLine();
			
			System.out.println("pw를 입력해주세요>>> ");
			String pw = sc.nextLine();
			
			User user = uexe.logIn(id, pw);
			if (user != null) {
				System.out.println(user.getUserName() + "님, 제로클럽 [관리자] 페이지에 오신 것을 환영합니다 :)");
				break;
			} else {
				System.out.println("id 및 pw 확인해주세요");
			}
		}
	} // end of login()
	
	
	// 관리자의 회원관리 메소드
	public static void memManageMenu() throws Exception {
		boolean run = true;
		while (run) {
			System.out.println("[-------------------회원관리 페이지 메뉴-------------------]");
			System.out.println("(1)회원등록 (2)회원전체목록 (3)등급변경 (4)회원정보수정 (5)회원삭제 (6)돌아가기");
			int detailMenu = Integer.parseInt(sc.nextLine());
			switch (detailMenu) {
			case 1: // 회원등록
				System.out.println("회원번호 입력 >>");
				String no = sc.nextLine();
				System.out.println("회원명 입력 >>");
				String name = sc.nextLine();
				System.out.println("전화번호 입력 >>");
				String phone = sc.nextLine();
				System.out.println("가입날짜 입력 >>");
				String join = sc.nextLine();
				System.out.println("등급 입력 >>");
				String grade = sc.nextLine();
				System.out.println("가입승인여부 입력 >>");
				String approval = sc.nextLine();
				
				SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
				Member mem = new Member(no, name, phone, sdf.parse(join), grade, approval);
				
				if(mdao.addMember(mem)) {
					System.out.println("저장되었습니다 :)");		
				}else {
					System.out.println("저장 중 오류 :(");	
				}
				break;
			case 2: // 회원전체목록
				ArrayList<Member> memAry = mdao.getMemberList();
				for(Member memb : memAry) {
					memb.showInfo();
				}
				System.out.println("");
				break;
			case 3: // 등급변경
				System.out.println("등급변경 여기");
				break;
			case 4: // 회원정보수정
				System.out.println("회원정보수정 여기");
				break;
			case 5: // 회원삭제
				System.out.println("회원삭제 여기");
				break;
			case 6: // 돌아가기
				System.out.println("메인메뉴 돌아갑니다");
				run = false;
			}// end of switch_detailMenu
		}
	} // end of memManageMenu()

	
	// 관리자의 공지글관리 메소드
	public static void boradManageMenu() {
		boolean run = true;
		while(run) {
			System.out.println("[------------------공지글 관리 페이지 메뉴------------------]");
			System.out.println("(1)공지글 등록 (2)목록 (3)수정 (4)삭제 (5)돌아가기");
			int detailMenu = Integer.parseInt(sc.nextLine());
			switch (detailMenu) {
			case 1: // 공지글 등록
				System.out.println("공지글 여기");
				break;
			case 2: // 목록
				System.out.println("목록 여기");
				break;
			case 3: // 수정
				System.out.println("수정 여기");
				break;
			case 4: // 삭제
				System.out.println("삭제 여기");
				break;
			case 5: // 돌아가기
				run = false;
				break;
			}// end of switch_detailMenu
		}
	}
}// end of class
