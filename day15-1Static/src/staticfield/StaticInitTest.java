package staticfield;

/**
 * static <--> non-static 
 * 사이의 호출관계를
 * 서로 다른 클래스에서 테스트하는 클래스
 * @author 304
 *
 */
public class StaticInitTest {

	// main 메소드는 static 메소드
	public static void main(String[] args) {
		
		// 다른 클래스의 static 필드에 대한 사용
		// ==> 선언, 초기화, 사용의 순서가 필요 없음
		//     바로 사용 가능
		// 1. StaticInit 클래스의 static 변수 사용
		//  ==>클래스이름.변수이름
		System.out.println("StaticInit.count=" + StaticInit.count);
		
		// 2. StaticInit 클래스의 static 메소드 사용
		//  ==>클래스이름.메소드이름();
		StaticInit.increaseCount();
		System.out.println("StaticInit.count=" + StaticInit.count);
		
		
		// 다른 클래스의 non-static 필드 사용에 관한 순서
		// main 메소드는 static 이기 때문에
		// 다른 클래스의 non-static 필드를 사용하려면
		// 반드시 명시적 초기화 코드가 나타나야 사용가능
		
		// 1. 선언, 2. 초기화
		StaticInit init = new StaticInit();
		
		// 3. 사용
		init.setMemberCnt(10);
		System.out.println("memberCnt + count = " + init.addCount());

		// 4. StaticInit 클래스의 static print() 를 사용
		StaticInit.print();
		StaticInit.print(init);
	}


}
