package control.swtchstmt;

import java.util.Scanner;

/**
 * 다중 선택 switch 구문 사용하여 다음의 기준으로
 * 학점을 계산하는 클래스
 * -------------------------------------------
 * A : 90점 이상
 * B : 80 ~ 89 점 사이
 * C : 60 ~ 79 점 사이
 * D : 40 ~ 59 점 사이
 * F : 이하 나머지
 * -------------------------------------------
 * printf 로 출력
 * @author Administrator
 *
 */
public class ReportGrade {

	public static void main(String[] args) {
		// 1. 선언
		int score;
		char grade;
		
		Scanner scan;
		
		// 2. 초기화
		scan = new Scanner(System.in);
		
		// 안내문 출력
		System.out.println("0 ~ 100 사이의 정수를 입력 :");
		score = scan.nextInt();
		// 3. 실행
		switch (score / 10) {
		case 10 : case 9 :
			grade = 'A';
			System.out.printf("입력 값 %d 는 %c 점 입니다.", score, grade);
			break;
		case 8  :
			grade = 'B';
			System.out.printf("입력 값 %d 는 %c 점 입니다.", score, grade);
			break;
		case 7 : case 6 :
			grade = 'C';
			System.out.printf("입력 값 %d 는 %c 점 입니다.", score, grade);
			break;
		case 5 : case 4 : 
			grade = 'D';
			System.out.printf("입력 값 %d 는 %c 점 입니다.", score, grade);
			break;
			default :
				System.out.println("F");
		}
		
	}

}
