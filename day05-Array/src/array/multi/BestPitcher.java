package array.multi;

import java.util.Scanner;

/**
 * 야구 구단의 1~5 선발 선수의 방어율을 입력하고 그 중 가장 방어율이 낮은 최고의 투수를 찾는 클래스
 * @author Administrator
 *
 */
public class BestPitcher {

	public static void main(String[] args) {
		// 1. 선언, 2. 초기화
		Scanner scan = new Scanner(System.in);
		double[][] era = new double [3][5];
		double min = 10.0;
		// 각 팀별로 각 투수의 방어율을 입력받아 배열에 저장한다
		System.out.println("1선발 2선발 3선발 4선발 5선발 방어율 입력");
		
		for (int idx = 0; idx < era.length; idx++) {
			System.out.println((idx+1) + "번째 팀 1 ~ 5 선발 투수 방어율 :");
			for (int ind = 0; ind < era[idx].length; ind++) {
				era[idx][ind] = scan.nextDouble();
				if (era[idx][ind] < min) {
					min = era[idx][ind];
				}
			}
		}
		System.out.println("최고의 투수는");
		for (int idx = 0; idx < era.length; idx++) {
			for (int ind = 0; ind < era[idx].length; ind++) {
				System.out.printf("[%d]팀 [%d]선발 방어율[%3.2f]%n", idx, ind, era[idx][ind]);
				if(era[idx][ind] == min) {
				System.out.println("===========================MVP===========================");
				System.out.printf("[%d]팀 [%d]선발 방어율[%3.2f]선수", idx, ind, min);
				}
			}// end inner for
			System.out.println();
		} // end outer for
	}// end main

}
