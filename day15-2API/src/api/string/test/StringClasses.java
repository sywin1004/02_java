package api.string.test;

/**
 * String        : 변경되지 않는 문자열
 * StringBuilder : 변경되는 문자열
 * 
 * 두 클래스의 인스턴스가
 * 문자열 변경 후 유지되는지 여부를 확인하는
 * 테스트 클래스
 * @author 304
 *
 */
public class StringClasses {

	public static void main(String[] args) {

		// 1. 선언, 2. 초기화
		String str = new String("안녕하세요.");
		StringBuilder builder = new StringBuilder("안녕하세요.");
		
		// 3. 사용
		System.out.println("==== 변경 전 ====");
		// (1) 초기화 직후 내용 출력
		System.out.println("str    :" + str);
		System.out.println("builder:" + builder);
		// (2) 초기화 직후 객체참조변수의 해시값을 출력
		System.out.print("str의 hash    :");
		System.out.println(str.getClass().getName() + "@" 
                         + Integer.toHexString(str.hashCode()));
		
		System.out.print("builder의 hash:");
		System.out.println(builder.getClass().getName() + "@" 
                         + Integer.toHexString(builder.hashCode()));
		
		System.out.println("==== 변경 후 ====");
		// (3) 값 변경
		str = str + " 자바.";
		builder.append(" 자바");
		
		// (4) 변경 후 각 참조변수 해시 출력
		System.out.println("str    :" + str);
		System.out.println("builder:" + builder);
		System.out.print("str의 hash    :");
		System.out.println(str.getClass().getName() + "@" 
                         + Integer.toHexString(str.hashCode()));
		
		System.out.print("builder의 hash:");
		System.out.println(builder.getClass().getName() + "@" 
                         + Integer.toHexString(builder.hashCode()));
		
	}
}
