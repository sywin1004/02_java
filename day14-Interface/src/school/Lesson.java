package school;

/**
 * 학교 구성원 중
 * 학생, 교사만 구현할 수있는
 * 수업을 나타내는 인터페이스
 * @author Administrator
 *
 */
public interface Lesson {
	
	/**
	 * 수업 진행을 나타내는 문자열을 리턴
	 * public abstract는 너무 당연해서 생략해도 자동으로 지원
	 * @retrun
	 */
	String lesson();
}
