package account.one;

/**
 * 계좌의 (Account 타입) 클래스의
 * 인스턴스(객체, 실체) 를 생성하고
 * 입금기능, 현재 계좌 상태 출력 기능등을
 * 
 * 테스트하는 클래스
 * @author Administrator
 *
 */
public class AccountTest {

	public static void main(String[] args) {
		// 1. 선언
		Account account;
		Account myAccount;
		
		// 2. 초기화
		account = new Account(); // 실체화함 생성자 생략의 경우 매개변수()를 비운다
		myAccount = new Account(); // () <== 생성자 호출
		// account 와 myAccount의 상태는 같은 new Account지만 서로 다르다
		
		
		// 3. 사용
		// (1) 계좌 생성 직후 상태 출력
		System.out.println("account의 상태");
		account.print();
		
		System.out.println("MyAccount의 상태");
		myAccount.print();
		
		System.out.println("=================================");
		// (2) 계좌에 10,000원 입금
		System.out.println("account 의 10,000원 입금");
		account.deposit(10000);
		System.out.println("myAccount 100,000원 입금");
		myAccount.deposit(100000);
		
		// (3) 입금 후 상태 출력
		System.out.println("account의 상태");
		account.print();
		System.out.println("myAccount의 상태");
		myAccount.print();
		// (4) 계좌에 5,000원 입금
		account.deposit(5000);
		
		// (5) 입금 후 상태 출력
		System.out.println("account의 상태");
		account.print();
		System.out.println("myAccount의 상태");
		myAccount.print();
		
	}

}
