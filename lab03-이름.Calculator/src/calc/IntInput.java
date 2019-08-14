package calc;

/**
 * 사칙연산에 사용될 두 피연산자를
 * 멤버변수로 갖는 클래스를 정의
 * 
 * int x
 * int y 를 선언
 * 
 * 기본 생성자 선언
 * 
 * 접근자 수정자 선언
 * 
 * equals() & hashCode() 재정의
 * 
 * toString 재정의
 *    출력문자열:입력값 [x=값, y=값]
 * @author 304
 *
 */
public class IntInput {
	
	// 멤버변수 선언부
	private int x;
	private int y;
	
	// 생성자 선언부
	public IntInput() {
		super();
	}
	
	// 메소드 선언부
	// 접근자 수정자
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	// toString() 재정의
	@Override
	public String toString() {
		return "입력값 [x=" + x + ", y=" + y + "]";
	}
	
	
	
}
