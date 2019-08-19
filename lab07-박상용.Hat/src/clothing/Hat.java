package clothing;

/**
 * 모자제품들을 정의하는 클래스


사용 클래스 HatTest 작성
패키지 이름 : clothing.test
클래스 이름 : HatTest
--------------------------
main 메소드 작성

메인 메소드 내에 Hat 객체를 3개 생성
Hat cap = new Hat(......); // type을 "야구모자"로 생성, hatId: HT001, 나머지 필드는 적당히
Hat fedora = new Hat(....);// type을 "페도라"로 생성  , hatId: HT002, 나머지 필드는 적당히
Hat sunCap = new Hat(....);// type을 "썬캡" 으로 생성 , hatId: HT003, 나머지 필드는 적당히 

List<Hat> hats 를 생성하고 앞서 생성한 cap, fedora, sunCap 을 add() 한다.
hats 를 foreach 로 출력. 출력할 때 println() 메소드 안에 hat 객체를 바로 출력하여 모자 객체의 내용이 출력되도록 한다.
 * @author Administrator
 *
 */
public class Hat {
	/**
	 *    모자제품들을 정의하는 클래스
	 *    멤버변수 : 
		  hatId : String : 모자제품의 일련 번호(ht001 로 일련번호를 줄 용도)
		  type : String : 모자의 종류(스포츠캡, 페도라, 중절모, 썬캡, 베레모, 후드, 카우보이 등)
		  material : String : 모자의 소재(가죽, 플라스틱, 천, 라탄 등)
		  size : double : 모자 둘레 길이(단위 : cm)
		  color : String : 모자의 색상
		  price : double : 모자의 가격
		  quantity : int : 재고 수량
		  gender : char : 사용성별 (M:남성, F:여성, U:공용 으로 설정)
	 */
	private String hatId;
	private String type;
	private String material;
	private double size;
	private String color;
	private double price;
	private int quantity;
	private char gender;
	
	/**
	 * 생성자 선언부
	 * 기본생성자
	 * 매개변수를 받는 생성자 (멤버변수 1개씩 증가시키며 모두) 중복 정의
	 */
	
	public Hat() {
		
	}

	public Hat(String hatId) {
		this();
		this.hatId = hatId;
	}

	public Hat(String hatId, String type) {
		this(hatId);
		this.type = type;
	}
	
	public Hat(String hatId, String type, String material) {
		this(hatId, type);
		this.material = material;
	}

	public Hat(String hatId, String type, String material, double size) {
		this(hatId, type, material);
		this.size = size;
	}

	public Hat(String hatId, String type, String material, double size, String color) {
		this(hatId, type, material, size);
		this.color = color;
	}

	public Hat(String hatId, String type, String material, double size, String color, double price) {
		this(hatId, type, material, size, color);
		this.price = price;
	}

	public Hat(String hatId, String type, String material, double size, String color, double price, int quantity) {
		this(hatId, type, material, size, color, price);
		this.quantity = quantity;
	}

	public Hat(String hatId, String type, String material, double size, String color, double price, int quantity,
			char gender) {
		this(hatId, type, material, size, color, price, quantity);
		this.gender = gender;
	}
	
	
	/**
	 * amount 만큼 할인한 가격을 리턴하는 메소드
	 * @param amount : int : 할인률
	 * @return 할인된 가격
	 */
	public double discount(int amount) {
		Hat hat = new Hat();
		double discount = 0;
		if(hat.getPrice() - amount >= 0) {
			discount = hat.getPrice() - amount;
		} else {
			System.out.println("제품 가격보다 크게 할인할 수 없습니다.");
		}
		return discount;			
	}
	
	/**
	 * 모자 색상을 입력된 color 로 염색하여 색상을 변경하는 메소드
	 * @param color
	 */
	public void dye(String color) {
		Hat dyeHat = new Hat();
		dyeHat.setColor(color);		
	}
	
	/**
	 * amount 만큼 재고수량 quantity 에서 판매 보유 재고보다 많은 수량을 팔 수 없음
	 * @param amount : int : 판매할 수량
	 * @return 판매후 남은 재고
	 */
	public int sell(int amount) {
		Hat quantityHat = new Hat();
		if(quantityHat.getQuantity() - amount >= 0) {
			quantityHat.setQuantity(quantityHat.getQuantity() - amount);
		} else {
			System.out.println("보유 재고 수량이 부족합니다.");
		}
		return quantityHat.getQuantity();
	}
	
	/**
	 * amount 만큼 재고수량 quantity 를 증가시키는 메소드
	 * @param amount : int : 구매할 재고
	 * @return 증가한 재고수량
	 */
	public int buy(int amount) {
		Hat buyHat = new Hat();
		buyHat.setQuantity(buyHat.getQuantity() + amount);
		
		return buyHat.getQuantity();
	}
	
	/**
	 *Hat 클래스의 접근자 , 수정자 정의
	 * @return
	 */
	public String getHatId() {
		return hatId;
	}

	public void setHatId(String hatId) {
		this.hatId = hatId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	/**
	 * hatId 를 기준으로 equals & hashCode 정의
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hatId == null) ? 0 : hatId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hat other = (Hat) obj;
		if (hatId == null) {
			if (other.hatId != null)
				return false;
		} else if (!hatId.equals(other.hatId))
			return false;
		return true;
	}
	
	/**
	 * toString() 재정의
	 */
	@Override
	public String toString() {
		return "모자 정보 [일련번호=" + hatId + ", 종류=" + type + ", 소재=" + material + ", 사이즈=" + size + ", 색상="
				+ color + ", 가격=" + price + ", 재고수량=" + quantity + ", 사용성별=" + gender + "]";
	}
	
	
	
	
}
