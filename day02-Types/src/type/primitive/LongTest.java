package type.primitive;
/**
 * ling : int 보다 큰 정수를 저장하는 타입
 * ----------------------------------------
 * long 타입의 변수에 값을 할당할 때는
 * 값의 뒤에 대문자 L, 소문자 l 을 붙여서 할당해야 한다
 * @author Administrator
 *
 */
public class LongTest {

	public static void main(String[] args) {
		// 1. 선언
		long milliSecond;
		
		// 2. 초기화
		milliSecond = 1000;
		System.out.println("milli Second=" + milliSecond);
		milliSecond = 3000L;
		System.out.println("milli Second=" + milliSecond);
		milliSecond = 5000l; 
		System.out.println("milli Second =" + milliSecond);
	}

}
