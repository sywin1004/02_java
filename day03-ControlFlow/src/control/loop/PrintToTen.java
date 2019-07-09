package control.loop;

/**
 * 0 ~ 10 까지 출력하는 클래스
 * 
 * while 구문을 사용해서 반복출력을 구현한다.
 * 
 * @author Administrator
 *
 */
public class PrintToTen {

	public static void main(String[] args) {
		// 1. 선언, 2. 초기화
		int number = 0;

		// 3. 반복구문 사용
		while (number <= 10) {
			System.out.printf("number=%d%n", number);
			number++;
		} // end while

	}// end main
} // end class