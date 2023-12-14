package todo.p20231205;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// 등록 / 목록 / 수정 / 삭제
public class BookDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	
	// JDBC 연결기능 메소드
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공~~!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	} // end of getConn()
	
	// 목록 반환
	ArrayList<Book> getBookList() {
		getConn();
		System.out.println("도서코드\t도서명\t저자\t가격");
		/* 배열선언 : 굳이 밖에 변수 선언하고 인스턴스 생성 안해도 되고
		getBookList() 실행시에만 배열이 생성되서 보이도록 하면 목록이 한번만 딱 출력 가능! */
		ArrayList<Book> books = new ArrayList<Book>();
		String sql = "select * from book order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getString("book_code"));
				book.setBookName(rs.getString("book_name"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				/* 컬렉션은 null 값을 확인할 필요가 없어서 생성자 태워서 만들어진
				 book을 books 컬렉션 배열에 넣어주고 books를 리턴해줌! */
				books.add(book);		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
	
	// 추가.
	boolean addBook(Book bok) {
		getConn();
		String sql = "insert into book values (?, ?, ?, ?, ?)";
		
		try {
			// conn.setAutoCommti(false); // 자동커밋 실행 여부.
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bok.getBookCode());
			psmt.setString(2, bok.getBookName());
			psmt.setString(3, bok.getAuthor());
			psmt.setString(4, bok.getPublisher());
			psmt.setInt(5, bok.getPrice());
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of addBook()
	
	// 수정.
	boolean modifyBook(String code, int price) {
		getConn();
		String sql = "update  book "
					+ "set     price =?"
					+ "where   book_code =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, price);
			psmt.setString(2, code);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of modifyBook()
	
	// 삭제.
	boolean removeBook(String code) {
		getConn();
		String sql = "delete  from book "
					+ "where   book_code =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} // end of removeBook()
	

}// end of BookDAO
