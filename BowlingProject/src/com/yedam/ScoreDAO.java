package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ScoreDAO {
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
	ArrayList<Score> getScoreList(String month){
		getConn();
		System.out.println("================================================================================================");
		System.out.println("목록 번호 \t 1G 볼링점수 \t 2G 볼링점수  \t  3G 볼링점수  \t 에버리지 \t 볼링친 날짜");
		System.out.println("================================================================================================");
		String sql = "select   game_no, "
					+ "        score_1g, score_2g, score_3g, "
					+ "        round((score_1g + score_2g + score_3g)/3) as AVG, "
					+ "        bowling_date "
					+ "from    scores "
					+ "where   extract(month from bowling_date) =?";
		ArrayList<Score> scores = new ArrayList<Score>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, month);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Score sco = new Score();
				sco.setGameNo(rs.getString("game_no"));
				sco.setScore1G(rs.getInt("score_1g"));
				sco.setScore2G(rs.getInt("score_2g"));
				sco.setScore3G(rs.getInt("score_3g"));
				sco.setAvg(rs.getInt("AVG"));
				sco.setBowlingDate(rs.getDate("bowling_date"));
				
				scores.add(sco);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return scores;
	} // end of getScoreList()
	
	
	// 추가
	boolean addScore(Score sco) {
		getConn();
		String sql = "insert into scores (game_no, score_1g, score_2g, score_3g, bowling_date) "
					+ "values (?, ?, ?, ?, ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sco.getGameNo());
			psmt.setInt(2, sco.getScore1G());
			psmt.setInt(3, sco.getScore2G());
			psmt.setInt(4, sco.getScore3G());
			psmt.setString(5, sdf.format(sco.getBowlingDate()));
			
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
	
	
	// 점수수정
	boolean modifyScore(String gameNo, int game1, int game2, int game3) {
		getConn();
		String sql = "update  scores "
					+ "set     score_1g =?, score_2g =?, score_3g =? "
					+ "where   game_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, game1);
			psmt.setInt(2, game2);
			psmt.setInt(3, game3);
			psmt.setString(4, gameNo);
			
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
	} // end of  modifyScore()
	
	
	// 점수 삭제
	boolean removeScore(String no) {
		getConn();
		String sql = "delete  from scores "
					+ "where   game_no =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			
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
	} // end of removeScore()
	
	
} //end of class
