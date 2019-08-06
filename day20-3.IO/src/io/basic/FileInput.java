package io.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 파일로 입력받아서(파일 내용을 읽어서)
 * 표준 출력(모니터, 콘솔창)을 하는 클래스
 * --------------------------------------------
 * -- 입력 --
 * 1. node stream (파일(문자 파일:reader) : FileReader)
 * 2. filter stream (reder => reader : BufferedReader)
 * 3. filter stream 의 메소드 readLine() 을 사용
 * 
 * -- 출력 --
 * 4. node stream (표준 출력: System.out : PrintStream)
 * 5. 1줄씩 출력 : println()
 * 
 * -- 정리 --
 * 6. 입력 filter stream 닫기
 * @author Administrator
 *
 */
public class FileInput {

	public static void main(String[] args) throws IOException {
		// 1. 입력 node stream : FileReader
		FileReader fr = new FileReader("out.txt");
		// 2. 입력 filter stream : BufferedReader
		BufferedReader br = new BufferedReader(fr);
		
		// 3. 입력 filter stream 의 줄단위 입력 메소드 사용
		//    readLine()
		String input = null;
		
		while((input = br.readLine()) != null) {
			// 4, 5
			System.out.println("파일에서 읽은 데이터:" + input);
		}
		
		// 6. 입력 filter stream 닫기
		br.close();

	}

}
