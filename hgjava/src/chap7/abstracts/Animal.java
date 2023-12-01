package chap7.abstracts;

// 추상클래스(설계규격) : 부모 클래스로써 구현한 필요가 있는 기능(메소드)을 미리 알려주는 규칙제시가 목적
public abstract class Animal {
	// 필드
	private String name;

	// 생성자 : 자식클래스를 위한 것
	public Animal() {

	}

	// 메소드
	public void setName(String name) {
		this.name = name;
	}

	public String getaName() {
		return name;
	}

	// 추상메소드: {}실행블록이 없음
	public abstract void sound();
}
