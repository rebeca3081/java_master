package chap5;

public class ArrayExe2 {

	public static void main(String[] args) {
		// ������ ���� �� �ִ� �迭�� ����(ũ��� 10���� ������ ����)
		// intAry -> 10 ~ 100 ����
		int[] intAry = new int[10];
		for(int i = 0; i < intAry.length; i++) {
			intAry[i] = (i + 1) * 10;
		}
		// ���. Ȯ��for���� => ������ : �迭������ ���� (�迭�� �÷��ǿ����� ����)
		int sum = 0; // 50���� ū ���� ����
		double avg = 0;
		int count = 0;
		for(int num : intAry) { // p.197 �迭�� ó������ �������� �ҷ��ͼ� num������ ������
			if(num > 50) {
				sum += num;
				count++;
			}
			System.out.println(num);
		}
		avg = sum / count;
		System.out.println("50���� ū ���� �հ�: " + sum);
		System.out.println("50���� ū ���� ���: " + avg);
	}

}
