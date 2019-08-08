package book.dao;

import java.util.ArrayList;
import java.util.List;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;

public class ListBookShelf implements BookShelf {
	
	// 1. 멤버변수
	private List<Book> books;
	
	// 2. 생성자
	// (1) 기본생성자
	public ListBookShelf() {
		books = new ArrayList<>();
	}
	
	// (2) 매개변수 생성자
	public ListBookShelf(List<Book> books) {
		System.out.println("ListBookShelf 입니다.");
		this.books = books;
	}
	
	
	@Override
	public int add(Book book) throws DuplicateException {
		int addCnt = 0;
		if (!isExists(book)) {
			books.add(book);
			addCnt++;
		} else {
			throw new DuplicateException("add", book);
		}
		return addCnt;
	}

	@Override
	public int set(Book book) throws NotFoundException {
		// 1. 선언, 초기
		int setCnt = 0;
		int index = findBookIndex(book);
		
		if (index > -1) {
			books.set(findBookIndex(book), book);
			setCnt++;
		} else {
			throw new NotFoundException("set", book);
		}
		return setCnt;
	}

	@Override
	public int remove(Book book) throws NotFoundException {
		int rmCnt = 0;
		
		if (isExists(book)) {
			if(books.remove(book)) {
				rmCnt++;
			}
		} else {
			throw new NotFoundException("remove", book);
		}
		return rmCnt;
	}

	@Override
	public Book get(Book book) throws NotFoundException {
		Book findBook = null;
		
		int index = findBookIndex(book);
		if(index > -1) {
			findBook = books.get(index);
		} else {
			throw new NotFoundException("get", book);
		}
		return findBook;
	}

	@Override
	public List<Book> getAllBooks() {
		return this.books;
	}
	
	/**
	 * 매개변수로 입력된 book 이
	 * 이미 리스트에 존재하는지 여부를 검사하는 메소드
	 * @param book
	 * @return
	 */
	private boolean isExists(Book book) {
		boolean exists = false;
		
		for(Book findBook: books) {
			if (findBook.equals(book)) {
				exists = true;
				break;
			}
		}
		return exists;
	}
	
	private int findBookIndex(Book book) {
		int index = 1;
		
		for(int idx = 0; idx < books.size(); idx++) {
			if (books.get(idx).equals(book)) {
				index = idx;
				break;
			}
		}
		return index;
	}	

}
