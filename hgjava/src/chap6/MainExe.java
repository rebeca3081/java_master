package chap6;

public class MainExe {

	public static void main(String[] args) {
		String[] strs = {"1.fdf", "2.poi", "3.okdvv", "4.ffgeoe", "5.love", "6.hope", "7.fonw", "8.fins"};
		int page = 1;
		int start = (page - 1) * 5;
		int end = page * 5;
		for(int i = 0; i < strs.length; i++) {
			if(i >= start && i < end) {
				System.out.println(strs[i]);
			}
		}
		
		// 페이지번호 달기: 전체 건수를 5개로 나눌때 몇 페이지 까지 나올지
		int cnt = 36;
		int totalPage = (int)Math.ceil(cnt / 5.0);
		System.out.println(totalPage);
		
		for(int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}

	}

}
