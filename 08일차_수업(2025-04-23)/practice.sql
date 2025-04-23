[서브쿼리 기본 문제]
1. SMITH와 동일한 업무를 하는 사원의 이름, 업무, 입사일을 출력하세요
     - SELECT ENAME, JOB, HIREDATE FROM EMP WHERE JOB = (SELECT JOB FROM EMP WHERE ENAME="SMITH");
2. WARD의 입사일보다 빠른 사원들을 출력하세요
     - SELECT * FROM EMP WHERE HIREDATE < (SELECT HIREDATE FROM EMP WHERE ENAME="WARD"); 
3. 사원의 평균 급여보다 적은 급여를 받는 사원의 이름, 급여를 출력하세요
     - SELECT ENAME, SAL FROM EMP WHERE SAL < (SELECT AVG(SAL) FROM EMP); 
4. 부서 위치가 DALLAS인 부서에 근무하는 사람들의 이름, 부서번호를 출력하세요
     - SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE LOC="DALLAS"); 
5. ALLEN의 매니저의 사원번호, 이름, 입사일을 출력하세요
     - SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE EMPNO = (SELECT MGR FROM EMP WHERE ENAME="ALLEN"); 
6. 커미션 계약을 한 사원들의 평균 급여에 1000을 더한 값보다 더 많은 급여를 받는 사원의 이름, 급여를 출력하세요
     - SELECT ENAME, SAL FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE COMM >= 0) + 1000;
7. 급여가 두 번째로 높은 사원과 같은 부서에서 근무하는 사원의 이름, 급여, 부서번호를 출력하세요
     - SELECT ENAME, SAL, DEPTNO FROM EMP WHERE ENAME = (SELECT ENAME FROM EMP WHERE 
8. 이름이 A로 시작하는 사원들의 급여의 합보다 높은 급여를 받는 사원의 사원명, 급여를 출력하세요
9. 입사일이 세 번째로 늦은 사원과 같은 부서에서 근무하는 사원들의 급여의 합을 출력하세요
10. 최대 커미션을 받는 사원의 매니저가 근무하는 부서명, 위치, 부서번호를 출력하세요
11. 최대급여에서 최소급여를 뺀 금액보다도 더 많은 급여를 받는 사원의 이름, 급여를 출력하세요
12. SALES 부서의 평균 급여보다 급여를 더 많이 받는 사원의 이름, 급여를 출력하세요
