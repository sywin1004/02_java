package nine.process;

import java.util.ArrayList;
import java.util.List;

/**
 * 구구단을 자바고인물같이 출력하는 메소드를 정의하는 클래스
 * @author Administrator
 *
 */
public class ProcessNineArray {
	
	public List<String> processNineArray(List<String> input) {
		List<String> inputArray = input;
		List<String> newArray = new ArrayList<String>();
		
		for (int idx = 0; idx < inputArray.size(); idx++) {
			if (inputArray.get(idx).equals(newArray)) {
				continue;
			} else {
				newArray.add(inputArray.get(idx));
			}
		}
		
		return newArray;
	}
}
