package io.data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 객체의 데이터가 담긴 파일을 읽어서
 * 데이터 단위로 입력받고
 * 그 내용을 객체로 생성 (new)
 *-----------------------------------------------
 * -- 입력 --
 * 1. node stream (파일 : FileInputStream)
 * 2. filter stream (데이터 단위 입력 : DataInputStream)
 * 3. read 작업 : filter stream 메소드 사용
 *    readInt(), readChar(), readUTF() ...
 * 
 * -- 출력 -- 
 * 4. read 를 통해서 얻은 값들로 Book 객체 생성
 * 5. 4에서 만들어진 Book 객체 표준 출력
 * 
 * -- 정리 --
 * 6. 입력 filter stream 닫기
 * @author Administrator
 *
 */
public class ReadBookData {

	public static void main(String[] args) throws IOException {
		// 1. 입력 node stream : FileInputStream
		FileInputStream fis = new FileInputStream("book.data");
		
		// 2. 입력 filter stream : DataInputStream
		DataInputStream in = new DataInputStream(fis);
		
		// 3. read 작업
		// (1) Book 객체 생성에 필요한 값들 읽어서 변수에 담기
		// 주의: 내가 write 한 순서대로 읽어야 함
		int sequence = in.readInt();
		String isbn = in.readUTF();
		String title = in.readUTF();
		String author = in.readUTF();
		String company = in.readUTF();
		int totalPage = in.readInt();
		int price = in.readInt();
		int quantity = in.readInt();
		
		// (2) Book 객체 생성
		Book vegeterian = new Book(sequence, isbn, title, author, company, totalPage, price, quantity);
		
		// 4. 표준 출력
		System.out.println(vegeterian);
		
		// 5. 입력 filter stream 닫기
		in.close();

	}

}
