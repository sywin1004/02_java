package book.dao;

import java.util.List;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;

/**
 * 일반적인 책장의 기능을 정의하는 인터페이스
 * 
 * @author Administrator
 *
 */
public interface BookShelf {
	
	/**
	 * 책 한권을 책장에 추가하는 메소드
	 * 
	 * @param book 추가할 책
	 * @return 추가에 성공한 책의 갯수
	 * @exception 추가하려는 책이 동일한 일련번호가 존재하는 경우
	 */
	public abstract int add(Book book) throws DuplicateException;
	
	/**
	 * 책 한권의 정보를 수정하는 메소드
	 * @param book 수정할 책 정보
	 * @return  수정에 성공한 책의 갯수
	 * @exception 수정하려는 책이 존재하지 않는 경우
	 */
	public abstract int set(Book book) throws NotFoundException;
	
	/**
	 * 책 한권의 정보를 제거(폐기) 하는 메소드
	 * @param book 삭제할 책의 정보
	 * @return 삭제에 성공한 책의 갯수
	 */
	public abstract int remove(Book book) throws NotFoundException;
	
	/**
	 * 책 한권의 전체 정보를 얻어내는 메소드
	 * @param book 조회할 책의 정보
	 * @return 조회된 책의 정보, 찾는 책이 없는 경우 null
	 */
	public abstract Book get(Book book) throws NotFoundException;
	
	/**
	 * 책장에 추가되어있는 모든 책 목록을 얻어내는 메소드
	 * @return
	 */
	public abstract List<Book> getAllBooks();
	
	/**
	 * 제목에 검색어 title 이 포함된 책의 목록을 조회하여 리턴
	 * @param title
	 * @return 책 목록
	 */
	public abstract List<Book> getBooksByTitle(String title);
	
	/**
	 * 책의 가격이 min ~ mas (포함)
	 * 사이인 책 목록을 조회하여 리턴
	 * @param min
	 * @param max
	 * @return
	 */
	public abstract List<Book> getBooksByPrice(int min, int max);
}

	/**
	 * 내부에 가격검색 최저가, 최고가가
	 * 함께 들어있는 Price 타입의 객체 하나를 받아서
	 * 도서 검색 결과를 리턴하는 메소드
	 * @param price
	 * @return
	 */
	public abstract List<Book> getBooksByPrice(Price price);
}
