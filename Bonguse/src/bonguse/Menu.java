package bonguse;

/**
 * 봉구스 메뉴 입력시 가격, 속재료를 출력하는 클래스
 * ------------------------------------
 * 변수 선언부
 * String name : 메뉴이름
 * int : price : 가격
 * String :ingredient : 속재료
 * ------------------------------------
 * 생성자 선언부
 * 기본생성자
 * 생성자 중복정의
 * ------------------------------------
 * 메소드
 * 메뉴 입력시 그 속재료를 알려주는 출력
 * 가격대 입력시 그 가격대에 맞는 봉구스 밥버거들 출력
 * 
 * 
 * @author Administrator
 *
 */
public class Menu {
	
	// 1. 멤버변수 선언부
	String name;
	int price;
	String ingredient;
	
	// 2. 생성자 선언부 (기본생성자 + 중복성언)
	Menu(){
		
	}
	Menu(String name){
		this();
		this.name = name;
	}
	Menu(String name, int price){
		this(name);
		this.price = price;
	}
	Menu(String name, int price, String ingredient){
		this(name,price);
		this.ingredient = ingredient;
	}
	
	// 3. 메소드 선언부
	// 메뉴 입력시 속재료 가격
	public void ingredient(String name) {
		System.out.printf("메뉴 : %s 가격 : %d 속재료 : %s", name);
	}
	// 가격대 입력시 그 가격대에 맞는 밥버거들 출력
	
	
	
	
	
}
