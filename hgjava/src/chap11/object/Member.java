package chap11.object;

public class Member {
	// 필드
	private String name;
	private int age;

	// 생성자
	Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// equals() 재정의
	@Override
	public boolean equals(Object obj) {
		// 논리적을 동등한 객체(이름, 나이)
		if (obj instanceof Member) { // 매개변수 obj가 Member클래스의 인스턴스인지 확인
			Member target = (Member) obj;
			if ( this.name.equals(target.name) && this.age == target.age) {
				return true;
			}
		}
		return false;
	}

	// hashCode() 재정의
	@Override
	public int hashCode() { // 문자열이 가지고있는 해시코드를 반환
		return this.name.hashCode();
	}

	// toString() : 기본적으로 객체의 문자정보를 리턴, 재정의
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}

}
