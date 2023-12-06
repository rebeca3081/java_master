package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EmpDAO {
	// 배열선언
	ArrayList<Employee> employees;

	// 생성자
	EmpDAO() {
		employees = new ArrayList<>();
		SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
		try {
			employees.add(new Employee("23-11", "홍길동", "943-1234", sdfo.parse("2023-11-23"), 230));
			employees.add(new Employee("23-12", "박길동", "943-2345", sdfo.parse("2023-12-01"), 300));
			employees.add(new Employee("23-13", "김길동", "943-3456", sdfo.parse("2023-12-02"), 200));
			employees.add(new Employee("23-14", "고길동", "943-4567", sdfo.parse("2023-12-03"), 330));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 메소드
	// - 추가
	boolean addEmployee(Employee emp) {
		return employees.add(emp);
	}
	// -목록반환
	ArrayList<Employee> getEmpList(){
		return employees;
	}
	// 수정 급여
	boolean modifySalary(String number, int salary) {
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getEmpNumber().equals(number)) {
				employees.get(i).setSalary(salary);
				return true;
			}
		}
		return false;
	}
	// 삭제(사번 조회를 통한)
	boolean removeEmployee(String number) {
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getEmpNumber().equals(number)) {
				employees.remove(i);
				return true;				
			}
		}
		return false;
	}
	// 입사일자 기준일자 이후 조회
	ArrayList<Employee> searchDate(Date joinDay) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		for(int i = 0; i < employees.size(); i++) {
			if(employees.get(i).getDate().after(joinDay)
					|| employees.get(i).getDate().equals(joinDay)) { 
				list.add(employees.get(i));
			}
		}
		return list;
	}
}
