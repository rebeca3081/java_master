package remind7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//컬렉션으로 바꿔서 해보기
public class StudentApp {
	public static void main(String[] args) {
		// 컬렉션 배열
		List<Student> students = new ArrayList<>();
		// StudentExe 인스턴스생성
		StudentExe exe = new StudentExe();

		Scanner sc = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1: // 등록
				System.out.println("학생번호 이름 영어점수 수학점수");
				String input = sc.nextLine();
				String[] inAry = input.split(" ");
				String no = inAry[0];
				String name = inAry[1];
				int eng = Integer.parseInt(inAry[2]);
				int math = Integer.parseInt(inAry[3]);

				students.add(new Student(no, name, eng, math));
				System.out.println("등록완료");
				break;
			case 2: // 목록
				for(Student stnd : exe.getStudentList()) {
					stnd.showInfo();
				}				
				break;
			case 3: // 단건조회
				System.out.println("조회할 학생번호>>> ");
				no = sc.nextLine();
				Student stnt = exe.getStudent(no);
				if(stnt != null) {
					stnt.showInfo();
				}else {
					System.out.println("존재하지 않는 정보!");
				}
				break;
			case 4: // 수정
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
			case 5: // 삭제
				System.out.println("삭제할 이름입력>>");
				name = sc.nextLine();
				if(exe.removeStudent(name)) {
					System.out.println("삭제완료 ;)");
				}else {
					System.out.println("삭제실패 :(");				
				}
				break;
			case 6: // 종료
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}

		} // end of while
		System.out.println("end of prog.");
	}// end of main

}// end of class
