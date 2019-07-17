package operator.binary;
/**
 * <, >, <=, >=, ==, !=
 * 
 * 두 변수의 값ㅇ르 비교하는
 * 비교연산자를 테스트하는 클래스
 * 
 * 관계연산의 결과는 boolean 타입으로 얻어짐.
 * @author Administrator
 *
 */
public class RelationalTest {

	public static void main(String[] args) {
		// 1. 선언, 2. 초기화
		int a = 1;
		int b = -5;
		
		// 3. 비교연산자 사용
		System.out.println("------------------------------");
		System.out.println("등가 비교 연산자");
		System.out.println("------------------------------");
		
		System.out.printf("%d == %d : %b%n", a, b, (a == b));
		System.out.printf("%d != %d : %b%n", a, b, (a != b));
		
		System.out.println("-----------------------------------");
		System.out.println("대소 비교 연산자");
		System.out.println("-----------------------------------");
		System.out.printf("%d > %d : %b%n", a, b, (a > b));
		System.out.printf("%d < %d : %b%n", a, b, (a < b));
		System.out.printf("%d >= %d : %b%n", a, b, (a >= b));
		System.out.printf("%d <= %d : %b%n", a, b, (a <= b));
		
		// 이클립스 IDE의 단축키
		// ctrl + d : 커서가 있는 행 전체 삭제
		// alt + shift + a : 세로줄 편집 기능 토글
		// alt + up/down : 행 전체 상하 이동
		// ctrl + shift + L : 단축키 모음 안내창 오픈
		// ctrl + F6
	}

}
