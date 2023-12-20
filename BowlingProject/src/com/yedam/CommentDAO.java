package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CommentDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	// JDBC 연결 메소드
	Connection getConn() {
		String url = "jdbc:oracle:thin:@192.168.0.18:1521:xe";
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
	
	// 공지글 목록 반환 메소드
	ArrayList<Board> getBoardList(int boardNum) {
		getConn();
		System.out.println("---------------------------------------------------------");
		System.out.println("글번호 \t 공지글 내용 \t\t\t 작성자  \t  작성일자");
		System.out.println("---------------------------------------------------------");
		ArrayList<Board> boards = new ArrayList<Board>();
		
		String sql = "select   *  "
					+ "from    boards "
					+ "where   board_no =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			rs = psmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			
			
			while(rs.next()) {
				Board bord = new Board();
				bord.setBoardNo(rs.getInt("board_no"));
				bord.setBoardContent(rs.getString("board_content"));
				bord.setBoardWriter(rs.getString("board_wirter"));
				bord.setBoardDate(sdf.format(rs.getDate("board_date")));
				
				boards.add(bord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return boards;
	}
	
	// 댓글 목록 반환 메소드
	ArrayList<Comment> getCommentList(int boardNum){
		getConn();
		System.out.println("==========================================================");
		System.out.println("댓글 번호   댓글 내용 \t\t\t작성자\t작성일자");
		System.out.println("==========================================================");
		
		ArrayList<Comment> comments = new ArrayList<Comment>();
		
		String sql = "select * "
					+ "from 	comments "
					+ "where 	board_no =?"
					+ "order by comment_no";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			rs = psmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			while(rs.next()) {
				Comment com = new Comment();
				com.setCommentNo(rs.getInt("comment_no"));
				com.setCommntCon(rs.getString("comment_content"));
				com.setCommentWriter(rs.getString("comment_writer"));
				com.setCommentDate(sdf.format(rs.getDate("wirter_date")));
				
				comments.add(com);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return comments;
	}
	
	// 댓글 추가 메소드
	boolean addComment(Comment com, int boardNum) {
		getConn();
		String sql = "insert into comments "
					+ "values (?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			psmt.setInt(2, com.getCommentNo());
			psmt.setString(3, com.getCommntCon());
			psmt.setString(4, com.getCommentWriter());
			psmt.setString(5, com.getCommentDate());
			
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
	}
	
	// 댓글 수정 메소드
	boolean modifyComment(int commentNum, String con) {
		getConn();
		String sql = "update  comments "
					+ "set     comment_content =? "
					+ "where   comment_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, con);
			psmt.setInt(2, commentNum);
			
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
	}
	
	// 댓글 삭제 메소드
	boolean removeComment(int commentNum) {
		getConn();
		String sql = "delete from comments "
					+ "where comment_no =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, commentNum);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 내 댓글 조회
	ArrayList<Comment> getMyComment(String myName){
		getConn();
		System.out.println("==========================================================");
		System.out.println("댓글 번호   댓글 내용 \t\t\t작성자\t작성일자");
		System.out.println("==========================================================");
		
		ArrayList<Comment> comments = new ArrayList<Comment>();
		
		String sql = "select  * "
					+ "from    comments "
					+ "where   comment_writer =? "
					+ "order by 2";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, myName);
			rs = psmt.executeQuery();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			while(rs.next()) {
				Comment com = new Comment();
				com.setCommentNo(rs.getInt("comment_no"));
				com.setCommntCon(rs.getString("comment_content"));
				com.setCommentWriter(rs.getString("comment_writer"));
				com.setCommentDate(sdf.format(rs.getDate("wirter_date")));
				
				comments.add(com);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return comments;
	}
	
	
} //end of class
