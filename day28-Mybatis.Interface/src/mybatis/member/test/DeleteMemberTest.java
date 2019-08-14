package mybatis.member.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.emp.MybatisClient;
import mybatis.member.vo.Member;

/**
 * member 테이블 멤버 한명 삭제를 테스트하는 클래스
 * @author Administrator
 *
 */
public class DeleteMemberTest {

	public static void main(String[] args) {
		// 팩토리 얻기
		SqlSessionFactory factory = MybatisClient.getFactory();
		// 세션얻기
		SqlSession session = factory.openSession(true);
		
		try {
			// 쿼리실행
			Member dmMember = new Member();
			dmMember.setMemberId("M010");
			
			int rmCnt = session.delete("mybatis.member.mapper.MemberMapper.deleteMember", dmMember);
			
			System.out.printf("멤버 %d 건이 삭제되었습니다.%n", rmCnt);
		} finally {
			// 세션닫기
			if(session != null) {
				session.close();
			}
		}
		
		

	}

}
