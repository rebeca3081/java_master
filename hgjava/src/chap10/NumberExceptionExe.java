package chap10;

import java.util.Scanner;

public class NumberExceptionExe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("1.추가 2.삭제 3.종료");
			int menu = 0;
			try {
				menu = Integer.parseInt(sc.nextLine()); // "1" -> 1				
			}catch(NumberFormatException e) { //NumberFormatException
				System.out.println("숫자를 입력하세요.");
				// 정상실행될 수 있도록 코드를 넣어줘야함
			}
			switch(menu) {
			case 1:
				System.out.println("추가합니다");
				break;
			case 2:
				System.out.println("삭제합니다");
				break;
			case 3:
				System.out.println("종료합니다");
				run = false;
			}
		}
		System.out.println("end of prog");

	}

}
