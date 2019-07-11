package array.basic;

/**
 * 자바 1.5 버전부터 지원되는
 * 향상된 for 반복문의 기능
 * -------------------------------
 * 데이터구조와 함께 사용된다.
 * 
 * 데이터 구조 : 1. 배열 (Array)
 *               2. 리스트 (List)
 *               3. 맵 (map)
 *               4. 셋 (set)
 * @author Administrator
 *
 */
public class ForEachTest {

	public static void main(String[] args) {
		// 1. 배열의 선언(과 동시에 값을 넣으면서 초기화)
		int[] numbers = {5, 4, 3, 2, 1};
		int sum = 0;
		
		// 3. foreach 구문으로 배열 값 출력
		// for (원소의타입 변수이름 : 자료구조(==배열)){
		// 		문장들;
		//	} num 은 for 안에서만 생성되었기 때문에 for 를 벗어난 곳에서는 쓸 수 없다.
		for (int num: numbers) {
			sum += num;
			System.out.println("num =" + num);
		}
		
		System.out.println("sum =" + sum);
		System.out.println("num.length" + numbers.length);

	}

}
