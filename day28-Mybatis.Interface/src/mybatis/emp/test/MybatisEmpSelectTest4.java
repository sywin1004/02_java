package mybatis.emp.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.emp.MybatisClient;
import mybatis.emp.mapper.EmpMapper;
import mybatis.emp.vo.Emp;

/**
 * EMP 테이블에서 1건, 전체조회를
 * Mybatis 를 사용하여 실행하는 테스트 클래스
 * 
 * @author 304
 *
 */
public class MybatisEmpSelectTest4 {

	public static void main(String[] args) {
		// 1. factory 얻기
		SqlSessionFactory factory = MybatisClient.getFactory();
		
		// 2. 세션 얻기
		SqlSession session = factory.openSession();
		
		try {
			// 3. 매퍼 인터페이스의 메소드를 사용한 쿼리 수행
			// (1) EmpMapper 타입의 인스턴스 얻기
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			
			// 조회에 사용할 객체 생성
			Emp inputEmp = new Emp();
			inputEmp.setEmpno(7698); // BLAKE 조회
			
			// (2) 동적 쿼리 메소드 호출 & 출력
//			System.out.println(mapper.select(inputEmp));
			
			System.out.println("== 직원 사번으로 조회 ==");
			for (Emp emp: mapper.select(inputEmp)) {
				System.out.println(emp);
			}
			
			
			System.out.println("== 이름에 J가 들어가는 직원 조회==");
			for (Emp emp: mapper.selectByName("J")) {
				System.out.println(emp);
			}
			
			System.out.println("== 이름에 J가 들어가는 직원 조회시 null 전달==");
			for (Emp emp: mapper.selectByName(null)) {
				System.out.println(emp);
			}
			
			System.out.println("=========================================");
			
		} finally {
			// 4. 닫기
			if (session != null)
				session.close();
		}
		
	}

}