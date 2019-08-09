package book.factory;

import book.view.ListResp;
import book.view.MessageResp;
import book.view.Response;
import book.view.SingleResp;

/**
 * 입력된 response 의 타입 값에 따라서
 * 목록 뷰(ListResp)
 * 한건 뷰(SingleResp)
 * 메세지 뷰(MessageResp)
 * 의 인스턴스를 생성하여 리턴하는 
 * 스태틱 메소드를 가진 클래스
 * @author Administrator
 *
 */
public class RespFactory {
	
	
	/**
	 * 매개변수로 들어온 type 값에 따라
	 * 적절한 response 인스턴스를 생성하여 리턴
	 * @param type
	 * @return Response 타입의 객체
	 */
	public static Response getResp(String type) {
		
		Response response = null;
		
		// yoda notation
		if("List".equals(type)) {
			response = new ListResp();
		} else if ("single".equals(type)) {
			response = new SingleResp();
		} else if ("message".equals(type)) {
			response = new MessageResp();
		}
		
		return response;
	}
}
