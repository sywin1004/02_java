package jdbc.pstmt.dml;

import static jdbc.ConnectionInfo.DRIVER;
import static jdbc.ConnectionInfo.PASSWORD;
import static jdbc.ConnectionInfo.URL;
import static jdbc.ConnectionInfo.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * EMP 테이블에 1행을 삭제하는 Update 쿼리를 
 * JDBC 연결을 통해 처리하는 클래스
 * ---------------------------------- 
 * 1. 드라이버 로드 (5번째 Class.forName(..) 
 * 2. 커넥션
 * 맺기 (DriverManager 클래스 사용) 
 * 3. 쿼리 준비 (PreparedStatement 사용) 
 * 4. 쿼리 실행
 * (excuteQuery(), executeUpdate()) 
 * 5. 결과 처리 (whilem, 리턴 값에 따라 적절한 처리) 
 * 6. 사용한 자원
 * 해제 (오픈한 역순)
 * 
 * 모든 과정에서 SQLException 처리 -----------------------------------
 * 
 * @author Administrator
 *
 */
public class EmpDelete {

	public static void main(String[] args) {
		// 필요한 변수들 먼저 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		// 1. 드라이버 로드
		Class.forName(DRIVER);
		// 2. 커넥션 맺기
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		// 3. 쿼리 준비
		String sql =  "DELETE EMP e"
				  +   " WHERE e.empno = ?";
		
		pstmt = conn.prepareStatement(sql);
		
		// ? 맵핑 (임꺽정 : 8888 tkrwp
		pstmt.setInt(1, 8888);
		

		// 4. 쿼리 실행 : ? 가 사전에 모두 맵핑된
		// pstmt 객체를 통해서 쿼리 실행
		
		int rmCnt = pstmt.executeUpdate(); // 반드시 매개변수 없는걸로 실행
		// 5. 결과 처리
		//    몇 건의 데이터가 처리되었는지를 나타내는
		//    정수 리턴값으로 처리 가능
		if(rmCnt> 0) {
			System.out.printf("%d 행이 삽입되었습니다.", rmCnt);
		}
		
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류!" + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 오류!" + e.getMessage());
			e.printStackTrace();
		}
		finally {
			// 6. 자원 해제	
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e){
				System.err.println("자원 해제 오류!" + e.getMessage());
				e.printStackTrace();
			}
		}

	}

}
