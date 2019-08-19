package book.mapper;

import java.util.List;

import book.vo.Book;

public interface BookMapper {
	
	public Book isExists (Book book);
	
	/**
	 * 책들의 모든 정보를 가져오는 메소드
	 * @return
	 */
	public List<Book> getAllBooks();
	
	
}
	