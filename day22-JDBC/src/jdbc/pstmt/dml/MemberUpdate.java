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
 * INSERT : (MEMBER_ID, MEMBER_NAME) 컬럼에 대하여 삽입하는 문구 실행
 * 
 * UPDATE : PHON, MAJOR, BIRTH_MONTH, GENDER 컬럼에 대해 수정 구문 실해
 * 
 * DELETE : MEMBER_ID 걸어서 삭제하는 구문 실행
 * -----------------------------------------------------
 * 1. 드라이버 로드
 * 2. 커넥션 맺기 DriverManager
 * 3. 쿼리 준비
 * 4. 쿼리 실행
 * 5. 결과 처리
 * 6. 자원 닫기 (사용한 역순)
 * 
 * 
 * @author Administrator
 *
 */

public class MemberUpdate {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 드라이버 로드
			Class.forName(DRIVER);			
			
			// 2. 커넥션 맺기			
			conn = DriverManager.getConnection(URL,USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "UPDATE MEMBER m" 
					+ "   SET m.phone = ?"  
					+ "     , m.major = ?" 
					+ "     , m.birth_month = ?"  
					+ "     , m.gender = ?"  
					+ " WHERE m.member_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			// ? 맵핑
			// Member 객체 생성 후
			// 수정자
		    pstmt.setString(1, "0000");
		    pstmt.setString(2, "도술");
		    pstmt.setInt(3, 12);
		    pstmt.setString(4, "M");
		    pstmt.setString(5, "M010");
		    
		    // 4. 쿼리 실행
		    int addCnt = pstmt.executeUpdate();
		    
		    // 5. 결과 처리
		    if (addCnt > 0) {
		    	System.out.printf("%d 행이 삽입되었습니다.", addCnt);
		    }		    		    															
		} catch (SQLException e) {
				System.err.println("SQL 구문 오류" + e.getMessage());
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 오류" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 사용한 자원 닫기
				try {
					if (pstmt != null) {
					pstmt.close();
					}
					if (conn != null) {
					conn.close();
					}
				} catch (SQLException e) {
					System.err.println("자원해제 오류!" + e.getMessage());
					e.printStackTrace();
				}
			}
	}
}

