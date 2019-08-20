package loop;

/**
 * 3! 과 같은 수학의 Factorial 을 계산하는 클래스
 * @author Administrator
 *
 */
public class Factorial {
	
	// +factorial(int n) : int
	public int factorial(int n) {
		int result;
		result = n;
		
		for (int idx = n - 1; idx >= 1; idx--) {
			result = (result * idx);			
		}
		
		return result;
	}
}
