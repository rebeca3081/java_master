package todo.p20231205emp;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {
		// 1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료
		boolean run = true;
		Scanner sc = new Scanner(System.in);

		// EmpExe 인스턴스생성
		EmpExe exe = new EmpExe();
		
		int menu = 0;
		
		while (run) {
			System.out.println("1.등록 2.목록 3.급여수정 4.삭제 5.조회 6.종료");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1: // 등록
					System.out.println("사번  이름  전화번호  급여  입사일자");
					String input =  sc.nextLine();
					String[] inpAry = input.split(" ");
					
					Emp emplo = null;
					if(inpAry.length == 4) {
						String today = inpAry[4];
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						emplo = new Emp()
						
					}
					
					String num = inpAry[0];
					String name = inpAry[1];
					String phone = inpAry[2];
					int salary = Integer.parseInt(inpAry[3]);
					String today = inpAry[4];
					
					Emp emplo = new Emp(num, name, phone, salary);
					
					if(exe.addEmp(emplo))
					
				
				
					break;
				
			case 2: // 목록
				System.out.println("사번  이름  전화번호  급여  입사일자");
				System.out.println("====================================");
				// 출력
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
