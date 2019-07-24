package bonguse;

/**
 * 손님이 주문한 봉구스 밥버거를 정의하는 클래스
 * 
 * 주문이 들어오면 봉구스 밥버거의 메뉴이름, 가격, 속재료를 받아서 전부 추가 해 두고 add
 * 각 메뉴의 상태를 출력 후 가격의총합을 보여주고 print
 * 주문의 수정이나 취소를 할 수 있어야 한다.
 * 
 * ----------------------------------------------
 * Menu[] orders;
 * 
 * @author passw
 *
 */
public class Order {
	// 1. 멤버변수 선언부
	private Menu[] orders;
	
	// 2. 생성자 선언부
	Order(){
		orders = new Menu[0];
	}
	// 생성자 중복선언
	Order(Menu[] oders) {
		this.orders = oders;
	}
	
	
	// 3. 메소드 선언부
	// 주문한 봉구스 버거를 입력해 배열에 넣는 메소드
	public void add(Menu bongu) {		
		// orders 보다 1 큰 새 주문배열생성
		Menu[] newOrders = new Menu[orders.length + 1];
		// 이전 orders의 주문들을 newOrders로 복사
		for(int idx = 0; idx < orders.length; idx++) {
			newOrders[idx] = orders[idx];
		}
		// newOders의 마지막 배열에는 새로 주문한 봉구스밥버거를 넣는다.
		newOrders[newOrders.length - 1 ] = bongu;
		// 다시 oders에 newOders를 저장
		this.orders = newOrders;
	}
	
	// 변심으로 주문을 수정할 때
	public void set(Menu bongu) {
		// for loop 로 모든 배열을 돌면서 들어온 bongu의 주문번호가 orders의 주문번호와 같으면 orders의 주문을 새로들어온 봉구로 바꾼다.
		for(int idx = 0; idx < orders.length; idx++) {
			if(orders[idx].getOrderNumber() == bongu.getOrderNumber()) {
				orders[idx] = bongu;
			}
		}
	}
	
	// 주문 취소
	public void cancel(Menu bongu) {
		// 삭제할 봉구스의 인덱스 배열값을 리턴한 findBonguIndex로 index를 초기화
		int index = findBonguIndex(bongu);
		// 만약 인덱스 배열값이 -1보다 크다면 주문취소가 있다고 판단 취소 로직을 수행하도록 함
		if(index > -1) {
			Menu[] newOrders = new Menu[orders.length - 1]; // 취소할 메뉴가 들어가므로 orders 보다 1 작은 배열 생성
			for(int idx = 0; idx < index; idx++) {
			// idx가 삭제할 index번호 직전까지 newOrders에 orders를 복사
				newOrders[idx] = orders[idx];
			}
			// index를 제외한 나머지 봉구스 복사
			for(int idx = index; idx < newOrders.length; idx++) {
				newOrders[idx] = orders[idx + 1];
			}
			orders = newOrders;
		}
	// for 문을 돌면서 remove랑 같은 oderNumber라면 그 배열을 제외한 나머지를 복사
//	for(int idx = 0 ; idx < orders.length; idx++) {
//		if(orders[idx].getOrderNumber() < remove.getOrderNumber()) {
//			removes[idx] = orders[idx];
//		} else if(orders[idx].getOrderNumber()  remove.getOrderNumber()) {
//			
//		}
//	} 실패
	
	}
	// 삭제할 봉구스의 배열[]인덱스를 찾아주는 메소드
	private int findBonguIndex(Menu bongu) {
		int index = -1; // 배열은 무조건 0번부터시작이므로 0보다 작은수를 선언, 초기화
		
		// forloop 를 돌려서 bongu와 orders의 주문번호가 같으면 그 orders의 배열인덱스를 index에 담고 반복종료
		for (int idx = 0; idx < orders.length; idx++) {
			if (orders[idx].getOrderNumber() == bongu.getOrderNumber()) {
				index = idx;
				break;
			}
		}
		return index;
	}
	
	// 저장된 봉구스의 상태와 가격 총합을 출력하는 메소드
	public void print() {
		int sum;
		sum = 0;
		for(Menu order: orders) {
			order.print();
			sum += order.getPrice();
		}
		System.out.printf("밥버거의 총 가격은 %d원 입니다.%n", sum);
	}
	
	
	
}
