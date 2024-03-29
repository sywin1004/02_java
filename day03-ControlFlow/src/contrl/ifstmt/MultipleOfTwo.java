package contrl.ifstmt;

import java.util.Scanner;

/**
 * 입력된 정수에 대해서 2의 배수인지 판별하는 클래스
 * 
 * 입력된 정수를 input 변수에 저장하고 입력된 값이 2의 배수인지 판단하는 조건을 작성하시오.
 * 
 * (1)--------------------------------------------------------- 2의 배수일 때: "입력값 4
 * 은(는) 2의 배수입니다." 2의 배수가 아닐 때 : "입력값 5은(는) 2의 배수가 아닙니다."
 * ------------------------------------------------------------
 * 
 * (2)--------------------------------------------------------- 나머지는 int mod; 에
 * 저장하여 사용하시오. 2의 배수일 때 : "입력값 4 은(는) 2의 배수입니다. 2의 배수가 아닐 때 : "입력값 5 은(는) 2의 배수가
 * 아닙니다." "나머지가 1 입니다."
 * ------------------------------------------------------------
 * 
 * 0이 들어와도 실행되는 오류가 있음 0이 들어오는 경우 따로 처리 할 수 있도록 if else 로직을 수정 입력값이 0인경우 "0은 배수
 * 판별할 수 없습니다."
 * 
 * @author Administrator
 *
 */
public class MultipleOfTwo {

	public static void main(String[] args) {
		// 1. 선언
		int input;
		int mod;
		Scanner scan;
		// 2. 초기화
		scan = new Scanner(System.in);
		// 3. 사용
		System.out.println("정수를 입력해 주세요");
		input = scan.nextInt();
		if (input == 0) {
			System.out.println("0은 배수 판별할 수 없습니다.");
		} else if (input % 2 == 0) {
			System.out.printf("입력값 %d 은(는) 2의 배수입니다.", input);
		} else {
			mod = input % 2;
			System.out.printf("입력값 %d 은(는) 2의 배수가 아닙니다. 나머지가 %d입니다.", input, mod);
		}
	}
}
