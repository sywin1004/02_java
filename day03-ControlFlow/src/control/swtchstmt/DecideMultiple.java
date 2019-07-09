package control.swtchstmt;

import java.util.Scanner;

/**
 * 입력된 자연수가 3의 배수인지 판별하는 클래스
 * -------------------------------------------
 * 배수 판단에 switch 구문을 사용
 * @author Administrator
 *
 */
public class DecideMultiple {

	public static void main(String[] args) {
		// 1. 선언
		int input;
		Scanner scan;
		
		// 2. 초기화
		scan = new Scanner(System.in);
		// 입력안내
		System.out.println("자연수를 입력하세요.");
		input = scan.nextInt();
		
		// 3. 사용 : input 변수의 값이 3의 배수인지 판단.
		switch (input % 3) {
		case 0 : 
			System.out.printf("입력값 %d 는 3의 배수입니다.%n", input);
			break;
		case 1 : case 2:
			System.out.printf("입력값 %d 는 3의 배수가 아닙니다.%n", input);
			break;
//		case 2:
//			System.out.printf("입력값 %d 는 3의 배수가 아닙니다.%n", input);
//			break;
			default :
				System.out.println("입력이 잘못되었습니다.");
		} // end switch
	}

}
