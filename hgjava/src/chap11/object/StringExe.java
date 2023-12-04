package chap11.object;

public class StringExe {

	public static void main(String[] args) {
		String[] fileNames = { "c:/images/prod/sample.jpg", "d:/test/sample/americano.png", "d:/goods/test/2023/moka.jpg" };
		for(String file : fileNames) {
			System.out.println(findFilrName(file));
		}

		//
		String[] numbers = { "980304-1234567", "980304-2234567", "020101-3456789", "020104-4456789", "0301054567887",
				"9506015754601" };
		for (String no : numbers) {
			System.out.println(findGender(no));
		}

		byte[] b1 = "Hello".getBytes();
		for (byte b : b1) {
			System.out.println(b);
		}

		String name = new String(new byte[] { 65, 66, 67, 68, 69 });
		name = new String(b1);
		System.out.println(name);

		char c1 = name.charAt(0); // 특정 위치의 문자를 리턴
		System.out.println(c1);
	} // end of main()


	// 성별을 반환하는 메소드
	static String findGender(String ssn) { // "980304-1234567"
		// 생년월일 뒷자리 - 1, 2, 3, 4 (1,3은 남 2,4는 여)
		/*
		 * if(ssn.length() == 14) { char gender = ssn.charAt(7); if (gender == '1' ||
		 * gender == '3') { return "남"; } return "여"; }else { char gender =
		 * ssn.charAt(6); if (gender == '2' || gender == '4') { return "남"; } return
		 * "여"; }
		 */
		/*
		 * if(ssn.length() == 14) { char gender = ssn.charAt(7); switch(gender) { case
		 * '1': case '3': return "남"; case '2': case '4': return "여"; default : return
		 * "오류"; // default 값이 없으면 오류남 } }else { char gender = ssn.charAt(6);
		 * switch(gender) { case '1': case '3': return "남"; case '2': case '4': return
		 * "여"; default : return "오류"; } }
		 */
		// 뒤에서 일곱자리 들고오기
		int pos = ssn.length() - 7;
		switch (ssn.charAt(pos)) {
		case '1':
		case '3':
			return "남";
		case '2':
		case '4':
			return "여";
		}
		return "오류";

	}//end of findGender()
	
	// 파일명 가져오기
	static String findFilrName(String file) { //"d:/goods/test/2023/moka.jpg"
		int slash = file.lastIndexOf("/"); // 뒤에서 "/"문자열을 찾아서 인덱스 번호를 리턴 - lastIndexOf()사용?
		return file.substring(slash + 1); // 인덱스번호 가져오기: .subString() // "/"다음부터 가져오기
	} //end of findFilrName()
	

}// end of class
