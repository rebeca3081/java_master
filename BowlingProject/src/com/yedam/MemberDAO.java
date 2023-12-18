package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
	
	// 연결접속 해제 : TNS listener 부족방지
	void disConn() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 목록 반환기능
	ArrayList<Member> getMemberList(){
		getConn();
		System.out.println("==================================================================");
		System.out.println("회원번호 \t 회원명 \t 전화번호  \t  가입날짜  \t 등급  \t  가입승인여부");
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
		} finally {
			disConn();
		}
		
		return members;
	} // end of getMemberList()
	
	
	// 추가
	boolean addMember(Member mem) {
		getConn();
		String sql = "insert into members "
						+ "values (?, ?, ?, ?, ?, ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getNo());
			psmt.setString(2, mem.getName());
			psmt.setString(3, mem.getPhone());
			psmt.setString(4, sdf.format(mem.getJoin()));
			psmt.setString(5, mem.getGrade());
			psmt.setString(6, mem.getApproval());
			
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	} //end of addMember()
	
	
	// 수정(2개월 지난 회원등급 일괄변경)
	boolean modifyAllGrade() {
		getConn();
		String sql = "update  members "
					+ "set     grade = '정회원' "
					+ "where   trunc(months_between(sysdate, join_date)) >= 2 "
					+ "and     grade = '준회원'";
		try {
			psmt = conn.prepareStatement(sql);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		
		return false;
	} //end of modifyAllGrade()
	
	// 시간이 된다면...추가해볼것 -> 등급변경할 회원 목록 조회 후 변경할 수 있도록 해보기
	
	
	// 회원정보수정_1 : 회원번호으로 조회 -> 회원전화번호 수정
	boolean modifyPhone(String num, String phonenum) {
		getConn();
		String sql = "update  members "
					+ "set    member_phone =? "
					+ "where  member_no =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, phonenum);
			psmt.setString(2, num);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	} //end of modifyPhone()
	
	
	// 회원정보수정_2 : 회원번호으로 조회 -> 승인여부 수정
	boolean modifyApprove(String num, String approve) {
		getConn();
		String sql = "update  members "
					+ "set     approval =? "
					+ "where   member_no =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, approve);
			psmt.setString(2, num);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	} //end of modifyApprove()
	
	
	// 회원 삭제
	boolean removeMember(String num) {
		getConn();
		String sql = "delete  from  members "
					+ "where   member_no =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, num);
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	} // end of removeMember()
	
	
	
}//end of class
