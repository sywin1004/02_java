package type.primitive;
/**
 * char : 문자 1개를 저장하는 타입
 * 내부적으로는 숫자를 저장하는 특징이 있다.
 * 
 * @author Administrator
 *
 */
public class CharTest {

	public static void main(String[] args) {
		// 1. 선언 : 타입이름 변수이름;
		char input;
		/*
		 input = 'A+' // 두 글자 이상을 저장하려는 오류
		 input = A;   // ''작은따옴표 안에 문자를 쓰지 않았으므로 오류
		 */ 
		 
		// 2. 초기화 : 변수이름 = 값
		input = 'a';
		
		// 3. 사용
		System.out.println("input=" + input);
		
		// 4. char 가 내부적으로 숫자로 저장되는 것 확인
		// 정수를 저장하는 변수 code 를 선언하면서
		// 문자를 저장하는 변수 input 의 값을 복사
		int code = input;
		System.out.println("code=" + code);
		
		// code 는 정수를 저장하는 변수이므로
		// +1 하는 산술연산을 하여 값을 증가시키고 
		code = code + 1;
		System.out.println("code=" + code);
		// + 1 증가된 정수값을 강제로 문자(char)로 바꾸어 출력
		System.out.println("(char)code=" + (char)code);
		
		
		
	}

}
