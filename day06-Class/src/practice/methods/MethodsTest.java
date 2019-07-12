package practice.methods;

public class MethodsTest {

	public static void main(String[] args) {
		// 1. 메소드 정의 클래스 VarietyMethods의
		//    변수 선언
		VarietyMethods methods;
		
		// 2. 초기화
		methods = new VarietyMethods();
		
		// 3. 사용
		methods.sayHello();
		methods.maxims("홍길동", "호부호형을 못하니...");
		methods.maxims("소크라테스", "Know Yourself");
		methods.maxims("피터사간", "모든 사람은 두 종류의 고통중에서 선택해야 한다. 훈련하는 고통이거나 후회하는고통이거나");
		double cel = methods.fahToCel(100.0);
		System.out.printf("cel =%3.2f%n", cel);
		methods.birthYearMonth("박상용", 1995, 11); // 1
		methods.printNineNineTable(9); // 
		//3
		//4
		int min = methods.min(3, 5);
		System.out.println("작은수는" + min);
	    int max = methods.max(5, 11);
	    System.out.println("큰 수" + max);
		
		
	}

}
