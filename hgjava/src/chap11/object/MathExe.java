package chap11.object;

public class MathExe {

	public static void main(String[] args) {
		long result = Math.round(-1.6);
		System.out.println("round: " + result);

		// 61 ~ 100 점
		for (int i = 0; i <= 10; i++) {
			int random = 61 + (int)(Math.random() * 40); // 0 <= x < 1
//			System.out.println(random);
		}

		//1 ~ 6까지의 수
		int[] numbers = new int[5];
		//중복되지 않는 값을 배열에 저장
		int dice = 1 + (int)(Math.random() * 6);
		boolean exists = false; //사용해서 해보기
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 0 && numbers[i] != dice) { // numbers에 dice값이 없다면 배열에 저장
				numbers[i] = dice;
				dice = 1 + (int)(Math.random() * 6); // 새로운 수 생성			
			}else if(numbers[i] == dice) {
				continue;
			}
		}
			//배열의 값이 다 저장이 되면 종료
		for(int num : numbers) {
			System.out.println(num);
		}
		
	}

}
