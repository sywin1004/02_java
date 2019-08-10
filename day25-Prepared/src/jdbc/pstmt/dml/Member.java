package jdbc.pstmt.dml;

/**
 * MEMBER 테이블의 컬럼과 똑같은 멤버변수를 가지는
 * vo 클래스
 * 
 * @author Administrator
 *
 */
public class Member {
	
	// 테이블 컬럼명에 _ 가 있는경우
	// 자바에서는 낙타표기법화 하여 변수 이름 지정
	private String memberId;
	private String memberName;
	private String phone;
	private String regDate;
	private String address;
	private String major;
	private int birthMonth;
	private String gender;
	
	// 기본생성자 명시
	public Member() {
		
	}
	
	// 접근자 수정자
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", phone=" + phone + ", regDate="
				+ regDate + ", address=" + address + ", major=" + major + ", birthMonth=" + birthMonth + ", gender="
				+ gender + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
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
		Member other = (Member) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
	
	
	
}
