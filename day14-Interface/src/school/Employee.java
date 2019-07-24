package school;

/**
 * 학교 시스템에서 교직원의 정보를 저장하는 클래스
 * 
 * 사람의 공통정보를 담는 클래스인 Person을 상속한다.
 * ------------------------------------------------
 * dept : String : 소속부서 이름
 * ------------------------------------------------
 * @author Administrator
 *
 */
public class Employee extends Person implements Attendance{
	// 1. 멤버변수 선언부
	private String dept;
	
	// 2. 생성자 선언부
	// (1) 기본생성자
	/**
	 * 기본생성자
	 */
	public Employee () {
		
	}
	// (2) 중복정의 된 생성자 dept만을 받는
	/**
	 * Employee 클래스 만의 필드(멤버변수) dept 를 초기화하는 생성자
	 * @param dept
	 */
	public Employee(String dept) {
		this.dept = dept;
	}
	
	/**
	 * Person 에서 물려받은 필드(id, name, age)와
	 * Employee 만의 필드 dept를 모두 초기화하는 생성자
	 * @param id
	 * @param name
	 * @param age
	 * @param dept
	 */
	public Employee(String id, String name, int age, String dept) {
		super(id, name, age);
		this.dept = dept;				
	}
	
	// 3. 메소드 선언부
	// (1) toString() 재정의
	@Override
	public String toString() {
		String empStr = String.format(", 부서: %s", dept);
		return String.format("직원정보[%s%s]", super.toString(), empStr);

	}
	@Override
	public String attend() {
		// 직원[아이디]이(가) 출근하였습니다. 문자열 리턴
		return String.format("직원[%s]이(가) 부서[%s] 에 출근하였습니다.", getId(), dept);
	}
	
}
