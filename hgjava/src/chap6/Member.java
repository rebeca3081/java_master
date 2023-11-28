package chap6;
// 회원관리 앱
// 회원번호, 회원이름, 연락처, 성별
// public <-> private
public class Member {
	// 속성(field)
	private int memberNo; // 자바에서는 두단어 이상의 조합: CamelCase
	private String memberName;
	private String phone; // 010-1234-5678
	private String gender; // Men or Women => M, W
	
	// 생성자 : 필드의 초기값을 지정하는 역할
	// 기본생성자:매개값(X) 컴파일러가 생성
	Member(){
		
	}
	// 매개값(O)
	Member(int memberNo, String memberName){
		this.memberNo = memberNo;
		this.memberName = memberName;	
	}
	
	public Member(int memberNo, String memberName, String phone, String gender) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.phone = phone;
		this.gender = gender;
	}
	// 기능(메소드) void:반환되는 값의 유형이 정해져있지 않음
	void showInfo() {
		System.out.println("이름은 " + memberName + "이고 연락처는 " + phone + "입니다.");
	}
	// 문자열 값을 반환하겠음
	String showAllInfo() {
		String result = "이름은 " + memberName + "이고 연락처는 " + phone + " 성별은 " + gender + "입니다.";
		return result;
	}
	
	//setmeberNo: meberNo의 값을 지정하는 메소드
	void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	void setGender(String gender) {
		this.gender = gender;
	}
	
	//getter : 값을 가져오기 위함
	int getMemberNo() {
		return memberNo;
	}
	String getMemberName() {
		return memberName;
	}
	String getPhone() {
		return phone;
	}
	String getGender() {
		return gender;
	}
	
	
}
