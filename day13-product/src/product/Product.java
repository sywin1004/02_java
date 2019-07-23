package product;

/**
 * 전자제품을 판매하는 매장에서
 * 관리하는 대상인 "제품"을 정의하는 클래스
 * ------------------------------------------
 * 멤버변수(private, protected, public)을 붙이지 말것
 * 제품번호 : pcode : String : <== "P001"
 * 제품 명 : pname : String : <== "삼성 지펠 ...."
 * 가격    : price : int    : 진짜 그 제품 가격
 * 재고수량 : quantity : int 
 * ------------------------------------------
 * 생성자 (public 으로 선언)
 * 기본생성자, 매개변수받는 생성자 필드 1씩 늘려가면
 * this, this() 사용
 * ------------------------------------------
 * 메소드
 * print() : void
 * ==> 제품의 상태출력
 * 
 * toString() : String
 * == > 이 제품을 대표하는 문자열을 리턴
 * == > String.format() 으로 문자열 생성후 리턴
 * 
 * discount (double percentage) : int
 * ==> 입력된 퍼센트만큼 할인된 가격을 리턴
 * 
 * sell(int amount) : void
 * ==> 매장에서 판매(출고)되어 재고수량이 amount 만큼 줄어들도록 반영
 * ==> 재고수량이 0보다 작아질 수 없도록 제한
 * 
 * buy(int amount) : void
 * ==> 매장에 입고되어 재고수량이 늘어남 
 * ==> amount만큼 늘어나도록 반영
 * ===============================================
 * 작성시 주의 할 것.
 * 
 * 각 필드를 선언할 때, 필드에대한 설명을 문서 주석으로 달 것.
 * 각 생성자 선언할 때, 문서 주석 달 것
 * 각 메소드 선언할 때, 메소드 설명을 문서 주석으로 달 것.
 * ----------------------------------------------- 
 * 
 * @author Administrator
 *
 */
public class Product {
	/**
	 * 멤버변수 선언부
	 * 제품코드, 이름 , 가격, 재고를 나타냄
	 */
	String pcode;
	String pname;
	int price;
	int quantity;
	
	/**
	 *생성자를 선언 기본생성자, this를 사용한 중복정의 
	 */
	// 기본생성자
	public Product() {
		
	}
	// this를 받는 생성자들
	public Product(String pcode) {
		this();
		this.pcode = pcode;
	}
	public Product(String pcode, String pname) {
		this(pcode);
		this.pname = pname;
	}
	public Product(String pcode, String pname, int price) {
		this(pcode, pname);
		this.price = price;
	}
	public Product(String pcode, String pname, int price, int quantity) {
		this(pcode, pname,price);
		this.quantity = quantity;
	}
	
	/**
	 * 메소드 선언부
	 * 메소드
	 * print() : void
	 * ==> 제품의 상태출력
	 * 
	 * toString() : String
	 * == > 이 제품을 대표하는 문자열을 리턴
	 * == > String.format() 으로 문자열 생성후 리턴
	 * 
	 * discount (double percentage) : int
	 * ==> 입력된 퍼센트만큼 할인된 가격을 리턴
	 * 
	 * sell(int amount) : void
	 * ==> 매장에서 판매(출고)되어 재고수량이 amount 만큼 줄어들도록 반영
	 * ==> 재고수량이 0보다 작아질 수 없도록 제한
	 * 
	 * buy(int amount) : void
	 * ==> 매장에 입고되어 재고수량이 늘어남 
	 * ==> amount만큼 늘어나도록 반영
	 */
	
	@Override
	public String toString() {
		return String.format("제품코드 :%s 제품이름 :%s 가격 :%d 남은재고: %d", pcode, pname, price, quantity);
	}
	
	// 출력메소드
	public void print() {
		System.out.println(this);
	}
	
	// 할인 메소드
	public int discount(double percentage) {
		double discount;
		discount = price * percentage;
		price = price - (int)discount;
		return price;
	}
	
	// 판매 메소드
	public void sell(int amount) {
		if(quantity - amount >= 0) {
			quantity -= amount;
		}
	}
	// 입고 메소드
	public void buy(int amount) {
		quantity += amount;
	}
}
