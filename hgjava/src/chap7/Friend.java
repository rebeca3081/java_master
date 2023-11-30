package chap7;

// 부모: 이름, 연락처, showInfo()

public class Friend{
	// 필드
	private String name;
	private String phone;

	// 기본생성자
	public Friend() {
		super(); //Object 클래스를 기본족으로 상속 받고 있음
	}
	// 생성자
	public Friend(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	// 메소드
	@Override // toString(): 문자열 나열 제공기능
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + "]";
	}
	
	public String showInfo() {
		return "이름은 " + name + " 연락처는 " + phone;
	}

	// getter, setter
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
