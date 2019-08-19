package calc;

import calc.input.DoubleInputValue;
import calc.input.IntInputValue;
import calc.result.DoubleResultValue;
import calc.result.IntResultValue;

/**
 *  IntInputValue, DoubleInputValue 를 각각 
    입력받아 각 클래스 인스턴스의 멤버변수 값을 사용하여 
    사칙연산과 나머지 연산을 수행하는 
    add, sub, mult, div, mod(나머지 연산) 메소드가 중복정의된 
    클래스 Calculator 를 작성
    Calculator 클래스 메소드들의 리턴타입은 
    IntInputValue 를 받는 경우는 IntResultValue 로 
    DoubleInputValue 를 받는 경우는 DoubleResultValue 타입으로 작성
 * @author passw
 *
 */
public class Calculator {
	// 생성자 선언부
	// 기본생성자
	public Calculator() {
		
	}
	
	// 메소드 선언부
	// IntInputValue 를 받는 add(덧셈 계산)
	public IntResultValue add (IntInputValue input) {
//		IntInputValue addInt = new IntInputValue();
		IntResultValue result = new IntResultValue();
		
//		addInt.setX(input.getX());
//		addInt.setY(input.getY());		
		result.setResult(input.getX() + input.getY());
		
		return result;
	}
	
	// DobuleInputValue 를 받는 add 중복정의
	public DoubleResultValue add (DoubleInputValue input) {
		DoubleResultValue result = new DoubleResultValue();
		
	
		result.setResult(input.getX() + input.getY());
		
		return result;
	}
	
	// IntInputValue 를 받는 sub(뺄셈 계산) 
	public IntResultValue sub (IntInputValue input) {
		IntResultValue result = new IntResultValue();
		
//		result = input.getX() - input.getY();
		result.setResult(input.getX() - input.getY());
		
		return result;
	}
	
	// DobuleInputValue 를 받는 sub 중복정의
	public DoubleResultValue sub (DoubleInputValue input) {
		DoubleResultValue result = new DoubleResultValue();
		
		result.setResult(input.getX() - input.getY());
		
		return result;
	}
	// IntInputValue 를 받는 mult(곱셈 계산)
	public IntResultValue mult (IntInputValue input) {
		IntResultValue result = new IntResultValue();
		
		result.setResult(input.getX() * input.getY());
		
		return result;
	}
	
	// DobuleInputValue 를 받는 mult 중복정의
	public DoubleResultValue mult (DoubleInputValue input) {
		DoubleResultValue result = new DoubleResultValue();
		
		result.setResult(input.getX() * input.getY());
		
		return result;
	}
	
	// IntInputValue 를 받는 div(나눗셈 계산)
	public IntResultValue div (IntInputValue input) {
		IntResultValue result = new IntResultValue();
		
		result.setResult(input.getX() / input.getY());
		
		return result;
	}
	
	// DobuleInputValue 를 받는 div 중복정의
	public DoubleResultValue div (DoubleInputValue input) {
		DoubleResultValue result = new DoubleResultValue();
		
		result.setResult(input.getX() / input.getY());
		
		return result;
	}
	
	// IntInputValue 를 받는 mod(나머지 계산)
	public IntResultValue mod (IntInputValue input) {
		IntResultValue result = new IntResultValue();
		
		result.setResult(input.getX() % input.getY());
		
		return result;
	}
	
	// DobuleInputValue 를 받는 mod 중복정의
	public DoubleResultValue mod (DoubleInputValue input) {
		DoubleResultValue result = new DoubleResultValue();
		
		result.setResult(input.getX() % input.getY());
		
		return result;
	}
}
