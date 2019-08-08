-- INSERT PreparedStatement
INSERT INTO EMP e(e.empno, e.ename)
VALUES (9999, '홍길동')
;
ROLLBACK;
-- Update PreparedStatement
UPDATE emp e
   SET e.job = ?
     , e.hiredate = sysdate
     , e.sal = ?
     , e.deptno = ?
 WHERE e.empno = ?
 ;
 -- Delete PreparedStatement
DELETE EMP e = ?
 WHERE e.empno = ?
;