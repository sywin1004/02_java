package api.object.product.test;

import api.object.product.Product;

public class ProductTest {

	public static void main(String[] args) {
		// 1. 선언 : 제품을 사용하기 위한 객체 참조 변수
		Product msMouse;
		Product ltMouse;
		Product airFrier;
		Product[] products = new Product[3];
		
		// 2. 초기화
		msMouse = new Product("P001", "MS-아크 터치 마우스", 51330, 36);
		ltMouse = new Product("P003", "로지텍코리아 G302 Daedalus Prime", 34900, 12);
		
		// 객체 생성은 기본생성자로 진행
		airFrier = new Product();

		airFrier.setPcode("P002");
		airFrier.setPname("[필립스] 에어프라이어 HD-9743");
		airFrier.setPrice(329000);
		airFrier.setQuantity(5);
		
		products[0] = msMouse;
		products[1] = airFrier;
		products[2] = ltMouse;
		
		
		System.out.println(airFrier.getPcode());
		System.out.println(airFrier.getPname());
		System.out.println(airFrier.getPrice());
		System.out.println(airFrier.getQuantity());
		
		// 3. 사용
		// (1) 초기 상태 출력
		for(Product product: products) {
			product.print();
		}
		
		// (2) ms 마우스의 가격을 변경
		Product msMouse2 = new Product("P001", "MS-아크 터치 마우스", 40000, 36);
		
		// 제품들이 들어있는 배열 products 에서
		// msMouse2 의 pcode 와 같은 제품번호를 갖는 인덱스의 원소를 
		// msMouse2 로 변경
		for(int idx = 0; idx < products.length; idx++) {
			// 객체의 내용비교를 하려면 .equals() 를 사용할 것
//			if(products[idx].getPcode() == msMouse2.getPcode()) {}
//			if(products[idx].getPcode().equals(msMouse2.getPcode()) {}
			if(products[idx].equals(msMouse2)) {
				products[idx] = msMouse2;
			}
		}
		
	}

}
