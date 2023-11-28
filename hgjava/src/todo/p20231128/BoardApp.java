package todo.p20231128;

import java.util.Scanner;

public class BoardApp {

	public static void main(String[] args) {
		// 1. 등록 2. 목록 3. 상세조회 4.종료
		Scanner sc = new Scanner(System.in);
		Board bod = new Board();
		
		boolean run = true;
		
		while(run) {
			System.out.println("1. 등록 2. 목록 3. 상세조회 4.종료");
			int menu = 0;
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: // 등록
				System.out.println("게시판 번호입력>> ");
				int no = Integer.parseInt(sc.nextLine());
				System.out.println("게시글 제목입력>> ");
				String tie = sc.nextLine();
				System.out.println("작성자 입력>> ");
				String wit = sc.nextLine();
				System.out.println("내용 입력>> ");
				String con = sc.nextLine();
				System.out.println("날짜 입력>> ");
				String date = sc.nextLine();
				
				Board brd = new Board(no, tie, wit, con, date);
				if(bod.addBoard(brd)) {
					System.out.println("저장완료!");
				}else {
					System.out.println("저장실패...");
				}
				break;
			case 2: // 목록조회
				System.out.println("번호 \t 제목 \t 작성자");
				System.out.println("-----------------------------------");
				for(Board bord : bod.getBoardList()) {
					if(bord != null) {
						bord.showInfo();
					}
				}
				System.out.println("-----------------------------------");
				
				break;
			case 3: // 상세조회
				System.out.println("-----------------------------------");
				for(Board bord : bod.getBoardList()) {
					if(bord != null) {
						bord.detailInfo();
						System.out.println("-----------------------------------");
					}
				}
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}//end of switch
			
		}// end of while
		System.out.println("end of prog");
		

	}// end of main()

}// end of class
