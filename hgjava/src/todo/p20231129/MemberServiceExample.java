package todo.p20231129;

public class MemberServiceExample {
	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		boolean result = memberService.logIn("hong", "12345");
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logOut("hong");
		}else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}
}
