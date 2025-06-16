1-1)
SQL> SELECT HIREDATE FROM EMP
  2  WHERE ENAME='CLARK';

HIREDATE
--------
81/06/09

1-2)
SQL> SELECT EMPNO, ENAME, JOB, SAL FROM EMP
  2  WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME='BLAKE');

     EMPNO ENAME                JOB                       SAL
---------- -------------------- ------------------ ----------
      7499 ALLEN                SALESMAN                 1600
      7521 WARD                 SALESMAN                 1250
      7654 MARTIN               SALESMAN                 1250
      7844 TURNER               SALESMAN                 1500
      7900 JAMES                CLERK                     950

1-3)
SQL> SELECT EMPNO, ENAME FROM EMP WHERE
  2  EMPNO IN (SELECT MGR FROM EMP WHERE HIREDATE > (SELECT
  3  HIREDATE FROM EMP WHERE JOB='PRESIDENT'));

     EMPNO ENAME
---------- --------------------
      7782 CLARK
      7698 BLAKE
      7566 JONES
      7788 SCOTT

1-4)
SQL> SELECT ENAME, JOB, SAL, COMM FROM EMP
  2  ORDER BY HIREDATE ASC;

ENAME                JOB                       SAL       COMM
-------------------- ------------------ ---------- ----------
SMITH                CLERK                     800
ALLEN                SALESMAN                 1600        300
WARD                 SALESMAN                 1250        500
JONES                MANAGER                  2975
BLAKE                MANAGER                  2850
CLARK                MANAGER                  2450
TURNER               SALESMAN                 1500          0
MARTIN               SALESMAN                 1250       1400
KING                 PRESIDENT                5000
JAMES                CLERK                     950
FORD                 ANALYST                  3000
MILLER               CLERK                    1300
SCOTT                ANALYST                  3000
ADAMS                CLERK                    1100

14 rows selected.

1-5) 
SQL> SELECT ENAME, SAL FROM EMP WHERE SAL > (
  2  SELECT AVG(SAL) FROM EMP WHERE DEPTNO=20
  3  ) 
  4  ORDER BY SAL DESC;

ENAME                       SAL
-------------------- ----------
KING                       5000
FORD                       3000
SCOTT                      3000
JONES                      2975
BLAKE                      2850
CLARK                      2450

6 rows selected.


2-1)
SQL> SELECT JOB FROM EMP
  2  GROUP BY JOB;

JOB
------------------
CLERK
SALESMAN
PRESIDENT
MANAGER
ANALYST

2-2)
SQL> SELECT JOB, AVG(SAL), COUNT(JOB) FROM EMP
   2 GROUP BY JOB;

JOB                  AVG(SAL) COUNT(JOB)
------------------ ---------- ----------
CLERK                  1037.5          4
SALESMAN                 1400          4
PRESIDENT                5000          1
MANAGER            2758.33333          3
ANALYST                  3000          2

2-3)
SQL> SELECT DEPTNO, COUNT(DEPTNO) FROM EMP
  2  GROUP BY DEPTNO;

    DEPTNO COUNT(DEPTNO)
---------- -------------
        30             6
        20             5
        10             3

2-4)
SQL> SELECT COUNT(EMPNO), AVG(SAL) FROM EMP
  2  GROUP BY MGR;

COUNT(EMPNO)   AVG(SAL)
------------ ----------
           3 2758.33333
           1       5000
           1       1300
           5       1310
           1        800
           2       3000
           1       1100

7 rows selected.

2-5)
SQL> SELECT (SELECT ENAME FROM EMP WHERE EMPNO=E.MGR) AS 팀장명,
  2  COUNT(EMPNO) AS 직원수,
  3  MAX(SAL) AS 최고급여
  4  FROM EMP E
  5  GROUP BY E.MGR;

팀장명                   직원수   최고급여
-------------------- ---------- ----------
KING                          3       2975
                              1       5000
CLARK                         1       1300
BLAKE                         5       1600
FORD                          1        800
JONES                         2       3000
SCOTT                         1       1100

7 rows selected.

비어있는 팀장명은 KING의 팀장 // KING은 팀장이 없으므로, 팀장명이 NULL

3-1)
3-2)
3-3)
3-4)
3-5)

4-1)
4-2)
4-3)
4-4)
4-5)
