## 집계함수
|함수|의미|
|-|-|
|COUNT()|개수 구하기|
|SUM()|합계 구하기|
|ABG()|평균 구하기|
|MAX()|최대값 구하기|
|MIN()|최소값 구하기|

1. 사원 수를 출력하시오
SELECT COUNT(세고 싶은 컬럼) FROM EMP; // SELECT COUNT(ENAME) FROM EMP;

2. 부서의 수를 출력하시오
SELECT COUNT(*) FROM DEPT;

3. 사원 급여의 합
SELECT SUM(SAL) FROM EMP; // SELECT SUM(COMM) FROM EMP;

4. 사원 급여의 평균
SELECT AVG(SAL) FROM EMP;

5. 최대/최소 급여 출력
SELECT MAX(SAL) FROM EMP; // SELECT MIN(SAL) FROM EMP;

---

## 그룹함수
SELECT subject, AVG(SCORE) AS 평균점수
FROM scores
GROUP BY subject;

6. 부서별로 몇 명이 근무하는가? (종류별로 묶자)
- SELECT DEPTNO FROM EMP GROUP BY DEPTNO; (부서번호만 구하기)
- SELECT DEPTNO, COUNT(DEPTNO) FROM EMP GROUP BY DEPTNO; (부서번호와 해당 부서번호의 인원수를 구하기)

** 표준 SQL에서는 GROUP BY에 명시한 컬럼만이 SELECT 절에 올 수 있음 **

- 그룹화된 결과에 조건을 적용할 때 HAVING 절을 사용함
- WHERE은 그룹화 이전의 조건, HAVING은 그룹화 이후의 조건

## 서브쿼리 (2개의 쿼리문을 한 문장으로, 하나의 쿼리문을 (소괄호) 안에 넣는다.)
Q. 20번 부서의 평균 급여보다 높은 급여를 받는 사원의 이름, 급여를 출력하시오.
  * SELECT ENAME, SAL FROM EMP WHERE SAL > (평균급여)
  * SELECT AVG(SAL) FROM EMP WHERE DEPTNO=20; \
→ SELECT ENAME, SAL FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=20);

Q. 커미션의 합보다 많은 급여를 받는 사원명, 급여를 출력하시오.
  * SELECT ENAME, SAL FROM EMP WHERE SAL > (SELECT SUM(COMM) FROM EMP); 

---
### 추가 개념
Q. 컬럼명을 ENAME에서 NAME으로 변경하여 보여줘
SELECT ENAME AS NAME FROM EMP;
