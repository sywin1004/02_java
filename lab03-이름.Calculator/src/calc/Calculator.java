package calc;

/**
 * 사칙연산 메소드를 제공하는 클래스
 * 
 * 
 * @author 304
 *
 */
public class Calculator {

	/**
	 * 메소드명 : add
	 * IntInput 타입 변수 input 을 받아
	 * 그 안에 있는 x, y 필드의 값을 더한 값을 리턴 
	 * 
	 * @param input : IntInput 타입 변수
	 * @return input의 x, y 필드의 합 : int
	 */
	
	public int add (IntInput input) {
		int result;
		
		result = input.getX() + input.getY();
		
		return result;
	}
	
	
	/**
	 * 메소드명 : subtract
	 * IntInput 타입 변수 input 을 받아
	 * 그 안에 있는 x 에서 y 를 뺀 값을 리턴
	 * 
	 * @param input : IntInput 타입 변수
	 * @return input 의 x 에서 y를 뺀 값 : int
	 */
	public int subtract (IntInput input) {
		int result;
		
		result = input.getX() - input.getY(); 
		
		return result;
	}
	
	/**
	 * 메소드명 : multiply
	 * IntInput 타입 변수 input 을 받아
	 * 그 안에 있는 x, y 필드의 곱한 값을 리턴
	 * 
	 * @param input : IntInput 타입의 값
	 * @return input 의 x, y 값의 곱 : int
	 */
	public int multiply(IntInput input) {
		int result;
		
		result = input.getX() * input.getY();
		
		return result;
	}
	
	/**
	 * 메소드명 : divide
	 * IntInput 타입 변수 input 을 받아
	 * 그 안에 있는 x 를 y로 나눈 값을 리턴
	 * 
	 * y가 0일 때 등의 처리는 하지 않음
	 * 그냥 일반 나눗셈으로 수행 
	 * @param input : IntInput 타입의 값
	 * @return input 의 x를 y로 나눈 값 : int
	 */
	public int divide (IntInput input) {
		int result;
		
		result = input.getX() / input.getY();
		
		return result;
	}
	
}
