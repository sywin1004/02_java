package mybatis.emp.test;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.emp.MybatisClient;

/**
 * EMP 테이블에서 직원정보 1건을 수정하는
 * 쿼리를 Mybatis 로 실행하는 테스트 클래스
 * -----------------------------------------
 * 수정 : 선 조회 => 후 수정
 * 
 * 1. 직원 사번으로 1명의 정보를 조회
 * 2. 조회된 내용이 맵으로 전달
 * 3. 2의 맵에 수정할 키(컬럼명)만 새로 put
 * 4. 3에서 변경된 맵 객체로 업데이트 실행 
 * @author Administrator
 *
 */
public class MybatisEmpUpdateTest {

	public static void main(String[] args) {
		// 1. factory 얻기
		SqlSessionFactory factory = MybatisClient.getFactory();
		
		// 2. 세션 얻기
		SqlSession session = factory.openSession(true);
		
		// 3. 세션에서 쿼리 실행
		try {
			// (1) 직원 1명 정보 조회
			// mybatis.emp.mapper.EmpMapper.selectEmp
			Map<String, Object> emp = session.selectOne("mybatis.emp.mapper.EmpMapper.selectEmp", 1111);
			
			// 맵 객체인 emp 에 담긴 내용
			// 1111 박준석 SALESMAN
			System.out.println(emp);
			
			//수정할 컬럼=값
			// mgr = 7698, sal=1260, comm=400, deptno=30
			emp.put("MGR", 7698);
			emp.put("SAL", Integer.valueOf(1260)); // autoboxing 이 일어나지 않았을 때 넣는법
			emp.put("COMM", 400);
			emp.put("DEPTNO", 30);
			

			// (2) 조회된 직원 정보 일부 수정
			// mybatis.emp.mapper.EmpMapper.update
			int setCnt = session.update("mybatis.emp.mapper.EmpMapper.update", emp);
			
			if(setCnt > 0) {
				BigDecimal empno = (BigDecimal) emp.get("EMPNO");
				System.out.printf("%d 직원의 정보가 %d건 수정되었습니다%n", empno.intValue(), setCnt);
			}
			
			// (3) 조회된 직원 정보 재 조회
			Map<String, Object> newEmp = session.selectOne("mybatis.emp.mapper.EmpMapper.selectEmp", 1111);
			
			System.out.println("수정된 정보");
			System.out.println(newEmp);
			
		} finally {
			// 4. 세션 닫기
			if(session != null) {
				session.close();
			}
		}
		
		

	}

}
