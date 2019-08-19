package calc.input;

/**
 *  실수형 멤버변수 x, y 두 개를 갖는 
 *  클래스 DoubleInputValue 클래스를 자바빈즈 규격의 클래스로 작성
 * @author passw
 *
 */
public class DoubleInputValue {
	
	// 멤버변수 선언부
	private double x;
	private double y;
	
	// 생성자 선언부
	// (기본생성자)
	public DoubleInputValue() {
		
	}
	
	// 메소드 선언부
	// 접근자, 수정자

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

//	 toString() 재정의
//	@Override
//	public String toString() {
//		return "입력값 [x=" + x + ", y=" + y + "]";
//	}
	
	
}
