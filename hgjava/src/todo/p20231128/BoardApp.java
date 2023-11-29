package todo.p20231128;

import java.util.Scanner;

public class BoardApp {
	static BoardExe exe = new BoardExe(); // 인스턴스

	public static void main(String[] args) {
		// 1. 등록 2. 목록 3. 상세조회 4.종료
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		String id = null;
		
		UserExe uexe = new UserExe();
		
		while(true) {
			System.out.println("id를 입력>>> ");
			id = sc.nextLine();
			System.out.println("pw를 입력>>> ");
			String pw = sc.nextLine();
			User user = uexe.logIn(id, pw);
			if(user != null) {
				System.out.println(user.getUserName() + "님 환영합니다 :)");
				break;
			}else {
				System.out.println("id, pw 확인하세요~!!");
			}
		} // 로그인 처리
		
		
		
		// 초기값 생성
		exe.initData();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.수정 5.삭제 6.종료");
			int menu = 0;
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: // 등록
				System.out.println("게시글 제목입력>> ");
				String tie = sc.nextLine();
				System.out.println("내용 입력>> ");
				String con = sc.nextLine();
				// System.out.println("일시 입력>> ");
				// String date = sc.nextLine();
				
				Board brd = new Board(exe.getSequence(), tie, id, con);
				if(exe.addBoard(brd)) {
					System.out.println("저장완료!");
				}else {
					System.out.println("저장실패...");
				}
				break;
			case 2: // 목록조회
				Board[] boardAry = exe.boardList(); // 전체목록
				showList(boardAry, 1); // 처음에는 1페이지 보여줌
				while(true) {
					int page = Integer.parseInt(sc.nextLine()); // 사용자 선택
					if(page == 0) {
						break;
					}
					showList(boardAry, page); // 선택한 페이지로 다시 호출
				}
				break;					
				
			case 3: // 상세조회
				System.out.println("글번호입력>> ");
				int no = Integer.parseInt(sc.nextLine());
				Board result = exe.getBoard(no);
				if(result != null) {
					System.out.println("-----------------------------------");
					System.out.println(result.showDetailInfo());
					System.out.println("-----------------------------------");
				}else {
					System.out.println("조회된 내용이 없습니다.");
				}
				break;
				
			case 4: // 글 내용수정
				System.out.println("수정할 글번호>> ");
				no = Integer.parseInt(sc.nextLine());
				if(!exe.checkResposibility(id, no)) { // 권한이 없으면
					System.out.println("수정 권한 없습니다.");
					continue; // 아래는 실행하지 않고 다시 올라감.
				}
				System.out.println("수정할 글내용>>> ");
				con = sc.nextLine();
				if(exe.modBoard(no, con)) {
					System.out.println("수정완료!");
				}else {
					System.out.println("수정실패...");
				}
				break;
				
			case 5: // 글삭제
				System.out.println("삭제할 글번호>> ");
				no = Integer.parseInt(sc.nextLine());
				if(!exe.checkResposibility(id, no)){
					System.out.println("삭제 권한이 없습니다~!");
					continue;
				}
				if(exe.remBoard(no)) {
					System.out.println("삭제성공!!");
				}else {
					System.out.println("삭제실패...");
				}
				break;
				
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}//end of switch
			
		}// end of while
		System.out.println("end of prog");
		

	}// end of main()
	
	public static void showList(Board[] boardAry, int page) { //★★★★★
		// 페이징처리
		Board[] pageAry = exe.pageList(boardAry, page);
		System.out.println("글번호\t제목\t\t작성자\t일시");
		System.out.println("=================================================");
		for(Board bord : pageAry) {
			if(bord != null) {
				System.out.println(bord.showInfo());					
			}
		}
		System.out.println("=================================================");
		// 전체페이지 계산하고 출력
		int cnt = exe.getBoardCount();
		int totalPage = (int)Math.ceil(cnt / 5.0);
		
		for(int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n페이지를 선택하세요>> 종료: 0 입력.");
	} //end of showList()

}// end of class
