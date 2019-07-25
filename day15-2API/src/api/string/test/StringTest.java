package api.string.test;

/**
 * 변경되지 않는 문자열을 제공하는
 * String 클래스 객체를 테스트하는 클래스
 * -----------------------------------------
 * new String(...) dmfh todtjdgkwl dksgrh
 * "...." 로 직접 할당하는 String 인스턴스는
 * literal pool 이라고 부르는 영역에 따로 생성된다.
 * 
 * literal pool 의 특징은 동일한 데이터는 재사용한다는 것.
 * -----------------------------------------
 * @author Administrator
 *
 */
public class StringTest {

	public static void main(String[] args) {
		// String 변수 선언
		
		String str1 = new String("안녕하세요.");
		String str2 = new String("안녕하세요.");
		String str3 = "안녕하세요.";
		String str4 = "안녕하세요.";
		
		System.out.println("== 객체 비교 ==");
		System.out.printf("str1 == str2 ? %b%n", str1 == str2);
		System.out.printf("str1 == str3 ? %b%n", str1 == str3);
		System.out.printf("str3 == str4 ? %b%n", str3 == str4);
		
		System.out.println("== 객체 내용 비교 ==");
		System.out.printf("str1.equals(str2) ? %b%n", str1.equals(str2));
		System.out.printf("str1.equals(str3) ? %b%n", str1.equals(str3));
		System.out.printf("str3.equals(str4) ? %b%n", str3.equals(str4));
	}

}
