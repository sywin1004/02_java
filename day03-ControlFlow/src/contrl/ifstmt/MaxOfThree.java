package contrl.ifstmt;

import java.util.Scanner;

/**
 * 입력된 세 값 중에서 가장 큰 값을 판별하는 클래스
 * 입력값은 각각 int num1, num2, num3; 변수에 저장
 * 가장 큰 값은 int max; 변수에 저장
 * 
 * 중첩 if ~ else 로 판단
 * 
 * 마지막 출력 printf 사용
 * ---------------------------------------------
 * @author Administrator
 *
 */
public class MaxOfThree {

	public static void main(String[] args) {
		// 1. 선언
		int num1;
		int num2;
		int num3;
		int max;
		Scanner scan;
		
		// 2. 초기화
		scan = new Scanner(System.in);
		// 3. 안내문 실행
		System.out.println("비교할 세 정수를 입력해 주세요");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		num3 = scan.nextInt();
		
		// 4. 비교하는 if 문 작성
		// num1이 가장 클 때
		if (num1 > num3) {
			if (num1 > num2) {
				max = num1;
			} else {
				max = num3;
			}
			// 그 외 max 가 num3 일 때
		} else {
			if (num2 > num3) {
				max = num2;
			} else {
				max = num3;
			} // end else
		}
		System.out.printf("입력된 세 값 %d, %d ,%d 중 가장 큰 값은 %d 입니다.", num1, num2, num3, max);

	}

}
