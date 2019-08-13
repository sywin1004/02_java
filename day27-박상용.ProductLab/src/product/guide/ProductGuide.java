package product.guide;

public class ProductGuide {
	
	// 자바 : mybatis 연동 작업 순서
	
	/*
	1. product.vo 패키지 : 3개의 클래스 작성
	  --------------------------------------------------------------------------------
	  Product 클래스 생성
	  --------------------------------------------------------------------------------
	  (1) PRODUCT 클래스 컬럼명과 동일한 멤버변수, 컬럼 타입별 
          자바에서 적당한 타입으로 지정된 멤버변수를 갖는 클래스 생성
	  (2) 컬럼명이 _(underscore) 인 경우 자바에서는 camelCase(낙타표기법 적용)
	  (3) 기본생성자 생성
	  (4) 접근자, 수정자 생성
	  (5) equals() & hashCode() : code 변수로 작성
	  (6) toString() 작성 
	    : "제품정보[안쪽에 각 멤버변수 이름:값, 이름:값, ..., 이름:값]" 형태로 출력되도록
	  --------------------------------------------------------------------------------
	  --------------------------------------------------------------------------------
	  PrimaryKey 클래스 생성
	  --------------------------------------------------------------------------------
	  (1) PRODUCT 테이블의 PK 컬럼인 code 컬럼을 멤버변수로 갖는 클래스 생성
	  (2) 기본생정자 생성
	  (3) 접근자, 수정자 생성
	  (4) equals(), & hashCode() : code 변수로 작성
	  (5) toString() 작성 
	    : "PK=P001" 과 같은 문자열이 출력되도록 작성
	  --------------------------------------------------------------------------------  
	  --------------------------------------------------------------------------------  
	  Price 클래스 생성 : 가격 검색을 위한 최저가, 최대가 를 저장하는 클래스
	  --------------------------------------------------------------------------------
	  (1) int min, int max 두 개의 멤버변수를 선언
	  (2) 기본생성자 생성
	  (3) 접근자, 수정자 생성
	  (4) equals() & hashCode() : 두 값 모두로 작성
	  (5) toString() 작성
	    : "검색가격[최저가:얼마 ~ 최대가:얼마]" 와 같은 문자열이 출력되도록 작성 
	  --------------------------------------------------------------------------------
	  --------------------------------------------------------------------------------
	2. product.mybatis 패키지
	   MybatisClient 클래스 제공됨
	   Mybatis 의 SqlSessionFactory 객체 얻는 방법 참고
	  --------------------------------------------------------------------------------
	  --------------------------------------------------------------------------------
	3. src 에 mybatis-config.xml 파일 내용 일부 제공됨
	   mybatis-config.xml 파일 내부에 <!-- TODO --> 로 되어있는 부분 작성
	  --------------------------------------------------------------------------------
	  -------------------------------------------------------------------------------- 
	4. product.mapper 패키지	 
	   ProductMapper.xml 파일 생성
	  -------------------------------------------------------------------------------- 
	   mapper DTD 설정 : 다음의 DTD 로 작성
	   
	   <!DOCTYPE mapper
		  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
	  --------------------------------------------------------------------------------	  
	   mapper 의 namespace : 패키지명.패키지명.파일명 으로 줄 것
      -------------------------------------------------------------------------------- 
       (1) 전체 컬럼 전체목록 조회 쿼리 작성
           id="selectAllProducts" resultType="Product"
       
      -------------------------------------------------------------------------------- 
       (2) PK 를 걸어서 1개의 제품정보 전체 컬럼 조회 쿼리 작성
           id="selectProduct" parameterType="PrimaryKey" resultType="Product"
       
      --------------------------------------------------------------------------------     
       (3) 1개의 제품 정보 삽입하는 INSERT 쿼리 작성
           삽입 대상 컬럼 : code, name, price, quantity
           id="insertProduct" parameterType="Product"

      --------------------------------------------------------------------------------     
       (4) 1개의 제품 정보 수정하는 UPDATE 쿼리 작성, 
           PK 걸어서 수정
           수정 대상 컬럼 : name, price, quantity, mod_date
           수정일은 현재 시스템 시간으로 업데이트
           
           id="updateProduct" parameterType="PrimaryKey"
           
      --------------------------------------------------------------------------------     
       (5) 1개의 제품 정보 삭제하는 DELETE 쿼리 작성,
           PK 걸어서 삭제
           id="deleteProduct" parameterType="PrimaryKey"
           
      --------------------------------------------------------------------------------     
       (6) 제품명(name)에 특정 검색어가 들어가는 제품목록 
           전체 컬럼 조회쿼리 작성 : LIKE 사용
           id="selectByName" parameterType="string"
           
      --------------------------------------------------------------------------------
      * 7 ~ 9 번 
      * xml 문서에는 SQL 비교 연산자인 <, > 기호를
      * 작성할 수 없음
      * 따라서 가격 비교 연산에 사용되는 < 또는 > 연산자를 다음과 같이 작성할 것
      * <![CDATA[ > ]]> , <![CDATA[ < ]]>
      *       
       (7) 가격이 두 값 사이인 제품목록 전체 컬럼 조회쿼리 작성
           id="selectByPrice" prarameterType="Price" resultType="Product"
           
      --------------------------------------------------------------------------------
       (8) 가격이 어떤 값 이상인 제품목록 전체컬럼 조회 쿼리 작성
           id="selectExpensiveThan" parameterType="int" resultType="Product"
      
      --------------------------------------------------------------------------------
       (9) 가격이 어떤 값 이하인 제품목록 전체컬럼 조회 쿼리 작성
           id="selectCheapThan" parameterType="int" resultType="Product"
           
      --------------------------------------------------------------------------------
       (10) 가장 비싼 가격의 제품목록 전체컬럼 조회 쿼리 작성
          id="selectMostExpensive" resultType="Product"
          
      --------------------------------------------------------------------------------
       (11) 재고가 가장 많은 제품목록 전체컬럼 조회 쿼리 작성
          id="selectMostQuantity" resultType="Product" 
           
      --------------------------------------------------------------------------------
	  -------------------------------------------------------------------------------- 
	  5. product.dao 패키지
	  
	     ProductDao 클래스 생성
	     (1) 멤버변수 SqlSessionFactory factory 선언
	     
         (2) 생성자 
             factory 변수를 MybatisClient 를 사용하여 초기화 진행
             
	     (3) 메소드
	        1)  selectProducts() : List<Product>
	            조회 쿼리 아이디 : selectAllProducts
	            
	        2)  selectProduct(PrimaryKey pk) : Product
	        	조회 쿼리 아이디 : selectProduct
	        	 
	        3)  insertProduct(Product product) : int
	        	조회 쿼리 아이디 : insertProduct
	        	 
	        4)  updateProduct(PrimaryKey pk, Product product) : int
	        	조회 쿼리 아이디 : updateProduct
	        	
	        5)  deleteProduct(PrimaryKey pk) : int
	        	조회 쿼리 아이디 : deleteProduct
	        	
	        6)  selectProducts(String name) : List<Product>
	        	조회 쿼리 아이디 : selectByName
	        	
	        7)  selectProducts(Price price) : List<Product>
	        	조회 쿼리 아이디 : selectByPrice
	        	
	        8)  selectProductsByMinPrice(int min) : List<Product>
	        	조회 쿼리 아이디 : selectExpensiveThan
	        	
	        9)  selectProductsByMaxPrice(int max) : List<Product>
	        	조회 쿼리 아이디 : selectCheapThan
	        	
	        10) selectMostExpensive() : List<Product>
	        	조회 쿼리 아이디 : selectMostExpensive
	        	
	        11) selectMostAmount() : List<Product>
	        	조회 쿼리 아이디 : selectMostQuantity
	  
	  6. product.test 패키지
	
	*
	*/
}
