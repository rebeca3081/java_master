package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 저장공간: Oracle DB.

// 추가/수정/삭제/목록/단건조회
public class StudentDAO {
	// 배열선언은 필요없음
	Connection conn;
	PreparedStatement psmt; // SQL 구문을 해석 및 처리, 실행 : .executeQuery()/.executeUpdate()
	ResultSet rs;

	// 연결기능은 따로 빼서 메소드로 선언해줌
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
			System.out.println("연결성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 연결접속 해제 : listener 부족방지
	public void disConn() {
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

	// 목록.
	public List<Student> getStudentList() {
		getConn();
		List<Student> students = new ArrayList<>();
		String sql = "select * from student order by 1"; 
																 // '%'||?||'%' 로 사용하면 파라미터로 값을 받을 수 있음
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // 조회
			while (rs.next()) { // ResultSet에서 읽어올 값이 있으면 true, 없으면 false
				// 생성자로 컬럼의 값을 받아와서 student 넣어주기
				Student student = new Student();
				student.setStudentNo(rs.getString("student_no"));
				student.setStudentName(rs.getString("student_name"));
				student.setScoreEng(rs.getInt("score_eng"));
				student.setScoreMath(rs.getInt("score_math"));
				
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return students;
	} // end of getStudentList()

	// 추가.
	public boolean addStudent(Student std) {
		getConn(); // JDBC연결
		String sql = "insert into student values (?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStudentNo());
			psmt.setString(2, std.getStudentName());
			psmt.setInt(3, std.getScoreEng());
			psmt.setInt(4, std.getScoreMath());

			int r = psmt.executeUpdate(); // 처리된 건수 반환
			if (r == 1) {
				return true; // 처리가 완료되면 true로 반환
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return false;
	} // end of addStudent()

	// 단건조회.
	public Student getStudent(String no) {
		getConn(); // JDBC연결
		// 쿼리
		String sql = "select * from student where student_no=?";
		// ? 지정하지 않으면 오류-> 인덱스에서 누락된 IN 또는 OUT 매개변수:: 1
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if (rs.next()) { // 값이 있는지 없는지 확인
				// 생성자로 컬럼의 값을 받아와서 student 넣어주기
				Student student = new Student();
				student.setStudentNo(rs.getString("student_no"));
				student.setStudentName(rs.getString("student_name"));
				student.setScoreEng(rs.getInt("score_eng"));
				student.setScoreMath(rs.getInt("score_math"));
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		return null; // 조회된 값이 없으면 null 값 반환.
	} // end of getStudent()
	
	
	// 수정
	public boolean modifyStudent(String no, int eng, int math) {
		getConn(); // JDBC연결
		String sql = "update  student "
				+ "	  set     score_eng =?, "
				+ "        	  score_math =? "
				+ "   where   student_no =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eng);
			psmt.setInt(2, math);
			psmt.setString(3, no);
			
			int r = psmt.executeUpdate();
			if(r > 0) { // 한건 보다 많으면
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConn();
		}
		
		return false;
	} // end of modifyStudent()
	
	
	// 삭제(여러건으로 변경)
	public boolean removeStudent(String name) {
		getConn();
		String sql = "delete from student "
					+ "where student_name =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			
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
	

}// end of class
