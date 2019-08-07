package jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

/**
 * SCOTT 계정의 EMP 테이블의 내용을 조회하여
 * 데이터 베이스 접속을 테스트하는 클래스
 * ----------------------------------------
 * 1. 드라이버 로드
 * 2. 커넥션 맺기
 * 3. 쿼리 준비
 * 4. 쿼리 실행
 * 5. 결과 처리
 * 6. 자원 해제
 * -----------------------------------------
 * @author Administrator
 *
 */
public class DriverLoadType1 {
	// DB 커넥션 정보를 static 상수로 선언
	
	private static final String URL = "jdbc:oracle:thin:@//127.0.0.1:1521/XE";
	private static final String USER = "SCOTT";
	private static final String PASSWORD = "TIGER";
	
	public static void main(String[] args) {
//		1. 드라이버 로드
		new OracleDriver();
		
//		2. 커넥션 맺기
		// JDBC 연결에 필요한
		Connection connection = null;
		Statement stmt = null;
		ResultSet result = null;
		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
//		3. 쿼리 준비  
		String sql = "SELECT e.empno" 
				+    "     , e.ename"
				+    "     , e.job"
				+    "     , e.sal"
				+    "  FROM emp e"
				+    " ORDER BY e.ename";
		
		stmt = connection.createStatement();

//		4. 쿼리 실행 
		result = stmt.executeQuery(sql);
		
		// 결과 셋의 컬럼이름 추출
		ResultSetMetaData meta = result.getMetaData();
		String colEmpno = meta.getColumnName(1);
		String colEname = meta.getColumnName(2);
		String coljob = meta.getColumnName(3);
		String colSal = meta.getColumnName(4);
		
		System.out.printf("%5s| %6s | %9s | %4s$n", colEmpno, colEname, coljob colSal);
		System.out.println("===========================================================");
//		5. 결과 처리 : 반복수행
//		SELECT 실행결과는 여러 행의 결과가 발생하는 것이
//		일반적이므로 각 행별 처리를 위해서는 반복처리가 필요
		while (result.next()) {
			// 결과셋의 표 형태를 받는 result 변수에서
			// next() 를 호출해야 최초의 행으로
			// 결과셋 커서(cursor) 가 이동
			// result 변수는 커서가 이동된 행 1 줄을 가리키게 됨.
			int empno = result.getInt(1);
			String ename = result.getString(2);
			String job = result.getString(3);
			int sal = result.getInt(4);
			System.out.printf("%4d | %6s | %9s | %4d%n", empno, ename, job, sal);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 해제  			
			//    해제 순서 : result => stmt => connection : 오픈한 반대로 닫는다
			//    오픈 순서 : connection => stmt => result
			if(result != null) {
				result.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

}
