package todo.p20231205emp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {
		// 1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료
		boolean run = true;
		Scanner sc = new Scanner(System.in);

		// EmpExe 인스턴스생성
		EmpExe exe = new EmpExe();
		
		// 컬렉션 임시 배열생성 -> exe로 옮기기
		// key는 사번, value는 나머지
		Map<String, Emp> empList = new HashMap<>();
		
		int menu = Integer.parseInt(sc.nextLine());
		while (run) {
			System.out.println("1.등록 2.목록 3.급여수정 4.삭제 5.조회 6.종료");
			switch (menu) {
			case 1: // 등록
				while(true) {
					System.out.println("사번  이름  전화번호  급여  입사일자");
					String input =  sc.nextLine();
					String[] inpAry = input.split(" ");
					
					if(inpAry.length != )
					
				}
				
				break;
			case 2: // 목록
				break;
			case 3: // 급여수정
				break;
			case 4: // 삭제
				break;
			case 5: // 조회
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}// end of switch

		} // end of while

	}// end of main

}// end of class
