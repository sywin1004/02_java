package product.test;

/**
 * 프로그램 테스트시 주의 점
 * --------------------------------
 * 1. 오류 나는 부분은 주석처리 해 가며 구현된 곳 까지 실행해가며 테스트
 * 2. 시퀀스(DB에 생성한)의 일련번호는 계속해서 증가만 하므로
 *    전체 테스트 진행 후 마지막 P005 삭제하고나면
 *    P005 번은 신규 생성이 불가능함.
 *    
 *    신규 생성되는 PK 는 P006, P007, .. 의 순으로 증가하니
 *    그 점 유의하여 업데이트 혹은 
 */
import java.util.ArrayList;
import java.util.List;

import product.dao.ProductDao;
import product.vo.PrimaryKey;
import product.vo.Product;

public class ProductTest {

	public static void main(String[] args) {
		// 입력 테스트 ---------------------------------------------------------------
		// 입력에 사용할 데이터 생성
		Product p001 = new Product();
		p001.setCode("p001");
		p001.setName("슈퍼스타");
		p001.setPrice(87200);
		p001.setQuantity(5);
		
		Product p002 = new Product();
		p002.setCode("p002");
		p002.setName("리복 로얄 테크큐 티");
		p002.setPrice(42000);
		p002.setQuantity(20);
		
		Product p003 = new Product();
		p003.setCode("p003");
		p003.setName("나이키 탄준 샌들");
		p003.setPrice(41300);
		p003.setQuantity(30);
		
		Product p004 = new Product();
		p004.setCode("p004");
		p004.setName("라이트라이드 샌들 우먼");
		p004.setPrice(40200);
		p004.setQuantity(7);
		
		Product p005 = new Product();
		p005.setCode("p005");
		p005.setName("지제 (WOMAN)");
		p005.setPrice(29000);
		p005.setQuantity(15);
		
		List<Product> productInputs = new ArrayList<>();
		productInputs.add(p001);
		productInputs.add(p002);
		productInputs.add(p003);
		productInputs.add(p004);
		productInputs.add(p005);
		
		// ProductDao 객체 선언 & 초기화
		ProductDao dao = new ProductDao();
		
		for (Product product: productInputs) {			
//			System.out.println(product);
			int addCnt = dao.insertProduct(product);
			
			if (addCnt > 0) {
				System.out.printf("%d 건이 등록되었습니다.%n", addCnt);
			}
			
		}
		

		// 수정 테스트 객체 생성-------------------------------------------------------------------------------
		// TODO : dao 객체에 selectProdudct(PrimaryKey) 를 호출하여 P001 코드 제품 검색;
		//        selectProdudct() 메소드 파라미터로 넘기는 PrimaryKey 타입의 인스턴스 내부 멤버변수인 code 값에
		//        P001 을 가지도록 생성하여 그 인스턴스를 넘기도록 함
		PrimaryKey pk = new PrimaryKey();
		pk.setCode("p001");
		
		Product p001Mod = dao.selectProduct(pk);
		
		p001Mod.setName("슈퍼스타 (플립샌들)");
		p001Mod.setPrice((int) (p001Mod.getPrice() * 0.9));
		p001Mod.setQuantity(2);
		
		
		
		
		
		// TODO : dao 객체에 selectProdudct(PrimaryKey) 를 호출하여 P002 코드 제품 검색;
		//        selectProdudct() 메소드 파라미터로 넘기는 PrimaryKey 타입의 인스턴스 내부 멤버변수인 code 값에
		//        P002 을 가지도록 생성하여 그 인스턴스를 넘기도록 함
		pk.setCode("p002");
		Product p002Mod = dao.selectProduct(pk);
		p002Mod.setName("리복 로얄 테크큐 티(L)");
		p002Mod.setPrice((int) (p002Mod.getPrice() * 0.9));
		p002Mod.setQuantity(20);
		
		// TODO : dao 객체에 selectProdudct(PrimaryKey) 를 호출하여 P003 코드 제품 검색;
		//        selectProdudct() 메소드 파라미터로 넘기는 PrimaryKey 타입의 인스턴스 내부 멤버변수인 code 값에
		//        P003 을 가지도록 생성하여 그 인스턴스를 넘기도록 함		
		pk.setCode("p003");
		Product p003Mod = dao.selectProduct(pk);
		p003Mod.setName("NIKE 탄준 샌들");
		p003Mod.setPrice((int) (p003Mod.getPrice() * 0.9));
		p003Mod.setQuantity(3);
		
		// TODO : dao 객체에 selectProdudct(PrimaryKey) 를 호출하여 P004 코드 제품 검색;
		//        selectProdudct() 메소드 파라미터로 넘기는 PrimaryKey 타입의 인스턴스 내부 멤버변수인 code 값에
		//        P004 을 가지도록 생성하여 그 인스턴스를 넘기도록 함
		pk.setCode("p004");
		Product p004Mod = dao.selectProduct(pk);
		p004Mod.setName("라이트라이드 샌들 (WOMAN)");
		p004Mod.setPrice((int) (p004Mod.getPrice() * 0.9));
		p004Mod.setQuantity(15);
		
		// TODO : dao 객체에 selectProdudct(PrimaryKey) 를 호출하여 P005 코드 제품 검색;
		//        selectProdudct() 메소드 파라미터로 넘기는 PrimaryKey 타입의 인스턴스 내부 멤버변수인 code 값에
		//        P005 을 가지도록 생성하여 그 인스턴스를 넘기도록 함
		pk.setCode("005");
		Product p005Mod = dao.selectProduct(pk);
		p005Mod.setName("지제 (WOMAN)");
		p005Mod.setPrice((int) (p005Mod.getPrice() * 0.9));
		p005Mod.setQuantity(3);
		
		// 수정 -----------------------------------------------------------------------
		List<Product> productUpdates = new ArrayList<>();
		productUpdates.add(p001Mod);
		productUpdates.add(p002Mod);
		productUpdates.add(p003Mod);
		productUpdates.add(p004Mod);
		productUpdates.add(p005Mod);
		
		for (Product product: productUpdates) {
			int setCnt = 0;
			// TODO : dao 객체에 updateProduct(Product product) 메소드 호출하여 5건의 데이터에 대해 업데이트 실행
			//        updateProduct 리턴값이 0보다 크면 "몇 건이 수정되었습니다." 출력
			setCnt = dao.updateProduct(product);
			if(setCnt > 0) {
				System.out.printf("%d 건이 수정되었습니다.", setCnt);
				
			}
		}
		
		
//		// 검색 테스트 -----------------------------------------------------------------------
//		// TODO : 검색어 "샌들" 로 제품목록 검색
//		List<Product> sandles = dao.selectProducts("샌들");
//		for (Product product: sandles) {
//			System.out.println(product);
//		}
		
		
//		// TODO : 가격 최저, 최고 20000 ~ 50000 을 가지는 Price 객체를 생성하여 가격 검색
//		List<Product> priceProducts = dao.selectProducts(Price);
//		for (Product product: priceProducts) {
//			System.out.println(product);
//		}
//		
//		// TODO : 가격 40000 이상 제품 가격 검색
//		List<Product> expensivesThan = // TODO : dao 객체를 사용하여 가격 이상 검색 완성;
//		for (Product product: expensivesThan) {
//			System.out.println(product);			
//		}
//		
//		// TODO : 가격 50000 이하 제품 가격 검색
//		List<Product> cheaps = // TODO : dao 객체를 사용하여 가격 이하 검색 완성;
//		for (Product product: cheaps) {
//			System.out.println(product);			
//		}
//		
//		// TODO : 가장 비싼 제품목록 검색
//		List<Product> mostExpensives = // TODO : dao 객체를 사용하여 가장 비싼 검색 완성;
//		for (Product product: mostExpensives) {
//			System.out.println(product);			
//		}
//		
//		// TODO : 가장 재고 많은 제품목록 검색
//		List<Product> mostQuantities = // TODO : dao 객체를 사용하여 가장 재고 많은 검색 완성;
//		for (Product product: mostQuantities) {
//			System.out.println(product);			
//		}
//		
//		
//		// 삭제 테스트 -----------------------------------------------------------------------
//		// TODO : PrimaryKey 타입의 인스턴스 내부 멤버변수인 code 값에
//		//        P005 을 가지도록 생성
//		
//		// TODO : dao 에 deleteProduct(PriamryKey pk) 메소드를 호출하며
//		//        위에서 생성한 PrimaryKey 인스턴스 전달
//		
//		
//		
//		
//		// 삭제 -----------------------------------------------------------------------
//		// TODO : P005 가 삭제된 전체 목록 조회
//		List<Product> allProducts = // TODO : dao 객체를 사용하여 전체 목록 검색 완성;
//		for (Product product: allProducts) {
//			System.out.println(product);			
//		}
		
				
	}

}
