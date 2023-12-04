package chap11.object;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {
		// 날짜 : Date / Calendar
		// 1:YEAR, 2: MONTH, DAY_OF_WEEK: 일(1) 월(2)... 토(7)
		Calendar cal = Calendar.getInstance(); // 정적메소드 호출
		cal.set(1, 2022); // 년도변경
		cal.set(Calendar.MONTH, 4);
		cal.set(Calendar.DATE, 1);
		cal.set(2023, 2, 1);
		System.out.println(Calendar.MONTH); // 2 : 달 지정
		System.out.println("요일: " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("막날: " + cal.getActualMaximum(Calendar.DATE)); // 마지막 날짜 반환
	}

}
