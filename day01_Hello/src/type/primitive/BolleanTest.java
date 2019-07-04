package type.primitive;
/**
 * 논리 타입인 boolean 타입을 선언하고
 * 테스트하는 클래스
 * @author Administrator
 *
 */
public class BolleanTest {

	public static void main(String[] args) {
		// 1. 선언
		boolean isLikeBaseball;
		boolean isExists;
		boolean isHave;
		boolean isEnd = false; // 선언과 동시에 초기화
		// 2. 초기화
		isLikeBaseball = true;
		isExists = true;
		isHave = false;
		
		// 3. 사용
		System.out.println("isLikeBaseball= " + isLikeBaseball);
		System.out.println("isExists=" + isExists);
		System.out.println("isHave=" + isHave);
		System.out.println("isEnd=" + isEnd);
	}

}
