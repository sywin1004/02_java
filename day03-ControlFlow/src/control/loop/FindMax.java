package control.loop;

import java.util.Scanner;

/**
 * 입력된 자연수 중에서 최댓값을 찾는 클래스
 * @author Administrator
 *
 */
public class FindMax {

	public static void main(String[] args) {
		// 1. 선언
		int input;
		int max;
		Scanner scan = new Scanner(System.in);
		
		// 2. 초기화
		max = 0;
		
		// 3. 입력값으로 부터 max 를 반복 설정
		do {
			System.out.println("양수를 입력(끝내려면 0 입력)");
			input = scan.nextInt();
			
			if (input > max) {
				max = input;
			}
		} while (input > 0);
		
		System.out.printf("최댓값은 %d 입니다.%n", max);

	}

}
