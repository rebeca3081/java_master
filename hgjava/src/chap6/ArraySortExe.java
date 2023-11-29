package chap6;

public class ArraySortExe {
	public static void main(String[] args) {
		int[] numAry = {106, 6, 2, 1, 5, 4, 3};
		
		// 정렬작업
		int temp = 0;
		for(int j = 0; j < numAry.length - 1; j++) { // 비교회차 반복
			// 위치변경작업
			for(int i = 0; i < numAry.length - 1; i++) {
				if(numAry[i] > numAry[i+1]) { // 앞 > 뒤
					temp = numAry[i]; // 공간 <- 앞
					numAry[i] = numAry[i+1]; // 앞 <- 뒤
					numAry[i+1] = temp; // 뒤 <- 공간(앞)
				}
			}
		}
		for(int num : numAry) {
		System.out.println(num);
		}
	}
}
