package product.vo;

/**
 * (1) int min, int max 두 개의 멤버변수를 선언
 * (2) 기본생성자 생성
 * (3) 접근자, 수정자 생성
 * (4) equals() & hashCode() : 두 값 모두로 작성
 * (5) toString() 작성
 *   : "검색가격[최저가:얼마 ~ 최대가:얼마]" 와 같은 문자열이 출력되도록 작성 
 * @author 304
 *
 */
public class Price {
	// 멤버변수 선언부
	private int min;
	private int max;
	// 생성자 선언부
	// (기본생성자)
	public Price() {
		super();
	}
	
	// 메소드 선언부
	// 접근자 수정자
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	// equals hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + max;
		result = prime * result + min;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		if (max != other.max)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "검색가격 [최저가:" + min + " ~ 최대가:" + max + "]";
	}
		
	
	
}
