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
	static CommentDAO cdao = new CommentDAO();
	static UserDAO udao = new UserDAO();

	public static void main(String[] args) throws Exception {
		boolean run = true;

		System.out.println("'제로'볼링클럽 관리프로그램을 실행합니다.");
		while (run) {
			System.out.println("--------------------------------");
			int menu = login(); // 로그인 메소드
			

			switch (menu) {
			case 1: // 1.관리자
				boolean subRun = true;
				while (subRun) {
					System.out.println("1.회원관리 2.공지글 관리 3.로그인으로 돌아가기");
					int subMenu = Integer.parseInt(sc.nextLine());
					switch (subMenu) {
					case 1: // 회원관리
						memManageMenu(); // 회원관리메뉴 메소드
						break;
					case 2: // 공지글 관리
						boradManageMenu(); // 공지글 관리 메소드
						break;
					case 3: // 로그인으로 돌아가기
						subRun = false;
					} // end of switch_subMenu
				} // end of while_subRun
				break;

			case 2: // 2.일반회원
				subRun = true;
				while (subRun) {
					System.out.println("1.내 점수관리 2.공지글확인 및 댓글관리 3.내 댓글전체목록 4.로그인으로 돌아가기");
					int subMenu = Integer.parseInt(sc.nextLine());
					switch (subMenu) {
					case 1: // 내 점수관리
						scoreManageMenu(); // 내 점수관리 메소드
						break;
					case 2: // 공지글확인 및 댓글관리
						showBoardCommentList(); //공지글확인 및 댓글관리 메소드
						break;
					case 3: // 내 댓글 전체 목록
						// 내댓글 전체 목록 메소드
						showMyComment();
						break;
					case 4: // 로그인으로 돌아가기
						subRun = false;
					} // end of switch_subMenu
				} // end of while_subRun
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}

		}
		System.out.println("SEE YOU AGAIN~💨💨");

	} // end of main()

	// 로그인 메소드
	public static Integer login() {
		while (true) {
			System.out.println("로그인하려면 '엔터키'를 누르세요");
			System.out.println("(종료 시 '7' 입력)");
			
			if(sc.nextLine().equals("7")) {
				return 7;
			}
			System.out.println("id를 입력해주세요>>> ");
			String id = sc.nextLine();

			System.out.println("pw를 입력해주세요>>> ");
			int pw = Integer.parseInt(sc.nextLine());

			if(udao.logIn(id, pw) != null) {
				if(udao.logIn(id, pw).getRights().equals("president")) {
					System.out.println(udao.logIn(id, pw).getUserName() + "님, 제로클럽 [관리자] 페이지에 오신 것을 환영합니다 :)");
					return 1;
				}else if(udao.logIn(id, pw).getRights().equals("member")) {
					if(udao.logIn(id, pw).getApproval().equals("승인")) {
						System.out.println(udao.logIn(id, pw).getUserName() + "님, 제로클럽 [일반회원] 페이지에 오신 것을 환영합니다 :)");
						return 2;						
					}else {
						System.out.println("관리자(회장) 승인이 필요합니다!🚨");
					}
				}
			}
			else {
				System.out.println("id 및 pw 확인해주세요");
				
			}
		}
	} // end of login()
	

	// 관리자의 회원관리 메소드
	public static void memManageMenu() throws ParseException {
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

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Member mem = new Member(no, name, phone, sdf.parse(join), grade, approval);

				if (mdao.addMember(mem)) {
					System.out.println("저장되었습니다 :)");
				} else {
					System.out.println("저장 중 오류 :(");
				}
				break;
			case 2: // 회원전체목록
				ArrayList<Member> memAry = mdao.getMemberList();
				for (Member memb : memAry) {
					memb.showInfo();
				}
				System.out.println("");
				break;
			case 3: // 등급변경
				System.out.println("가입기간 2개월이 지난 회원을 '정회원'으로 일괄 변경하시겠습니까?");
				System.out.println("y(네) / n(아니요)");
				String yesNo = sc.nextLine();

				if (yesNo.equals("y")) {
					if (mdao.modifyAllGrade()) {
						System.out.println("등급변경 성공!");
					} else {
						System.out.println("등급변경할 회원이 없습니다");
					}
				}

				break;
			case 4: // 회원정보수정
				System.out.println("a.전화번호 수정  |  b.가입승인여부 수정");
				String modify = sc.nextLine();
				if (modify.equals("a")) {
					System.out.println("회원번호 입력 >>");
					String num = sc.nextLine();
					System.out.println("수정할 전화번호 입력 >>");
					String phonenum = sc.nextLine();
					if (mdao.modifyPhone(num, phonenum)) {
						System.out.println("전화번호 수정완료!");
					} else {
						System.out.println("전화번호 수정실패...");
					}
				} else if (modify.equals("b")) {
					System.out.println("회원번호 입력 >>");
					String num = sc.nextLine();
					System.out.println("가입승인여부 입력 >>");
					String approve = sc.nextLine();
					if (mdao.modifyApprove(num, approve)) {
						System.out.println("가입승인수정 완료!");
					} else {
						System.out.println("가입승인수정 실패...");
					}
				}
				break;
			case 5: // 회원삭제
				System.out.println("삭제할 회원번호를 입력 >>");
				String num = sc.nextLine();
				if (mdao.removeMember(num)) {
					System.out.println("삭제 완료!");
				} else {
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
		while (run) {
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
				if (bdao.addBoard(bob)) {
					System.out.println("등록 완료!");
				} else {
					System.err.println("등록 실패...");
				}

				break;
			case 2: // 목록
				ArrayList<Board> bodAry = bdao.getBoardList();
				for (Board bord : bodAry) {
					bord.showBoardInfo();
				}
				break;
			case 3: // 수정
				System.out.println("글번호 입력 >>");
				int num = Integer.parseInt(sc.nextLine());
				System.out.println("수정할 공지글 내용 >>");
				String contnet = sc.nextLine();

				if (bdao.modifyBoard(num, contnet)) {
					System.out.println("수정 성공!");
				} else {
					System.out.println("수정 실패...");
				}
				break;
			case 4: // 삭제
				System.out.println("글번호 입력 >>");
				num = Integer.parseInt(sc.nextLine());
				if (bdao.removeBoard(num)) {
					System.out.println("공지글 삭제 완료!");
				} else {
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
		while (run) {
			System.out.println("--------------------------내점수 관리 메뉴--------------------------");
			System.out.println("(1)볼링점수 등록 (2)볼링점수 확인(월별) (3)점수 수정 (4)점수 삭제 (5)돌아가기");
			int detailMenu = Integer.parseInt(sc.nextLine());
			switch (detailMenu) {
			case 1:
				System.out.println("볼링점수 등록");
				System.out.println("경기번호 입력 >>");
				String gameNo = sc.nextLine();
				System.out.println("회원번호 입력 >>"); 
				String memNo = sc.nextLine();
				System.out.println("1번째 게임 볼링점수 입력 >>");
				int bowling1G = Integer.parseInt(sc.nextLine());
				System.out.println("2번째 게임 볼링점수 입력 >>");
				int bowling2G = Integer.parseInt(sc.nextLine());
				System.out.println("3번째 게임 볼링점수 입력 >>");
				int bowling3G = Integer.parseInt(sc.nextLine());
				System.out.println("볼링친 날짜 입력 >>");
				String bowlingDate = sc.nextLine();

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				Score sco = new Score(gameNo, memNo, bowling1G, bowling2G, bowling3G, sdf.parse(bowlingDate));

				if (sdao.addScore(sco)) {
					System.out.println("점수 등록완료!");
				} else {
					System.out.println("점수 등록실패...");
				}

				break;
			case 2:
				System.out.println("조회할 달(월)을 입력 >>");
				String month = sc.nextLine();
				System.out.println("내 회원번호 입력 >>"); 
				memNo = sc.nextLine();
				ArrayList<Score> scoreAry = sdao.getScoreList(month, memNo);
				for (Score score : scoreAry) {
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

				if (sdao.modifyScore(gameNo, bowling1G, bowling2G, bowling3G)) {
					System.out.println("점수 수정완료!");
				} else {
					System.out.println("점수 수정 실패...");
				}

				break;
			case 4:
				System.out.println("삭제할 경기번호 입력 >>");
				gameNo = sc.nextLine();
				if (sdao.removeScore(gameNo)) {
					System.out.println("삭제 완료!");
				} else {
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

	// 일반회원의 공지글 + 댓글 관리 메소드
	public static void showBoardCommentList() throws ParseException {
		boolean run = true;
		while (run) {
			System.out.println("공지글 번호 입력 >>");
			int boardNum = Integer.parseInt(sc.nextLine());
			System.out.println("[-----공지 " + boardNum + "번 글-----]");
			ArrayList<Board> bodAry = cdao.getBoardList(boardNum);
			for (Board bord : bodAry) {
				bord.showBoardInfo();

			}
			System.out.println("");
			System.out.println("[++++++++++댓글++++++++++]");
			ArrayList<Comment> comAry = cdao.getCommentList(boardNum);
			for (Comment comm : comAry) {
				comm.showComentInfo();
			}
			System.out.println("");
			boolean subrun = true;
			while (subrun) {
				System.out.println("");
				System.out.println("↓↓↓ 댓글 관리 기능을 선택해주세요 ↓↓↓");
				System.out.println("(1)내 댓글 등록  (2)내 댓글 수정 (3)내 댓글 삭제 (4)돌아가기");
				int detailmenu = Integer.parseInt(sc.nextLine());
				switch (detailmenu) {
				case 1: // 댓글등록
					System.out.println("댓글번호 입력 >>");
					int commentNum = Integer.parseInt(sc.nextLine());
					System.out.println("댓글내용 입력 >>");
					String con = sc.nextLine();
					System.out.println("작성자 입력 >>");
					String writer = sc.nextLine();
					System.out.println("작성일자 입력 >>");
					String writeDate = sc.nextLine();
										
					Comment com = new Comment(commentNum, con, writer, writeDate);
					
					if(cdao.addComment(com, boardNum)) {
						System.out.println("댓글 등록완료!");
					}else {
						System.out.println("댓글 등록실패...");
					}
					break;
				case 2: // 댓글수정
					System.out.println("수정할 댓글번호 입력 >>");
					commentNum = Integer.parseInt(sc.nextLine());
					System.out.println("댓글 내용 입력 >>");
					con = sc.nextLine();
					
					if(cdao.modifyComment(commentNum, con)) {
						System.out.println("댓글 수정완료!");
					}else {
						System.out.println("댓글 수정실패...");
					}
					break;
				case 3: // 댓글삭제
					System.out.println("삭제할 댓글번호 입력 >>");
					commentNum = Integer.parseInt(sc.nextLine());
					if(cdao.removeComment(commentNum)) {
						System.out.println("댓글 삭제성공!");
					}else {
						System.out.println("댓글 삭제실패...");
					}
					break;
				case 4:
					System.out.println("상위 메뉴로 돌아갑니다");
					subrun = false;
				}
			} // end of while_subrun

			run = false;// while문 탈출
		} // end of while
	}


	// 내 댓글 전체보기
	public static void showMyComment() {
		System.out.println("내 이름을 입력 >>");
		String myName = sc.nextLine();
		ArrayList<Comment> commAry = cdao.getMyComment(myName);
		for(Comment coent : commAry) {
			coent.showComentInfo();
		}
	}
	
}// end of class
