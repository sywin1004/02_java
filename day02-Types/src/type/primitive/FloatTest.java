package type.primitive;
/**
 * float, double : 실수형(소수점 표현 가능) 데이터를
 *                 표현, 저장할 수 있는 타입
 * --------------------------------------------------
 * float 타입의 변수에 값을 할당할 때는
 * 값의 뒤에 대문자 F, 소문자 f 를 접미사로 붙인다.                 
 * @author Administrator
 *
 */
public class FloatTest {

	public static void main(String[] args) {
		// 1. 선언
		float pi1;
		double pi2;
		
		// 2. 초기화
		pi1 = 3.14F;
		pi2 = 3.14;
		
		// 3. 사용 : 변수 값 출력
		System.out.println("float pi=" + pi1);
		System.out.println("double pi=" + pi2);
		System.out.println("===========================");
		
		pi1 = 3.141592653589793238462643383279502884197169F;
		pi2 = 3.141592653589793238462643383279502884197169;
		System.out.println("float =" + pi1);
		System.out.println("double =" + pi2);
	

	}

}
