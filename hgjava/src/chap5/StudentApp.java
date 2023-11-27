package chap5;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int studentNum = 0;
		int[] scores = null;
		String[] names = null;
		
		//1.학생수 2.점수입력 3.목록출력 4. 분석(최고점수, 평균) 5.종료
		boolean run = true;
		while(run) {
			System.out.println("1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.종료");
			int menu = sc.nextInt(); // 3 (Enter)<- 처리가 안됌
			sc.nextLine(); //enter 처리하도록해줌
			
			switch(menu) {
			case 1 :
				System.out.print("학생수 입력>> ");
				studentNum = sc.nextInt();
				scores = new int[studentNum]; // 입력받은 값을 scores 배열에 저장함
				names = new String[studentNum]; // 배열의 크기를 똑같이
				break;
			case 2 :
				System.out.println("점수 입력>> ");
				// for 반복
				for(int i = 0; i < scores.length; i++) {
					System.out.print("names[" + i + "]>> ");
					names[i] = sc.nextLine();
					System.out.print("socores[" + i + "]>> ");
					scores[i] = sc.nextInt();
					sc.nextLine();
				}
				break;
			case 3 :
				System.out.println("목록출력>> ");
				for(int i = 0; i < scores.length; i++) {
					System.out.print("이름은 " + names[i] + ", 점수는 " + scores[i] + "\n");
				}
				break;
			case 4 :
				System.out.println("분석>> ");
				// 최고 점수 출력
				int maxScore = 0;
				int sum = 0;
				double avg = 0;
				String maxName = "";
				
				// for(int num : scores) {
				for(int i = 0; i < scores.length; i++) {
					// 합계 계산
					sum += scores[i];
					if(maxScore < scores[i]) {
						maxScore = scores[i];
						// 최고 점수 이름 가져오기
						maxName = names[i];
					}
					// 평균 출력
					avg = sum * 1.0 / scores.length; // 정수 + 정수 -> 실수의 결과로 만들어 주기 위해서 1.0곱함
				}
				System.out.println(maxName + "의" + ", 점수 " + maxScore + ", 평균: " + avg);
				break;
			case 5 :
				System.out.println("종료>> ");
				run = false;
				break;
			} // end of switch
		} // end of while
		System.out.println("end of prog.");

	}

}
