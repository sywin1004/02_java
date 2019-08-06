package io.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 문자 파일에서 입력받아서(문자 파일을 읽어서)
 * 문자 파일로 출력(문자 파일로 쓰기)
 * ----------------------------------------------
 * -- 입력 --
 * 1. node stream (문자(reader) 파일 : FileReader)
 * 2. filter stream (reader => reader : BufferedReader)
 * 3. 입력 filter stream 의 줄단위 입력 메소드 사용
 * realLine()
 * 
 * -- 출력 -- 
 * 4. node stream (문자(writer) 파일 : FileWriter)
 * 5. filter stream (writer => writer : PrintWriter)
 * 6. 출력 filter stream 의 줄단위 출력 메소드 사용
 *    println()
 * 
 * -- 정리 --
 * 7. 입력 filter stream 닫기
 * 8. 출력 filter strema 닫기
 * 
 * @author Administrator
 *
 */
public class TextFileCopy {

	public static void main(String[] args) throws IOException {
		// 1. 입력 node stream : FileReader
		FileReader fr = new FileReader("out.txt");
		
		// 2. 입력 filter stream : BufferedReader
		BufferedReader br = new BufferedReader(fr);
		
		// =========== 입력 스트림들 선언, 초기화
		
		// 4. 출력 node stream : FileWriter
		FileWriter fw = new FileWriter("copied.txt");
		
		// 5. 출력 filter stream : PrintWriter
		PrintWriter out = new PrintWriter(fw);
		
		// 3. 읽기 작업 : readLine()
		String input = null;
		
		while((input = br.readLine())!= null) {
			// 6. 쓰기 작업 : printtln()
			out.println("복사된 내용:" + input);
			// 화면 출력 같이
			System.out.println("파일에서 읽은 데이터:" + input);
		}
		
		System.out.println("파일 복사가 완료되었습니다.");
		
		// 7. 입력 filter stream 닫기
		br.close();
		// 8. 출력 filter stream 닫기
		out.close();
	}

}
