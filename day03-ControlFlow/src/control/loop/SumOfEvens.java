package control.loop;
/**
 * while 문을 이용하여 1~100사이의 짝수의 합을 구하는 클래스
 * @author Administrator
 *
 */
public class SumOfEvens {

	public static void main(String[] args) {
		// 1. 선언
		int num;
		int sum;
		
		// 2. 초기화
		num = 2;
		sum = 0;
		while (num <= 100) {
			sum += num;
			num = num+2;
		}
		System.out.printf("1~100 까지 짝수의 합을 %d 입니다.%n", sum);
	}

}
