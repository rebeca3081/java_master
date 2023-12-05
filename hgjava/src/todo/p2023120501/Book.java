package todo.p2023120501;

public class Book {
	// 필드
	private String bookCode;
	private String bookTitle;
	private String author;
	private String publisher;
	private int price;

	// 생성자
	Book(String bookCode, String bookTitle, String author, String publisher, int price) {
		this.bookCode = bookCode;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	// 메소드
	public void showInfo() {
		System.out.println(bookCode + " " + bookTitle + " " + author + " " + price);
	}

	// getter, setter
	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
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

}
