package chap8;

// 상속 : 클래스 extends 부모클래스
// 구현 : 클래스 implements 인터페이스
public class MySQLService implements DatabaseService {

	// 인터페이스에 선언되었던 추상메소드들을 반드시 구현해줘야함
	@Override
	public void add() {
		System.out.println("MySQL 입력처리");
		
	}

	@Override
	public void modify() {
		System.out.println("MySQL 수정처리");
		
	}

	@Override
	public void remove() {
		System.out.println("MySQL 삭제처리");
		
	}
	
}
