package todo.p20231205;

import java.util.ArrayList;
import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		//컬렉션 배열
		BookExe exe = new BookExe();
		//JDBC 연동된 기능들
		BookDAO dao = new BookDAO();
		
		// 1.등록 2.목록 3.수정 4.삭제 5.종료
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.종료");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				System.out.println("1) 도서코드 입력>> ");
				String code = sc.nextLine();
				System.out.println("2) 도서명 입력>> ");
				String name = sc.nextLine();
				System.out.println("3) 저자 입력>> ");
				String author = sc.nextLine();
				System.out.println("4) 출판사 입력>> ");
				String publisher = sc.nextLine();
				System.out.println("5) 가격 입력>> ");
				int price = Integer.parseInt(sc.nextLine());
				
				Book bok = new Book(code, name, author, publisher, price);
				
				if(dao.addBook(bok)) {
					System.out.println("저장되었습니다");	
				}else {
					System.out.println("저장실패...");
				}
				
				break;
			case 2: // 전체목록
				// System.out.println("도서코드  도서명  저자  가격");
				ArrayList<Book> bookAry = dao.getBookList();
				for(Book book : bookAry) {
					if(book != null) {
						book.showInfo();
					}
				}
				/* for(Book book : exe.getBookList()) {
					book.showInfo();
				}*/
				break;
			case 3: // 수정
				System.out.println("1) 도서코드 입력>> ");
				code = sc.nextLine();
				System.out.println("2) 가격 입력>> ");
				price = Integer.parseInt(sc.nextLine());
				if(dao.modifyBook(code, price)) {
					System.out.println("수정되었습니다");
				}else {
					System.out.println("수정실패...");
				}
				break;
			case 4: // 삭제
				System.out.println("1) 도서코드 입력>> ");
				code = sc.nextLine();
				if(dao.removeBook(code)) {
					System.out.println("삭제되었습니다");					
				}else {
					System.out.println("삭제실패...");
				}
				break;
			case 5: 
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}

		} // end of while
		System.out.println("end of prog");

	}// end of main

}// end of class
