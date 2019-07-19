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
	OreoBox(){
		oreos = new Oreo[0];
	}
	
	OreoBox(Oreo[] oreos){
		this();
		this.oreos = oreos;
	}
	
	// TODO 오레오 박스에
	// 오레오 쿠키를 1개씩 추가, 삭제, 수정, 꺼내(get)거나
	public void add(Oreo oreo) {
		Oreo[] newOreos;
		newOreos = new Oreo[oreos.length + 1];
		
		for(int idx = 0; idx < oreos.length; idx++) {
			newOreos[idx] = oreos[idx];
		}
		newOreos[newOreos.length - 1] = oreo;
		
		this.oreos = newOreos;
	}
	
	public void remove(Oreo oreo) {
		
	}
	
	public void set(Oreo oreo) {
		
	}
	
	public Oreo get(Oreo oreo) {
		return null;
	}
	
	public Oreo[] getAllOreos() {
		return null;	
	}
	
}
