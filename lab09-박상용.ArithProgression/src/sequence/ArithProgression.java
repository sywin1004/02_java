package sequence;

/**
 * 공차 수열의 메소드를 정의하는 클래스
 * @author Administrator
 *
 */

/**
 * 프로젝트명 : lab09-이름.ArithProgression
패키지명 : sequence
---------------------------------------------

첫항 : start
공차 : diff
항의 갯수 : index 
--------------------------------------------------------
첫 항이 start 이고, 공차가 diff 이며, 항의 갯수 index 만큼인
등차수열의 합을 구하는 메소드 sequence 를 작성하시오.

등차 수열의 일반항은
start + diff * (index - 1) 로 구한다.
--------------------------------------------------------
+ArithProgression     : class 
+sequence(int start, int diff, int index) : int
--------------------------------------------------------
+ArithProgressionTest : test class
+main()
start : 1, diff : 3, index : 3 ==> 12

 * @author Administrator
 *
 */
public class ArithProgression {
	public int sequence(int start, int diff, int index) {
		int result = start;
		
		for(int idx = )
		result = result + diff;
		
		return result;
	}
}
