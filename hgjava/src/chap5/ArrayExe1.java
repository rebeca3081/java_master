package chap5;

public class ArrayExe1 {
	public static void main(String[] args) {
		int a = 10;
		int[] ary = { 10, 20, 33, 25, 34 }; // ����� ���ÿ� �� �ֱ�
		int sum = 0;
		// sum = ary[0] + ary[1] + ary[2];
		for(int i = 0; i < ary.length; i++) { // ArrayIndexOutOfBoundsException
			sum = sum + ary[i];
		}
		System.out.println("�հ�� " + sum + "�Դϴ�.");
		
		int[] intAry = new int[5];
		System.out.println(intAry[0]); // 0���� �ʱ�ȭ �Ǿ�����
		
		double[] heights = new double[3];
		System.out.println(heights[0]); // 0.0���� �ʱ�ȭ �Ǿ�����
		
		String[] names = new String[10]; // 10���� ���� �迭�� ����
		names[0] = "ȫ�浿"; //�����̸�[�ε�����ȣ] = ��;
		names[1] = "��浿";
		System.out.println(names[0]);
		System.out.println(names[2]); // ������� ������ null�� ä����
	}
}
