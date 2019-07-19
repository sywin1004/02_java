package snack;

/**
 * Oreo 쿠키가 3개 들어있는 oreoBox 라는 변수를
 * Oreo 배열타입으로 선언하고
 * 
 * oreoBox[0] ~ [2] Oreo 쿠키를 입력
 * 크림의 종류는 바닐라, 초코, 딸기, 말차 중 하나로 입력할 것. 
 * 
 * foreach를 사용하여
 * oreoBox 에서 하나의 쿠키의 상태를 출력
 * 
 * for 를 사용하여 모든 쿠키의 크림을 바닐라로 변경
 * 
 * foreach를 사용해서 모든 쿠키의 크림 변경 상태 확인을 위한 출력
 * @author Administrator
 *
 */
public class OreoTest {

	public static void main(String[] args) {
		// 1. 선언
		Oreo[] oreos = new Oreo[0];
		
		OreoBox box = new OreoBox(oreos);
			
		// 2. 초기화
		oreos = new Oreo[3];
		Oreo strawberry = new Oreo(1, "딸기");
		Oreo choco = new Oreo(2, "초코");
		Oreo greentea = new Oreo(3, "말차");
		// 3. 실행
		// 3.1 쿠키상태 출력 foreach
		for(Oreo oreo : oreos) {
			oreo.print();
		}
		
		// 초코 쿠키 (1번 쿠키) 를 바닐라로 변경 : set
		
		// 변경된 초코쿠키 (1번 쿠키) :get
		
		// 3.2 쿠키 크림 변경 (바닐라) 
		for (Oreo oreo : box.getAllOreos()) {
			oreo.changeCream("바닐라");
		}
		// 3.3 쿠키상태 확인 foreach
		for(Oreo oreo : oreos) {
			oreo.print();
		}
		
		// 3번 쿠키 삭제 : remove
		
		// 전체 목록 출력
	}

}
