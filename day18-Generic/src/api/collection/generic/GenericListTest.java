package api.collection.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 컬렉션에 저장할 타입의 제한을 주는
 * Generic 이 적용된 List 를 테스트
 * @author Administrator
 *
 *
 */
public class GenericListTest {

	public static void main(String[] args) {
		// 1. 선언 : Integer 만 저장할 수 있는 List 선언
		List<Integer> numbers;
		//           Book 만 저장할 수 있는 List 선언
		List<Book> books;
		
		// 2. 초기화 : Integer 만 저장할 수 있는 ArrayList 로 생성
		numbers = new ArrayList<>(); // ArrayList 처음 초기화했을 때 size == 0
		books = new ArrayList<>();
		
		// 3. 사용
		// (1) Integer 만 저장하는 List에 add(E)
		// auto-boxing
		numbers.add(1); // index:0, value:1
		numbers.add(3); // index:1, value:3
		// numbers List의 1번 인덱스에 2라는 값을 끼워넣는 add()
		numbers.add(1, 2);
		
		// (2) Book 만 저장하는 List 에 add(E)
		
		books.add(new Book(1, "9788936433598", "채식주의자", "한강", "창비", 247, 10800, 10));
		
		books.add(new Book(2, "9791159039690", "어린왕자(초판본)", "생텍쥐페리", "더스토리", 150, 8820, 5));
		
		books.add(new Book(3, "9791190182645", "제 인생에 답이 없어요" , "선바", "위즈덤하우스", 192, 10800, 3));
		
		books.add(new Book(4, "9791196394509", "죽고 싶지만 떡볶이는 먹고 싶어", "백세희", "흔", 208, 12420, 2));
		
		books.add(new Book(5, "9788956055466", "책은 도끼다", "박웅현", "북하우스", 348, 14400, 2));
		
		books.add(new Book());
		// 중복데이터 추가 시도
		books.add(new Book());
		// books 리스트는 Book 타입의 인스턴스만 저장가능
		// books.add("Book"); String 타입이기때문에 Generic에 제한되 나오지 못함
		
		// auto-unboxing 적용
		for(int number: numbers) {
			// set에서 추출된 값에 * 100 을 출력
			System.out.println(number * 100);
		}
		for(Book book: books) {
			System.out.println(book);
		}
		
	}

}
