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
 * 
 * @author Administrator
 *
 */
public class Menu {
	
	// 1. 멤버변수 선언부
	private int orderNumber;
	private String name;
	private int price;
	private String ingredient;
	
	// 2. 생성자 선언부 (기본생성자 + 중복성언)
	Menu(){
		
	}
	Menu(int orderNumber){
		this();
		this.orderNumber = orderNumber;
	}
	Menu(int orderNumber, String name){
		this(orderNumber);
		this.name = name;
	}
	Menu(int orderNumber, String name, int price){
		this(orderNumber, name);
		this.price = price;
	}
	Menu(int orderNumber, String name, int price, String ingredient){
		this(orderNumber, name, price);
		this.ingredient = ingredient;
	}
	
	// 3. 메소드 선언부
	// 밥버거의 상태 출력
	public void print() {
		System.out.printf("주문자 :%s 메뉴 : %s 가격 : %d 속재료 : %s%n", orderNumber, this.name, price, ingredient);
	}
	
	// 접근자 수정자 선언
	/**
	 * 메뉴이름을 리턴하는 접근자
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 메뉴이름을 수정(set)하는 수정자
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 주문번호를 리턴하는 접근자
	 * @return
	 */
	public int getOrderNumber() {
		return orderNumber;
	}
	/**
	 * 주문번호를 수정하는 수정자
	 * @param orderNumber
	 */
	public void setOderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * 가격을 리턴하는 접근자
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * 가격을 수정하는 수정자
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * 속재료를 리턴하는 접근자
	 * @return
	 */
	public String getIngredient() {
		return ingredient;
	}
	/**
	 * 속재료를 수정하는 수정자
	 * @param ingredient
	 */
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
}
