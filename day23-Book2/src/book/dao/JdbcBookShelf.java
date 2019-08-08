package book.dao;

import static book.dao.ConnectionInfo.DRIVER;
import static book.dao.ConnectionInfo.PASSWORD;
import static book.dao.ConnectionInfo.URL;
import static book.dao.ConnectionInfo.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;

public class JdbcBookShelf implements BookShelf {

	// 커넥션 정보 : ConnnectionInfo 의 static 필드로 사용
	
	// 2. 생성자 
	public JdbcBookShelf() {
		// 1. 드라이버 로드
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 오류!" 
		                      + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public int add(Book book) throws DuplicateException {
		// INSERT 필요 객체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		// 2. 커넥션 맺기
		try {
			conn = DriverManager.getConnection(USER, PASSWORD, URL);
		} catch (SQLException e) {
			System.err.println("커넥션 오류");
			e.printStackTrace();
		}
		
		
		// 3. 쿼리 준비		
		try {
			String sql ="INSERT INTO BOOK b(b.sequence, b.isbn, b.title, b.author, b.company, b.total_page,b.price,b.quantity)" 
					+ "  VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			// ? 값 입력
			pstmt.setInt(1, 1);
			pstmt.setString(2, "9788936433598");
			pstmt.setString(3, "채식주의자");
			pstmt.setString(4, "한강");
			pstmt.setString(5, "창비");
			pstmt.setInt(6, 247);
			pstmt.setInt(7, 10800);
			pstmt.setInt(8, 10);
			// 4. 쿼리 실행
			int addCnt = pstmt.executeUpdate();
			// 5. 결과 처리
				count = addCnt;
				
		} catch (SQLException e) {
			System.err.println("구문 실행시 오류!" + e.getMessage());
			e.printStackTrace();
			
		} finally {
			// 6. 자원 해제
			try {
				if(pstmt != null) {
					pstmt.close();
					}
				if(conn != null) {
					conn.close();
				} 
			} catch (SQLException e) {
					System.err.println("자원 해제시 오류" + e.getMessage());
					e.printStackTrace();
				}
			}
		return count;
	}


	@Override
	public int set(Book book) throws NotFoundException {
		// UPDATE 필요 객체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int addCnt = 0;
		
		// 2. 커넥션 맺기
		try {
			conn = DriverManager.getConnection(URL,PASSWORD,USER);
		} catch (SQLException e) {
			System.err.println("커넥션 오류" + e.getMessage());
			e.printStackTrace();
		}
		// 3. 쿼리 준비
		try {
		String sql = "UPDATE BOOK "  
				+ "      SET b.sequence = ?"  
				+ "        , b.isbn = ?"  
				+ "        , b.title = ?" 
				+ "        , b.author = ?"  
				+ "        , b.company = ?" 
				+ "        , b.total_page = ?"  
				+ "        , b.price = ?"  
				+ "        , b.quantity = ?"  
				+ "    WHERE b.sequence = ?"; 
		
		// ? 매핑
			pstmt.setInt(1, 1);
			pstmt.setString(2, "9788936433598");
			pstmt.setString(3, "채식주의자");
			pstmt.setString(4, "한강");
			pstmt.setString(5, "창비");
			pstmt.setInt(6, 247);
			pstmt.setInt(7, 10000);
			pstmt.setInt(8, 7);
			pstmt.setInt(9, 1);
			// 4. 쿼리 실행
			addCnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			System.err.println("SQL 구문 실행 오류" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			try {
				if(pstmt != null) {
					pstmt.close();
					}
				if(conn != null) {
					conn.close();
					}
				} catch (SQLException e) {
					System.err.println("자원 해제시 오류" + e.getMessage());
					e.printStackTrace();
				}
			}
		return addCnt;
	}
		
		
	

	@Override
	public int remove(Book book) throws NotFoundException {
		// DELETE 필요 객체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rmCnt = 0;
		
		// 2. 커넥션 맺기
		try {
			conn = DriverManager.getConnection(URL, PASSWORD, USER);
		} catch (SQLException e) {
			System.err.println("커넥션 오류" + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			// 3. 쿼리 준비
			String sql = "DELETE Book b"  
					+ "    WHERE b.sequence = ?";
			
			// ? 매핑
			pstmt.setInt(1, 1);
			
			// 4. 쿼리 실행
			rmCnt = pstmt.executeUpdate();
			// 5. 결과 처리
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
				try {
					if(pstmt != null) {
					pstmt.close();
					}
					if(conn != null) {
					conn.close();	
					}
				} catch (SQLException e) {
					System.err.println("자원 해제 오류" + e.getMessage());
					e.printStackTrace();
				}
			}
		return rmCnt;
	}


	@Override
	public Book get(Book book) throws NotFoundException {
		// SELECT 1건 필요 객체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		// 리턴 할 수 있는 Book 타입으로 포장
		Book returnBook = new Book();
		
		// 2. 커넥션 맺기
		try {
			conn = DriverManager.getConnection(URL, PASSWORD, USER);
		} catch (SQLException e) {
			System.err.println("커넥션 에러" + e.getMessage());
			e.printStackTrace();
		}
		
		try {
		// 3. 쿼리 준비
		String sql = "SELECT b.sequence" 
				+ "         , b.isbn" 
				+ "         , b.title"  
				+ "         , b.author"  
				+ "         , b.company"  
				+ "         , b.total_page"  
				+ "         , b.price"  
				+ "         , b.quantity" 
				+ "      FROM BOOK b"  
				+ " WHERE b.sequence = 1";
		
		// 4. 쿼리 실행
			pstmt = conn.prepareStatement(sql);
			// 5. 결과 처리
			pstmt.executeQuery();
		
			while (result.next()) {
				int sequence = result.getInt(1);
				String isbn = result.getString(2);
				String title = result.getString(3);
				String author = result.getString(4);
				String company = result.getString(5);
				int totalPage = result.getInt(6);		
				int price = result.getInt(7);
				int quantity = result.getInt(8);
				
				
				
				
				returnBook.setSequence(sequence);
				returnBook.setIsbn(isbn);
				returnBook.setTitle(title);
				returnBook.setAuthor(author);
				returnBook.setCompany(company);
				returnBook.setTotalPage(totalPage);
				returnBook.setPrice(price);
				returnBook.setQuantity(quantity);
				
			}
		
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			try {
				if(result != null) {
					result.close();
				}
				if(pstmt != null) {
						pstmt.close();
				}
				if(conn != null) {
						conn.close();
				} 
			}catch (SQLException e) {
					System.err.println("자원 해제 오류" + e.getMessage());
					e.printStackTrace();
				}
			}							
		return returnBook;
	}

	@Override
	public List<Book> getAllBooks() {
		// SELECT 전체행 필요 객체 선언
		
		// 2. 커넥션 맺기
		
		// 3. 쿼리 준비
		
		// 4. 쿼리 실행
		
		// 5. 결과 처리
		
		// 6. 자원 해제
		return null;
	}
	
	
	private boolean isExists(Book book) {
		boolean exists = false;
		// SELECT 1건 필요 객체 선언
		
		// 2. 커넥션 맺기
		
		// 3. 쿼리 준비
		
		// 4. 쿼리 실행
		
		// 5. 결과 처리
		
		// 6. 자원 해제
		return exists;
	}

	@Override
	public List<Book> getBooksByTitle(String title) {
		// SELECT title 포함된 
		// 책목록 조회 필요 객체 선언
		
		// 2. 커넥션 맺기
		
		// 3. 쿼리 준비
		
		// 4. 쿼리 실행
		
		// 5. 결과 처리
		
		// 6. 자원 해제
		return null;
	}

	@Override
	public List<Book> getBooksByPrice(int min, int max) {
		// SELECT price min ~ max 사이인 
		// min, max 값 포함 책목록 조회 
		// 필요 객체 선언
		
		// 2. 커넥션 맺기
		
		// 3. 쿼리 준비
		
		// 4. 쿼리 실행
		
		// 5. 결과 처리
		
		// 6. 자원 해제
		return null;
	}

}

