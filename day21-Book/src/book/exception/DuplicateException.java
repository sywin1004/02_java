package book.exception;

import book.vo.Book;

/**
 * 책 정보를 신규 입력할 때,
 * 책 정보가 중복인 경우
 * 발생시킬 예외 정의 클래스
 * @author Administrator
 *
 */
public class DuplicateException extends Exception {
	
	// 2. 생성자
	
	public DuplicateException() {
		super("도서 정보가 중복되었습니다.");
	}
	
	public DuplicateException(String type, Book book) {
		super(String.format("%s:[%d] 도서 정보가 중복되었습니다.", type, book.getSequence()));
	}
	
}
