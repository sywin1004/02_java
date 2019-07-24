package school;

/**
 * 학교 시스템에서
 * 구성원들 모두 (학생, 선생, 직원) 의
 * 출결을 나타내기 위해 정의하는 인터페이ㅡㅅ
 * @author Administrator
 *
 */
public interface Attendance {
	
	/**
	 * 구성원의 출결을 나타내는 문자열을 리턴
	 * @return
	 */
	public abstract String attend();
}
