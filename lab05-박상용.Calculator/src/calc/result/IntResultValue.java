package calc.result;

/**
 * 정수형 멤버변수 result 한 개를 갖는
 * 클래스 IntResultValue 클래스를 자바빈즈 규격의 클래스로 작성
 * 
 * @author passw
 *
 */
public class IntResultValue {
	
	// 멤벼번수 선언부
	private int result;
	// 생성자 선언부
	// (기본생성자)
	public IntResultValue() {
		super();
	}
	// 접근자, 수정자
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	// toString 재정의
	@Override
	public String toString() {
		return "결과값 [result=" + result + "]";
	}
	
	
	
}
