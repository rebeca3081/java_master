package todo.p20231205;

public class Book {
	// 필드
	private String bookCode; // B001, C003 => key 역할
	private String bookName;
	private String author; 
	private String publisher;
	private int price; // 25000
	
	//생성자
	Book(){
		
	}
	Book(String bookCode, String bookName, String author, String publisher, int price){
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
	
	//getter,setter
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	String getBookCode() {
		return bookCode;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	String getBookName() {
		return bookName;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	String getAuthor() {
		return author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// 메소드
	public void showInfo() {
		System.out.println(bookCode + "\t" + bookName + "\t" + author + "\t" + price);
	}

}
