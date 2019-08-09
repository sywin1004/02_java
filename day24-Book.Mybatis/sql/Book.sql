-- 1. Book 테이블 생성
/*
일련번호  : sequence  : int       
ISBN      : isbn      : String
제목      : title     : String  
저자      : author    : String  
출판사    : company   : String   
페이지 수 : totalPage : int       
가격      : price     : int     
재고수량  : quantity  : int       
*/
-- BOOK TABLE 생성 구문
DROP TABLE BOOK;
CREATE TABLE BOOK 
(  SEQUENCE NUMBER       
 , ISBN     VARCHAR2(13) 
 , TITLE    VARCHAR2(100) NOT NULL
 , AUTHOR   VARCHAR2(30) 
 , COMPANY  VARCHAR2(30)
 , TOTAL_PAGE NUMBER
 , PRICE    NUMBER(7)
 , QUANTITY NUMBER(4)
 , REG_DATE DATE        DEFAULT sysdate 
 , MOD_DATE DATE                        
 , CONSTRAINT PK_BOOK PRIMARY KEY (SEQUENCE)
 , CONSTRAINT UQ_BOOK_ISBN UNIQUE (ISBN)
);


-- 1건 조회
-- SEQUENCE 컬럼으로 걸어서 1번 책의 전체 컬럼 조회
SELECT b.sequence
     , b.isbn
     , b.title
     , b.author
     , b.company
     , b.total_page
     , b.price
     , b.quantity
     , b.reg_date
     , b.mod_date
  FROM BOOK b
 WHERE b.sequence = 1
;



-- 전체 컬럼 조회
SELECT b.sequence
     , b.isbn
     , b.title
     , b.author
     , b.company
     , b.total_page
     , b.price
     , b.quantity
  FROM BOOK b
 WHERE b.sequence = 1
;


-- INSERT 구문 
-- 전체 컬럼에 값 추가하는 구문으로 작성
/*
1, "9788936433598", "채식주의자" , "한강", "창비", 247, 10800, 10
일련번호  : sequence  : int       
ISBN      : isbn      : String
제목      : title     : String  
저자      : author    : String  
출판사    : company   : String   
페이지 수 : totalPage : int       
가격      : price     : int     
재고수량  : quantity  : int   
*/
INSERT INTO BOOK b(b.sequence, b.isbn, b.title, b.author, b.company, b.total_page,b.price,b.quantity)
VALUES (1,'9788936433598', '채식주의자', '한강', '창비', 247, 10800, 10)
;


-- UPDATE 구문
/*
1번 일련번호 책에 대해서 다음의 값으로 수정
1, "9788936433598", "채식주의자", "한강", "창비", 247, 10000, 7
*/
UPDATE BOOK b
   SET b.sequence = 1
     , b.isbn = '9788936433598'
     , b.title = '채식주의자'
     , b.author = '한강'
     , b.company = '창비'
     , b.total_page = 247
     , b.price = 10000
     , b.quantity = 7
 WHERE b.sequence = 1
;

-- DELETE 구문
-- SEQUENCE 컬럼으로 걸어서 1번 책 정보 삭제
DELETE Book b
 WHERE b.sequence = 1
;

-- 책 제목 유사검색 쿼리 작성 = LIKE
SELECT b.sequence
     , b.isbn 
     , b.title 
     , b.author
     , b.company
     , b.total_page
     , b.price
     , b.quantity 
     , b.reg_date 
     , b.mod_date 
  FROM BOOK b 
 WHERE b.title LIKE '%아%'
;

-- 책 가격 범위검색 쿼리 작성 = BETWEEN ~ AND ~
SELECT b.sequence" 
     , b.isbn" 
     , b.title" 
     , b.author" 
     , b.company" 
     , b.total_page" 
     , b.price" 
     , b.quantity" 
     , b.reg_date" 
     , b.mod_date" 
  FROM BOOK b 
 WHERE b.price BETWEEN 10000 AND 11000
;