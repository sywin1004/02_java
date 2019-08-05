package io.basic;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 표준 입력인 키보드 입력을 받아서
 * 입력된 내용을 파일로 출력하는 클래스
 * --------------------------------------------
 * -- 입력 --
 * 1. node stream (키보드 = System.in : InputStream)
 * 2. filter stream (stream --> reader : InputStreamReader)
 * 3. filter stream (reader --> reader : BufferedReader)
 * 4. 3의 filter stream 을 통해 1줄단위 입력을 지원하는
 *    readLine() 을 사용
 * 
 * 
 * -- 출력 --
 * 5. node stream (파일 - 문자저장(writer) : FileWriter)
 * 6. filter stream (writer --> writer : PrintWriter)
 * 7. 6의 filter stream 을 통해서 1줄단위 출력을 지원하는
 *    println() 을 사용
 *    
 * -- 정리 --
 * 8. 입력에서 마지막으로 사용된 filter stream 닫기
 * 9. 출력에서 마지막으로 사용된 filter stream 닫기
 * 
 * @author 304
 *
 */
public class KeyboardInputFileOutput2 {

	public static void main(String[] args) {

		// 1. 입력 : node stream : System.in
//		InputStream in = System.in;
		
		// 2. 입력 : filter stream : stream --> reader
//		InputStreamReader ir = new InputStreamReader(in);
		
		// 3. 입력 : filter stream : reader --> reader
//		BufferedReader br = new BufferedReader(ir);
		BufferedReader br = 
				new BufferedReader(new InputStreamReader(System.in));

		// 5. 출력 : node stream : file : FileWriter
//		FileWriter fw = new FileWriter("out.txt");
		
		// 6. 출력 : filter stream : writer --> writer
//		PrintWriter out = new PrintWriter(fw);
		PrintWriter out = null;
		
		try {
			out = new PrintWriter(new FileWriter("out.txt"));
			
			// 4. 입력 filter stream 에서 읽기
			System.out.println("값을 입력하세요. (ctrl + z 입력시 중단)");
			
			String readData = null;
			while ((readData = br.readLine()) != null) {
				// 7. 출력 filter stream 에 쓰기
				out.println(readData);
				//    화면 출력
				System.out.println("읽은 데이터:" + readData);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			// 8, 9 객체 닫기
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (out != null)
				out.close();
			
		} // end try ~ catch ~ finally
		
	} // end main method
	
} // end class
