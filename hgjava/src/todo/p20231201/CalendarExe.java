package todo.p20231201;

public class CalendarExe {

	public static void main(String[] args) {
		// 숙제: 12월 달력 작성
		String[] days = {"Sun","Mon","Tue","Wed", "Thr", "Fri", "Sat"};
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		// 빈공백 생성
		for(int j = 0; j < 5; j++) {
			//j를 공백으로 만들장 int -> String으로
			
			System.out.printf("%4d", j);
		}
		// 날짜 생성
		for(int i = 1; i <= 31; i++) {
			System.out.printf("%4d", i);
			if(i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n====== the end =======");
		
		// 1이 금요일 위치에 올 수 있을지 -> 5개 밀면됨

	}

}
