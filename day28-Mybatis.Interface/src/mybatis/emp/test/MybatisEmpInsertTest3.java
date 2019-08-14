package mybatis.emp.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.emp.MybatisClient;
import mybatis.emp.mapper.EmpMapper;
import mybatis.emp.vo.Emp;

/**
 * EMP 테이블에 
 * 직원 정보 1 건을 추가하는 
 * Mybatis 테스트 클래스
 * @author Administrator
 *
 */
public class MybatisEmpInsertTest3 {

	public static void main(String[] args) {
		// 1. factory 얻기
		SqlSessionFactory factory = MybatisClient.getFactory();
		// 2. session 얻기
		/*
		 * --------------------------------------------------------------------------------
		 * DML(데이터 조작어) insert delete 작업을 할 때 세션 오픈시 autoCommit 옵션 조절
		 * --------------------------------------------------------------------------------
		 * JDBC 는 커넥션이 기본 autoCommit 이 설정 된 상태
		 *      JDBC 로 만든 디비 접속 응용프로그램에서는
		 *      autoCommit 옵션을 신경쓰지 않아도 좋다.
		 * --------------------------------------------------------------------------------
		 * Mybatis 는 기본 non-autoCommit 이므로
		 *      세션을 열 때, 커밋 옵션 조절에 신경써야 한다.
		 *      
		 *      openSession() 메소드는 중복정의 되어있는데
		 *      매개변수로 boolean 값을 받는 메소드가
		 *      autoCommit 옵션을 조절할 수 있다.
		 *      이 때, 값을 true 로 주어야만 autoCommit 이 활성화
		 *      
		 *      매개변수가 없는 openSession() 메소드는
		 *      openSession(false) 와 같은 사용법
		 * --------------------------------------------------------------------------------
		 *      
		 */
		SqlSession session = factory.openSession(true);
		
		try {
			// 3. 세션 통해서 쿼리 실행 & 결과 받기
			
			// 입력에 사용할 값이 담기는 맵 객체 생성
			
			Emp emp = new Emp();
			emp.setEmpno(1111);
			emp.setEname("박준석");
			emp.setJob("SALESMAN");
			
			// DML 수행에 성공한 건수를 리턴
//			int addCnt =session.insert("mybatis.emp.mapper.EmpMapper.insert2", emp);
			EmpMapper mapper;
			mapper = session.getMapper(EmpMapper.class);
			
			// (2) EmpMapper 인터페이스의 insert() 메소드 호출
			int addCnt = mapper.insert2(emp);
			
			if (addCnt > 0) {
				System.out.println("직원정보=" + emp);
				System.out.printf("%d 행이 삽입되었습니다.%n", addCnt);
			}
			
		} finally {
			// 4. 세션 닫기(해제)
			if (session != null) {
				session.close();
			}
		}
		

	}

}
