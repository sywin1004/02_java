package mybatis.member.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.emp.MybatisClient;
import mybatis.member.vo.Member;

/**
 * 현재 member 테이블의 정보를 조회하는 클래스
 * @author Administrator
 *
 */
public class SelectMemberTest {

	public static void main(String[] args) {
		// 1. 팩토리 받기
		SqlSessionFactory factory = MybatisClient.getFactory();
		// 2. 세션받기
		SqlSession session = factory.openSession(true);
		
		try {
			// 3. 쿼리실행 결과받기
			// 1. 전체 member 테이블 정보 조회
			List<Member> members = session.selectList("mybatis.member.mapper.MemberMapper.selectAll");
			
			// 리스트 배열로 가져온 members foreach로 출력
			for (Member member: members) {
				System.out.println(member);
			}
			
			
			
			// 2. member 1명의 정보 조회
			Member inputMember = new Member();
			inputMember.setMemberId("M010");
			
			Member member = session.selectOne("mybatis.member.mapper.MemberMapper.selectMember", inputMember);
			
			// member1명 결과 출력
			System.out.println(member);
			
			
			
			
			
		} finally {
			// 4. 세션 닫기
			if(session != null) {
				session.close();
			}
		}
		
		

	}

}
