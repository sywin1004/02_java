package book;

import book.resp.ListResp;
import book.resp.MessageResp;
import book.resp.Response;
import book.resp.SingleResp;

/**
 * 책장(BookShelf)을 사용하는 북매니저를 나타내는 클래스
 * ----------------------------------------------------- 서점의 북매니저는
 * 
 * 1. 책을 책장에 꼽거나(추가하거나) 2. 책장에서 찾아달라고 부탁받은 책을 가지고 오거나 3. 어떤 책의 수량이나 가격정보를 수정하거나
 * 4. 더 이상 판매하지 않을 책을 폐기 하고 5. 이 서점에서 파는 책 목록안내
 * 
 * 하는 등의 작업을 진행 ----------------------------------------------------- 전제 조건 : 북
 * 매니저는 책장이 어디있는지, 무엇인지 알고 있어야 한다.
 * -----------------------------------------------------
 * ================================================== 1. 캡슐화 적용 : 멤버변수는 private
 * 생성자, 메소드는 public
 * 
 * ==================================================
 * 
 * @author 304
 *
 */
public class BookManager {

	// 1. 멤버변수 선언부
	private ArrayBookShelf bookShelf;

	// 매니저가 어떤 작업 후에 어떻게 응답해야 할지를 나타내는 타입
	private Response response;

	// 2. 생성자 선언부
	// (1) 기본 생성자 명시
	public BookManager() {
		bookShelf = new ArrayBookShelf();
	}

	// (2) 매개변수 생성자 작성
	public BookManager(ArrayBookShelf bookShelf) {
		this.bookShelf = bookShelf;
	}

	// 3. 메소드 선언
	// (1) 매니저는 책 한권을 책장에 가져가서
	// 새로 꼽을 수 있다.
	public void add(Book book) {
		int addCnt = this.bookShelf.add(book);

		String message;
		response = new MessageResp();

		if (addCnt > 0) {
			message = String.format(book.toString() + "%d 건이 추가되었습니다.", addCnt);
		} else {
			message = String.format(book.toString() + "가 이미 존재합니다.");
		}
		response.response(message);
	}

	/**
	 * 책 한권을 폐기(삭제)함
	 * ------------------------------------------------------------------------ 책을
	 * 삭제하려 할 때, 매니저는 삭제에 성공할 수도 실패할 수도 있다. isExists(book) 의 결과 책이 있으면 삭제에 성공이고 책이
	 * 없으면 삭제에 실패일 것이다. 이 두가지 경우 모두 성공/실패에 관한 메시지만 발생할 것이므로 매니저의 응답을 담당할 Response 의
	 * 실제 인스턴스는 String 메시지를 처리할 수 있는 MessageResp 타입으로 생성하여 사용하면 된다.
	 * -------------------------------------------------------------------------
	 * 
	 * @param book
	 */
	public void remove(Book book) {
		int rmCnt = this.bookShelf.remove(book);

		String message;
		response = new MessageResp();

		if (rmCnt > 0) {
			message = String.format(book.toString() + "%d 건이 삭제되었습니다.", rmCnt);
		} else {
			message = "삭제하려는 도서가 존재하지 않습니다.";
		}

		response.response(message);
	}

	/**
	 * 매니저는 책장에서 찾아달라고 고객이 요청한 책 한개를 가지고 올 수 있다. 이 때 책을 가져오며 책의 정보를 알려주는 응답을 한다.
	 * 
	 * 이제 매니저가 직접 응답을 할 것이므로 리턴타입을 Book --> void 로 변경한다.
	 * ------------------------------------------------------------------- 찾는 책을 가져올
	 * 때, 매니저는 찾기에 성공할 수도 있고 실패할 수도 있다. findBook(book) 결과 책이 있으면 해당 책을 가져올 것이고 책이
	 * 없으면 가져오기에 실패할 것이다. 이 두가지 경우 찾기 성공일 때는 책 1개의 정보 출력을 하면 되고 찾기 실패의 경우 실패 메시지가
	 * 발생할 것이다. 따라서 성공의 경우에는 SingleResp 타입으로 응답하고 실패의 경우에는 MesssageResp 타입으로 응답할 수
	 * 있도록 각각 Response 를 달리 생성하여 사용하면 된다.
	 * -------------------------------------------------------------------
	 * 
	 * @param book
	 */
	public void get(Book book) {
		Book findBook = this.bookShelf.get(book);

		if (findBook != null) {
			// 책 한건의 정보를 출력하는 기능을 담당하는 응답 타입인
			// SingleResp 타입으로 응답 인스턴스를 생성하고
			response = new SingleResp();
			// 바로 찾은 findBook 객체를 넘겨 찾은 책의 정보를 출력한다.
			response.response(findBook);
		} else {
			// 찾은 책이 없는 경우는 찾는 도서가 없습니다. 라는 메시지를 처리할 수 있어야 하므로
			// 메시지를 처리할 수 있는 MessageResp 타입으로
			// 응답 인스턴스를 생성하고
			response = new MessageResp();
			// 이렇게 생성한 response 객체에 찾기 실패 메시지를 출력하도록 한다.
			response.response("찾는 도서가 존재하지 않습니다.");
		}
	}

	/**
	 * 매니저는 책장에 가서 판매 가격 등 책의 정보를 수정할 수 있다.
	 * ------------------------------------------------------------------ 책을 수정하려 할
	 * 때, 매니저는 수정에 성공할 수도 실패할 수도 있다. isExists(book) 의 결과 책이 있으면 수정에 성공이고 책이 없으면 수정에
	 * 실패일 것이다. 이 두가지 경우 모두 성공/실패에 관한 메시지만 발생할 것이므로 매니저의 응답을 담당할 Response 의 실제 인스턴스는
	 * String 메시지를 처리할 수 있는 MessageResp 타입으로 생성하여 사용하면 된다.
	 * 
	 * @param book
	 */
	public void set(Book book) {
		int setCnt = this.bookShelf.set(book);

		String message;
		response = new MessageResp();
		if (setCnt > 0) {
			message = String.format(book.toString() + " %d 건을 수정하였습니다.", setCnt);
		} else {
			message = "수정하려는 도서가 존재하지 않습니다.";
		}

		response.response(message);
	}

	// (5) 매니저는 서점에서 판매되고 있는 책의 목록을
	// 보여줄 수 있다. 조회할 수 있다.
	public void getAllBooks() {
		response = new ListResp();
		response.response(bookShelf.getAllBooks());
	}

}