package snack;

/**
 * 오레오(Oreo) 쿠키가 여러개 들어가 있는 박스
 * 
 * @author Administrator
 *
 */
public class OreoBox {

	// TODO Oreo 를 여러개 저장할 수 있는
	// Oreo[] oreos 를 멤버 변수로 갖도록 선언
	Oreo[] oreos;

	// TODO 생성자 기본, 매개변수 중복정의
	OreoBox() {
		oreos = new Oreo[0];
	}

	OreoBox(Oreo[] oreos) {
		this();
		this.oreos = oreos;
	}

	// TODO 오레오 박스에
	// 오레오 쿠키를 1개씩 추가, 삭제, 수정, 꺼내(get)거나
	public void add(Oreo oreo) {
		Oreo[] newOreos;
		newOreos = new Oreo[oreos.length + 1];

		for (int idx = 0; idx < oreos.length; idx++) {
			newOreos[idx] = oreos[idx];
		}
		newOreos[newOreos.length - 1] = oreo;

		this.oreos = newOreos;
	}

	public void remove(Oreo oreo) {
		Oreo[] newOreos;

		int index = findOreoIndex(oreo);

		if (index > -1) {
			newOreos = new Oreo[oreos.length - 1];

			for (int idx = 0; idx < index; idx++) {
				newOreos[idx] = oreos[idx];
			}
			
			for (int idx = index; idx < newOreos.length; idx++) {
				newOreos[idx] = oreos[idx + 1];
			}

			this.oreos = newOreos;

		} 
	}

	public void set(Oreo oreo) {
		// 수정할 오레오 위치 찾기
		int index = findOreoIndex(oreo);
		if (index > -1) {
			oreos[index] = oreo;
		}

	}

	public Oreo get(Oreo oreo) {
		// 오레오 하나 얻기
		return findOreo(oreo);
	}

	public Oreo[] getAllOreos() {
		// 안에 있는 오레오를 전부 리턴
		return this.oreos;
	}

	// 오레오를 찾는 메소드
	private Oreo findOreo(Oreo oreo) {
		Oreo findOreo = null;
		for (int idx = 0; idx < oreos.length; idx++) {
			if (oreos[idx].getSequence() == oreo.getSequence()) {
				findOreo = oreos[idx];
				break;
			}
		}
		return findOreo;
	}

	private int findOreoIndex(Oreo oreo) {
		// oreo과 같은녀석을 찾을 수 있는 위치를 알려주는 메소드
		int index = -1; // 배열이 0번부터 시작하기 때문에 -1로 초기화
		Oreo findOreo = null;
		for (int idx = 0; idx < oreos.length; idx++) {
			if (oreos[idx].getSequence() == oreo.getSequence()) {
				findOreo = oreos[idx];
				index = idx;
				break;
			}
		}
		return index;
	}

}
