package book.view;

import java.util.List;

import book.vo.Book;

public class ListResp implements Response {

	/**
	 * 입력된 데이터가 전체 책 목록(배열)일 때
	 * 전체 목록을 출력 
	 */
	@Override
	public void response(Object object) {

		List<Book> books = (List<Book>) object;
		if (books != null) {
			for (Book book: books) {
				System.out.println(book);
			}
		}
	}


}