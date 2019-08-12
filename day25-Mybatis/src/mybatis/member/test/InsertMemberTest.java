package mybatis.member.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.emp.MybatisClient;
import mybatis.member.vo.Member;

public class InsertMemberTest {

	public static void main(String[] args) {
		// 1. 팩토리 받기
		SqlSessionFactory factory = MybatisClient.getFactory();
		// 2. 세션받기
		SqlSession session = factory.openSession(true);
		
		try {
			// 3. 쿼리실행 결과받기
			Member member = new Member();
			
			member.setMemberId("M010");
			member.setMemberName("에어컨");
			member.setPhone("6598");
			member.setAddress("선문대");
			member.setMajor("기계공학");
			member.setBirthMonth(8);
			member.setGender("M");
			
			// 자료 넣은 후 결과
			int addCnt = session.insert("mybatis.member.mapper.MemberMapper.insertMember", member);
			
			if (addCnt > 0) {
				System.out.printf("%s 의 멤버가 %d 건 입력되었습니다.", member.getMemberId(), addCnt);
			}
			
			
		} finally {
			// 4. 세션닫기
			if(session != null) {
				session.close();
			}
		}
		

	}

}
