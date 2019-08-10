package book.dao;

import java.util.ArrayList;
import java.util.List;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;
import book.vo.Price;

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
		int setCnt = 0;
		
		if (isExists(book)) {
			int index = findBookIndex(book);
			if (index > -1) {
				books.set(index, book);
				setCnt++;
			}
			
		} else {
			throw new NotFoundException("set", book);
		}
		return setCnt;
	}

	@Override
	public int remove(Book book) throws NotFoundException {
		int rmCnt = 0;
		
		if (isExists(book)) {
			if (books.remove(book)) {
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
		if (index > -1) {
			findBook = books.get(index);
			
		} else {
			throw new NotFoundException("get", book);
		}
		
		return findBook;
	}

	@Override
	public List<Book> getAllBooks() {		
		return books;
	}

	/**
	 * 매개변수로 입력된 book 이
	 * 이미 리스트에 존재하는지 여부를 검사하는 메소드
	 * 
	 * @param book
	 * @return
	 */
	private boolean isExists(Book book) {
		boolean exists = false;
		
		for (Book findBook: books) {
			if (findBook.equals(book)) {
				exists = true;
				break;
			}
		}
		
		return exists;
	}

	/**
	 * 찾을 책이 존재하는 리스트의 
	 * 인덱스를 리턴하는 메소드
	 * 없는 경우 -1 리턴
	 * @param book
	 * @return
	 */
	private int findBookIndex(Book book) {
		int index = -1;
		
		for (int idx = 0; idx < books.size(); idx++) {
			if (books.get(idx).equals(book)) {
				index = idx;
				break;
			}
		}
		
		return index;
	}

	@Override
	public List<Book> getBooksByTitle(String title) {
		List<Book> books = new ArrayList<>();
		
		for (Book book: this.books) {
			// 매개변수로 입력된 title 이 this.books 리스트에 들어있는 각 
			// Book 객체의 제목에 포함(contains() ) 되어 있으면
			if (book.getTitle().contains(title)) {
				books.add(book);
			}
		}
		return books;
	}

	@Override
	public List<Book> getBooksByPrice(int min, int max) {
		List<Book> books = new ArrayList<>();
		
		for (Book book: this.books) {
			// this.books 리스트에 있는 각 Book 객체의 가격이
			// min보다 크거나 같고, max 보다 작거나 같은 조건을 동시에 만족시키면
			if (book.getPrice() >= min && book.getPrice() <= max) {
				books.add(book);
			}
		}
		
		return books;
	}

	@Override
	public List<Book> getBooksByPrice(Price price) {
		List<Book> books = new ArrayList<>();
		
		for (Book book: this.books) {
			// this.books 리스트에 있는 각 Book 객체의 가격이
			// price 객체의 min보다 크거나 같고, 
			// price 객체의 max 보다 작거나 같은 조건을 동시에 만족시키면
			if (book.getPrice() >= price.getMin() && book.getPrice() <= price.getMax()) {
				books.add(book);
			}
		}
		
		return books;
	}
}

