package statical.method;

import static statical.method.Calculator.subtract;
/**
 * Calculator 클래스에 있는
 * static 메소드를 테스트하는 클래스
 * --------------------------------------
 * static 메소드는
 * 클래스이름.메소드이름(아규먼트);
 * 의 방식으로 호출
 * 
 * 
 * @author Administrator
 *
 */
public class CalcTest {

	public static void main(String[] args) {
		// static 이 아닌 메소드를 호출할 때는
		// 해당 메소드가 정의 된 클래스 객체참조 변수를 초기화 후
		// 해당 변수에 메소드를 호출
//		Calculator cal = new Calculator();
//		cal.add(10.0, 15.2);
		
		// static 메소드는 클래스이름.메소드이름(아규먼트);
		double result = Calculator.add(1.0, 2.5);
		System.out.println(result);
		
		int addResult = Calculator.add(3, 5);
		System.out.println(addResult);
		
		// 자바에서는 클래스의 static필드들 (변수, 메소드)에 대해서
		// static import를 지원
		// static import 구문을 클래스 선언 위쪽에 작성한 경우
		// 메소드이름 만으로 호출할 수 있다.
		
		double subResult = subtract(20.5, 1.4);
		System.out.println(subResult);
		
	}

}
