package control.loop;
/**
 * while 문을 이용하여 1~100 사이의 홀수의 합을 구하는 클래스
 * @author Administrator
 *
 */
public class SumOfOdds2 {

	public static void main(String[] args) {
		// 1. 선언, 2. 초기화
		int num = 1;
		int sum = 0;
		
		while (num <= 100) {
			if (num % 2 == 1) {
				sum += num;
			}
			num++;
		}
		System.out.printf("1부터 100사이 홀수의 합은 %d 입니다.%n", sum);
	}

}
