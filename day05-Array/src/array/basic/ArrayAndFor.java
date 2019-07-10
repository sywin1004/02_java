package array.basic;

/**
 * 10칸짜리 int배열 numbers 를 선언, 생성(0초기화) 한 후 각 원소의 값을 0번 인덱스부터 9번 인덱스까지 10, 20, 30,
 * ... 100 까지 저장한다.
 * 
 * 배열의 저장된 원소의 합을 int summary; 변수에 누적하여 출력하시오.
 * 
 * @author Administrator
 *
 */
public class ArrayAndFor {

	public static void main(String[] args) {
		// 1. 선언
		int[] numbers;
		int summary;

		// 2. 초기화
		numbers = new int[10];
		summary = 0;
		// 3. 인덱스 저장
		for (int idx = 0; idx < numbers.length; idx++) {
			numbers[idx] = (idx + 1) * 10;
			summary += numbers[idx];
		}

		// 4. 인덱스 누적값 출력
		System.out.printf("원소의 합 : %d%n", summary);

	}

}
