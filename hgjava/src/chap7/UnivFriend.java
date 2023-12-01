package chap7;

// 자식: UnivFriend -> 부모: Friend

public class UnivFriend extends Friend {
	// 필드
	private String univ; // 학과
	private String major; // 전공

	// 기본 생성자
	public UnivFriend() {
	}

	// 생성자
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone); //부모클래스에 있는 필드를 쓰겠습니다~
		this.univ = univ;
		this.major = major;
	}

	// 메소드
	@Override // 오버라이드: 부모가 가지고있는 메소드를 자식이 재정의
	public String showInfo() {
		return "이름은 " + getName() + " 연락처는 " + getPhone() + " 학교는 " + univ + " 전공은 " + major;
	}

	// getter, setter
	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
}
