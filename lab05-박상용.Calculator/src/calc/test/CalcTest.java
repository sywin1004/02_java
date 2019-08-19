package calc.test;

import calc.Calculator;
import calc.input.DoubleInputValue;
import calc.input.IntInputValue;
import calc.result.DoubleResultValue;
import calc.result.IntResultValue;

/**
 * Calculator 클래스에서 만든 메소드 10개를 테스트하는 클래스
 * @author passw
 *
 */
public class CalcTest {

	public static void main(String[] args) {
		
		// 선언
		IntInputValue intInput;
		DoubleInputValue doubleInput;
		Calculator calc;
		IntResultValue intResult;
		DoubleResultValue doubleResult;
		// 초기화
		calc = new Calculator();
		intInput = new IntInputValue();
		doubleInput = new DoubleInputValue();
		intResult = new IntResultValue();
		doubleResult = new DoubleResultValue();
		
		
		// intInput x와 y값 set
		intInput.setX(100);
		intInput.setY(30);
		
		// doubleInput x와 y값 set
		doubleInput.setX(100);
		doubleInput.setY(30);
		
		// 실행
		intResult = calc.add(intInput);
		System.out.printf("[x= %d] + [y= %d] = %s%n", intInput.getX(), intInput.getY(), intResult);
		
		doubleResult = calc.add(doubleInput);
		System.out.println(doubleResult);
		
		intResult = calc.div(intInput);
		System.out.println(intResult);
		
		doubleResult = calc.div(doubleInput);
		System.out.println(doubleResult);
		
		intResult = calc.mult(intInput);
		System.out.println(intResult);
		
		doubleResult = calc.mult(doubleInput);
		System.out.println(doubleResult);
		
		intResult = calc.mod(intInput);
		System.out.println(intResult);
		
		doubleResult = calc.mod(doubleInput);
		System.out.println(doubleResult);
	}

}
