package snack;

/**
 * Oreo 쿠키를 정의하는 클래스
 * -----------------------------
 * 속성 :
 * cream     : String : 바닐라, 초코, 딸기, 말차
 * radius    : double : 오레오 쿠키 1개의 반지름 길이
 * thickness : double : 오레오 쿠키 1개의 두께
 * -------------------------------------------
 * 생성자 : 기본생성자, 중복된 this, this() 로 정의하는 생성자
 * 총 4개의 생성자 중복정의
 * -------------------------------------------
 * 메소드 :
 * print() : void : 오레오 쿠키의 상태출력
 * changeCream(String cream) : void : 매개변수로 입력된 cream 값으로 오레오 쿠키의 크림을 변경함
 * --------------------------------------------------
 *   
 * @author Administrator
 *
 */
public class Oreo {
	// 1. 변수선언부
	String cream;
	double radius;
	double thickness;
	
	// 2. 생성자 선언부
	// 2.1 기본 생성자 (CLASS(Oreo)와 이름이 같고 매개변수가 비어있음
	Oreo(){
		
	}
	
	// 2.2 this() 생성자
	Oreo(String cream){
		this();
		this.cream = cream;
	}
	
	// 2.3 this()에2개를 받는 생성자
	Oreo(String cream, double radius){
		this(cream);
		this.radius = radius;
	}
	
	// 2.3 this()에3개를 받는 생성자
	Oreo(String cream, double radius, double thickness){
		this(cream, radius);
		this.thickness = thickness;
	}
		
	
	// 3. 메소드 선언부
	public void changCream(String cream) {
		this.cream = cream;
	}
	
	public void print() {
		System.out.printf("현재 오레오 상태는 크림 :%s맛 반지름 :%4.1f 두께 :%4.1f 입니다.%n", cream, radius, thickness);
	}
	
	
	
	
	
}
