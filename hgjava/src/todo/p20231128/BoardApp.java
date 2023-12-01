package todo.p20231128;

import java.util.Scanner;

// M(model):java - V(view):html - C(control):java
public class BoardApp { // C(control)
	// static BoardExe exe = new BoardExe();
	// 인스턴스: 여러건 각각다른 데이터
	// 정적멤버 static: 데이터마다 다른 정보를 담을 필요가 없는 클래스 (BoardExe.)
	// -> static 바로 사용가능하도록 메모리에 올려짐
	private Scanner sc = new Scanner(System.in);
	private String id = null;
	// 싱글톤방식의 인스턴스를 생성 : 자기 자신을 생성
	private static BoardApp instance = new BoardApp();

	// 생성자
	private BoardApp() {
	}

	// instance 호출 메소드 , private 생성자를 못써서 정적변수로 선언
	public static BoardApp getInstance() {
		return instance;
	}

	// 등록 메소드
	private void boardAdd() {
		System.out.println("게시글 제목입력>> ");
		String tie = sc.nextLine();
		System.out.println("내용 입력>> ");
		String con = sc.nextLine();
		// System.out.println("일시 입력>> ");
		// String date = sc.nextLine();

		Board brd = new Board(BoardExe.getSequence(), tie, id, con);
		if (BoardExe.addBoard(brd)) {
			System.out.println("저장완료!");
		} else {
			System.out.println("저장실패...");
		}
	} // end of boardAdd()

	// 목록보기 메소드
	private void boardList() {
		Board[] boardAry = BoardExe.boardList(); // 전체목록
		showList(boardAry, 1); // 처음에는 1페이지 보여줌
		while (true) {
			int page = Integer.parseInt(sc.nextLine()); // 사용자 선택
			if (page == 0) {
				break;
			}
			showList(boardAry, page); // 선택한 페이지로 다시 호출
		}
	} // end of boardList()

	// 상세조회 메소드
	private void getBoard() {
		int no = 0;
		while (true) {
			System.out.println("글번호입력>> ");
			// 예외처리
			try {
				no = Integer.parseInt(sc.nextLine());
				break; // 정상적으로 입력하면 입력문을 빠져나오게해줌
			} catch (NumberFormatException ee) { //(Exception e)
				System.out.println("올바른 글 번호를 입력하세요");
			}
		}
		Board result = BoardExe.getBoard(no);
		if (result != null) {
			System.out.println("-----------------------------------");
			System.out.println(result.showDetailInfo());
			System.out.println("-----------------------------------");
		} else {
			System.out.println("조회된 내용이 없습니다.");
		}
	} // end of getBoard()

	// 수정 메소드
	private void boardEdit() {
		System.out.println("수정할 글번호>> ");
		int no = Integer.parseInt(sc.nextLine());
		if (!BoardExe.checkResposibility(id, no)) { // 권한이 없으면
			System.out.println("수정 권한 없습니다.");
			// continue; // 아래는 실행하지 않고 다시 올라감.
			return;
		}
		System.out.println("수정할 글내용>>> ");
		String con = sc.nextLine();
		if (BoardExe.modBoard(no, con)) {
			System.out.println("수정완료!");
		} else {
			System.out.println("수정실패...");
		}
	}// end of boardEdit()

	// 삭제 메소드
	private void boardDel() {
		System.out.println("삭제할 글번호>> ");
		int no = Integer.parseInt(sc.nextLine());
		// 권한체크
		if (!BoardExe.checkResposibility(id, no)) {
			System.out.println("삭제 권한이 없습니다~!");
			return;
		}
		if (BoardExe.remBoard(no)) {
			System.out.println("삭제성공!!");
		} else {
			System.out.println("삭제실패...");
		}
	} // end of boardDel()

	// 시작부분
	public void start() {
		// 1. 등록 2. 목록 3. 상세조회 4.종료
		boolean run = true;

		UserExe uexe = new UserExe();

		while (true) {
			System.out.println("id를 입력>>> ");
			id = sc.nextLine();
			System.out.println("pw를 입력>>> ");
			String pw = sc.nextLine();
			User user = uexe.logIn(id, pw);
			if (user != null) {
				System.out.println(user.getUserName() + "님 환영합니다 :)");
				break;
			} else {
				System.out.println("id, pw 확인하세요~!!");
			}
		} // 로그인 처리

		// 초기값 생성
		BoardExe.initData();

		while (run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.수정 5.삭제 6.종료");
			int menu = 0;
			// 예외처리
			try {
				menu = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("메뉴 번호를 입력하세요");
				continue; // 밑으로 내려 가지 않고 다시 while문으로 돌아감
			}

			switch (menu) {
			case 1: // 등록
				boardAdd();
				break;
			case 2: // 목록조회 -> 페이지보기
				boardList();
				break;

			case 3: // 단건 상세조회
				getBoard();
				break;

			case 4: // 글 내용수정
				boardEdit();
				break;

			case 5: // 글삭제
				boardDel();
				break;

			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}// end of switch
		} // end of while
		System.out.println("end of prog");

	}// end of main()

	private void showList(Board[] boardAry, int page) { // ★★★★★
		// 페이징처리
		Board[] pageAry = BoardExe.pageList(boardAry, page);
		System.out.println("글번호\t제목\t\t작성자\t일시");
		System.out.println("=================================================");
		for (Board bord : pageAry) {
			if (bord != null) {
				System.out.println(bord.showInfo());
			}
		}
		System.out.println("=================================================");
		// 전체페이지 계산하고 출력
		int cnt = BoardExe.getBoardCount();
		int totalPage = (int) Math.ceil(cnt / 5.0);

		for (int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n페이지를 선택하세요>> 종료: 0 입력.");
	} // end of showList()

}// end of class
