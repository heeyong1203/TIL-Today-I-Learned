### sql 문제연습
   
1.업무가 SALESMAN, CLERK 인 사원들의 이름, 업무, 급여를 출력하시오 (in 이용)

2.급여가 2000 이상 3000 이하인 사원의 이름, 급여를 출력하되, 급여를 기준으로 내림차순 정렬하시오. (BETWEEN A AND B) 

3.이름에 K 자가 들어가는 사원의 이름, 급여, 입사일을 출력하되 입사일이 빠른 날짜 순으로 출력하시오.

4.커미션 계약을 하지 않은 사원들의 이름, 급여, 커미션을 출력하되, 급여가 높은 순으로 출력하세요
	
5.급여가 높은 상위 3명의 사원명, 급여를 출력하세요(limit)
	
6.급여가 낮은 순으로 정렬된 상태에서, 상위 2명은 제외시키고 3번째부터 시작하여 5명의 이름, 급여, 부서번호를 출력하시오 (offset )

7.급여가  1500 이상 2000 이하가 아닌 사원의 이름, 급여를 출력하되 급여를 기준으로 오름차순으로 정렬하세요 (not between)

8.사원들을 부서 번호를 기준으로 오름차순으로 정렬시키고, 그 정렬 내에서, 다시 급여가 높은 순으로 정렬이 되게 출력해
  보세요

8-1) 아래의 조건으로 테이블을 생성하세요
table명: member
id컬럼 : 한글,영문 20자 수용 크기
pwd컬럼 : 암호화 해시값용 64자 수용 크기 
email 컬럼: 영문 25자 수용 크기

8-2) 아래의 조건으로 member 테이블 구조 변경하기
(1) name 컬럼 추가 : 한글,영문 등 문자 20자 수용 크기
 
(2) 테이블명 변경 : 기존 테이블명을 membership 으로                 
                 
(3) 컬럼명 변경: 기존 pwd를 pass로 

(4) 컬럼의 크기 변경: 기존 email컬럼의 크기를 20자로

8-3) 테이블 제거하기

정답	1. SELECT ENAME, JOB, SAL FROM EMP WHERE JOB IN ('SALESMAN', 'CLERK');
	2. SELECT ENAME, SAL FROM EMP WHERE SAL BETWEEN 2000 AND 3000 ORDER BY SAL DESC;
	3. SELECT ENAME, SAL, HIREDATE FROM EMP WHERE ENAME LIKE '%K%' ORDER BY HIREDATE ASC;	
	4. SELECT ENAME, SAL, COMM FROM EMP WHERE COMM IS NULL ORDER BY SAL DESC;
	5. SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC LIMIT 0, 3; // 높은 순으로 정렬 후 0명 제외, 3명까지
동일 표현 → SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC LIMIT 3 OFFSET 0;
	6. SELECT ENAME, SAL, DEPTNO FROM EMP ORDER BY SAL ASC LIMIT 5 OFFSET 2;
	7. SELECT ENAME, SAL FROM EMP WHERE SAL NOT BETWEEN 1500 AND 2000 ORDER BY SAL ASC;
	8. SELECT * FROM EMP ORDER BY DEPTNO, SAL ASC; 
	9-1) CREATE TABLE MEMBER (
		ID VARCHAR(20) PRIMARY KEY
		, PWD CHAR(64) NOT NULL
		, EMAIL VARCHAR(25) NOT NULL // 태생을 건드림 DDL(Data Definition Language)
		); // 만들어진 컬럼을 보고 싶으면 DESC MEMBER; // DESCRIBE MEMBER; 입력하면 됨
  	9-2)	(1)	ALTER TABLE MEMBER 
			ADD NAME VARCHAR(20);
		(2)	RENAME TABLE MEMBER TO MEMBERSHIP;
		(3)	ALTER TABLE MEMBERSHIP
			CHANGE PWD PASS CHAR(64) NOT NULL;
		(4)	ALTER TABLE MEMBERSHIP
			MODIFY EMAIL VARCHAR(64) NOT NULL;
	9-3)	DROP TABLE MEMBERSHIP; 

---

[ DML 기본 문제 ]

1. 사원 테이블을 emp2 라는 이름으로 복사하세요  
2. 부서 테이블을 dept2 라는 이름으로 복사하세요  
3. dept2 테이블의 30번 부서명을 한글 ‘세일즈’ 로 수정하세요  
4. emp2 테이블에서 이름이 WARD인 사원의 급여를 3500 으로 수정하세요  
5. emp2 테이블에서 사원 번호가 7839 인 사원의 이름은 회장으로, 급여는 9000 으로, 커미션은 5000 으로 수정하세요  
6. emp2 테이블에서 급여가 1000 보다 적은 사원의 정보를 삭제하세요  

정답
1) 	CREATE TABLE EMP2 AS SELECT * FROM EMP;
2) 	CREATE TABLE DEPT2 AS SELECT * FROM DEPT;
3)	UPDATE TABLE EMP2 
	SET JOB='세일즈' WHERE DEPTNO=30;
4)	UPDATE EMP2
	

