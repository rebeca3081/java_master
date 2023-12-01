package chap8;

// 인터페이스 : 추상클래스처럼 추상메소드만 정의할수 있음.
// ex) Oracle : insert(), update() <- 변경할 예정 MySQL : add(), modify()
// 
public interface DatabaseService {
	public static final String NAME = ""; // 필드: 상수(대문자) 선언만 가능
	public int PHONE_NUM = 0; // static final생략가능
	
	// 입력, 수정, 삭제 추상 메소드
	public abstract void add();

	public void modify(); //abstract 생략가능

	public void remove();

}
