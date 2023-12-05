package chap13;

import lombok.Data;

@Data // getter setter
public class Member {

	// 필드
	private String memberNo;
	private String memberName;
	private int point;

	// 생성자
	Member(String memberNo, String memberName, int point) {
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.point = point;
	}

	// 메소드
	// 원래 hashCode, equals 정의하는 지에 따라서 동일객체
	/* @Override // 논리적으로 다른 객체라고 재정의함
	public int hashCode() {
		return super.hashCode(); // Object객체 : 다른객체라고 함
	} */

} // end of class
