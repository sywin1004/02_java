package sequence;

/**
 * 등차 수열의 합 메소드를 정의하는 클래스
 * @author Administrator
 *
 */

public class ArithProgression {
	public int sequence(int start, int diff, int index) {
		int sumResult = start;
		int result = start;
		
		for(int idx = 0; idx < index - 1; idx++) {
			result += diff;
			sumResult += result;
		}
		
		return sumResult;
	}
}