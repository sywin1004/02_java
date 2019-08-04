package api.map;

import static java.lang.Integer.valueOf;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Key : Integer
 * Value : Book
 * ----------------------------------
 * 데이터 입력
 * key : Book 객체의 seq 를 입력
 * value : Book 객체 자체
 * ----------------------------------
 * 데이터 출력
 * foreach
 * (1) keyset 얻기
 * (2) get(key) 로 추출 = > 출력
 * 
 * foreach
 * (1) keyset 얻기
 * (2) 각 Book 객체의 가격 10%할인가로 출력
 * @author Administrator
 *
 */
public class BookMapTest {

	public static void main(String[] args) {
		
		// 1. 선언
		Map<Integer, Book> books;
		
		// 2. 초기화 put으로 key, value 넣기
		books = new HashMap<>();
		
		Book vegetarian = new Book(1, "9788936433598", "채식주의자" , "한강", "창비", 247, 10800, 10);
		
		Book littlePrince = new Book(2, "9791159039690", "어린왕자(초판본)" , "생텍쥐페리", "더스토리", 150, 8820, 5);
		
		Book noDaap = new Book(3, "9791190182645", "제 인생에 답이 없어요", "선바", "위즈덤하우스", 192, 10800, 3);
		
		Book dduk = new Book(4, "9791196394509", "죽고 싶지만 떡볶이는 먹고 싶어" , "백세희", "흔", 208, 12420, 2); 
		
		Book ax = new Book(5, "9788956055466", "책은 도끼다", "박웅현", "북하우스", 348, 14400, 2);
		

		
		// 3. 실행
		// put 으로 초기화한 Book 타입들을 Key, Value 에 넣기
		books.put(vegetarian.getSequence(), vegetarian);
		books.put(littlePrince.getSequence(), littlePrince);
		books.put(noDaap.getSequence(), noDaap);
		books.put(ax.getSequence(), ax);
		// new Integer로 직접 포장
		books.put(new Integer(dduk.getSequence()), dduk);
		
		// Integer 객체로 포장하는 또 다른 방법
		// static 메소드인 valueOf(int) 를 사용함, import static
		books.put(valueOf(dduk.getQuantity()), dduk);
		books.put(valueOf(ax.getQuantity()), ax);
		
		// keyset으로 key꾸러미 얻기
		Set<Integer> keys = books.keySet(); // Generic을 줘서 Integer만 받은 keyset을 받을 수 있다.
		
		// foreach문을 사용한 key, value 출력
		for(int key: keys) {
			System.out.printf("key=%d : Value=%s%n", key, books.get(key)); // books.get(key)엔 toString() 이 자동 실행 되 printf에서 자동작동 %s가 실행 된다.
		}
		// foreach로 10%할인적용한 key, value 출력
		System.out.println("== 10% 할인 적용 ==");
		for(Object key: keys) {
			int price = books.get(key).getPrice();
			books.get(key).setPrice((int)(price * 0.9));
			System.out.printf("key=%d : Value=%s%n", key,books.get(key));
		}
		
		// JSON Object notation
		
		// Map과 Set을 익히면 이런 선언도 가능해진다
//		Map<Integer, Book>[] bookMaps = new HashMap[5];		
//		List<Map<Integer, Book>> booksList;
//		Set<Map<Integer, Map<Integer, List<Integer>>>> booksSet;
		
		
	}

}
