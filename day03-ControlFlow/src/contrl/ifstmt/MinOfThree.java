package contrl.ifstmt;

import java.util.Scanner;

/**
 * 세 정수를 입력받아서
 * 그 중 가장 작은 정수를 판별하는 클래스이다.
 * ------------------------------------------
 * 가장 작은 
 * @author Administrator
 *
 */
public class MinOfThree {

	public static void main(String[] args) {
		// 1. 선언
		int num1;
		int num2;
		int num3;
		int min;
		Scanner scan;
		
		// 2. 초기화
		scan = new Scanner(System.in);
		// 정수 입력 안내 prompt
		System.out.println("세 정수를 입력하세요.(space bar 로 분리)");
		
		// 입력 값 저장
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		num3 = scan.nextInt();
		
		// 3. 사용 : 입력값의 대소비교
		if (num1 < num2) {
			// num1 이 작을 때 진입
			if (num1 > num3) {
				min = num1;
			} else {
				// num3 작을 때 진입
				min = num3;
			}
		} else {
			if (num2 < num3) {
				min = num2;
			} else {
				min = num3;
			} // end else
		}
		
		// 4. 출력
		System.out.printf("입력된 세 값 %d, %d, %d 중 가장 작은값 : %d%n", num1, num2, num3, min);
	}// end main

}
