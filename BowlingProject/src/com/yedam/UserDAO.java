package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	// JDBC 연결 메소드
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			// System.out.println("연결성공~~!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
		
	// 연결접속 해제 : listener 부족방지
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
	
	// 로그인 메소드
	ArrayList<User> logIn(String id, int pw) {
		getConn();
		String sql = "select  user_id, user_pw "
					+ "from    users "
					+ "where   user_id =? "
					+ "and     user_pw =?";
		
		ArrayList<User> logins = new ArrayList<User>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setInt(2, pw);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				User use = new User();
				use.setUserId(rs.getString("user_id"));
				use.setUserPw(rs.getInt("user_pw"));
				logins.add(use);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return logins;
	}
	
	// 로그인 사용자 이름 반환 메소드
	ArrayList<User> getUserName(String id) {
		getConn();
		String sql = "select	m.member_name "
					+ "from		users u, members m "
					+ "where	u.user_no = m.member_no "
					+ "and      u.user_id = 'jang'";
		
		ArrayList<User> users = new ArrayList<User>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				User use = new User();
				use.setUserName(rs.getString("m.member_name"));
				
				users.add(use);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return users;
	}
	
} // end of class
