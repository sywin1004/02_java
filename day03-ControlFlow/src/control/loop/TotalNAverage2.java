package control.loop;

import java.util.Scanner;

public class TotalNAverage2 {

	public static void main(String[] args) {
		// 1. 선언
		int total;
		int score;
		int count;
		double average;
		Scanner scan;

		// 2. 초기화
		scan = new Scanner(System.in);
		total = 0;
		score = 0;
		count = 0;

		// 안내구문 출력
		System.out.println("점수를 입력(끝내려면 0 입력) :");
		score = scan.nextInt();
		// 3. 실행
		while (score != 0) {
			total += score;
			System.out.println("다음 점수를 입력해 주세요");
			score = scan.nextInt();
			count++;
		}
		if (count == 0) {
			System.out.println("입력된 값이 없습니다.");
		} else {
			average = (double) total / count;
			System.out.printf("총점 : %d%n", total);
			System.out.printf("과목 수 : %d%n", count);
			System.out.printf("평균 : %5.2f%n", average);

		}

	}

}
