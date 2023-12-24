package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BoardDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// JDBC 연결 메소드
	Connection getConn() {
		//String url = "jdbc:oracle:thin:@192.168.0.18:1521:xe";
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

	// 목록 반환기능
	ArrayList<Board> getBoardList() {
		getConn();
		System.out.println("---------------------------------------------------------");
		System.out.println("글번호 \t 공지글 내용 \t\t\t 작성자  \t  작성일자");
		System.out.println("---------------------------------------------------------");

		ArrayList<Board> boards = new ArrayList<Board>();
		String sql = "select * from boards order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

			while (rs.next()) {
				Board bod = new Board();
				bod.setBoardNo(rs.getInt("board_no"));
				bod.setBoardContent(rs.getString("board_content"));
				bod.setBoardWriter(rs.getString("board_wirter"));
				bod.setBoardDate(sdf.format(rs.getDate("board_date")));

				boards.add(bod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return boards;
	} // end of getBoardList()

	// 게시글 추가 기능
	boolean addBoard(Board bor) {
		getConn();
		String sql = "insert into boards (board_no, board_content) " 
					+ "values (?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bor.getBoardNo());
			psmt.setString(2, bor.getBoardContent());

			int r = psmt.executeUpdate();
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	}

	// 게시글 수정
	boolean modifyBoard(int num, String contnet) {
		getConn();
		String sql = "update  boards " 
					+ "set     board_content =? " 
					+ "where   board_no =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, contnet);
			psmt.setInt(2, num);
			
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	} // end of modifyBoard()
	
	// 게시글 삭제
	boolean removeBoard(int num) {
		getConn();
		String sql = "delete  from boards "
					+ "where   board_no =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			
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
	} //end of removeBoard()

} // end of Class
