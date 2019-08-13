package product.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Mybatis 의 커넥션인 세션을 생성하는
 * SqlSessionFactory 클래스 인스턴스를 생성하고 
 * 
 * 생성한 인스턴스를 리턴하는 
 * 스태틱 메소드 getFactory() 를 제공하는 클래스
 * @author 304
 *
 */
public class MybatisClient {

	private static SqlSessionFactory factory;
	
	private MybatisClient() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			System.err.println("mybatis 설정 읽기 오류!");
			e.printStackTrace();
		}
	} // 생성자 종료
	
	public static SqlSessionFactory getFactory() {
		if (factory == null) {
			new MybatisClient();
		}
		
		return factory;
	}
}






