package todo.p20231128;

public class Board {
	// 필드
	private int boardNo; // 1, 2, ...
	private String title; //자바게시판입니다
	private String writer; //user01
	private String content; // 오늘은~
	private String date; //2023-11-28
	
	// 생성자
	Board(){
		
	}
	Board(int boardNo, String title, String writer, String content, String date){
		this.boardNo = boardNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.date = date;		
	}
	
	// 메소드
	// 등록기능
	void addBoard() {
		
	}
	// 목록조회기능
	void showInfo() {
		System.out.println("");
	}
	// 상세조회
	void detailInfo() {
		
	}
	
	//setter
	void setBoardNo (int boardNo) {
		this.boardNo = boardNo;
	}
	void setTitle (String title) {
		this.title = title;
	}
	void setWriter (String writer) {
		this.writer = writer;
	}
	void setContent (String content) {
		this.content = content;
	}
	void setDate (String date){
		this.date = date;
	}
	
	//getter
	int getBoardNo() {
		return boardNo;
	}
	String getTitle() {
		return title;
	}
	String getWriter() {
		return writer;
	}
	String getContent() {
		return content;
	}
	String getDate() {
		return date;
	}
	

}
