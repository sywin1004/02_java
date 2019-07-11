package control.loop;

/**
 * 1. 50 ~ 0 까지 짝수만 역순으로 출력
 *    (1) continue 없이
 *    (2) continue 사용
 * 
 * 2. 1 ~ 10 까지 제곱표를 출력
 *     1 x 1 =   1
 *     2 x 2 =   4
 *    ...
 *    10 x 10 = 100
 * @author Administrator
 *
 */
public class ForTest {

	public static void main(String[] args) {
		// 1. 선언 2. 초기화
		for (int idx = 50; idx >= 0 ; idx--) {
			if(idx % 2 == 1) {
				;
			} else {
				System.out.printf("짝수 %d%n", idx);
			}
		}
		System.out.println("=================continue 사용==========================");
		
		for (int idx = 50; idx >= 0; idx--) {
			if (idx % 2 == 1) {
				continue;
			}
			System.out.printf("짝수 %d%n", idx);
		}
		
		System.out.println("============================= 1 ~ 10 제곱표=================================");
		
		for (int idx = 1; idx <= 10; idx++) {
			System.out.printf("%2d x %2d = %3d%n", idx, idx, (idx * idx));
		}
		
		System.out.println("==============================while 사용======================================");
		
		// 1. 선언
		int idx = 50;
		
		// 2. 초기화 3. 실행
		while (idx >= 0) {
			if(idx % 2 == 1) {
				;
			} else {
				System.out.printf("짝수 %d%n", idx);
			}
			idx--;
			
			// 3. 제곱표 출력 (배열, foreach 사용)
			int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			
			for (int num: numbers) {
				System.out.printf("%2d x %2d = %3d%n", num, num, (num * num));
			}
		}
	}

}
