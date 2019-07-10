package array.basic;

/**
 * 직원들의 급여정보 (기본형 int 타입)를
 * 저장하는 배열을 테스트하는 클래스
 * @author Administrator
 *
 */
public class ArraySalaries {

	public static void main(String[] args) {
		// 1. 선언 : 배열 참조 변수 : 변수이름 복수형으로 줄 것.
		int[] salaries;
		
		// 2. 초기화 : 배열 참조 변수는 기본형이 아니므로
		//             초기화를 위해 new 를 사용해야 한다.
		//             배열 괄호 안에 배열의 크기를 입력한다.
		salaries = new int[10];
		
		// 3. 사용
		// (1) 배열의 값을 넣기 전에 출력
		// vs. 일반 기본형 변수는 명시적 초기화 후에 사용 가능
//		int age = 30;
//		System.out.println("나이:" + age);
		
		System.out.println("(1) 배열 생성 직후 원소 출력==");
		System.out.printf("salaries[0]=%d%n", salaries[0]);
		System.out.printf("salaries[1]=%d%n", salaries[1]);
		System.out.printf("salaries[2]=%d%n", salaries[2]);
		System.out.printf("salaries[3]=%d%n", salaries[3]);
		System.out.printf("salaries[4]=%d%n", salaries[4]);
		System.out.printf("salaries[5]=%d%n", salaries[5]);
		System.out.printf("salaries[6]=%d%n", salaries[6]);
		System.out.printf("salaries[7]=%d%n", salaries[7]);
		System.out.printf("salaries[8]=%d%n", salaries[8]);
		System.out.printf("salaries[9]=%d%n", salaries[9]);
		// 결과의 원인 : new 연산자의 기능
		//               칸을 마련 + 원소 타입의 기본값으로 초기화 int의 기본값 : 0
		
		// 배열의 각 칸에 값을 할당
		
		salaries[0] = 10;
		salaries[1] = 55;
		salaries[2] = 86;
		salaries[3] = 23;
		salaries[4] = 98;
		salaries[5] = 34;
		salaries[6] = 50;
		salaries[7] = 76;
		salaries[8] = 11;
		salaries[9] = 8;
		System.out.println("(2) 배열 생성 직후 원소 출력==");
		System.out.printf("salaries[0]=%d%n", salaries[0]);
		System.out.printf("salaries[1]=%d%n", salaries[1]);
		System.out.printf("salaries[2]=%d%n", salaries[2]);
		System.out.printf("salaries[3]=%d%n", salaries[3]);
		System.out.printf("salaries[4]=%d%n", salaries[4]);
		System.out.printf("salaries[5]=%d%n", salaries[5]);
		System.out.printf("salaries[6]=%d%n", salaries[6]);
		System.out.printf("salaries[7]=%d%n", salaries[7]);
		System.out.printf("salaries[8]=%d%n", salaries[8]);
		System.out.printf("salaries[9]=%d%n", salaries[9]);
		
		// 배열이 생성되면 길이를 나타내는 length 변수가
		// JVM(자바 가상 머신)에 의해 생성됨.
//		System.out.println("salaries 배열의 길이 :" + salaries.length);
		
		// 만약 index 를 벗어나는 접근을 하면
//		System.out.printf("salaries[10]=%d%n", salaries[10]);
		/*
		 *java.lang.ArrayIndexOutOfBoundsException: 10 
		 */
		
		// 만약 index 를 -값으로 접근을 하면
//		System.out.printf("salaries[-1]=%d%n", salaries[-1]);
		/*
		 * java.lang.ArrayIndexOutOfBoundsException: -1
		 */
		
		// ====================================================
		// for loop 와 배열의 조합
		for (int idx = 0; idx < salaries.length; idx++) {
			System.out.printf("salaries[%d]=%d%n", idx, salaries[idx]);
		}
	}

}
