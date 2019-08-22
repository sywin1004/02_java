package sequence;

/**
 * 등차 수열의 합 메소드를 정의하는 클래스
 * @author Administrator
 *
 */

public class ArithProgression {
	
	public int sequence(int start, int diff, int index) {
		int sumSequence = start;
		int resultSequence = start;
		
		for (int idx = 0; idx < index - 1; idx++) {
			resultSequence += diff;
			sumSequence += resultSequence;
		}
		
		return sumSequence;
	}
	
	public int sequence2(int start, int diff, int index) {
		
		if (index == 1) {
			return start;
			
		} else {			
			return start + (diff * (index - 1)) + sequence2(start, diff, index - 1);
		}		
	}
}


