package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// 데이터 엑세스 오브젝트
public class MemberDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	// JDBC 기능
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공~~!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 목록 반환기능
	ArrayList<Member> getMemberList(){
		getConn();
		System.out.println("==================================================================");
		System.out.println("회원번호 \t 회원명 \t 전화번호 \t 가입날짜 \t 등급 \t 가입승인여부");
		System.out.println("==================================================================");
		
		ArrayList<Member> members = new ArrayList<>();
		String sql = "select * from members order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member memb = new Member();
				memb.setNo(rs.getString("member_no"));
				memb.setName(rs.getString("member_name"));
				memb.setPhone(rs.getString("member_phone"));
				memb.setJoin(rs.getDate("join_date"));
				memb.setGrade(rs.getString("grade"));
				memb.setApproval(rs.getString("approval"));
				members.add(memb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return members;
	} // end of getMemberList()
	
	
	// 추가
	boolean addMember(Member mem) {
		getConn();
		return false;
	}
	
	
}
