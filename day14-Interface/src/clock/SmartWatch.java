package clock;

/**
 * Clock 인터페이스를 구현하여
 * 스마트워치를 정의하는 클래스
 * -----------------------------
 * 인터페이스를 수현하면 구현하는 인터페이스안에 선언된
 * 추상메소드를 상속받게 된다.
 * 
 * 클래스가 추상메소드를 가지고 있으면
 * 반드시 추상클래스로 선언되어야 한다.
 * @author Administrator
 *
 */
public abstract class SmartWatch implements Clock {
	
	/**
	 * 스마트워치 이름을 저장하는 변수
	 */
	private String watchName;
	
	// 수정자 접근자
	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}
	
	public String getWatchName() {
		return watchName;
	}
	
	// Clock 인터페이스에서 상속받은 displayTime() 메소드가 
	// 구현되지 않았으므로 추상클래스로 작성
	// == > 인스턴스화 불가능한 추상클래스가 되며
	// == > 다형성의 타입제공의 의미만 가진 클래스로 된다.
}
