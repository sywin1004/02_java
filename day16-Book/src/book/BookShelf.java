package book;

import java.util.Arrays;

/**
 * Book 여러개가 꼽혀있어
 * 책 객체 여러개를 한번에 저장하고 
 * 관리할 수 있는 클래스
 * 
 * ==================================================
 * 1. 캡슐화 적용 : 멤버변수는 private
 *                  생성자, 메소드는 public
 *                  
 * ==================================================
 * @author 304
 *
 */
public class BookShelf {

	// 멤버변수
	private Book[] books;
	
	public BookShelf() {
		books = new Book[0];
	}
	
	public BookShelf(Book[] books) {
		this.books = books;
	}
	
	// 책장에 책을 추가 : add : void : 매개변수로 Book 1개를 받는다.
	/**
	 * 1. 리턴을 int 타입으로 변경 추가 성공한 건수를 리턴
	 * 
	 * 2. 매개변수로 입력된 book 객체가 
	 *    이미 목록에 존재하는지 여부를 
	 * 
	 *    isExists(book) 메소드를 사용하여 판단하고
	 *    isExists(book) 의 결과가 false 일 때만
	 *    현재의 추가로직이 작동하도록 변경
	 * 
	 * @param book
	 * @return 0 : 이미 같인 seq 번호의 책이 있어서
	 *             추가 실패
	 *         1 : 새 책 정보 1건이 성공적으로 추가된 경우
	 */
	public int add(Book book) {
		// 1. 리턴 값 저장변수 선언, 초기화
		int addCount = 0;
		
		// 3. 로직전개
		// 추가하려는 책이 존재하는지 판단
		if (!isExists(book)) {
		
			// 이미 존재하는 배열 + 1크기로 복사
			this.books = Arrays.copyOf(books, books.length + 1);
			
			// 1 늘어난 배열 마지막 자리에 새 book
			// (매개변수로 넘어온 것) 저장
			this.books[books.length - 1] = book;
			
			addCount++;
		}
		
		// 2. 리턴 값 저장 변수 리턴 구문 
		return addCount;
	}
	
	// 책장에서 책을 제거 : void : remove(Book book)
	/**
	 * 삭제하기 전에 목록에 book 객체가 존재하는지 먼저
	 * isExists(book) 으로 판단
	 * 
	 * 결과가 true 일 때만 삭제로직 진행    1리턴
	 * 결과가 false 이면 삭제로직 진행 없이 0리턴
	 * @param book
	 */
	public int remove(Book book) {
		// book 객체의 sequence 가 같으면 같은 책으로 판단해서
		// 삭제
		// 폐기 안하고 남는 책을 유지할 새 배열
		int rmCnt = 0;		
		Book[] newBooks;
		
		// 삭제할 책이 존재하면
		if (isExists(book)) {
			
			// 1. 폐기할 책이 위치하는 인덱스를 찾기
			int index = findBookIndex(book);
			
			// 2. 폐기할 책의 인덱스가 -1보다 크면
			//    폐기할 책이 있다는 의미로 판단하고 삭제로직 진입
			if (index > -1) {
				// 3. 폐기 안할 책을 유지할 
				//    새 배열을 지금 배열 크기 - 1 크기로 생성
				newBooks = new Book[books.length - 1];
				
				//  (1) 삭제할 책 앞쪽의 책정보는 같은 인덱스로 복사
				for (int idx = 0; idx < index; idx++) {
					newBooks[idx] = books[idx];
				}
				
				//  (2) 삭제할 책 뒤쪽의 남는 책정보는 현재 인덱스 - 1 위치로 복사
				for (int idx = index; idx < newBooks.length; idx++) {
					newBooks[idx] = books[idx + 1];
				}
				
				// 6. 남는 책이 복사된 새 배열을
				//    this.book 에 새로 저장
				this.books = newBooks;
				rmCnt++;
			} // end outer if
		}
		
		return rmCnt;
	}
	
	// 책 정보 수정 : void : set(Book book)
	/**
	 * 수정하기 전에 수정할 book 객체가
	 * 목록에 이미 존재하는지 여부를
	 * isExists(book) 수행 결과로 판단해서
	 * 
	 * true 이면 수정하고 1리턴
	 * false 이면 수정진행하지 않고 0리턴
	 * @param book
	 */
	public int set(Book book) {
		int setCnt = 0;
		if (isExists(book)) {
			// 수정할 book 이 books 배열 
			// 몇번째 인덱스에 있는지 찾는다.
			books[findBookIndex(book)] = book;
			setCnt++;
		}
		return setCnt;
	}
	
	// 책 한권 얻기 : Book : get(Book book)
	public Book get(Book book) {
		// 입력된 book의 sequence 값과
		// 내부 배열에 저장된 책들중 일치하는 sequence 를 가진
		// 책 1권의 정보를 리턴
		return findBook(book);
	}
	
	// 전체 책 목록을 얻기 : getAllBooks()
	public Book[] getAllBooks() {
		return this.books;
	}
	
	// 접근자
	public Book[] getBooks() {
		return books;
	}
	
	// 수정자
	public void setBooks(Book[] books) {
		this.books = books;
	}

	// ---------------------------------------
	/**
	 * 매개변수 전달된 책 정보와
	 * 일치하는 일련번호를 가진 책(책 배열: books 에 있는)을
	 * 찾아서 배열에 안에 들어있는 책을 리턴
	 * ---------------------------------------
	 * 같은 책을 찾는 로직을 
	 * sequence 값 직접 비교에서
	 * book 객체 비교로 변경
	 * ---------------------------------------
	 * @param book
	 * @return
	 */
	private Book findBook(Book book) {
		Book findBook = null;
		for (int idx = 0; idx < books.length; idx++) {
			if (books[idx].equals(book)) {
				// 같은 책 찾았다.
				findBook = books[idx];
				break;
			}
		}
		return findBook;
	}
	
	/**
	 * 같은 책을 찾는 로직을 
	 * sequence 값 직접 비교에서
	 * book 객체 비교로 변경
	 * 
	 * @param book
	 * @return
	 */
	private int findBookIndex(Book book) {
		int index = -1;
		for (int idx = 0; idx < books.length; idx++) {
			if (books[idx].equals(book)) {
				// 같은 책 찾았다.
				index = idx;
				break;
			}
		}
		return index;
	}

	/**
	 * 매개변수로 전달된 book(책)이 
	 * 목록(배열)에 존재하는지 여부를 검색해서
	 *  
	 * 존재하면 true
	 * 존재하지 않으면 false 
	 * 를 리턴하는 private 메소드
	 * 
	 * @param book
	 * @return true : 찾는 책이 목록에 존재, 
	 *         false : 찾는 책이 목록에 없을 때
	 */
	private boolean isExists(Book book) {
		// 리턴 값이 있는 메소드의 경우
		// 리턴 값을 저장할 변수를 선언, 초기화
		boolean exists = false;
		
		for (Book findBook: books) {
			if (findBook.equals(book)) {
				// 메소드 로직 중간에서는
				// 리턴 값을 저장하는 변수의 값을 결정만 진행
				exists = true;
				break;
			}
		}
		// 리턴 구문은 메소드 종료 직전 
		// 1번만 하는 습관 들이세요.
		return exists;
	}
	
	
}
