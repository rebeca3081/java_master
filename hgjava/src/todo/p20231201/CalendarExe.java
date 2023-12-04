package todo.p20231201;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {
		int year = 2023;
		int month = 10;
		
		Calendar today = Calendar.getInstance();
		// 날짜지정
		today.set(Calendar.YEAR, year);
		today.set(Calendar.MONTH, month);
		today.set(Calendar.DATE, 1);
		System.out.println(today.get(Calendar.DAY_OF_WEEK));
		
		// 10월 달력 작성
		System.out.println(today.get(Calendar.YEAR) + "년 " + today.get(Calendar.MONTH) + "월 달력");
		String[] days = {"Sun","Mon","Tue","Wed", "Thr", "Fri", "Sat"};
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		// 빈공백 생성
		for(int j = 0; j < today.get(Calendar.DAY_OF_WEEK) - 3; j++) {
			System.out.printf("%4s", "");
		}
		// 날짜 생성
		for(int i = 1; i <= today.getActualMaximum(Calendar.DATE); i++) { // 달의 마지막 날짜 들고오기
			System.out.printf("%4d", i);
			// 1일은 무슨요일?
			if(today.get(Calendar.DAY_OF_WEEK) == 1) {
				if(i % 7 == 0) {
					System.out.println();
				}
			}else {
				int whatWeek = today.get(Calendar.DAY_OF_WEEK) - 3;
				if(i == 2 || (i - whatWeek) % 7 == 0) {
					System.out.println();
				}				
			}
			// today.get(Calendar.DAY_OF_WEEK);
			// firstFri는 첫번째 금요일인 날
		}
		System.out.println("\n========= the end ==========");
		
		// 1이 금요일 위치에 올 수 있을지 -> 5개 밀면됨
		int whatWeek = today.get(Calendar.DAY_OF_WEEK);

	}

}
