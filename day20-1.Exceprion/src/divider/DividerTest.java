package divider;

import java.util.Scanner;

/**
 * 입력 값에 따라서 0으로 나누는 상황이 발생할 가능성이 있는 클래스 Divider 를 테스트 한다.
 * 
 * 
 * @author 304
 *
 */
public class DividerTest {

	public static void main(String[] args) {

		// 1. 선언
		Scanner scan;
		int input;
		Divider div;

		// 2. 초기화
		div = new Divider();
		scan = new Scanner(System.in);

		// 입력 시지하는 출력
		System.out.println("정수를 입력하세요.");
		input = scan.nextInt();

		// 3. 사용
		int result;

		try {
			result = div.divide(input);
			System.out.printf("나눗셈 성공:%d%n", result);

		} catch (DivideZeroException e) {
			System.err.printf("나눗셈 실패:%s%n", e);
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("=프로그램 종료=");
		/*
		 * ------------------------- input : 2 나눗셈 성공:50 =프로그램 종료=
		 * ================================== input : 0 Exception in thread "main"
		 * java.lang.ArithmeticException: / by zero at
		 * divider.Divider.divide(Divider.java:30) at
		 * divider.DividerTest.main(DividerTest.java:32) 프로그램 종료 메시지가 출력되지 않음 ==> 예외가
		 * 처리되지 못하고 프로그램 중단됨 알 수 있음.
		 * 
		 * ================================== 0 나눗셈 실패:0으로 나누려는 시도가 있습니다. 0으로 나누려는 시도가
		 * 있습니다. at divider.Divider.divide(Divider.java:33) at
		 * divider.DividerTest.main(DividerTest.java:35) =프로그램 종료=
		 * 
		 * -------------------------
		 */
	}

}
