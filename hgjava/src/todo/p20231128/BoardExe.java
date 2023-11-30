package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

// 저장소: boards
public class BoardExe {
	// 배열필드
	static Board[] boards;
	
	BoardExe(){
		// boards = new Board[100];		
	}
	//정적 실행블록
	static {
		boards = new Board[100];
	}
	
	// 초기값 생성
	public static void initData() {
		boards[0] = new Board(1, "첫번째 글", "user01", "오늘은 숙제로 자바게시판을 만들어봅시다.", "2023-11-26");
		boards[1] = new Board(2, "두번째 글", "user02", "열심히 하면 언젠간 잘하게 될거양!", "2023-11-27");
		boards[2] = new Board(3, "세번째 글", "user03", "test", "2023-11-28"); // boards[2] <-- 5번 글 등록 
		boards[3] = new Board(4, "네번째 글", "user03", "SQL도 화이팅!!");
		
		boards[4] = new Board(5, "다섯번째 글", "user01", "다섯번째 글 내용용");
		boards[5] = new Board(6, "여섯번째 글", "user02", "여섯번째 글 내용용");
		boards[6] = new Board(7, "일곱번째 글", "user03", "일곱번째 글 내용용");
		boards[7] = new Board(8, "여덟번째 글", "user03", "여덟번째 글 내용용");
	}
	
	// 등록기능. (글번호 / 제목 / 작성자 / 내용 /작성일자) => 반환값 boolean.
	public static boolean addBoard(Board board) { // Board 클래스 타입으로 하나의 변수에 담아서 받기~
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] == null) {
				boards[i] = board;
				return true;
			}
		}
		return false;
	}
	
	// 목록. 반환값: 배열/ 매개값은 없음 전체배열을 들고옴
	public static Board[] boardList() {
		// boards => 새로운 배열에 정렬된 값으로 반환.
		Board temp = null;
		//정렬반복
		for(int k = 0; k < boards.length - 1; k++) {
			for(int j = 0; j < boards.length - 1; j++) {
				if(boards[j] != null && boards[j + 1] != null) {
					if(boards[j].getBoardNo() > boards[j + 1].getBoardNo()) {
						temp = boards[j];
						boards[j] = boards[j + 1];
						boards[j + 1] = temp;
					}
				}
			}
		}
		return boards;
	} // end of boardList()
	
	// ★ 배열, 페이지 => 페이지의 5건을 반환
	public static Board[] pageList(Board[] ary, int page) {
		Board[] resultAry = new Board[5];
		
		int start = (page - 1) * 5;
		int end = page * 5;
		int j = 0; // resultAry배열에 인덱스로 사용하기 위함
		
		for(int i = 0; i < ary.length; i++) {
			if(i >= start && i < end) { //0~5
				resultAry[j++] = ary[i];
			}
		}
		return resultAry;
	}
	
	// 단건조회. 매개변수: 글번호, 반환값: Board
	public static Board getBoard(int boardNum) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNo() == boardNum) {
				return boards[i];
			}
		}
		return null;
	}
	
	// 신규번호 : 현재글 번호 + 1
	public static int getSequence() {
		int seqNo = 1;
		// 배열에서 글번호의 max값 가져오기
		int max = 0;
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNo() > max) {
				max = boards[i].getBoardNo();
			}
		}
		seqNo = max + 1;
		return seqNo;
	}
	
	// 수정기능. 매개값(글번호, 내용) => boolean
	public static boolean modBoard(int no, String content) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNo() == no) {
				boards[i].setContent(content);
				boards[i].setDate(sdf.format(today));
				return true;
			}
		}
		return false;
	}
	
	// 삭제기능. 매개값(글번호) => boolean
	public static boolean remBoard(int no) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNo() == no) {
				boards[i] = null;
				return true;
			}
		}
		return false;
	}
	
	// 사용자가 해당 글 번호의 수정, 삭제 권한 체크 => boolean
	public static boolean checkResposibility(String id, int no) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null 
					&& boards[i].getBoardNo() == no 
					&& boards[i].getWriter().equals(id) ) {
				return true;
			}
		}
		return false;
	}
	
	// 게시글을 담고 있는 배열에서 값이 있는 건수를 반환
	public static int getBoardCount() {
		int realCnt = 0;
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null) {
				realCnt++;				
			}
		}
		return realCnt;
	}
	
	
} // end of class
