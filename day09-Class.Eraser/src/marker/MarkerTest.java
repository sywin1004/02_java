package marker;

/**
 * 화이트 보드 마커를 사용하는 테스트 클래스
 * @author Administrator
 *
 */
public class MarkerTest {

	public static void main(String[] args) {
		// 1. 선언
		Marker red;
		Marker blue;
		Marker green;
		Marker black;
		
		// 2. 초기화
		red = new Marker(true, true, "빨강");
		blue = new Marker(false, false, "파랑");
		green = new Marker(true, false, "초록");
		black = new Marker(true, false, "검정");
		// 3. 사용
		// (1) 마커 상태 출력
		red.print();
		blue.print();
		green.print();
		black.print();
		
		// (2)
		blue.used();
		black.used();
	}

}













