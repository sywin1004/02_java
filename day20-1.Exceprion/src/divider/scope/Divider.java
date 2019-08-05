package divider.scope;

/**
 * int 값 하나를 입력받아서
 * 지정된 수식을 계산하는 메소드(divide) 를 가진 클래스
 * ------------------------------------------------------
 * 이 메소드는 입력 값이 1, 0 인 경우는
 * 0 으로 나누는 상황이 발생하는 수식을 처리한다.
 * 입력 값이 1, 0 이 아닌 경우는 정상적인 수식 연산을 수행할 수 있다.
 * ------------------------------------------------------
 * 0으로 나누는 상황이 발생하는 경우는
 * 사전에 정의 된
 * DivideZeroException 예외를 사용하여
 * 부드럽게 처리하고 넘어갈 수 있도록 하자.
 * 
 * @author Administrator
 *
 */
public class Divider {
	
	// 2. 생성자 선언
	// 기본 생성자 명시
	public Divider() {
		
	}
	
	// 3. 메소드 선언
	public int divide(int x) throws DivideZeroException {
		
		switch (x) {
		case 0: case 1:
			throw new DivideZeroException();
		
		default :
			break;
		}
		
		int result = 100 / (x * (x - 1));
		return result;
	}
	
}
