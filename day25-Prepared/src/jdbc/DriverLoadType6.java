package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * SCOTT 계정의 EMP 테이블의 내용을 조회하여 데이터 베이스 접속을 테스트하는 클래스
 * ---------------------------------------- 1. 드라이버 로드 2. 커넥션 맺기 3. 쿼리 준비 4. 쿼리
 * 실행 5. 결과 처리 6. 자원 해제 -----------------------------------------
 * 
 * @author Administrator
 *
 */
public class DriverLoadType6 {
	// DB 커넥션 정보를 static 상수로 선언

	private static final String URL = "jdbc:oracle:thin:@//127.0.0.1:1521/XE";
	
	private static final String MYSQL_URL = "jdbc:mysql://127.0.0.1:3306/emp?serverTimezone=Asia/Seoul";
	
	private static final String USER = "SCOTT";
	private static final String PASSWORD = "TIGER";
	private static final String PASSWORD2 = "0000";
	
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		// JDBC 연결에 필요한 객체들 선언
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String id = null;
		String password = null;

		try {

			//			1. 드라이버 로드
			Class.forName(DRIVER);


			//		2. 커넥션 맺기
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

			

			//3. 쿼리 준비 
			System.out.println("아이디를 입력하세요.");
			id = new Scanner(System.in).nextLine();
			
			System.out.println("비밀번호를 입력하세요.");
			password = new Scanner(System.in).nextLine();
			
			// SQL Injection 공격에 취약한 일반 Statement 구문
			// id 에는 아이디를 입력하고
			// password 에는 ' OR 1=1 -- 를 입력
			String sql = "SELECT l.userid"  
					+ "     FROM LOGIN l"  
					+ "    WHERE l.userid = ?"  
					+ "      AND l.password = ?" ;

			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);

			

			//4. 쿼리 실행 
			result = pstmt.executeQuery();


			//5. 결과 처리 : 반복수행
			if(result.next()) {
				System.out.println("접속된 아이디 : ");
				System.out.println(result.getString(1));
				System.out.println("접속 되었습니다.");
			} else {
				System.out.println("비밀번호를 확인하세요");
			}
		} catch(SQLException e) {
			System.err.println("SQL 구문 실행시 오류! " + e.getMessage());
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			
			System.out.println("드라이버 로드시 오류!" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			try {
				if (result != null) {
					result.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.err.println("자원 해제시 오류!" + e.getMessage());
				e.printStackTrace();
			}
		}

	}
}
