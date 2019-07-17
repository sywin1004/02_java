package eraser.two;

/**
 * 칠판 지우개를 정의하는 클래스
 * ------------------------------------
 * 칠판 지우개 속성 정의 => 멤버변수로 생성
 * 가로 : width  : double
 * 세로 : height : double
 * 높이 : depth  : double
 * 겹   : layer  : int
 * 색상 : color  : String
 * ------------------------------------
 * 생성자 정의 : 중복정의
 * 기본생성자 명시
 * 매개변수를 받는 생성자 : 모든 필드를 다 받도록 정의
 *                        : this 키워드를 사용하여 매개변수 생성자 정의
 * ------------------------------------
 * 기능 정의 : 메소드로 생성
 * 칠판 지우기  : erase() : void : "칠판을 지웠습니다." 문자열 출력
 * 한 겹씩 제거 : peel()  : void : 현재 layer 값에서 1 layer가 0이 될 때까지 
 * 지우개 상태 출력 : print() : void : 현재 지우개의 가로,세로, 높이, 겹, 색상 등의 상태를 출력
 * @author Administrator
 *
 */
public class Eraser {
	// 1. 멤버변수 선언부
	/** 지구개 가로 길이*/
	double width;
	/** 지우개 세로 길이*/
	double height;
	/**지우개 높이 길이*/
	double depth;
	/**지우개 겹의 수*/
	int layer;
	/**손잡이 색깔*/
	String color;
	// 2. 생성자 선언부
	// (1) 기본생성자
	/**
	 * 지우개 클래스의 기본 생성자
	 * 각 멤버변수 필드를 타입의 기본값으로 초기화 진행
	 */
	Eraser(){		
	}
	// (2)매개변수가 있는 생성자
	// 다섯개의 매개변수를 모두 받는다.
	Eraser(double width, double height, double depth, int layer, String color){
		// alt + shift + a : 세로 편집 모드 토글
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.layer = layer;
		this.color = color;
	}
	
	// 3. 메소드 선언부
	// (1) 지우개 기능 erase()
	public void erase() {
		System.out.println("칠판을 지웠습니다.");
	}
	// (2) 겹 갈아끼우기 peel()
	/**
	 * 남아있는 지우개 겹을 벗겨내는 메소드
	 * layer 갑싱 0 보다 작을 수는 없다.
	 * @param peel
	 */
	public void peel() {
		if ((layer = 1) >= 0) {
			layer --;
//			layer -= 1;
		}
//		if (layer >= peel) {
//			layer -= peel;
//		}
	}
	// (3) 상태 호출 print()
	public void print() {
		System.out.printf("현재 지우개 상태는 가로 :%4.2f 세로 :%4.2f 높이 :%4.2f 남은 겹 :%d 색상 :%s%n", width, height, depth, layer, color);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
