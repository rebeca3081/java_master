package com.yedam;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	// 필드
	private String empNumber; // 23-11
	private String empName;
	private String phone; // 943-1234
	private Date date; // 2023-10-01
	private int salary;

	// 생성자
	Employee(String empNumber, String empName, String phone, Date date, int salary) {
		this.empNumber = empNumber;
		this.empName = empName;
		this.phone = phone;
		this.date = date;
		this.salary = salary;
	}
	Employee(String empNumber, String empName, String phone, int salary) {
		this.empNumber = empNumber;
		this.empName = empName;
		this.phone = phone;
		this.salary = salary;
		this.date = new Date();
	}

	// getter,setter
	public String getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return (Date) date;
	}

	public void setDate(Date date) {
		this.date = (Date) date;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	// 메소드
	// 전체정보
	public void showFullInfo() {
		System.out.println(empNumber + "\t" + empName + "\t" + phone + "     " + salary);
	}
	// 입사일자 조회정보
	public void showJoinDayInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(empNumber + "\t" + empName + "\t" + sdf.format(date));
	}

}
