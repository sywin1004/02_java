package book;

/**
 * 책 한 권의 정보를 담는 클래스
 * ---------------------------------
 * 멤버변수 (클래스 안에서 선언)
 * 일련번호 	: sequence		: int
 * ISBN 		: isbn 			: String
 * 제목 		: title 		: String
 * 저자 		: author 		: String
 * 출판사 		: company 		: String
 * 페이지 수 	: totalPage 	: int
 * 가격 		: price 		: int
 * 재고수량 	: quantity : int 0보다 작아질 수 없음
 * ---------------------------------
 * 생성자 중복정의 (기본생성자 명시, 매개변수 생성자 중복정의)
 * ---------------------------------
 * 메소드 :
 * -- 기능 메소드
 * print () :책의 정보를 출력하는 메소드 void
 * buy (int amount) : amount 책의 재고를 늘리는 메소드  void
 * sell (int amount) : amount 만큼 재고가 줄어듦 메소드 void
 * 
 * -- 각 필드를 설정하는 메소드
 * -- 자바 빈스 (Java Beans) 규격에 의한 접근자/ 수정자 메소드
 * -- getter/seeter (접근자 / 수정자) 
 * 
 * getter 작성시 메소드 이름 규격
 *  == > get으로 시작하고 멤버변수필드의 첫 글자를 대문자로 조합
 *       매개변수 없음
 *       리턴타입이 해당 멤버변수 필드의 타입과 맞춤
 *       
 *  예) sequence 필드의 getter 는 다음의 규격을 갖는다.
 *  int getSequence(){
 *  return this.sequence;
 *  }
 *  
 *  setter 작성시 메소드 이름 규격
 *  == > set으로 시작하고 멤버변수 필드의 첫글자를 대문자로 조합
 *       매개변수는 해당 멤버변수 필드와 같은 변수로 받는다.
 *       리턴값이 없이 작성
 *  void setSequence(int sequence) {
 *  this.sequence = sequence;
 *  }
 *  
 *  만약 멤버변수 필드가 boolean 타입이라면 getter의 이름을 get으로 시작하지않고 is로 시작한다.
 */

public class Book {
	// 1. 변수선언부
	int sequence;
	String isbn ;
	String title ;		
	String author ;		
	String company ;		
	int totalPage ;
	int price 	;
	int quantity;
	
	// sequence 멤버 변수의 getter
	public int getSequence() {
		return sequence;
	}
	
	// sequence의 setter
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	// isbn 멤버변수 필드에 대한 getter
	public String getIsbn() {
		return isbn;
	}
	
	// isbn의 setter
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	// title의 getter
	public String getTitle() {
		return title;
	}
	
	// title의 setter
	public void setTitle(String title) {
		this.title = title;
	}
	
	// author의 getter
	public String getAuthor() {
		return author;
	}
	
	// author의 setter
	public void setAuthor(String author) {
		this.author = author;
	}
	
	// company의 getter
	public String getCompany() {
		return company;
	}
	
	// company의 setter
	public void setCompany(String company) {
		this.company = company;
	}
	
	// totalPage의 getter
	public int getTotalPage() {
		return totalPage;
	}
	
	// totalPage의 setter
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	// price의 getter
	public int getPrice() {
		return price;
	}
	
	// price의 setter
	public void setPrice(int price) {
		this.price = price;
	}
	
	// quantity의 getter
	public int getQuantity() {
		return totalPage;
	}
	
	// quantity의 setter
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	// 2. 생성자 선언부
	// 2.1 기본생성자
	Book () {
		
	}
	// 2.2 
	Book(int sequence){
		this();
		this.sequence = sequence;
	}
	
	Book(int sequence, String isbn){
		this(sequence);
		this.isbn = isbn;
	}
	
	Book(int sequence, String isbn, String title){
		this(sequence, isbn);
		this.title = title;
	}
	
	Book(int sequence, String isbn, String title, String author){
		this(sequence, isbn, title);
		this.author = author;
	}
	
	Book(int sequence, String isbn, String title, String author, String company){
		this(sequence, isbn, title, author);
		this.company = company;
	}
	
	Book(int sequence, String isbn, String title, String author, String company, int totalPage){
		this(sequence, isbn, title, author, company);
		this.totalPage = totalPage;
	}
	
	Book(int sequence, String isbn, String title, String author, String company, int totalPage, int price){
		this(sequence, isbn, title, author, company, totalPage);
		this.price = price;
	}
	
	Book(int sequence, String isbn, String title, String author, String company, int totalPage, int price, int quantity){
		this(sequence, isbn, title, author, company, totalPage, price);
		this.quantity = quantity;
	}
	// 3. 메소드 선언부
	// print()
	// buy (int amount)
	// sell (int amount)
	public void print() {
		System.out.printf("이 책의 일련번호 :%d\t ISBN :%s \t제목 :%s \t\t저자 :%s \t출판사 :%s \t총페이지 :%d \t재고수량 :%d 입니다.%n", sequence, isbn, title, author, company, totalPage, price, quantity);
	}
	
	public void buy(int amount) {
		quantity += amount;
	}
	
	public void sell(int amount) {
		if(quantity > amount) {
			if(quantity > 0) {
				quantity -= amount;
			}
		}
	}
	
	
}
