package com.yedam;

import java.util.Date;

public class Member {

	// 필드
	private	String no;
	private String name;
	private String phone;
	private Date join;
	private String grade;
	private String approval;
	
	// 생성자
	public Member() {
	}
	
	public Member(String no, String name, String phone, Date join, String grade, String approval) {
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.join = join;
		this.grade = grade;
		this.approval = approval;
	}

	// 메소드
	public void showInfo() {
		System.out.println(no + " \t" + name + "\t" + phone + "\t" + join + "\t" + grade + "\t" + approval);
	}

	//getter,setter
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getJoin() {
		return join;
	}

	public void setJoin(Date join) {
		this.join = join;
	}
	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}
	
	
	
} //end of Member
