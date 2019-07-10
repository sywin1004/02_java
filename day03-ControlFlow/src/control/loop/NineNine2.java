package control.loop;
/**
 * 중첩 for loop 한번으로 2단 3단 2개씩 묶어서 찍기
 * @author Administrator
 *
 */
public class NineNine2 {

	public static void main(String[] args) {
		// 1. 선언 2. 초기화 3. 실행
		
		for (int stage = 2; stage <= 9; stage++) {
			System.out.printf("%n%2d 단\t\t%2d 단%n", stage, stage += 1);
			for(int times = 1; times <= 9; times++) {
				System.out.printf("%2d x %2d = %2d\t%2d x %2d = %2d%n", stage - 1 , times, ((stage -1) * times), stage , times , (stage * times));
			}
		}
		
		// 솔루션
//		for (int stage = 2; stage <= 9; stage += 3) {
//			System.out.printf("%n%d단\t\t%d단\t\t", stage, stage +1);
//			if (stage < 8) {
//				System.out.printf("%d단", stage + 2);
//			}
//			System.out.println();
//			
//			for (int times = 1; times < 10; times++) {
//				System.out.printf("%d x %d = %2d\t%d x %d = %2d\t", stage, times, stage * times, stage + 1, times, (stage + 1) * times);
//				if (stage < 8) {
//					System.out.printf("%d x %d = %2d", stage + 2, times, (stage +2) * times);
//				}
//				System.out.println();
//			}
//		}
	} // end main

}// end class
