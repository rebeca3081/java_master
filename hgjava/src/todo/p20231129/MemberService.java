package todo.p20231129;

public class MemberService {
	String id;
	String passWord;
	
	Boolean logIn(String id, String passWord) {
		if(id.equals("hong") && passWord.equals("12345")) {
			return true;
		}else {
			return false;
		}
	}
	void logOut(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
}
