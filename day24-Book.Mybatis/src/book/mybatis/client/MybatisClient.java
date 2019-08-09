package book.mybatis.client;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis 의 커넥션인 세션을 생성하는
 * SqlSesseionFactory 클래스 인스턴스를
 * 생성하고 생성한 인스턴스를
 * 싱글턴(sin leton) 으로 관리하는 클래스
 * 
 * ------------------------------------
 * 싱글턴 : 디자인 패턴
 * 
 * 어떤 인스턴스 프로그램이 실행되는 동안
 * 단 한개로 유지되는기법
 * 
 * 1. 싱글턴으로 유지할 타입의 변수를 public static 하게 선언
 * 2. 생성자를 private 변경
 * 3. 싱글턴으로 유지할 타입을 리턴하는 public static 메소드 getInstance() 등을 선언하고
 *    이 메소드 내부에서만 생성자 호출을
 *
 * 
 *
 *
 * @author Administrator
 *
 */
public class MybatisClient {
	
	//1.
	// 싱글턴으로 관리할 타입(SqlSessionFactory) 의
	// static 변수를 선언
	public static SqlSessionFactory factory;
	
	// 2.  싱글턴으로 관리할 변수를 초기화
	//	public MybatisClient() {
//			mybatis-configx.xml 파일을 InputStream 으로 읽어서
		// sqlSeesionFactory 생성
	String resource = "mybattis-config.xml";
	InputStream in = null;
	
	try {
		in = in = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder()factory.build(in);
				
	} catch (IO) {
		
	}
	// 3.
	// 싱글턴으로 관리할 타입(SqlSessionFactory) 을 리턴하는
	// static 메소드 getFactory() 를 선언
	public static SqlSessionfactory getFactory() {
		if (factory == null){
			new MybatisClient();
		}
		
		return factory;
	}
	
	
}
