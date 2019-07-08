package operator.binary;
/**
 * 누적 대입 연산자 테스트 클래스
 * 
 * += : 산술 덧셈 연산 후 왼쪽의 변수로 재할당
 * @author Administrator
 *
 */
public class PlusAssignment {

	public static void main(String[] args) {
		// 1. 선언, 2. 초기화
		int num = 0;
		
		// 3. 사용
		System.out.printf("초기 num 값 = %d%n", num);
		
		num += 1;
		System.out.printf("num += 1 수행 후 num =%d%n", num);
		
		num = num + 1;
		System.out.printf("num = num + 1 수행 후, num=%d%n", num);
		
		num += num + 1;
		System.out.printf("num += num+1 수행 후 , num=%d%n", num);
		
		num *= num * num;
		System.out.printf("num *= num+1 수행 후 , num=%d%n", num);

	}

}
