package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class BowlingApp {
	static Scanner sc = new Scanner(System.in);
	static MemberDAO mdao = new MemberDAO();
	static BoardDAO bdao = new BoardDAO();
	static ScoreDAO sdao = new ScoreDAO();

	public static void main(String[] args) throws Exception {
		boolean run = true;

		while (run) {
			System.out.println("'제로'볼링클럽 관리프로그램을 실행합니다.");
			System.out.println("-------계정을 선택해주세요:)--------");
			System.out.println("1.관리자(회장) | 2.일반회원 | 3.종료");
			System.out.println("--------------------------------");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1: // 1.관리자
				login(); // 관리자의 ID, PW확인 메소드
				boolean subRun = true;
				while(subRun) {
					System.out.println("1.회원관리 2.공지글 관리 3.계정선택으로 돌아가기");
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
				subRun = true;
				while(subRun) {
					System.out.println("1.내 점수관리 2.공지글확인 및 댓글관리 3.내 댓글전체목록 4.계정선택으로 돌아가기");
					int subMenu = Integer.parseInt(sc.nextLine());
					switch (subMenu) {
					case 1: // 내 점수관리
						// 내 점수관리 메소드
						scoreManageMenu();
						break;
					case 2: // 공지글확인 및 댓글관리
						// 공지글확인 메소드
						
						// 댓글관리 메소드

						break;
						
					case 3: // 내 댓글 전체 목록
						// 내댓글 전체 목록 메소드
						
						break;
					case 4: // 돌아가기
						subRun = false;
					} // end of switch_subMenu
				} // end of while_subRun
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}

		}
		System.out.println("SEE YOU AGAIN~💨💨");

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
	public static void memManageMenu() throws ParseException{
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
				System.out.println("가입기간 2개월이 지난 회원을 '정회원'으로 일괄 변경하시겠습니까?");
				System.out.println("y(네) / n(아니요)");
				String yesNo = sc.nextLine();
				
				if(yesNo.equals("y")) {
					if(mdao.modifyAllGrade()){
						System.out.println("등급변경 성공!");
					}else {
						System.out.println("등급변경할 회원이 없습니다");
					}
				}
				
				break;
			case 4: // 회원정보수정
				System.out.println("a.전화번호 수정  |  b.가입승인여부 수정");
				String modify = sc.nextLine();
				if(modify.equals("a")) {
					System.out.println("회원번호 입력 >>");
					String num = sc.nextLine();
					System.out.println("수정할 전화번호 입력 >>");
					String phonenum = sc.nextLine();
					if(mdao.modifyPhone(num, phonenum)){
						System.out.println("전화번호 수정완료!");
					}else {
						System.out.println("전화번호 수정실패...");
					}
				}else if(modify.equals("b")) {
					System.out.println("회원번호 입력 >>");
					String num = sc.nextLine();
					System.out.println("수정할 등급 입력 >>");
					String approve = sc.nextLine();
					if(mdao.modifyApprove(num, approve)) {
						System.out.println("등급수정 완료!");
					}else {
						System.out.println("등급수정 실패...");
					}
				}
				break;
			case 5: // 회원삭제
				System.out.println("삭제할 회원번호를 입력 >>");
				String num = sc.nextLine();
				if(mdao.removeMember(num)) {
					System.out.println("삭제 완료!");
				}else {
					System.out.println("삭제 실패...");
				}
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
				System.out.println("글번호 입력 >>");
				int no = Integer.parseInt(sc.nextLine());
				System.out.println("공지글 내용 입력>>");
				String con = sc.nextLine();
				
				Board bob = new Board(no, con);
				if(bdao.addBoard(bob)) {
					System.out.println("등록 완료!");
				}else {
					System.err.println("등록 실패...");
				}
				
				break;
			case 2: // 목록
				ArrayList<Board> bodAry = bdao.getBoardList();
				for(Board bord : bodAry) {
					bord.showBoardInfo();
				}
				break;
			case 3: // 수정
				System.out.println("글번호 입력 >>");
				int num = Integer.parseInt(sc.nextLine());
				System.out.println("수정할 공지글 내용 >>");
				String contnet = sc.nextLine();
				
				if(bdao.modifyBoard(num, contnet)) {
					System.out.println("수정 성공!");
				}else {
					System.out.println("수정 실패...");
				}
				break;
			case 4: // 삭제
				System.out.println("글번호 입력 >>");
				num = Integer.parseInt(sc.nextLine());
				if(bdao.removeBoard(num)) {
					System.out.println("공지글 삭제 완료!");
				}else {
					System.out.println("삭제 실패...");
				}
				break;
			case 5: // 돌아가기
				run = false;
				break;
			}// end of switch_detailMenu
		}
	}


	// 일반회원의 내 점수 관리 메소드
	public static void scoreManageMenu() throws ParseException {
		boolean run = true;
		while(run) {
			System.out.println("--------------------------내점수 관리 메뉴--------------------------");
			System.out.println("(1)볼링점수 등록 (2)볼링점수 확인(월별) (3)점수 수정 (4)점수 삭제 (5)돌아가기");
			int detailMenu = Integer.parseInt(sc.nextLine());
			switch(detailMenu) {
			case 1:
				System.out.println("볼링점수 등록");
				System.out.println("경기번호 입력 >>");
				String gameNo = sc.nextLine();
				// 내점수만 입력하기 때문에 회원번호는 따로 입력받지 않아도 괜찮을듯..?
				/* System.out.println("회원번호 입력 >>");
				String memNo = sc.nextLine(); */
				System.out.println("1번째 게임 볼링점수 입력 >>");
				int bowling1G = Integer.parseInt(sc.nextLine());
				System.out.println("2번째 게임 볼링점수 입력 >>");
				int bowling2G = Integer.parseInt(sc.nextLine());
				System.out.println("3번째 게임 볼링점수 입력 >>");
				int bowling3G = Integer.parseInt(sc.nextLine());
				System.out.println("볼링친 날짜 입력 >>");
				String bowlingDate = sc.nextLine();
						
				SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
				
				Score sco = new Score(gameNo, bowling1G, bowling2G, bowling3G, sdf.parse(bowlingDate));
				
				if(sdao.addScore(sco)) {
					System.out.println("점수 등록완료!");
				}else {
					System.out.println("점수 등록실패...");
				}
				
				break;
			case 2:
				System.out.println("조회할 달(월)을 입력 >>");
				String month = sc.nextLine();
				ArrayList<Score> scoreAry = sdao.getScoreList(month);
				for(Score score : scoreAry) {
					score.showScoreInfo();
				}
				System.out.println("");
				break;
			case 3:
				System.out.println("수정할 경기번호 입력 >>");
				gameNo = sc.nextLine();
				System.out.println("1번째 게임 볼링점수 입력 >>");
				bowling1G = Integer.parseInt(sc.nextLine());
				System.out.println("2번째 게임 볼링점수 입력 >>");
				bowling2G = Integer.parseInt(sc.nextLine());
				System.out.println("3번째 게임 볼링점수 입력 >>");
				bowling3G = Integer.parseInt(sc.nextLine());
				
				if(sdao.modifyScore(gameNo, bowling1G, bowling2G, bowling3G)) {
					System.out.println("점수 수정완료!");
				}else {
					System.out.println("점수 수정 실패...");
				}
				
				break;
			case 4:
				System.out.println("삭제할 경기번호 입력 >>");
				gameNo = sc.nextLine();
				if(sdao.removeScore(gameNo)) {
					System.out.println("삭제 완료!");
				}else {
					System.out.println("삭제실패...");
				}
				break;
			case 5:
				// 돌아가기
				System.out.println("메인메뉴 돌아갑니다");
				run = false;
				
			}
		}
	}



}// end of class
