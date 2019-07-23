package school;

/**
 * 학교 시스템을 테스트하는 클래스
 * ---------------------------------
 * Person과 상속관계인 
 * Student, Employee, Teacher 를
 * 테스트하는 클래스이다.
 * @author Administrator
 *
 */
public class SchoolTest {

	public static void main(String[] args) {
		// 1. 선언 
		// Person 타입의 배열 persons를 선언
		Person[] persons; //= {new Student("S01", "홍길동", 18, "도술"), new Teacher("T01", "정약용", 32, "실학"), new Employee("E01", "허균", 48, "문학예술지원부")};
		
		// 2. 초기화
		// (1) persons 를 3 사이즈로 생성
		// (2) persons 배열의 각각 0 ~ 2 인덱스에
		// [0] : Student : id=S01, name=홍길동, age=18, major=도술
		// [1] : Teacher : id=T01, name=정약용, age=32, subject=실학
		// [2] : Employee : id=E01, name=허균, age=48, dept=문학예술지원부
		// 상위타입의 변수 Person에 하위타입 인스턴스(멤버변수)를 사용할 수 있는 이유: Student 상속에의한 다형성제공 에 의한 형상
		persons = new Person[3];
		persons[0] = new Student("S01", "홍길동", 18, "도술");
		persons[1] = new Teacher("T01", "정약용", 32, "실학");
		persons[2] = new Employee("E01", "허균", 48, "문학예술지원부");
		
		// 실행
		// foreach를 사용하여 persons 배열의 각 엘리먼트에 대하여
		// print() 메소드 호출
		for(Person person: persons) {
			person.print();
		}
	}

}
