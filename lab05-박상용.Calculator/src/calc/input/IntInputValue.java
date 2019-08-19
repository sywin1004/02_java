package calc.input;

/**
 *     정수형 멤버변수 x, y 두 개를 갖는    
 *     클래스 IntInputValue 클래스를 자바빈즈 규격의 클래스로 작성
 * @author passw
 */
public class IntInputValue {
	
	// 멤버변수 선언부
	private int x;
	private int y;
	
	// 생성자 선언부
	//(기본생성자)
	public IntInputValue() {
		super();
	}

	// 메소드 선언부
	// 접근자, 수정자
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	// toString()재정의
//	@Override
//	public String toString() {
//		return "입력값 [x=" + x + ", y=" + y + "]";
//	}
	
	
	
	
	
	
}
