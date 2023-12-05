package todo.p20231205emp;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Emp {
	// 필드 : 사번, 이름, 전화번호, 입사일자(오늘일자), 급여
	private String empNum; //E01
	private String empName;
	private String phone; // 010-1234
	private int salary;
	private Date enterDay; // 2023-12-05
	
	// 날짜는 자동생성되는 생성자...
	Emp(String empNum, String empName, String phone, int salary){
		this.empNum = empNum;
		this.empName = empName;
		this.phone = phone;
		this.salary = salary;
		this.enterDay = new Date();
	}
	// 생성자
	Emp(String empNum, String empName, String phone, Date enterDay, int salary){
		this.empNum = empNum;
		this.empName = empName;
		this.phone = phone;
		this.salary = salary;
		this.enterDay = enterDay;
	}
	
	//메소드
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return empNum + "  " + empName + "  " + phone + "  " + salary + "  " + sdf.format(enterDay);
	}
	
	
	public void showInfo() {
		System.out.println(empNum + "  " + empName + "  " + phone + "  " + salary + "  " + enterDay);
	}
	
	

}
