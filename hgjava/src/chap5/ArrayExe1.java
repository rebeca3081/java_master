package chap5;

public class ArrayExe1 {
	public static void main(String[] args) {
		int a = 10;
		int[] ary = { 10, 20, 33, 25, 34 }; // 선언과 동시에 값 넣기
		int sum = 0;
		// sum = ary[0] + ary[1] + ary[2];
		for(int i = 0; i < ary.length; i++) { // ArrayIndexOutOfBoundsException
			sum = sum + ary[i];
		}
		System.out.println("합계는 " + sum + "입니다.");
		
		int[] intAry = new int[5];
		System.out.println(intAry[0]); // 0으로 초기화 되어있음
		
		double[] heights = new double[3];
		System.out.println(heights[0]); // 0.0으로 초기화 되어있음
		
		String[] names = new String[10]; // 10개의 공간 배열을 생성
		names[0] = "홍길동"; //변수이름[인덱스번호] = 값;
		names[1] = "김길동";
		System.out.println(names[0]);
		System.out.println(names[2]); // 빈공간만 있으면 null로 채워짐
	}
}
