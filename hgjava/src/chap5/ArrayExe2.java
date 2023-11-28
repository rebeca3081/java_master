package chap5;

public class ArrayExe2 {

	public static void main(String[] args) {
		// 정수를 담을 수 있는 배열을 생성(크기는 10개의 정수를 저장)
		// intAry -> 10 ~ 100 저장
		int[] intAry = new int[10];
		for(int i = 0; i < intAry.length; i++) {
			intAry[i] = (i + 1) * 10;
		}
		// 출력. 확장for구문 => 변수명 : 배열명으로 선언 (배열과 컬렉션에서만 가능)
		int sum = 0; // 50보다 큰 수를 저장
		double avg = 0;
		int count = 0;
		for(int num : intAry) { // p.197 배열의 처음부터 끝값까지 불러와서 num변수에 저장함
			if(num > 50) {
				sum += num;
				count++;
			}
			System.out.println(num);
		}
		avg = sum / count;
		System.out.println("50보다 큰 수의 합계: " + sum);
		System.out.println("50보다 큰 수의 평균: " + avg);
	}

}
