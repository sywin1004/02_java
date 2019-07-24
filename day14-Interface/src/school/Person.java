package school;

/**
 * 시스템에 저장될 학생, 선생, 직원의 정보중
 * 공통적인 내용을 추출한 상위클래스
 * 일반적인 사람의 정보를 저장한다.
 * --------------------------------------------
 * id : String
 * name : String
 * age : int
 * --------------------------------------------
 * @author Administrator
 *
 */
public abstract class Person {
	private String id;
	private String name; // 멤버변수(필드생성)
	private int age;
	
	// 생성자 선언
	// (1) 기본생성자 명시 : 생성자 선언부를 완전히 생략하면 자동으로 기본생성자 선언이 들어감. 
	//                       기본생상자가 아닌 생성자를 하나라도 선언하면 자동생성되지 않음
	
	public Person() {
		
	}
	
	/**
	 * id 필드만 초기화하는 생성자
	 * @param id
	 */
	// (2) 매개변수를 받는 생성자 중복정의
	//     매개변수를 받는 생성자가 선언이 된 상태에서 기본생성자 누락하는 경우 기본생성자는 자동으로 만들어지지않음 주의
	public Person(String id) {
		this();
		this.id = id;
	}
	
	/**
	 * id, name 필드만 초기화하는 생성자
	 * @param id
	 * @param name
	 */
	public Person(String id, String name) {
		this(id);
		this.name = name;
	}
	/**
	 * 전체 필드 초기화하는 생성자
	 * @param id : 시스템에 등록되는 아이디
	 * @param name : 구성원의 이름
	 * @param age : 구성원의 나이
	 */
	public Person(String id, String name, int age) {
		this(id, name);
		this.age = age;
	}
	
	// 3. 메소드 선언부
	
	// toString() 재정의
	/**
	 * 1. print 계열의 메소드에서 객체참조변수(화살표)를 출력할 때 자동으로 작동하는 메소드
	 * 2. Object 클래스에서 상속받은 메소드
	 * 3. 객체를 대표하는 문자열을 리턴
	 *    => 각 필드를 모두 출력하는 문자열
	 */
	@Override
	public String toString() {
		return String.format("아이디: %s 이름: %s 나이: %d", id, name, age);
	}
	
	/**
	 * 현재의 객체를 출력하는 메소드
	 */
	public void print() {
		// 가상 메소드 호출(virtual method invocation)
		// 부모클래스에 정의된 메소드를 호출해도
		// 실제 인스턴스 타입의 하위클래스에 정의된 메소드가 응답하는 것
		// 가상메소드 호출이 되기 위해서는 반드시 상속이 전제되어야 함
		System.out.println(this); // this <= 멤버변수를 가르키는 instance를 가르킴 toString이 선언되었기 때문에 this가 선언 가능
	
		
	}
	// 아이디 수정자
	public void setId(String id) {
		this.id = id;
	}
	// 아이디 접근자
	public String getId() {
		return id;
	}
	
	// 이름 수정자
	public void setName(String name) {
		 this.name = name;
	}
	// 이름 접근자
	public String getName() {
		return name;
	}
	
	// 나이 수정자
	public void setAge(int age) {
		this.age = age;
	}
	// 나이 접근자
	public int getAge() {
		return age;
	}
}
