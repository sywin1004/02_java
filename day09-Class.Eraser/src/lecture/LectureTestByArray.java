package lecture;

/**
 * 2개의 지우개와 4개의 마커를
 * 배열을 사용하여 사용/관리 하는 테스트 클래스
 * ----------------------------------------------
 * 1. 마커(Marker) 배열 markers 를 선언
 *    지우개(Eraser) 배열 erasers 를 선언
 *    
 * 2. markers 는 길이 4로 생성
 *    eraser 는 길이 2로 생성
 * markers[0] <== 에는 순서대로
 * ~
 * markers[3] red, green, blue, black 마커를 저장
 * 
 * erasers[0], [1] 에는 순서대로 leftEraser, rightEraser를 저장
 * @author Administrator
 *
 * 3. foreach를 사용하여
 * (1) 모든 마커를 한번씩 사용(use())
 * (2) 모든 지우개를 한번씩 사용((erase())
 * (3) 모든 지우개를 한번씩 한 겹 벗겨내기((peel))
 * (4) 모든 지우개의 상태 출력
 * (5) 모든 마커의 상태 출력
 */
public class LectureTestByArray {

	public static void main(String[] args) {
		// 1. 선언
		Eraser[] erasers;
		Marker red;
		Marker blue;
		Marker green;
		Marker black;
		Eraser leftEraser;
		Eraser rightEraser;
		
		// 2. 초기화
		leftEraser = new Eraser(3.5, 12.0, 5.5, 3, "검정색", "왼쪽");
		rightEraser = new Eraser(3.5, 12.0, 5.5, 3, "흰색", "오른쪽");	
		
		erasers = new Eraser[2];
		erasers[0] = leftEraser;
		erasers[1] = rightEraser;
		
		red = new Marker(true, true, "빨강");
		blue = new Marker(false, false, "파랑");
		green = new Marker(true, false, "초록");
		black = new Marker(true, false, "검정");
		
		Marker[] markers = {red, green, blue, black}; // 초기화 리스트 배열은 선언과 동시에 초기화해야함
		
		// 3. 사용
		for(Marker marker : markers) {
			marker.used();
		}
		
		for (Eraser eraser : erasers) {
			eraser.erase();
		}
		
		for (Eraser eraser : erasers) {
			eraser.peel();
		}
		
		for (Eraser eraser : erasers) {
			eraser.print();
		}
		
		for (Marker marker : markers) {
			marker.print();
		}
	}

}
