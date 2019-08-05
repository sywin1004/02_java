package divider.scope;

/**
 * 예외의 전파를 알아볼 수 있는
 * DividerScope 클래스를 테스트
 * 
 * @author Administrator
 *
 */
public class ExceptionScopeTest  {

	public static void main(String[] args) {
		// 1. 선언
		DividerScope divScope;
		// 2. 초기화
		divScope = new DividerScope();
		
		// 3. 사용
		System.out.println("=== main 이 실행되었습니다. ===");
		
		divScope.level1();
		
		System.out.println("=== main 이 종료되었습니다. ===");
	}

}
