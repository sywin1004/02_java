package staticfield;

/**
 * static 멤버(변수, 메소드) 와
 * non-static 멤버(변수, 메소드) 의
 * 
 * 초기화 시점에 따른 참조를 구성하는 클래스 
 * 
 * @author 304
 *
 */
public class StaticInit {
	
	// 1. 변수선언
	// (1) 스태틱 변수 선언(클래스 변수 선언)
	//     static 변수는 생성자가 초기화하는 영역이 아니므로
	//     선언하면서 필요한 초기값을 바로 할당한다.
	static int count = 0;
	
	// (2) 멤버 변수 선언(인스턴스 변수 선언) 
	int memberCnt;
	
	// 2. 생성자 선언 생략 ==> 기본 생성자 자동 제공
	
	// 3. 메소드 선언
	// (1) 접근자 / 수정자 ==> 멤버 변수에 대해서 제공
	public int getMemberCnt() {
		return memberCnt;
	}
	
	public void setMemberCnt(int memberCnt) {
		this.memberCnt = memberCnt;
	}
	
	// (2) 그 외 기타 기능 메소드
	/**
	 * static 필드인 count 변수의 값을 리턴하는 메소드
	 * static 메소드로 작성
	 * 
	 * @return count : int
	 */
	public static int getCount() {
		return count;
	}
	
	/**
	 * static 필드인 count 변수를 증가시키는 메소드
	 */
	public static void increaseCount() {
		count++;
	}
	
	/**
	 * static 필드인 count 변수와
	 * non-static 필드인 memberCnt 변수의 
	 * 값을 모두 출력하는 메소드
	 */
	public static void print() {
		System.out.println("print1=================");
		// 1. count 출력
		System.out.println("count=" + count);
		
		// 2. memberCnt 출력
//		System.out.println("memberCnt=" + memberCnt);
//		System.out.println("memberCnt=" + getMemberCnt());
		/* -------------------------------------------
		 * 윗줄의 오류 이유 : print() 메소드는 static
		 *                    memberCnt 변수는 non-static
		 * -------------------------------------------
		 * static 필드에서 non-static 필드를 참조(사용)
		 * 하려면 바로 사용 할 수 없고
		 * 그 non-static 필드를 가지고 있는 클래스의
		 * 인스턴스를 생성한 후(new .... : 명시적 초기화) 
		 * 생성한 인스턴스.non-static 필드 이름 으로 접근
		 * 하는 것만 가능하다.
		 * -------------------------------------------
		 */
		StaticInit init = new StaticInit();
		System.out.println("memberCnt=" + init.memberCnt);
		System.out.println("memberCnt=" + init.getMemberCnt());
	}
	
	/**
	 * 이 클래스의 count 값과
	 * 입력된 StaticInit 객체로부터 memberCnt 값을 출력
	 * @param init
	 */
	public static void print(StaticInit init) {
		System.out.println("print2=================");
		System.out.println("count=" + count);
		System.out.println("memberCnt=" + init.memberCnt);
	}
	
	/**
	 * 이 클래스의 클래스 변수(static 변수)인 count와 
	 * 인스턴스 변수인 memberCnt 를 
	 * 더한 값을 리턴하는 메소드
	 * -----------------------------------------------
	 * 1. 이 메소드는 static modifier 가 붙지 않았으므로
	 *    non-static 메소드가 된다.
	 *    
	 * 2. non-static 메소드인 이 메소드에서
	 *    static 필드인 count 값을 사용(참조) 하려 할 때
	 *    아무런 제약없이 바로 사용 가능
	 *    
	 * 3. 이유는 static 필드는 초기화 시점이 앞서기 때문
	 * 
	 * @return count + memberCnt : int 
	 */
	public int addCount() {
		return this.memberCnt + count;
	}

}
