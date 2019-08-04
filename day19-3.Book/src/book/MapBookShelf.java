package book;

import java.util.List;
import java.util.Map;

/**
 * Map 구조로 구현된 책장 클래스
 * 
 * @author Administrator
 *
 */
public class MapBookShelf implements BookShelf {
	
	// 1. 멤버변수
	private Map<Integer, Book> books;
	
	// 2. 생성자
	// (1) 기본생성자
	public Map<Integer, Book>(){
		
	}
	
	
	// (2) 매개변수 생성자
	
	@Override
	public int add(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int set(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book get(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

}
