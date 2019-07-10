package control.loop;

/**
 * 1 ~ 10 까지 출력하는 클랙스
 * for 구문을 사용해서 출력
 * @author Administrator
 *
 */
public class PrintToTenByFor {

	public static void main(String[] args) {
		
		
		// for (선언식; 조건식; 증감식) {
		//      문장들;
		// }
		// 1. 선언식 : 선언의 형태 => 타입 변수이름;
		// 2. 조건식 : 조건의 형태 => 비교연산자(관계, 동일)
		//                            연산의 결과가 true, false 로 얻어짐
		// 3. 증감식 : 증감 연산자(++, --)를 활용하여
		//             선언식에서 선언된 루프제어 변수 값을 변경
		
		for (int idx = 1; idx <= 10; idx++) {
			System.out.printf("idx=%2d%n", idx);
			for (int idx2 = 0; idx2 <= 10; idx2++) {
				System.out.println("idx=" + idx);
			}
		}
		System.out.println("===========================================");
		System.out.println(" == 10~ 1 R까지 역순 출력");
		for (int idx = 10; idx > 0; idx--) {

			System.out.printf("idx=%2d%n", idx);
		}

		// final 변수 == 상수를 활용한 for for loop
		
		final int FROM = 1;
		final int TO = 10;

		for (int idx = FROM; idx <= TO; idx++) {
			System.out.printf("idx=%2d%n", idx);
		}
		
		System.out.println("== FROM, TO 상수를 사용한 역순출력");
		
		for (int idx = TO; idx >= FROM; idx--) {
			System.out.printf("idx=%2d%n", idx);
		}
		
		System.out.println("== FROM, TO 를 사용해서 0 ~ 9 까지 출력 ==");
		
		for (int idx = FROM; idx <= TO; idx++) {
			System.out.printf("idx=%2d%n", idx - 1);
		}
		for (int idx = FROM - 1; idx <= TO; idx++) {
			System.out.printf("idx=%2d%n", idx);
		}

	}

}
