package book.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import book.vo.Book;

/**
 * Set 으로 만들어진 책장 구현 클래스
 * 
 * @author 304
 *
 */
public class SetBookShelf implements BookShelf {

	// 1. 멤버변수
	Set<Book> books;
	
	// 2. 생성자
	// (1) 기본생성자
	public SetBookShelf() {
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
		
		if (books.add(book)) {
			addCnt++;
		}
		
		return addCnt;
	}

	@Override
	public int set(Book book) {
		/*
		 * Set 구조에서 
		 * set:데이터 수정 은
		 * 기존 값 제거 후 수정할 값 추가
		 */
		int setCnt = 0;
		
		if (books.remove(book)) {
			books.add(book);
			setCnt++;
		}
		
		return setCnt;
	}

	@Override
	public int remove(Book book) {
		int rmCnt = 0;
		
		if (books.remove(book)) {
			rmCnt++;
		}
		
		return rmCnt;
	}

	@Override
	public Book get(Book book) {
		Book findBook = null;

		for (Book inBook: books) {
			if (inBook.equals(book)) {
				findBook = inBook;
				break;
			}
		}
		
		return findBook;
	}

	@Override
	public List<Book> getAllBooks() {
		// Set<Book> ===> List<Book> 
		// (1) API 메소드 사용하여 변환
		List<Book> bookList = 
				Arrays.asList(books.toArray(new Book[] {}));
		
//		List<Book> bookList = new ArrayList<>();
//		for (Book book: books) {
//			bookList.add(book);
//		}
		
		return bookList;
	}

}
