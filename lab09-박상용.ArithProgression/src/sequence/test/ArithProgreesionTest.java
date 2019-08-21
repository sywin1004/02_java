package sequence.test;

import sequence.ArithProgression;

/**
 * 등차 수열의 합을 테스트 하는 클래스
 * @author Administrator
 *
 */
public class ArithProgreesionTest {

	public static void main(String[] args) {
		ArithProgression progression = new ArithProgression();
		int result;
		int firstInput = 1;
		int secondInput = 3;
		int thirdInput = 3;
		
		result = progression.sequence(firstInput, secondInput, thirdInput);
		
		System.out.printf("첫항=%d 공차=%d 항의갯수=%d 등차수열 합=%d%n", firstInput, secondInput, thirdInput, result);

	}

}
