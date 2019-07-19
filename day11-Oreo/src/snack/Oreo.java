package snack;

/**
 * Oreo 쿠키를 정의하는 클래스 ---------------------------- 속성 : cream : String : 바닐라, 초코,
 * 딸기, 말차 radius : double : 오레오 쿠키 1개의 반지름 길이 thickness : double : 오레오 쿠기 1개의 두께
 * ---------------------------- 생성자 : 기본생성자, this, this() 로 정의하는 생성자 총 4개의 생성자
 * 중복정의 ---------------------------- 메소드 : print() : void : 오레오 쿠키의 상태 출력
 * changeCream(String cream) : void : 매개변수로 입력된 cream 값으로 오레오 쿠키의 크림을 변경함
 * ----------------------------
 * 
 * @author 304
 *
 */
public class Oreo {

	// 1. 멤버변수 선언
	// TODO 쿠키 일려번호 int seq; 추가
	int sequence;
	String cream;
	double radius;
	double thickness;

	// 2. 생성자 중복정의
	Oreo() {
		
	}
	
	// TODO 생성자 seq 필드에 대해 중복정의
	Oreo (int sequence){
		this();
		this.sequence = sequence;
	}
	
	Oreo(int sequence,String cream) {
		this(sequence);
		this.cream = cream;
	}

	Oreo(int sequence, String cream, double radius) {
		this(sequence, cream);
		this.radius = radius;
	}

	Oreo(int sequence, String cream, double radius, double thickness) {
		this(sequence,cream, radius);
		this.thickness = thickness;
	}

	// 3. 메소드
	public void print() {
		System.out.printf("오레오 쿠키 상태 [크림의 종류:%s" + ", 반지름: %4.1f, 두께: %4.1f] %n", cream, radius, thickness);
	}

	public void changeCream(String cream) {
		this.cream = cream;
	}

	// TODO 접근자, 수정자 추가 getter setter
	// getter ==> 리턴타입이 해당 멤버변수와 같은 타입을 받고 매개변수가 비어있다. 이름은 앞의get뒤에 붙는 문자는 대문자
	// setter ==> 리턴타입이 없고 멤버변수와 같은 타입의 매개변수를 받고 this.멤버변수 = 매개변수 앞의 set 붙이고 붙는문자는 대문자로
	
	// sequence 멤버변수의 getter
	public int getSequence() {
		return sequence;
	}
	
	// sequence 멤버변수의 setter
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	// cream 멤버변수의 getter
	public String getCream() {
		return cream;
	}
	
	// cream 멤버변수의 setter
	public void setSequence(String cream) {
		this.cream = cream;
	}
	
	// radius 멤버변수의 getter
	public double getRadius() {
		return radius;
	}
	
	// radius 멤버변수의 setter
	public void setRadius (double radius) {
		this.radius = radius;
	}
	
	// thickness 멤버변수의 getter
	public double getThickness() {
		return thickness;
	}
	
	// thickness 멤버변수의 setter
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}

}
