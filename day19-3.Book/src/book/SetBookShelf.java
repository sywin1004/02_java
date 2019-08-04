package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Set 으로 만들어진 책장 구현 클래스
 * @author Administrator
 *
 */
public class SetBookShelf implements BookShelf {

	// 1. 멤버변수
	Set<Book> books;
	
	// 2. 생성자
	// (1) 기본생성자
	
	public public SetBookShelf() {
		// books 를 HashSet 으로 직접 초기화
		books = new HashSet<>();
	}
	
	// (2) 매개변수 생성자
	public SetBookShelf(Set<Book> books) {
		this.books = books;
	}
	
	
	@Override
	public int add(Book book) {
		int addCnt = 0;
		
		if(books.add(book)) {
			addCnt++;
		}
		
		return addCnt;
	}

	@Override
	public int set(Book book) {
		int setCnt = 0;
		return 0;
	}

	@Override
	public int remove(Book book) {
		int rmCnt = 0;
		if(books.remove(book)) {
			rmCnt++;
		}
		return rmCnt;
	}

	@Override
	public Book get(Book book) {
		Book findBook = null;
		
		for(Book inBook: books) {
			if(inBook.equals(book)){
				findBook = inBook;
				break;
			}
		}
		
		
		return findBook;
	}

	@Override
	public List<Book> getAllBooks() {
		// Set<Book> ==> List<Book>

		// (1) API 메소드 사용하여 변환
		Book[] bookArray = (Book[])books.toArray();
		List<Object> bookList = Arrays.asList(bookArray);
//		Arrays.asList((Book[])books.toArray());
		
		// foreach 반복문을 돌려서 변환
//		List<Book> bookList = new ArrayList<>();
//		for(Book book: books) {
//			bookList.add(book);
//		}
		
		
		return bookList;
	}

}
