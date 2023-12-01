package chap11.object;

public class SystemExe {
	public static void main(String[] args) {
		// System 클래스 : 1970년 1월 1일 0시
		// 1000(밀리초) * 60(분) * 60(시) * 24(일)
		long dayCun = 1000 * 60 * 60 * 24 * 365;
		long cur = System.currentTimeMillis(); //현재시점의 Date
		System.out.println(cur / dayCun);
		
		long start = System.currentTimeMillis();
		long sum = 0;
		for(int i = 1; i <= 1000000; i++) {
			sum += i;
		}
		System.out.println("누적합: " + sum);
		long end = System.currentTimeMillis();
		System.out.println("걸린시간: " + (end - start));
	}

}
