package product.vo;

/**
 * 
 * (1) PRODUCT 테이블의 PK 컬럼인 code 컬럼을 멤버변수로 갖는 클래스 생성
 * (2) 기본생정자 생성, 
 *     code 컬럼을 받아서 초기화하는 생성자 생성
 * (3) 접근자, 수정자 생성
 * (4) equals(), & hashCode() : code 변수로 작성
 * (5) toString() 작성 
 *   : "PK=P001" 과 같은 문자열이 출력되도록 작성
 *   
 * @author 304
 *
 */
public class PrimaryKey {
	// 멤버변수 선언부
	private String code;

	// 생성자 선언부
	// (기본생성자)
	public PrimaryKey() {
		super();
	}
	// 메소드 선언부
	// 접근자, 수정자
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	// equals(), hashcode()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		PrimaryKey other = (PrimaryKey) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PK=" + code;
	}
	
	
	
	
	
}
