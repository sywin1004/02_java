package loop;

/**
 * 3! 과 같은 수학의 Factorial 을 계산하는 클래스
 * @author Administrator
 *
 */
public class Factorial {
	
	// +factorial(int n) : int
	public int factorial(int n) {
		int factorial;
		factorial = n;
		int result = 0;
		
		for (int idx = n; idx < 0; idx--) {
			factorial = (factorial*(idx-1));
			
		}
		
		return factorial;
	}
}
