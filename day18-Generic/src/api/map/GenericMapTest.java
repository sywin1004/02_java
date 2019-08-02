package api.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 데이터를 Key, Value 를 쌍으로 저장하는 자료구조인
 * Map 인터페이스에서
 * 
 * Key, Value 양쪽 모두 Generic 을 적용하는
 * 테스트
 * 
 * @author Administrator
 *
 */
public class GenericMapTest {

	public static void main(String[] args) {
		// 1. 선언 : Key : Integer, Value : String
		Map<Integer, String> map;
		
		// 2. 초기화 : HashMap 중 Key : Integer, Value : String
		map = new HashMap<>();
		
		// 3. 사용 
		// (1) 데이터 추가: put(Integer, String)
		map.put(1, "안녕하세요");
		// Key : Integer, Value : String
		map.put(new Integer(2), "반가워요~");
		// Key : Character, Value : String
		map.put(3, "아... 오늘 날씨가...");
		// Key : Double, Value : String
		map.put(4, "너무나 더워요..!");
		// Key Boolean, Value : Book : (사용자 정의 타입 가능)
		map.put(5, new Book().getTitle());
		map.put(6, new Book(5).getAuthor());
		
		Set<Integer> keys = map.keySet();
		
		for(int key: keys) {
			System.out.printf("key=%d : value=%s%n", key, map.get(key));
		}
	}

}
