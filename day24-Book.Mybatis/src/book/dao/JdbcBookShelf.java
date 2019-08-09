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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;
import book.vo.Price;

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
		int addCnt = -1;
		
		// 동일한 키로 등록된 책 정보가 존재하는지 검사
		// 있으면 중복 예외 발생
		if (isExists(book))
			throw new DuplicateException("add", book);
		
		try {
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 3. 쿼리 준비
			String sql = "INSERT INTO BOOK b (b.sequence, b.isbn, b.title, b.author"
					   + "                  , b.company, b.total_page, b.price, b.quantity) " 
					   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getSequence());
			pstmt.setString(2, book.getIsbn());
			pstmt.setString(3, book.getTitle());
			pstmt.setString(4, book.getAuthor());
			pstmt.setString(5, book.getCompany());
			pstmt.setInt(6, book.getTotalPage());
			pstmt.setInt(7, book.getPrice());
			pstmt.setInt(8, book.getQuantity());
			
			// 4. 쿼리 실행
			addCnt = pstmt.executeUpdate();
			
			// 5. 결과 처리
			// 4의 리턴값이 곧 결과
			
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류!" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			closeResources(conn, pstmt, null);
		}
		
		return addCnt;
	}

	@Override
	public int set(Book book) throws NotFoundException {
		// UPDATE 필요 객체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int setCnt = -1;
		
		if (!isExists(book)) 
			throw new NotFoundException("set", book);
		
		try {
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 3. 쿼리 준비.
			// PK 인 sequence 컬럼은 바꾸지 않도록 UPDATE 구문을 짭니다.
			String sql = "UPDATE BOOK b" 
			           + "   SET b.isbn = ?" 
					   + "     , b.title = ?" 
			           + "     , b.author = ?" 
					   + "     , b.company = ?" 
			           + "     , b.total_page = ?" 
					   + "     , b.price = ?" 
			           + "     , b.quantity = ?" 
					   + "     , b.mod_date = sysdate" 
			           + " WHERE b.sequence = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getCompany());
			pstmt.setInt(5, book.getTotalPage());
			pstmt.setInt(6, book.getPrice());
			pstmt.setInt(7, book.getQuantity());
			pstmt.setInt(8, book.getSequence());
			
			// 4. 쿼리 실행
			setCnt = pstmt.executeUpdate();
			
			// 5. 결과 처리
			// 4의 리턴값이 곧 결과
			
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류!" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			closeResources(conn, pstmt, null);
		}
		
		return setCnt;
	}

	@Override
	public int remove(Book book) throws NotFoundException {
		// DELETE 필요 객체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rmCnt = -1;
		
		if (!isExists(book)) 
			throw new NotFoundException("remove", book);
		
		try {
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			// 3. 쿼리 준비.
			// PK 인 sequence 로 걸어서 DELETE 구문을 작성합니다.
			String sql = "DELETE BOOK b " 
			           + " WHERE b.sequence = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getSequence());
			
			// 4. 쿼리 실행
			rmCnt = pstmt.executeUpdate();
			
			// 5. 결과 처리
			// 4의 리턴값이 곧 결과
			
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류!" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			closeResources(conn, pstmt, null);
		}
		
		return rmCnt;
	}

	@Override
	public Book get(Book book) throws NotFoundException {
		// SELECT 1건 필요 객체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		Book foundBook = null;
		
		if (!isExists(book)) 
			throw new NotFoundException("get", book);
		
		try {
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "SELECT b.sequence" 
					+ "     , b.isbn" 
					+ "     , b.title" 
					+ "     , b.author" 
					+ "     , b.company" 
					+ "     , b.total_page" 
					+ "     , b.price" 
					+ "     , b.quantity" 
					+ "     , b.reg_date" 
					+ "     , b.mod_date" 
					+ "  FROM BOOK b" 
					+ " WHERE b.sequence = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getSequence());
			
			// 4. 쿼리 실행
			result = pstmt.executeQuery();
			
			// 5. 결과 처리
			// 1건만 조회될 것이므로 while 대신 if 를 사용
			if (result.next()) {
				foundBook = new Book();
				
				foundBook.setSequence(result.getInt(1));
				foundBook.setIsbn(result.getString(2));
				foundBook.setTitle(result.getString(3));
				foundBook.setAuthor(result.getString(4));
				foundBook.setCompany(result.getString(5));
				foundBook.setTotalPage(result.getInt(6));
				foundBook.setPrice(result.getInt(7));
				foundBook.setQuantity(result.getInt(8));
			}
			
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류!" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			closeResources(conn, pstmt, result);
		}
		
		return foundBook;
	}

	@Override
	public List<Book> getAllBooks() {
		// SELECT 전체행 필요 객체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Book> books = new ArrayList<>();
		
		try {
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "SELECT b.sequence" 
					+ "     , b.isbn" 
					+ "     , b.title" 
					+ "     , b.author" 
					+ "     , b.company" 
					+ "     , b.total_page" 
					+ "     , b.price" 
					+ "     , b.quantity" 
					+ "     , b.reg_date" 
					+ "     , b.mod_date" 
					+ "  FROM BOOK b" ;
			
			pstmt = conn.prepareStatement(sql);
			
			// 4. 쿼리 실행
			result = pstmt.executeQuery();
			
			// 5. 결과 처리
			while (result.next()) {
				Book book = new Book();
				
				book.setSequence(result.getInt(1));
				book.setIsbn(result.getString(2));
				book.setTitle(result.getString(3));
				book.setAuthor(result.getString(4));
				book.setCompany(result.getString(5));
				book.setTotalPage(result.getInt(6));
				book.setPrice(result.getInt(7));
				book.setQuantity(result.getInt(8));
				
				books.add(book);
				
			}
			
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류!" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			closeResources(conn, pstmt, result);
		}
		
		return books;
	}

	@Override
	public List<Book> getBooksByTitle(String title) {
		// SELECT title 포함된 
		// 책목록 조회 필요 객체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Book> books = new ArrayList<>();
		
		try {
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "SELECT b.sequence" 
					+ "     , b.isbn" 
					+ "     , b.title" 
					+ "     , b.author" 
					+ "     , b.company" 
					+ "     , b.total_page" 
					+ "     , b.price" 
					+ "     , b.quantity" 
					+ "     , b.reg_date" 
					+ "     , b.mod_date" 
					+ "  FROM BOOK b" 
					+ " WHERE b.title LIKE ? ";
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, String.format("%%%s%%", title));
			// 위의 String.format 구문은 아래의 구문과 동일함
//			pstmt.setString(1, "%" + title + "%");
			
			// 4. 쿼리 실행
			result = pstmt.executeQuery();
			
			// 5. 결과 처리
			while (result.next()) {
				Book book = new Book();
				
				book.setSequence(result.getInt(1));
				book.setIsbn(result.getString(2));
				book.setTitle(result.getString(3));
				book.setAuthor(result.getString(4));
				book.setCompany(result.getString(5));
				book.setTotalPage(result.getInt(6));
				book.setPrice(result.getInt(7));
				book.setQuantity(result.getInt(8));
				
				books.add(book);
				
			}
			
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류!" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			closeResources(conn, pstmt, result);
		}
		
		return books;
	}

	@Override
	public List<Book> getBooksByPrice(int min, int max) {
		// SELECT price min ~ max 사이인 
		// min, max 값 포함 책목록 조회 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Book> books = new ArrayList<>();
		
		try {
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "SELECT b.sequence" 
					+ "     , b.isbn" 
					+ "     , b.title" 
					+ "     , b.author" 
					+ "     , b.company" 
					+ "     , b.total_page" 
					+ "     , b.price" 
					+ "     , b.quantity" 
					+ "     , b.reg_date" 
					+ "     , b.mod_date" 
					+ "  FROM BOOK b" 
					+ " WHERE b.price BETWEEN ? AND ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);
			
			// 4. 쿼리 실행
			result = pstmt.executeQuery();
			
			// 5. 결과 처리
			while (result.next()) {
				Book book = new Book();
				
				book.setSequence(result.getInt(1));
				book.setIsbn(result.getString(2));
				book.setTitle(result.getString(3));
				book.setAuthor(result.getString(4));
				book.setCompany(result.getString(5));
				book.setTotalPage(result.getInt(6));
				book.setPrice(result.getInt(7));
				book.setQuantity(result.getInt(8));
				
				books.add(book);
			}
			
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류!" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			closeResources(conn, pstmt, result);
		}
		
		return books;
	}
	
	@Override
	public List<Book> getBooksByPrice(Price price) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		List<Book> books = new ArrayList<>();
		
		try {
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "SELECT b.sequence" 
					+ "     , b.isbn" 
					+ "     , b.title" 
					+ "     , b.author" 
					+ "     , b.company" 
					+ "     , b.total_page" 
					+ "     , b.price" 
					+ "     , b.quantity" 
					+ "     , b.reg_date" 
					+ "     , b.mod_date" 
					+ "  FROM BOOK b" 
					+ " WHERE b.price BETWEEN ? AND ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, price.getMin());
			pstmt.setInt(2, price.getMax());
			
			// 4. 쿼리 실행
			result = pstmt.executeQuery();
			
			// 5. 결과 처리
			while (result.next()) {
				Book book = new Book();
				
				book.setSequence(result.getInt(1));
				book.setIsbn(result.getString(2));
				book.setTitle(result.getString(3));
				book.setAuthor(result.getString(4));
				book.setCompany(result.getString(5));
				book.setTotalPage(result.getInt(6));
				book.setPrice(result.getInt(7));
				book.setQuantity(result.getInt(8));
				
				books.add(book);
			}
			
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류!" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			closeResources(conn, pstmt, result);
		}
		
		return books;
	}

	
	/**
	 * 전달된 book 정보가 데이터베이스 테이블에 이미 존재하는지 검사
	 * @param book
	 * @return
	 */
	private boolean isExists(Book book) {
		boolean exists = false;

		// SELECT 1건 필요 객체 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		
		try {
			// 2. 커넥션 맺기
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. 쿼리 준비
			String sql = "SELECT b.sequence" 
					   + "  FROM BOOK b" 
					   + " WHERE b.sequence = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getSequence());
			
			// 4. 쿼리 실행
			result = pstmt.executeQuery();
			
			// 5. 결과 처리
			// 1건만 조회될 것이므로 while 대신 if 를 사용
			if (result.next()) {
				exists = true;
			}
			
		} catch (SQLException e) {
			System.err.println("SQL 구문 오류!" + e.getMessage());
			e.printStackTrace();
		} finally {
			// 6. 자원 해제
			closeResources(conn, pstmt, result);
		}
		return exists;
	}
	
	/**
	 * 자원 해제 반복 코드를 줄이기 위한 메소드
	 * @param conn
	 * @param stmt
	 * @param result
	 */
	private void closeResources(Connection conn, Statement stmt, ResultSet result) {
		try {
			if (result != null) {
				result.close();
			}
			
			if (stmt != null) {
				stmt.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.err.println("자원 해제 오류!" + e.getMessage());
			e.printStackTrace();
		}
	}
}

