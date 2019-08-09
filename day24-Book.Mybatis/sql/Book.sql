-- 1. Book ���̺� ����
/*
�Ϸù�ȣ  : sequence  : int       
ISBN      : isbn      : String
����      : title     : String  
����      : author    : String  
���ǻ�    : company   : String   
������ �� : totalPage : int       
����      : price     : int     
������  : quantity  : int       
*/
-- BOOK TABLE ���� ����
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


-- 1�� ��ȸ
-- SEQUENCE �÷����� �ɾ 1�� å�� ��ü �÷� ��ȸ
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



-- ��ü �÷� ��ȸ
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


-- INSERT ���� 
-- ��ü �÷��� �� �߰��ϴ� �������� �ۼ�
/*
1, "9788936433598", "ä��������" , "�Ѱ�", "â��", 247, 10800, 10
�Ϸù�ȣ  : sequence  : int       
ISBN      : isbn      : String
����      : title     : String  
����      : author    : String  
���ǻ�    : company   : String   
������ �� : totalPage : int       
����      : price     : int     
������  : quantity  : int   
*/
INSERT INTO BOOK b(b.sequence, b.isbn, b.title, b.author, b.company, b.total_page,b.price,b.quantity)
VALUES (1,'9788936433598', 'ä��������', '�Ѱ�', 'â��', 247, 10800, 10)
;


-- UPDATE ����
/*
1�� �Ϸù�ȣ å�� ���ؼ� ������ ������ ����
1, "9788936433598", "ä��������", "�Ѱ�", "â��", 247, 10000, 7
*/
UPDATE BOOK b
   SET b.sequence = 1
     , b.isbn = '9788936433598'
     , b.title = 'ä��������'
     , b.author = '�Ѱ�'
     , b.company = 'â��'
     , b.total_page = 247
     , b.price = 10000
     , b.quantity = 7
 WHERE b.sequence = 1
;

-- DELETE ����
-- SEQUENCE �÷����� �ɾ 1�� å ���� ����
DELETE Book b
 WHERE b.sequence = 1
;

-- å ���� ����˻� ���� �ۼ� = LIKE
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
 WHERE b.title LIKE '%��%'
;

-- å ���� �����˻� ���� �ۼ� = BETWEEN ~ AND ~
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