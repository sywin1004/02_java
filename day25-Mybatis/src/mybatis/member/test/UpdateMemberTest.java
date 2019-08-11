package mybatis.member.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.emp.MybatisClient;
import mybatis.member.vo.Member;

/**
 * member 테이블의 멤버정보의 수정을 테스트하는 클래스
 * @author Administrator
 *
 */
public class UpdateMemberTest {

	public static void main(String[] args) {
		// 1. 팩토리 얻기
		SqlSessionFactory factory = MybatisClient.getFactory();
		// 2. 세션 얻기
		SqlSession session = factory.openSession();
		
		try {
			// 쿼리 실행, 결과받기
			// 수정 전 정보 출력
			Member inputMember = new Member();
			inputMember.setMemberId("M010");
			
			Member member = session.selectOne("mybatis.member.mapper.MemberMapper.selectMember", "M010");
			
			System.out.println("수정 전 정보");
			
			System.out.println(member);
			
			// 수정실행
			
			member.setMajor("컴퓨터공학");
			member.setGender("F");
			
			// 수정 후 결과 출력
			
			Member newMember = new Member();
			newMember.setMemberId("M010");
			
			Member setMember = session.selectOne("mybatis.member.mapper.MemberMapper.selectMember", "M010");
			
			System.out.println("수정 후 정보");
			System.out.println("setMember");
			
			
			
		} finally {
			// 4. 세션 닫기
			if(session != null) {
				session.close();
			}
		}
		

	}

}
