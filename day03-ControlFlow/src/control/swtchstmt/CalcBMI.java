package control.swtchstmt;

import java.util.Scanner;

/**
 * 체질량 지수 변수 : weight height String = result double 타입으로
 * @author Administrator
 *
 */
public class CalcBMI {

	public static void main(String[] args) {
		// 1. 선언
		double weight;
		double height;
		String result;
		double bmi;
		Scanner scan;
		
		// 2. 초기화
		scan = new Scanner(System.in);
		
		// 안내문 생성
		System.out.println("키(m)와 몸무게(kg)를 적어주세요.");
		height = scan.nextDouble();
		weight = scan.nextDouble();
		bmi = weight / (height * height);
		
		if (bmi < 15) {
			result = "병적인 저체중";
		} else if (bmi >= 15 && bmi < 18.5) {
			result = "저체중";
		} else if (bmi >= 18.5 && bmi < 23.0) {
			result = "정상";
		} else if (bmi >= 23.0 && bmi < 27.5 ) {
			result = "과체중";
		} else if (bmi > 27.5 && bmi <= 40.0 ) {
			result = "비만";
		} else {
			result = "병적인 비만";
		}
		System.out.printf("당신이 입력한 키%f 와 몸무게 %f 의 체질량 지수는 %f 고 판정은 %s 입니다 %n", height, weight, bmi, result);
		
	}

}
