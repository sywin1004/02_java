package mybatis.emp.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.emp.MybatisClient;
import mybatis.emp.mapper.EmpMapper;
import mybatis.emp.vo.Emp;

/**
 * EMP 테이블에서 1건, 전체조회를
 * Mybatis 를 사용하여 실행하는 테스트 클래스
 * @author Administrator
 *
 */
public class MybatisEmpSelectTest4 {

	public static void main(String[] args) {
		// 1. factory 얻기
		SqlSessionFactory factory = MybatisClient.getFactory();
		// 2. 세션 얻기
		SqlSession session = factory.openSession();
		
		
		try {
			// 3. 세션을 통해 쿼리 실행
			// 매퍼 인터페이스의 메소드를 사용한 쿼리 수행
			// (1) 전체 조회 mybatis.emp.mapper.EmpMapper.selectAll
			
			// 3. 매퍼 인터페이스의 메소드를 사용한 쿼리 수행
			// (1) EmpMapper 타입의 인스턴스 얻기
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			List<Map<String, Object>> emps2 = mapper.selectAll();
			List<Emp> emps = mapper.selectAll2();
			
			// 조회에 사용할 객체
			Emp inputEmp = new Emp();
			inputEmp.setEmpno(7698); // BLAKE 조회
			
			System.out.println(mapper.select(inputEmp));
			// 조회 결과 foreach 출력
			for (Emp emp: emps) {
				// emp 클래스 객체출력
				System.out.println(emp);
			}
			
			System.out.println("===============================================");
			
			
			// (2) 직원 1명 조회 mybatis.emp.mapper.EmpMapper.selectEmp
			// 조회를위한 객체 생성 : empno가 들어있는 emp타입의 객체
			
			System.out.println("직원 사번으로 조회");
			for(Emp emp: mapper.select(inputEmp)) {
				System.out.println(emp);
			}
			
			System.out.println("이름에 J가 들어가는 직원 조회");
			for(Emp emp: mapper.selectByName("J")) {
				System.out.println(emp);
			}
			
			
			
			Emp inputEmp = new Emp();
			inputEmp.setEmpno(8888);
//			Emp emp = session.selectOne("mybatis.emp.mapper.EmpMapper.selectEmp2", inputEmp); // Mybatis가 inputEmp.get을 바로 불러줌
			
			// 직원 1명 결과 출력
			System.out.println(emp);
			
		} finally {
			// 4. 닫기
			if(session != null) {
				session.close();
			}
		}
		
		
		// 4. 닫기
		

	}

}
