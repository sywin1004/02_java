package book.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import book.exception.DuplicateException;
import book.exception.NotFoundException;
import book.vo.Book;
import book.vo.Price;

/**
 * Map 구조로 구현된 책장 클래스
 * 
 * key   : Book.sequence 필드로 사용
 * value : Book 인스턴스 자체
 * 
 * @author 304
 *
 */
public class MapBookShelf implements BookShelf {
	
	// 1. 멤버변수
	private Map<Integer, Book> books;

	// 2. 생성자
	// (1) 기본생성자
	public MapBookShelf() {
		books = new HashMap<>(); 
	}
	
	// (2) 매개변수 생성자
	public MapBookShelf(Map<Integer, Book> books) {
		this.books = books; 
	}
	
	@Override
	public int add(Book book) throws DuplicateException {
		int addCnt = 0;
		
		// 키가 존재하지 않는 경우만 신규 추가
		if (!isExists(book)) {
			books.put(book.getSequence(), book);
			addCnt++;
		} else {
			throw new DuplicateException("add", book);
		}
		
		return addCnt;
	}

	@Override
	public int set(Book book) throws NotFoundException {
		int setCnt = 0;
		
		// 수정할 책의 키가 존재하는 경우만
		if (isExists(book)) {
			books.put(book.getSequence(), book);
			setCnt++;
		} else {
			throw new NotFoundException("set", book);
		}
		
		return setCnt;
	}

	@Override
	public int remove(Book book) throws NotFoundException {
		int rmCnt = 0;
		
		// 수정할 책의 키가 존재하는 경우만
		if (isExists(book)) {
			books.remove(book.getSequence());
			rmCnt++;
		} else {
			throw new NotFoundException("remove", book);
		}
		
		return rmCnt;
	}

	@Override
	public Book get(Book book) throws NotFoundException {
		Book found = null;
		
		if (isExists(book))	{
			found = books.get(book.getSequence());
		} else {
			throw new NotFoundException("get", book);
		}
		
		return found;
	}

	@Override
	public List<Book> getAllBooks() {
		// Map 에는 값들만 취해서 Collection 에 Generic 이
		// 적용된 형태로 만들어주는 valuse() 메소드가 있으므로
		// 그 메소드를 적용하여 Map 의 값들만 추출
		Collection<Book> collection = books.values();
		
		// Collection 인터페이스에는 컬렉션을 배열로 만들어주는
		// toArray() 메소드가 존재
		// 이 때, 매개변수로 만들 배열의 타입을 지정해서 넣어주면
		// Object[] 이 아닌 특정 타입의 배열로 리턴받을 수 있음.
		Book[] books = collection.toArray(new Book[] {});
		
		// 그렇게 만들어진 배열을 리스트로 변경
		return Arrays.asList(books);
	}
	
	// 필요시 private 메소드 추가
	/**
	 * Map 인터페이스가 가지고 있는 
	 * containsKey() 메소드를 사용하여
	 * 키를 넘기며 그 키가 있으면 true, 
	 * 아니면 false 를 리턴받아
	 * 키 존재 여부를 살피는 메소드
	 * 
	 * @param book
	 * @return
	 */
	private boolean isExists(Book book) {
		return books.containsKey(book.getSequence());
	}

	@Override
	public List<Book> getBooksByTitle(String title) {
		List<Book> books = new ArrayList<>();
		
		for (Book book: getAllBooks()) {
			// 매개변수로 입력된 title 이 getAllBooks()로 얻는 리스트에 들어있는 각 
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
		
		for (Book book: getAllBooks()) {
			// getAllBooks()로 얻는 리스트에 있는 각 Book 객체의 가격이
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
		
		for (Book book: getAllBooks()) {
			// getAllBooks() 로 얻는 리스트에 있는 각 Book 객체의 가격이
			// price 객체의 min보다 크거나 같고, 
			// price 객체의 max 보다 작거나 같은 조건을 동시에 만족시키면
			if (book.getPrice() >= price.getMin() && book.getPrice() <= price.getMax()) {
				books.add(book);
			}
		}
		
		return books;
	}

}