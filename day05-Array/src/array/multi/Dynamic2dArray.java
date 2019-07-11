package array.multi;

/**
 * 동적 2차원 배열을 생성하고 사용해보는 클래스
 * 
 * 2차수 배열의 크기는 순서대로
 * 3, 4, 1, 5 로 생성한다
 * 
 * 생성된 2차 배열안에 숫자를 
 * 1 ~ 13까지 할당하고 출력해본다.
 * @author Administrator
 *
 */
public class Dynamic2dArray {

	public static void main(String[] args) {
		// 1. 선언
		int [][] twoDArray;
		int count = 0;
		
		// 2. 초기화
		twoDArray = new int[4][];
		
		for(int[] array: twoDArray) {
			System.out.println("array=" + array);
		}
		
		twoDArray[0] = new int[3];	
		twoDArray[1] = new int[4];		
		twoDArray[2] = new int[1];		
		twoDArray[3] = new int[5];
		
		for(int[] array: twoDArray) {
			System.out.println("array=" + array);
		}
		
		// 3. 1 ~ 13 까지 데이터 저장
		for (int idx = 0; idx < twoDArray.length; idx++) {
			for (int ind = 0; ind < twoDArray[idx].length; ind++) {
				twoDArray[idx][ind] = ++count;
			}
		}
		
		// 4. 출력 (foreach)
		for(int[] array: twoDArray) {
			for (int num: array) {
				System.out.printf("%d\t", num);
			}
			System.out.println();
		}
		
	}

}
