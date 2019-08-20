package loop.test;

import java.util.Scanner;

import loop.Factorial;

/**
 * Factorial을 테스트하는 클래스
 * @author Administrator
 *
 */
public class FactorialTest {

	public static void main(String[] args) {
		// 스캐너 선언 초기화, 안내 후 메소드로 사용
		Scanner scan = new Scanner(System.in);
		Factorial factorial = new Factorial();
		int result;
		int input;
		
		//사용안내
		System.out.println("factorial 계산 할 정수를 입력하세요");
		input = scan.nextInt();
		
		result = factorial.factorial(input);
		
		System.out.printf("[%d! = %d 입니다.]", input, result);
	}

}
