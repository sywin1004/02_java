package eraser.two;

/**
 * 지우개를 사용해보는 클래스
 * @author Administrator
 *
 */
public class EraserTest {

	public static void main(String[] args) {
		// 1. 선언 : 칠판 지우개 객체 참조 변수
		Eraser leftEraser;
		Eraser rightEraser;
		
		// 2. 초기화
		// (1) 왼쪽지우개는 기본생성자로 초기화
		leftEraser = new Eraser();
		// (2) 오른쪽 지우개는 매개변수 생성자로 초기화
		rightEraser = new Eraser(3, 12.0, 5.5, 3, "흰색");
		
		// 3. 사용
//		(1) 두 지우개 초기 상태 출력
		leftEraser.print();
		rightEraser.print();
		
//		(2) 오른쪽 지우개에 한 겹 제거
		rightEraser.peel();
		
//		(3) 두 지우개 상태 출력
		leftEraser.print();
		rightEraser.print();
		
//		(4) 오른쪽 지우개 한 겹 제거
		leftEraser.peel();
		rightEraser.peel();
		
//		(5) 왼쪽 지우개로 칠판지우기
		leftEraser.erase();
		
//		(6) 두 지우개 상태 출력
		leftEraser.print();
		rightEraser.print();
	}

}
