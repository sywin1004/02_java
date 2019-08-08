package book.view;

/**
 * 북매니저가 어떤 작업에 대해
 * 응답하는 방식을 정의하는 인터페이스
 *  
 * @author 304
 *
 */
public interface Response {

	/**
	 * 매니저가 특정 작업에 대해 
	 * 응답하는 메소드
	 *   
	 * @param object
	 */
	public abstract void response(Object object);
}