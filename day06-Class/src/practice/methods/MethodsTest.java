package practice.methods;

import java.util.Scanner;

public class MethodsTest {

	public static void main(String[] args) {
		// 1. 메소드 정의 클래스 VarietyMethods의
		//    변수 선언
		VarietyMethods methods;
		Scanner scan;
		
		
		// 2. 초기화
		methods = new VarietyMethods();
		scan = new Scanner(System.in);
		
		// 3. 사용
		methods.sayHello();
		methods.maxims("홍길동", "호부호형을 못하니...");
		methods.maxims("소크라테스", "Know Yourself");
		methods.maxims("피터사간", "모든 사람은 두 종류의 고통중에서 선택해야 한다. 훈련하는 고통이거나 후회하는고통이거나");
		double cel = methods.fahToCel(100.0);
		System.out.printf("cel =%3.2f%n", cel);
		
		// 1
		methods.birthYearMonth("박상용", 1995, 11);
		
		// 2
		methods.printNineNineTable(9);
		
		//3
		System.out.println("보고싶은 구구단 3개를 입력하세요");
		int[] timetables = {scan.nextInt(),scan.nextInt(), scan.nextInt()};
		int[] timetables2 = new int[3];
		timetables2[0] = 7;
		timetables2[1] = 9;
		timetables2[2] = 4;
		methods.printNintNineTableFromArray(timetables);
		
		// 4
		System.out.println("당신의 몸무게(kg) 과 키(m)를 입력해주세요");
		String bmi = methods.calcBmi(scan.nextDouble(),scan.nextDouble());
		System.out.printf("당신의 BMI 결과는 %s%n", bmi);
		
		// 5
		System.out.println("비교할 정수 2개를 입력해 주세요");
		int min = methods.min(scan.nextInt(), scan.nextInt());
		System.out.println("작은수는" + min);
		
		// 6
		System.out.println("비교할 정수 2개를 입력해 주세요");
	    int max = methods.max(scan.nextInt(), scan.nextInt());
	    System.out.println("큰 수" + max);
	    
	    // 7
	    System.out.println("합을 보고싶은 정수 3개를 입력해 주세요");
	    int[] sums = {scan.nextInt(), scan.nextInt(), scan.nextInt()};
	    System.out.println("각 배열 원소의 합" + methods.sumOfArray(sums));
	    
	    // 8
	    System.out.println("합의 평균을 보고싶은 정수 5개 입력");
	    int[] avgs = {scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt()};
	    System.out.printf("각 배열 원소 합의 평균 =%5.2f%n", methods.avgOfArray(avgs));
	    
		// 9
	    methods.adder(30, 60, '+');
	    methods.adder(70, 80, '-');
		
	}

}
