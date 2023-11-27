package chap5;

import java.util.Scanner;

public class StudentApp2 {
	// static : class 전역에서 변수를 사용하기 위함
	static Scanner sc = new Scanner(System.in);
	static Student[] students = null; //클래스 배열 초기화
	
	public static void addStudent() {
		System.out.println("학생정보 입력>> ");
		for(int i = 0; i < students.length; i++) {
			Student student = new Student(); // Student:데이터타입, student:변수명
			// student 인스턴스의 속성 name, score, gender
			System.out.println("학생 이름 입력>> ");
			student.name = sc.nextLine();
			System.out.println("학생 점수 입력>> ");
			student.score = Integer.parseInt(sc.nextLine());
			System.out.println("남/여 입력>> ");
			student.gender = sc.nextLine();
			
			students[i] = student;
		}
	} //end of addStudent()
	
	public static void searchStudent() {
		System.out.println("조회할 이름 입력>> ");
		String name = sc.nextLine();
		boolean exists = false;
		// 학생 이름 - 점수 출력
		for(Student stdn : students) {
			if(name.equals(stdn.name)) { // 입력받은 이름이랑 배열의 이름이랑 같은 지 비교
				System.out.println("이름은 " + stdn.name + ", 점수는 " + stdn.score);						
				exists = true;
			}
		}
		// 찾는 이름의 존재여부 : exists를 확인
		if(!exists) {
			System.out.println("찾는 이름이 없습니다.");
		}		
	} //end of searchStudent()
	
	public static void analysis() {
		int sumOfMen = 0, cntOfMen = 0;
		int sumOfWomen = 0, cntOfWomen = 0;
		for(Student stn : students) {
			// 남학생 평균
			if(stn.gender.equals("남")) {
				sumOfMen += stn.score;
				cntOfMen++;
			// 여학생 평균
			}else if(stn.gender.equals("여")) {
				sumOfWomen += stn.score;
				cntOfWomen++;
			}
		}
		System.out.println("남학생의 평균: " + (sumOfMen * 1.0 / cntOfMen));
		System.out.println("여학생의 평균: " + (sumOfWomen * 1.0 / cntOfWomen));
	} //end of analysis();
	
	public static void modify() {
		// 이름 입력 -> 변경점수
		System.out.println("조회할 이름 입력>> ");
		String name = sc.nextLine();
		System.out.println("바꿀 이름 입력>> ");
		String reName = sc.nextLine();
		boolean exists = false;
		
		for(int i = 0; i < students.length; i++) {
			// 조건추가 => 변경점수 입력
			if(name.equals(students[i].name)) {
				students[i].name = reName;
				System.out.println(name + "->" + students[i].name + " 수정완료!");				
				exists = true;
			}
		}
		// 찾는 이름 없음
		if(!exists) {
			System.out.println("찾는 이름이 없습니다.");
		}
	} //end of modify()
	
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		
		while(run) {
			System.out.println("1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.수정 6.종료");
			int menu = sc.nextInt(); // 3 Enter
			sc.nextLine();
			
			switch(menu) {
			case 1:
				System.out.println("학생수 입력>> ");
				studentNum = Integer.parseInt(sc.nextLine()); // 형변환 "3" -> 3
				students = new Student[studentNum];
				break;
			case 2:
				addStudent(); // 추가 기능
				break;
			case 3:
				searchStudent(); // 조회 기능
				break;
			case 4:
				analysis(); // 분석 기능
				break;
			case 5:
				modify();
				break;
			case 6:
				System.out.println("종료합니다.");
				run = false;
			} //end switch
		} //end while
	} //end main()
} // end class
