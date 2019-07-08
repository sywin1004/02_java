package contrl.ifstmt;

import java.util.Scanner;

public class FindMax {

	public static void main(String[] args) {
		// 1. 선언
		int x;
		int y;
		int max;
		max = 0;	
		// 스캐너 입력
		Scanner scan;
		scan = new Scanner(System.in); 
		// 스캐너 사용한 정수 입력(초기화)
		System.out.println("두 정수를 입력해 주세요");
		x = scan.nextInt();
		y = scan.nextInt();
		
		// 사용
		if (x > y) {
			max = x;
			System.out.printf("입력된 두 값 x=%d, y=%d 중 큰 값은 %d%n", x, y, max);
		}
		if (y > x) {
			max = y;
			System.out.printf("입력된 두 값 x=%d, y=%d 중 큰 값은 %d%n", x, y, max);
		}

		if (x == y) {
			System.out.printf("입력된 두 값 x=%d y=%d 이 동일합니다.", x, y);
		}
	}

}
