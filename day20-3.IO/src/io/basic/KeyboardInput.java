package io.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 표준 입력인 키보드 입력을 받아서
 * 표준 출력인 모니터(콘솔창) 출력하는 클래스
 * --------------------------------------------------
 * 1. node stream    (키보드 = System.in : InputStream)
 * 2. fulter stream  (stream => reader : InputStreamReader)
 *    1 바이트 키보드 인풋스트림을
 *    2 바이트 문자로 변경
 *    (키보드는 사실 문자입력이기 때문에 변경하는것이 편리함)
 * 3. filter stream (reader => reader : BufferedReader)
 *    2 바이트 문자를 1줄 단위로 읽어서
 *    스트링으로 만들 수 있는 편리한 메소드를 사용하기 위해서
 *    
 * 4. 3에서 만들어진 filter stream 객체를 사용해서
 *    read() 로 읽어들인다.
 *    
 * 5. 4에서 읽어들인 내용을 표준 출력
 *    (모니터 = System.out)
 * 
 * 6. 마지막 필터 스크림들을 닫아서 자원 해제
 * @author Administrator
 *
 */
public class KeyboardInput {

	public static void main(String[] args) throws IOException {
		// 1. 입력 스트림(표준 입력 : 키보드)
		InputStream in = System.in;
		
		// 2. 노드 스르미을 포장할 피렅 스트림
		// InputStream ==> Reader 바꿔주는 필터 스트림 적용
//		InputStreamReader ir = new InputStreamReader(in);
		
		// 3. 2의 필터 스트림을 편리한 사용을 위한
		//    다른 필터 스트림으로 포장
//		BufferedReader br = new BufferedReader(ir);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("값을 입력하세요. (ctrl + z 입력시 중단됩니다.");
		// 4. 3의 필터 스트림의 편리한 메소드 사용해서 읽기
		String readData = null;
		try {
			while((readData = br.readLine()) != null) {
				// 5. 읽은 데이터가 null 이 아니면
				//    표준 출력에 출력하기
				System.out.println("읽은 데이터:" + readData);
			}	
		} catch(IOException) {
			
		}
		
		
		// 6. 자원 해제
		//    예외 발생 여부에 관계 없이
		//    자원 해제는 항상 안정적으로 이루어져야 하므로
		//    finally 에서 진행하도록 작성
		br.close();
	}

}
