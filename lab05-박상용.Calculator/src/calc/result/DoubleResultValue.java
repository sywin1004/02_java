package calc.result;

/**
 * 실수형 멤버변수 result 한 개를 갖는
 * 클래스 DoubleResultValue 클래스를 자바빈즈 규격의 클래스로 작성
 * 
 * @author passw
 *
 */
public class DoubleResultValue {
	
	// 멤버변수 선언부
	private double result;
	// 생성자 선언부
	// (기본생성자)
	public DoubleResultValue() {
		super();
	}
	// 접근자, 수정자
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "결과값 [result=" + result + "]";
	}
	
	
	
}
