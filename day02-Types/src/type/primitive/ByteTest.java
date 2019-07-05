package type.primitive;
/**
 * byte : 1byte(8bit) 에 해당하는 범위만큼
 *        정수를 저장하는 타입
 *------------------------------------------------
 * 8bit = 2의 제곱
 *      = 256
 *      = 256개의 숫자를 표현가능
 *      = -127 ~ 0 ~ 126 까지 표현가능
 * ----------------------------------------------             
 * @author Administrator
 *
 */
public class ByteTest {

	public static void main(String[] args) {
		// 1. 선언
		byte buffer;
		
		// 2. 초기화
		buffer = 0;
		
		// 3. 사용 : 출력
		System.out.println("buffer=" + buffer);
		
		// 4. 값을 변경
		buffer = 127;
		System.out.println("buffer=" + buffer);
		
		buffer = -128;
		System.out.println("buffer=" + buffer);
		
		// 5. 값의 범위를 벗어나는 값을 저장하려는 시도
		// err : Type mismatch
//		buffer = 128; 타입이 맞지않는다 128은 byte의 최댓값을 넘어 int로 인식함
	}

}
