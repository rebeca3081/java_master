package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmpDAO dao = new EmpDAO();
		boolean run = true;
		int menu = 0;
		while (run) {
			System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
			menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1: // 등록
				System.out.print("사번입력>> ");
				String number = sc.nextLine();
				System.out.print("이름입력>> ");
				String name = sc.nextLine();
				System.out.print("전화번호입력>> ");
				String phone = sc.nextLine();
				System.out.print("입사일입력>> ");
				String joinDay = sc.nextLine();
				System.out.print("급여입력>> ");
				int salary = Integer.parseInt(sc.nextLine());
				// .parse(): String -> Date
				// .format : Date -> String
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Employee emp;
				try {
					emp = new Employee(number, name, phone, sdf.parse(joinDay), salary);
					if (dao.addEmployee(emp)) {
						System.out.println("등록완료!");
					} else {
						System.out.println("등록실패...");
					}
				} catch (ParseException e) {
					System.out.println("올바른 입사일자를 입력해주세요");
				}

				break;
			case 2: // 목록
				System.out.println("사번\t이름\t전화번호     급여");
				for (Employee emplo : dao.getEmpList()) {
					emplo.showFullInfo();
				}
				break;
			case 3: //수정(급여)
				System.out.print("사번 급여>> ");
				String input = sc.nextLine();
				String[] inAry = input.split(" ");
				number = inAry[0];
				salary = Integer.parseInt(inAry[1]);
				
				if(dao.modifySalary(number, salary)) {
					System.out.println("급여 수정완료!");
				}else {
					System.out.println("수정 실패...");
				}
				break;
			case 4: // 삭제
				System.out.print("사번>> ");
				number = sc.nextLine();
				if(dao.removeEmployee(number)) {
					System.out.println("삭제 완료 :)");
				}else {
					System.out.println("삭제 실패...");
				}
				break;
			case 5: //조회(조건:입사일자)
				System.out.print("입사일자>> ");
				joinDay = sc.nextLine();
				// .parse(): String -> Date
				// .format : Date -> String
				SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
				
				try {					
					ArrayList<Employee> list = dao.searchDate(sdfo.parse(joinDay));
					System.out.println("사번\t이름\t입사일자");
					for (Employee empo : list) {
						empo.showJoinDayInfo();
					}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				break;
			case 6:
				System.out.println("프로그램을 종료합니다");
				run = false;
			} // end of switch
		} // end of while
		System.out.println("end of prog");

	} // end of main

}
