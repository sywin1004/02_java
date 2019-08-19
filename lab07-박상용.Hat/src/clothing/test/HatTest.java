package clothing.test;

import java.util.ArrayList;
import java.util.List;

import clothing.Hat;

/**
 * Hat 클래스를 테스트 하는 클래스
 * @author Administrator
 *
 */
public class HatTest {

	public static void main(String[] args) {
		// 선언 초기화
		/**
		 * 야구모자를 정보를 입력하여 선언 및 초기화
		 */
		Hat cap = new Hat("HT001", "야구모자", "가죽", 15, "주황색", 12000, 8, 'M');
		Hat fedora = new Hat("HT002", "페도라", "천", 10, "빨강색", 15000, 15, 'F');
		Hat sunCap = new Hat("HT003", "썬캡", "플라스틱", 20, "검정색", 10000, 17, 'U');
		
		/**
		 * 야구모자들을 담는 List<Hat> 배열 생성 후 모자들 담기
		 */
		List<Hat> hats = new ArrayList();
		hats.add(cap);
		hats.add(fedora);
		hats.add(sunCap);
		
		// 사용
		for (Hat hat: hats) {
			System.out.println(hat);
		}
		

	}

}
