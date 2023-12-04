package remind6;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		boolean run = true;		
		
		Scanner sc = new Scanner(System.in);
		StudentExe exe = new StudentExe(); // 기능메소드
		
		while(run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(sc.nextLine()); // "1" -> 1
			
			switch(menu) {
			case 1:
				System.out.println("학생번호입력>> ");
				String no = sc.nextLine();
				System.out.println("학생이름입력>> ");
				String name = sc.nextLine();
				System.out.println("영어점수입력>> ");
				int eng = Integer.parseInt(sc.nextLine());
				System.out.println("수학점수입력>> ");
				int math = Integer.parseInt(sc.nextLine());
				
				Student std = new Student(no, name, eng, math); // 사용자 입력 매개값의 생성자가 있어야 에러 안남
				// Students 배열에 한건 저장
				if(exe.addStudent(std)) {
					System.out.println("저장되었습니다 :)");					
				}else {
					System.out.println("저장 중 오류 :(");	
				}
				break;
			case 2: // 목록보기
				for(Student stdnt : exe.getStudentList()) {
					if(stdnt != null) {
						stdnt.showInfo();
					}
				}
				break;
			case 3: // 단건조회
				System.out.println("조회할 학생번호를 입력>>>> ");
				no = sc.nextLine();
				Student stnt = exe.getStudent(no); //★
				if(stnt != null) {
					stnt.showInfo();
				}else {
					System.out.println("존재하지 않는 정보!");
				}
				break;
			case 4: // 번호조회 후 영어, 수학점수 수정
				System.out.println("학생번호 조회>> ");
				no = sc.nextLine();
				System.out.println("수정할 영어점수 입력>> ");
				eng = Integer.parseInt(sc.nextLine());
				System.out.println("수정할 수학점수 입력>> ");
				math = Integer.parseInt(sc.nextLine());
				if(exe.modifyStudent(no, eng, math)){
					System.out.println("수정완료:)");
				}else {
					System.out.println("수정실패:(");					
				}
				break;
			case 5: // 이름삭제
				System.out.println("삭제할 이름입력>>");
				name = sc.nextLine();
				if(exe.removeStudent(name)) {
					System.out.println("삭제완료 ;)");
				}else {
					System.out.println("삭제실패 :(");				
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다");
				run = false;
			}
		}//end of while
		System.out.println("end of prop");

	} //end of main()

}
