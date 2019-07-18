package account;

/**
 * 은행 계좌를 정의하는 클래스
 * ------------------------------------------
 * 계좌의 속성을 나타내기 위하여 두 개의 멤버변수 선어
 * 계좌변호 : accNumber
 * 계좌잔액 : balance
 * ------------------------------------------
 * 기본생성자 : 매개변수가 비어있는 생성자
 * 매개변수가 있는 생성자 : 매개변수 목록이 있는 생성자
 * ------------------------------------------
 * 계좌의 잔액을 증가시키는 입금 메소드 : deposit(int amount)
 * 계좌의 현재 상태 출력하는 메소드 : print()
 * 
 * @author Administrator
 *
 */
public class Account {
	// 클래스 변수 선언(static 변수 선언)
	/** 계좌의 일련번호 부여를 위해 공유하는 클래스 변수*/
	static int count = 0;
	
	// 1. 멤버변수 (instance실체변수) 선언부
	/** 계좌 번호 */
	int accNumber;
	/** 계좌 잔액 */
	int balance;
	/** 계좌 번호 부여를 위해 선언된 변수 */
	int cnt;
	
	// 2. 생성자 선언부
	/**
	 * 기본생성자 : 클래스 이름과 대소문자까지 모두 동일하고
	 * 				매개변수 목록이 비어있는 생성자
	 */
	Account() {
	}
	
	/**
	 * 계좌 잔액만 전달받고,
	 * 계좌번호는 클래스 변수인 count가 값이 유지되는 특징을 사용하여
	 * 증가되는 일련번호로 직접 적용하여
	 * 계좌 객체를 생성하는 생성자.
	 * @param balance
	 */
	Account(int balance){
		this.accNumber = ++count;
		this.balance = balance;
	}
	/**
	 * 계좌 번호, 계좌 잔액을 매개변수로 받아서
	 * 입력된 값으로 계좌를 실체화(초기화) 하는 생성자
	 * 
	 *  중복정의된 생성자
	 * 
	 * @param newAccNumber
	 * @param newBalance
	 */
	Account(int newAccNumber, int newBalance) {
		accNumber = newAccNumber;
		balance = newBalance;
	}
	
	/**
	 * 문자열로 된 계좌번호와
	 * 정수값의 잔액을 입력받아서
	 * 각각 계좌번호(accNumber)와 잔액(balance) 필드를 초기화하는
	 * 중복정의 된 생성자
	 * 
	 * 중복정의(overloading)
	 * ------------------------------
	 * 메소드의 이름은 같고, 매개변수 목록이 다른 메소드를
	 * 정의하는 기법
	 * 중복정의는 생성자에도 적용되는 정의 기법
	 * 
	 * 매개변수 목록이 다르다
	 *  (1) 갯수가 다르다
	 *  (2) 갯수가 같을 때는 매개변수의 타입의 순서가 다르다
	 * @param strAccNumber
	 * @param newbalance
	 */
	Account(String strAccNumber, int newbalance){
		accNumber = Integer.valueOf(strAccNumber);
		balance = newbalance;
	}
	
	
	// 3. 메소드 선언부
	/**
	 * 입력된 amount 만큼 이 계좌의 잔액을 증가시킨다.
	 * @param amount : int 입금할 금액
	 */
	public void deposit(int amount) {
		balance += amount;
	}
	
	/**
	 * 이 계좌의 상태를 출력 
	 */
	public void print() {
		System.out.printf("계좌번호 : %d | \t 계좌잔액 : %d%n", accNumber, balance);
	}
		/**
		 * 
		 * 출금하는 메소드 withdraw
		 * 
		 * 출금하려는 금액(amount) 만큼 잔액에서 
		 * 차감하는 메소드
		 * 
		 * 만약 잔액이 amount보다 적으면
		 * 출금을 진행하지 않는다.
		 * 
		 * 출금이 실패하면
		 * "잔액이 부족합니다." 라는 문자열을 리턴하고
		 * 출금이 성공하면
		 * "얼마 ...가 출금되었습니다. 잔액은 얼마입니다." 라는 문자열을 리턴
		 * 
		 * @param amount : int 출금하려는 금액
		 * @return String : 출금 성공 실패 알림 문자열
		 */
		public String withdraw(int amount) {
			String result;
			if (balance >= amount) {
				balance -= amount;
				result = amount + "가 출금되었습니다. 잔액은" + balance + "입니다.";
			} else {
				result = "잔액이 부족합니다";
			}
			return result;
		}
	}