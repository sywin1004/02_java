package divider;

/**
 * 0으로 나누려는 시도가 있을 때 
 * 발생시킬 예외를 정의하는 클래스
 * ------------------------------------
 * 모든 예외 클래스는 일반 클래스와 동일하게 정의 가능
 * ------------------------------------
 * 예외 클래스를 정의할 때 주의 점.
 * 1. 멤버 변수, 생성자, 메소드 정의는 동일
 * 2. Exception 클래스를 반드시 상속
 * 3. 클래스 이름 마지막에 Exception 으로 끝나도록 하여 이 클래스가 예외 클래스임을 명시
 * ------------------------------------- 
 * 예외 객체 사용시 주의 점.
 * 1. new 로 생성하는 것은 다른 클래스 객체와 동일
 * 2. new 로 생성 후
 *    throw (던져서) [발생] 시켜야 사용 되기 시작.
 * --------------------------------------
 * @author Administrator
 *
 */
public class DivideZeroException extends Exception {
	
	// 1. 멤버 변수 선언
	/** 예외의 이유를 저장하는 변수 */
	private String reason;
	
	// 2. 생성자 선언
	// (1) 기본 생성자 : 발생 이유(reason) 을 직접 할당.
	public DivideZeroException() {
		this.reason = "0 으로 나누려는 시도가 있습니다.";
	}
	
	// (2) 매개변수 생성자 : 발생 이유를 외부에서 전달받음
	public DivideZeroException(String reason) {
		this.reason = reason;
	}
	
	// 3. 메소드 선언
	@Override
	public String toString() {
		return this.reason;
	}
	
}
