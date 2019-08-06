package io.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 바이트 처리만 할 수 있는
 * 
 * 이미지 파일을 입력받아서
 * 이미지 파일로 출력하는
 * (stream 으로만 작업하는)
 * 
 * 이미지 복사 클래스
 * ----------------------------------
 * -- 입력 --
 * 1. node stream (stream : FileInputStream)
 * 2. read 작업 : node stream 메소드 read(byte[])
 * 
 * -- 출력 --
 * 3. node stream (stream : FileOutputStram)
 * 4. write 작업 : node stream 메소드 write(byte[])
 * 
 * 
 * -- 정리 --
 * 5. 입력 node 닫기
 * 6. 출력 node 닫기
 * 
 * @author Administrator
 *
 */
public class ImageCopy {

	public static void main(String[] args) throws IOException {
		// 1. 입력 node stream : FileInputStream
		FileInputStream in = new FileInputStream("Tulips.jpg");
		
		// ======= 입력 node stream 선언, 초기화 완료
		
		// 3. 출력 node stream : FileOutputStream
		FileOutputStream out = new FileOutputStream("Tulips-copied.jpg");
		
		// ====== 출력 node stream 선언, 초기화 완료
		
		// 2. read 작업 : read(byte[]) 메소드
		//    읽기 작업의 매개변수로 사용된
		//    byte[]을 선언
		
		// (1) 바이트 배열 : buffer
		byte[] buffer = new byte[4096];
		
		// (2) read(byte[]) 메소드는 읽어들인 바이트 수
		//     를 정수로 리턴하는 메소드
		//     읽은 데이터가 없으면 -1 리턴
		int readSize = 0;
		int repeat = 0;
		
		// (3) read()
		while ((readSize = in.read(buffer)) != -1) {
			// 4. write(byte[]) 작업 : 출력 node stream 메소드로 작업
			out.write(buffer);
			// 화면에 작업내용 출력
			System.out.printf("읽은 바이트:%d\t, 반복 회수:%d%n", readSize, ++repeat);
		}
		System.out.println("이미지 파일 복사가 완료되었습니다.");
		
		// 5,6 입출력 node 닫기
		in.close();
		out.close();

	}

}
