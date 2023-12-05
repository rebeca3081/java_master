package chap13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TypingSpeedGame {
	public static void main(String[] args) {
		
		String word = "Artist of the Year was one of the four top awards presented this year";
		String[] words = word.split(" ");
		List<String> list = new ArrayList<>();
		for(String str : words) {
			list.add(str);
		}
		boolean run = true;
		
		long start = System.currentTimeMillis(); // 시작시점의 시간
		while(run) {
			// 목록출력
			System.out.println("===단어목록===");
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			System.out.println("남은 단어의 수 : " + list.size() + "개");
			
			Scanner sc = new Scanner(System.in); // 스캐너
			System.out.print(">>>>>>>삭제할 단어 입력>>>>  ");
			String input = sc.nextLine();
			
			for(int i = 0; i < list.size(); i++) { // 사용자 입력값과 컬렉션의 값과 비교해서 같은 단어 있으면 삭제.
				if(list.get(i).equals(input)) {
					list.remove(i);
				}
			}
			if(list.size() == 0) { // 컬렉션의 사이즈가 0이 되면 while문 탈출
				run = false;
			}
		
		}//end of while
		System.out.println("end of game");
		long end = System.currentTimeMillis(); // 종료시점의 시간

		// 시작시점 ~ 종료시점 걸린시간을 초단위로 계산.
		// 완료하는데 35초가 걸림.
		System.out.println("게임종료까지 걸린시간 : " + (end - start)/1000 + "초");
		
	}//end of main
}//end of class
