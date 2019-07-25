package bonguse;

/**
 * 봉구스 주문을 테스트 해보는 클래스
 * @author passw
 *
 */
public class BonguseTest {

	public static void main(String[] args) {
		Menu[] bonguses = new Menu[0];
		Order order = new Order(bonguses);
		
		// 주문시작
		
		Menu jeyuk = new Menu(1, "제육밥버거", 2500, "기본+제육");
		Menu bongu = new Menu(2, "봉구스밥버거", 2000, "기본");
		Menu bonguegg = new Menu(3, "봉구스밥버거", 2500, "기본+계란");
		Menu ssoya = new Menu(4, "쏘야밥버거", 2000, "소세지 + 야채");
		
		// 봉구스 추가
		order.add(jeyuk);
		order.add(bongu);
		order.add(bonguegg);
		order.add(ssoya);
		
		// 현재 주문상태 확인
		order.print();
		
		// 계란추가 봉구스 메뉴 바꾸기
		Menu bonguking = new Menu(3, "봉구킹", 4500, "기본 + 햄치즈 + 제육");
		order.set(bonguking);
		
		// 주문상태 확인		
		order.print();
		
		// 쏘야밥버거 주문취소
		order.cancel(ssoya);
		
		// 주문상태 확인
		order.print();
		
	}

}
