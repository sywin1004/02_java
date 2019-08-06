package io.data;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import io.object.Book;

/**
 * 객체 생성 후 객체의 데이터 필드(멤버 변수)를 출력
 * --------------------------------------------------
 * -- 입력 --
 * 1. Book 객체 생성
 * 
 * -- 출력 --
 * 2. node stream (파일 : FileOutputStream)
 * 3. filter stream (data 단위 출력 : DataOutputStream)
 * 4. 실제 write 작업 : filter stream 의 메소드 사용
 *    writeChar(), writeInt(), writeDouble(), writeUTF() .. 
 * 
 * -- 정리 --
 * 5. 출력 filter stream 닫기
 * 
 * @author Administrator
 *
 */
public class WriteBookData {

	public static void main(String[] args) throws IOException {
		// 입력을 위한 Book 객체 생성
		Book vegetarian = new Book(1, "9788936433598", "채식주의자", "한강", "창비", 247, 10800, 10);
		
		// 2. 출력 node stream
		FileOutputStream fos = new FileOutputStream("book.data");
		
		// 3. 출력용 filter stream
		DataOutputStream out = new DataOutputStream(fos);
		
		// 4. write 작업 : filter stream 의 메소드 사용
		out.writeInt(vegetarian.getSequence());
		out.writeUTF(vegetarian.getIsbn());
		out.writeUTF(vegetarian.getTitle());
		out.writeUTF(vegetarian.getAuthor());
		out.writeUTF(vegetarian.getCompany());
		out.writeInt(vegetarian.getTotalPage());
		out.writeInt(vegetarian.getPrice());
		out.writeInt(vegetarian.getQuantity());
		System.out.println("book.data 파일이 생성되었습니다.");
		
		// 5. 출력 filter stream 닫기
		out.close();
	}

}
