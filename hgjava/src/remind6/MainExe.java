package remind6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainExe {
	static Connection conn; //정적변수로 선언

	public static void main(String[] args) {
		// JDBC test -> lib 연결확인
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			// DB 연결
			Class.forName("oracle.jdbc.OracleDriver");
			// 세션을 얻어와서 연결하는 통로의 역할
			conn = DriverManager.getConnection(url, "dev", "dev"); // (URL, "사용자계정 이름", "사용자계정 비밀번호")
			System.out.println("연결성공!!");
			// select();
			// 쿼리만들기
			String sql = "insert into student (student_no, student_name, score_eng, score_math) " // 엔터키 -> space 한칸 남겨두기!
							+ "values (?, ?, ?, ?)"; // ? : 파라미터로 처리 하겠습니다
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, "23-003"); // .setString(파라미터 인덱스, 넣을값)
			psmt.setString(2, "박씨");
			psmt.setInt(3, 80);
			psmt.setInt(4, 85);
			
			// 입력, 수정, 삭제 => executeUpdate();  //조회 : executeQuery();
			int r = psmt.executeUpdate(); // 처리된 건수를 반환해줌
			if(r == 1) {
				System.out.println("입력 성공.");
			}
			
			
			
		} catch (Exception e) {
			 e.printStackTrace();
			// System.out.println("Driver 없음.");
		}
		
		
	} // end of main()
	
	public static void select() throws Exception { // select()메소드에서 예외가 나오면 호출하는 부분에서 예외를 처리하도록함
		String sql = "select * from student"; // ';'있으면 안됌! - SQLSyntaxErrorException
		PreparedStatement psmt = conn.prepareStatement(sql); // 구문 처리기능-쿼리실행
		ResultSet rs =  psmt.executeQuery(sql); // Set 컬렉션이랑 비슷한 ResultSet- 여러건을 담고있음
		while(rs.next()) { // 읽어올 값이 있으면 true, 없으면 false
			System.out.println("번호: " + rs.getString("student_no") // .getString("컬럼명") -> 문자열 값으로 컬럼의 값을 가져옴
							  	+ ", 이름: " + rs.getString("student_name")
							  	+ ", 영어점수: " + rs.getInt("score_eng")
							  	+ ", 수학점수: " + rs.getInt("score_math"));
		}
	} // end of select()
	
	

}
