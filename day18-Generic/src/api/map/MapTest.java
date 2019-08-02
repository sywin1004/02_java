package api.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 데이터를 Key, Value 를 쌍으로 저장하는 자료구조인
 * Map 을 테스트하는 클래스
 * 
 * Key : 중복을 허용하지 않음 순서는 상관없음(Set의 특징을 가짐)
 * Value : 중복을 허용
 * 
 * Key, Value 는 반드시 한 쌍으로만 취급할 수 있음
 * Key 없는 Value 를 만들 수 없음.
 * Key 없이 Value 를 찾을 수 없음
 * 
 * Key, Value 에 모든 (참조)타입의 데이터 저장 가능
 * 
 * --------------------------------------------
 * 
 * @author Administrator
 *
 */
public class MapTest {

	public static void main(String[] args) {
		// 1. 선언 : Map 인터페이스 타입 변수
		Map map;
		
		// 2. 초기화 : HashMap 클래스 인스턴스로 초기화
		map = new HashMap();
		
		// 3. 사용 
		// (1) Map 에 데이터 추가 put(k, v)
		// Key : String, Value : String
		map.put("1", "안녕하세요");
		// Key : Integer, Value : String
		map.put(new Integer(2), "반가워요~");
		// Key : Character, Value : String
		map.put('3', "아... 오늘 날씨가...");
		// Key : Double, Value : String
		map.put(4.0, "너무나 더워요..!");
		// Key Boolean, Value : Book : (사용자 정의 타입 가능)
		map.put(true, new Book());
		map.put(false, new Book(5));
		
		// (2) Map 의 데이터 추출 get(K)
		System.out.println(map.get("1"));
		System.out.println(map.get(2)); // auto-boxing, equals(), toString(), hashCode()
		System.out.println('3');
		System.out.println(map.get(new Double(4.0)));
		System.out.println(map.get(true));
		System.out.println(map.get(false));
		
		// (3) Map 의 데이터 추출 : 전체 데이터 추출
		// foreach 로 
		// Key 꾸러미를 먼저 얻어내야 함
		Set keys = map.keySet();
		
		// 얻어진 key 꾸러미가 Set 이기 때문에
		// 1. 이 key 에 foreach를 적용
		// 2. 이 때 얻어진 Key 로 get(key)를 반복적용
		for(Object key: keys) {
//			System.out.println(map.get(key));
			System.out.printf("key=%s : value=%s%n",key.toString(), map.get(key).toString());
		}
		
	}

}
