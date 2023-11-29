package todo.p20231128;

public class Board {
	// 필드
	private int boardNo; // 1, 2, ...
	private String title; //자바게시판입니다
	private String writer; //user01
	private String content; // 오늘은~
	private String date; //2023-11-28
	// 배열필드
	private Board[] boards;
	// 이 부분이 변경되었습니다~
	// 생성자
	Board(){
		boards = new Board[50];
		boards[0] = new Board(1, "자바게시판입니다", "user01", "오늘은 숙제로 자바게시판을 만들어봅시다.", "2023-11-28");
		boards[1] = new Board(2, "공부합시다", "user02", "열심히 하면 언젠간 잘하게 될거양!", "2023-11-27");
		boards[2] = new Board(3, "SQL이 기대됩니다", "user03", "SQL도 화이팅!!", "2023-11-29");
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
	boolean addBoard(Board brd) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] == null) {
				boards[i] = brd;
				return true;
			}
		}
		return false;
	}
	// 목록 반환
	Board[] getBoardList() {
		return boards;
	}
	// 목록조회기능
	void showInfo() {
		System.out.println(boardNo + "\t" + title + "\t" + writer);
	}
	// 상세조회
	void detailInfo() {
		System.out.print("번호: "+ boardNo + "\t");
		System.out.println("제목: "+ title);
		System.out.println("작성자: "+ writer);
		System.out.println("내용: "+ content);
		System.out.println("일시: "+ date);
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
