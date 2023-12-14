package todo.p20231205;

import java.util.ArrayList;
import java.util.List;

public class BookExe {
	// 컬렉션 배열선언
	private ArrayList<Book> books; //★
	
	BookExe(){
		books = new ArrayList<Book>(); //★
		books.add(new Book("B001", "이것이 자바다", "신용권", "한빛미디어", 25000));
	}

	// 기능: 추가
	boolean addBook(Book bok) {
		return books.add(bok); //add()메소드의 리턴 타입이 boolean임
	}
	
	// 기능: 목록반환
	ArrayList<Book> getBookList() {
		return books;
	}
	
	// 기능: 단건조회
	Book getBook(String bookCode) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i) != null 
					&& books.get(i).getBookCode().equals(bookCode)) {
				return books.get(i); // 데이터 한건 반환
			}
		}
		return null;
	}

	// 기능: 수정
	boolean modifyBook(String code, int price) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getBookCode().equals(code)) {
				books.get(i).setPrice(price);
				return true;
			}
		}
		return false;
	}
	
	// 기능: 삭제
	boolean removeBook(String code) {
		for(int i = 0; i < books.size(); i++) {
			if(books.get(i).getBookCode().equals(code)) { //indexOf(code) != -1
				books.remove(i);
				return true;
			}
		}
		return false;
	}

}
