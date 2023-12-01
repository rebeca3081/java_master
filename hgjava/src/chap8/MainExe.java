package chap8;

import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 인터페이스타입 = 자식클래스 인스턴스 담기
		DatabaseService svc = new OracleService(); // new MySQLService();
		
		boolean run = true;
		while(run) {
			System.out.println("1.등록 2.수정 3.삭제 4.종료");
			int menu = 0;
			switch(menu) {
			case 1: //등록
				svc.add();
				break;
			case 2: //수정
				svc.modify();
				break;
			case 3: //삭제
				svc.remove();
				break;
			default:
				run = false;
			}
			
		}
		System.out.println("end of prog");

	}

}
