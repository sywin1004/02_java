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
		// Attendance 타입의 배열 attends를 선언
		Attendance[] attends; //= {new Student("S01", "홍길동", 18, "도술"), new Teacher("T01", "정약용", 32, "실학"), new Employee("E01", "허균", 48, "문학예술지원부")};
		
		// 2. 초기화
		attends = new Attendance[3];
		attends[0] = new Student("S01", "홍길동", 18, "도술");
		attends[1] = new Teacher("T01", "정약용", 32, "실학");
		attends[2] = new Employee("E01", "허균", 48, "문학예술지원부");
		
		// 실행
		// foreach를 사용하여 persons 배열의 각 엘리먼트에 대하여
		// print() 메소드 호출
		for(Attendance attend: attends) {
			// 가상 메소드 호출(virtual method invocation)
			System.out.println(attend.attend());
		}
		
		/////////////////////////////////////////
		Lesson[] lessons = new Lesson[2];
		lessons[0] = new Student("S01", "홍길동", 18, "도술");
		lessons[1] = new Teacher("T01", "정약용", 32, "실학");
		
		for (Lesson lesson: lessons) {
			System.out.println(lesson.lesson());
		}
		
		Person[] persons;
		persons = new Person[3];
		persons[0] = new Student("S01", "홍길동", 18, "도술");
		persons[1] = new Teacher("T01", "정약용", 32, "실학");
		persons[2] = new Employee("E01", "허균", 48, "문학예술지원부");		
		
//		for(Person person: persons) {
//			System.out.println(person.attend());
//		}
	}

}
