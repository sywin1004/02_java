package book.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import book.dao.ArrayBookShelf;
import book.dao.BookShelf;
import book.dao.ListBookShelf;
import book.dao.MapBookShelf;
import book.dao.SetBookShelf;
import book.vo.Book;

/**
 * 입력 매개변수의 값에 따라
 * 배열 구현
 * 리스트 구현
 * 맵 구현
 * 셋 구현
 * 
 * 책장을 종류별로 만들어서
 * BookShelf 인터페이스 타입의
 * 인스턴스로 리턴
 * @author Administrator
 *
 */
public class DaoFactory {
	
	public static BookShelf getBookShelf(String type) {
		BookShelf bookShelf = null;
		
		if("list".equals(type)) {
			bookShelf = new ListBookShelf(new ArrayList<Book>());
		} else if ("set".equals(type)) {
			bookShelf = new SetBookShelf(new HashSet<Book>());
		} else if ("map".equals(type)) {
			bookShelf = new MapBookShelf(new HashMap<Integer, Book>());
		} else {
			bookShelf = new ArrayBookShelf(new Book[] {});
		}
		
		return bookShelf;
	}
}
