package generic.definition.getinstance;

import static generic.definition.getinstance.DataPair.getInstance;
/**
 * Generic 을 사용하여
 * 사용자 정의한 클래스인
 * DataPair 를 테스느
 * @author Administrator
 *
 */
public class DataPairTest {

	public static void main(String[] args) {
		// 1. 선언
		
		DataPair<Integer, String> isDataPair;
		DataPair<String, String> ssDataPair;
		DataPair<Integer, Book> idDataPari;
		
		// 2. 초기화
		isDataPair = getInstance(1, "one");
		ssDataPair = getInstance("two", "둘");
		idDataPari = getInstance(1, new Book(1));
		
		// 3. 사용
		System.out.printf("%d:%s%n", isDataPair.getKey(), isDataPair.getValue());
		System.out.printf("%s:%s%n", ssDataPair.getKey(), ssDataPair.getValue());
		System.out.printf("%d:%s%n", idDataPari.getKey(), idDataPari.getValue());
	}

}
