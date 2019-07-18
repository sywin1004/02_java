package marker;

/**
 * 화이트보드 마커를 정의하는 클래스
 * 속성
 * 색은 빨강 color
 * 뚜껑이 열림, 닫힘 boolean isOpened
 * 잉크가 가득, 다씀 boolean isFulled
 * 
 * ---------------------------------------
 * 생성자는 기본생성자, this의 매개변수 1, 2, 3 총 4개를생성
 * ----------------------------------------
 * 메소드
 * 기능은 사용기능 used
 * 출력 print
 * @author Administrator
 *
 */
public class Marker {
	// 1. 변수 선언부
	// 공용 (static 변수) 생성 
	static int count = 0; // 메인보다 먼저 실행되기 때문에 선언과 동시에 초기화
	
	// 1.1 받을 마커 일련번호 int serial
	int serial;
	
	/**뚜껑이 열려있는지 여부
	 * true : 새마커
	 * false : 다 쓴 마커
	 */
	boolean isOpened;
	
	/**잉크가 가득 있는지 여부
	 * true : 잉크가 가득
	 * false :잉크를 다 씀
	 *
	 */	
	boolean isFulled;
	String color;
	// 2. 생성자 선언부
	// (1) 기본생성자
	Marker(){
		this.serial = ++count;
	}
	// (2) 뚜껑의 상태를 받는 생성자
	Marker(boolean isOpened){
		this();
		this.isOpened = isOpened;
	}
	// (3) 잉크의 상태를 직접 받는 this 생성자
	Marker(boolean isOpened, boolean isFulled){
		this(isOpened);
		this.isFulled = isFulled;
	}
	
	Marker(boolean isOpened, boolean isFulled, String color){
		this(isOpened, isFulled);
		this.color = color;
	}
	// 3. 메소드 선언부
	// (1) 사용하는 기능
	/**
	 * ~ 색의 마커를 사용하고있습니다
	 * 라는 문장을 출력하는 메소드
	 */
	
	public void used() {
			System.out.printf("%d번 %s색 마커를 사용하고 있습니다.%n",serial, color);
	}
	
	
	// (2) 출력기능
	public void print() {
		if(isOpened) {
			if(isFulled) {
				System.out.printf("%d 번 %s색 마커가 뚜껑은 열려있고 잉크는 가득 차 있는 상태입니다%n",serial, color);
			} else {
				System.out.printf("%d 번 %s색 마커가 뚜껑이 열려있고 잉크가 다 쓴 상태입니다%n",serial, color);
			}
		}
		if (isOpened) {
			if(isFulled) {
				System.out.printf("%d 번 %s색 마커가 뚜껑이 닫혀있고 잉크는 가득 차 있는 상태입니다%n",serial, color);
			} else {
				System.out.printf("%d 번 %s색 마커가 뚜껑이 닫혀있고 잉크도 다 쓴 상태입니다%n",serial, color);
			}
		}
	}
	public void print2() {
		String message = "마커번호 %d 마커 색상 : %s, %s, %s%n";
		String openStatus;
		String newStatus;
		
		if(isOpened) {
			openStatus = "뚜껑이 열려 있습니다.";
		} else {
			openStatus = "뚜껑이 닫혀 있습니다.";
		}
		if(isFulled) {
			newStatus = "새 마커입니다";
		} else {
			newStatus ="다 쓴 마커입니다.";
		}
		System.out.printf(message, serial, color, openStatus, newStatus);
	}
		
}
