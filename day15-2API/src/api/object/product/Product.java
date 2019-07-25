package api.object.product;

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
	/** 제품코드 */
	private String pcode;
	/** 제품이름 */
	private String pname;
	/** 가격 */
	private int price;
	/** 재고수량 */
	private int quantity;
	
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
	
	
	
	// 할인 메소드
	/**
	 * 제품의 할인율을 받아 할인가를 돌려주는메소드
	 * @param percentage
	 * @return
	 */
	public int discount(double percentage) {
//		return price = price - (int)((double)price * percentage);
		double discount;
		discount = price * percentage;
		price = price - (int)discount;
		return price;
	}
	
	// 판매 메소드
	/**
	 * 팔린재고만큼 현재 재고에 차감하는메소드
	 * @param amount
	 */
	public void sell(int amount) {
		if(quantity - amount >= 0) {
			quantity -= amount;
		}
	}
	// 입고 메소드
	/**
	 * 들어온 제품을 재고에 더하는 메소드
	 * @param amount
	 */
	public void buy(int amount) {
		quantity += amount;
	}
	
	/* --------------------------------------------------
	 * 캡슐화를 적용하여 멤버변수 필드의 가시성이 private으로 조정되면 
	 * 다른 모든 클래스에서 접근이 불가능해진다.
	 * 따라서 숨겨진 필드에 접근할 수 있는 전용 메소드 쌍을 정의해야 한다. ==> 접근자 수정자
	 * --------------------------------------------------
	 * 접근자 메소드 : getter
	 * --------------------------------------------------
	 * 1. 반드시 메소드 이름은 get으로 시작
	 * 2. get뒤에 오는 이름은 접근하려는 멤버변수이름의 첫글자만 대문자
	 * 3. 매개변수가 없고 멤버변수타입을 리턴함
	 * 4. 멤버변수 타입이 boolean 인 경우
	 * get이 아닌 is로 시작하도록 작성
	 * 5. getXxx(), isXxx() 형태로 정의
	 * --------------------------------------------------
	 * 수정자 메소드 : setter
	 * --------------------------------------------------
	 * 1. set으로 시작
	 * 2. set 뒤에 오는 이름은 수정하려는 멤버변수 이름의 첫 글자만 대문자로하는 낙타표기법적용
	 * 3. 메소드 매개변수는 수정하려는 멤버변수 타입과 맞추고
	 * 수정변수이름과 멤버변수이름이 같게 설정
	 * this.xxx = xxx
	 * 4. 리턴타입은 void
	 */
	// 수정자 메소드 선언
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// 접근자 메소드 선언
	public String getPcode() {
		return pcode;
	}
	
	public String getPname() {
		return pname;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public String toString() {
		return String.format("제품코드 :%s 제품이름 :%s 가격 :%d 남은재고: %d", pcode, pname, price, quantity);
	}
	
	// 출력메소드
	/**
	 * 제품의 상태를 출력하는 메소드
	 */
	public void print() {
		System.out.println(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (pcode == null) {
			if (other.pcode != null)
				return false;
		} else if (!pcode.equals(other.pcode))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pcode == null) ? 0 : pcode.hashCode());
		return result;
	}
	
	
	
	
}
