package product.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import product.mybatis.MybatisClient;
import product.vo.Price;
import product.vo.PrimaryKey;
import product.vo.Product;

public class ProductDao {
	
	// (1) 멤버변수 SqlSessionFactory factory 선언
	SqlSessionFactory factory;
	// (2) 생성자 
	//     factory 변수를 MybatisClient 를 사용하여 초기화 진행
	public ProductDao() {
		factory = MybatisClient.getFactory();
	}
	// (3) 메소드
	//    1)  selectProducts() : List<Product>
	//      조회 쿼리 아이디 : selectAllProducts
	public List<Product> selectProducts(){
		// 세션얻기 , 필요한 변수 선언,초기화
		SqlSession session = factory.openSession(true);
		List<Product> products = new ArrayList<>();
		
		// 메소드 작성
		try {
			products = session.selectList("product.mapper.ProductMapper.selectAllProducts");
			
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return products;
						
	}
	//    2)  selectProduct(PrimaryKey pk) : Product
	//    	조회 쿼리 아이디 : selectProduct
	public Product selectProduct(PrimaryKey pk) {
		// 세션얻기 , 필요한 변수 선언, 초기화
		Product product = new Product();
		SqlSession session = factory.openSession(true);
		
		// 메소드 작성
		try {
			product = session.selectOne("product.mapper.ProductMapper.selectProduct", pk);
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return product;
		
	}
	//    3)  insertProduct(Product product) : int
	//    	조회 쿼리 아이디 : insertProduct
	public int insertProduct(Product product) {
		// 세션, 사용할 변수 얻기, 선언
		SqlSession session = factory.openSession(true);
		int addCnt = -1;
		try {
			addCnt = session.insert("product.mapper.ProductMapper.insertProduct", product);
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return addCnt;
	}	
	//    4)  updateProduct(PrimaryKey pk, Product product) : int
	//    	조회 쿼리 아이디 : updateProduct
	public int updateProduct(Product product) {
		SqlSession session = factory.openSession(true);
		int udpCnt = -1;
		
		try {						
			udpCnt = session.update("product.mapper.ProductMapper.updateProduct", product);
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
			return udpCnt;
			
		
	}
	//    5)  deleteProduct(PrimaryKey pk) : int
	//    	조회 쿼리 아이디 : deleteProduct
	public int deleteProduct(PrimaryKey pk) {
		// 세션 , 변수선언
		SqlSession session = factory.openSession(true);
		int delCnt = -1;
		// 쿼리 실행
		try {
			delCnt = session.delete("product.mapper.ProductMapper.deleteProduct", pk);
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return delCnt;
		
	}
	//    6)  selectProducts(String name) : List<Product>
	//    	조회 쿼리 아이디 : selectByName
	public List<Product> selectProducts(String name){
		// 세션얻기, 필요한변수선언
		SqlSession session = factory.openSession(true);
		List<Product> searchProducts = new ArrayList<>();
		
		try {
			searchProducts = session.selectList("product.mapper.ProductMapper.selectByName", name);
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
		return searchProducts;			
	}
	
	//    7)  selectProducts(Price price) : List<Product>
	//    	조회 쿼리 아이디 : selectByPrice
	public List<Product> selectProducts(Price price){
		// 세션얻기, 변수 선언
		SqlSession session = factory.openSession(true);
		List<Product> priceProducts = new ArrayList<>();
		
		try {
			priceProducts = session.selectList("product.mapper.ProductMapper.selectByPrice", price);
			
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return priceProducts;
		
	}
	//    8)  selectProductsByMinPrice(int min) : List<Product>
	//    	조회 쿼리 아이디 : selectExpensiveThan
	public List<Product> selectProductsByMinPrice(int min){
		// 세션얻기, 변수 선언
		SqlSession session = factory.openSession(true);
		List<Product> expensiveProducts = new ArrayList<>();
		
		try {
			expensiveProducts = session.selectList("product.mapper.ProductMapper.selectExpensiveThan", min);
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return expensiveProducts;
				
				
	}
	//    9)  selectProductsByMaxPrice(int max) : List<Product>
	//    	조회 쿼리 아이디 : selectCheapThan
	public List<Product> selectProductsByMaxPrice(int max) {
		SqlSession session = factory.openSession(true);
		List<Product> cheapProducts = new ArrayList<>();
		
		try {
			System.out.println("조회결과");
			cheapProducts = session.selectList("product.mapper.ProductMapper.selectCheapThan", max);

		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return cheapProducts;
		
	}
	//    10) selectMostExpensive() : List<Product>
	//    	조회 쿼리 아이디 : selectMostExpensive
	public List<Product> selectMostExpensive() {
		SqlSession session = factory.openSession(true);
		List<Product> mostExpensive = new ArrayList<Product>();
		Product product = new Product();
		
		try {
			
			mostExpensive = session.selectList("product.mapper.ProductMapper.selectMostExpensive", product);
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return mostExpensive;
		
		
		
		
	}
	//    11) selectMostAmount() : List<Product>
	//    	조회 쿼리 아이디 : selectMostQuantity
	public List<Product> selectMostAmount(){
		// 세션얻기, 필요한 변수 선언
		SqlSession session = factory.openSession(true);
		List<Product> mostQuantity = new ArrayList<Product>();
		
		try {
			mostQuantity = session.selectList("product.mapper.ProductMapper.selectMostQuantity");
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return mostQuantity;
		
	}
}
