## [오라클 접속]
services.msc 입력하여 service 실행
OracleServiceXE → 우클릭 하여 상태를 '시작' 상태로 변경

## [DBeaver 설치]
DBeaver → 크롬브라우저에 검색
DBeaver Community 버전 설치

## [DBeaver-Oracle 연결]
1) Select your database에서 Oracle 선택
2) Basic 탭의 Host / Database / Port / Username / Role / Password 설정
- Host : localhost
- Port : 1521
- Database : XE
- Username : sys
- Role : SYSDBA
- Password : **** (비밀번호 설정)
3) Client 위치 설정
노트북 용량부족으로 Client E:드라이브에 설치하였음

4) Test Connection 눌러 접속 되는지 확인
5) 추가 필요 Driver 다운로드

### [Oracle DataBase 만들기]
1. DBeaver 내 SQL 편집기 실행

2. CREATE TABLESPACE <테이블 스페이스 이름>
3. DATAFILE <데이터파일 생성위치> -- 데이터 파일 위치
4. SIZE <파일 용량 지정>;

5. 실제 적용 예시
CREATE TABLESPACE myspace 
DATAFILE 'E:\app\oracle\ordata\XE\myspace.dbf'
SIZE 1M;


### [User 만들기]
1. CREATE USER <유저이름>
2. IDENTIFIED BY <비밀번호>
3. DEFAULT TABLESPACE <사용할 테이블스페이스> -- 기본 사용가능한 테이블 스페이스(데이터베이스) 지정
4. quota unlimited ON <사용할 테이블스페이스>; -- 사용가능한 영역 지정

5. 실제 적용 예시
CREATE USER java
IDENTIFIED BY ****
DEFAULT TABLESPACE myspace
QUOTA UNLIMITED ON myspace; //할당량의 제한이 없음

6. DBeaver 내 Oracle(XE)의 Schemas를 선택 후 F5 누르면 User가 새로 생성된 것을 확인할 수 있음
Schemas>JAVA

### [접속 권한 설정]
- 이전에 배웠던 DDL, DML, DCL 중 사용하지 않았던 DCL
- DCL은 권한을 주거나 뺏는 기능을 가지고 있음

#### 접속 권한 부여
GRANT CREATE SESSION TO <유저이름>;
GRANT CREATE SESSION TO JAVA;
- SESSION : SERVER와 CLIENT 연결되었음을 의미 

### Oracle sql접속
1. CMD 실행
2. sqlplus java/**** 입력 <sqlplus + ID/Password> <!-- mysql이었다면 mysql -u root -p 입력 후 패스워드 입력창이 나오면 **** 입력 -->

### 테이블 생성

#### Oracle 용 
--------------------------------------------------------------
-- 부서 테이블 생성/레코드 넣기
--------------------------------------------------------------

create table dept(
deptno number 
,dname varchar2(14)
,loc varchar2(13)
,primary key(deptno)
);
 
 
--------------------------------------------------------------
-- 사원 테이블 생성/레코드 넣기
--------------------------------------------------------------
 
create table emp(
empno number 
,ename varchar2(10)     
,job varchar2(9)         
,mgr number
,hiredate date
,sal number
,comm number
,deptno number
,primary key(empno)
);
 
insert into dept(deptno,dname,loc) values(10,'ACCOUNTING','NEW YORK');
insert into dept(deptno,dname,loc) values(20,'RESEARCH','DALLAS');
insert into dept(deptno,dname,loc) values(30,'SALES','CHICAGO');
insert into dept(deptno,dname,loc) values(40,'OPERATIONS','BOSTON');
 
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7369,'SMITH','CLERK',7902,'80/12/17',800,20);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7499,'ALLEN','SALESMAN',7698,'81/02/20',1600,300,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7521,'WARD','SALESMAN',7698,'81/02/22',1250,500,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7566,'JONES','MANAGER',7839,'81/04/02',2975,20);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7654,'MARTIN','SALESMAN',7698,'81/09/28',1250,1400,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7698,'BLAKE','MANAGER',7839,'81/05/01',2850,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7782,'CLARK','MANAGER',7839,'81/06/09',2450,10);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7788,'SCOTT','ANALYST',7566,'87/04/19',3000,20);
insert into emp(empno,ename,job,hiredate,sal,deptno) values(7839,'KING','PRESIDENT','81/11/17',5000,10);
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(7844,'TURNER','SALESMAN',7698,'81/09/08',1500,0,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7876,'ADAMS','CLERK',7788,'87/05/23',1100,20);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7900,'JAMES','CLERK',7698,'81/12/03',950,30);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7902,'FORD','ANALYST',7566,'81/12/03',3000,20);
insert into emp(empno,ename,job,mgr,hiredate,sal,deptno) values(7934,'MILLER','CLERK',7782,'82/01/23',1300,10); 

--------------------------------------------------------------
-- 위 데이터 입력 적용하기
--------------------------------------------------------------
COMMIT; 

--------------------------------------------------------------
-- 데이터 입력을 마치고 sql 창에서 탈출하기
--------------------------------------------------------------
EXIT; <입력 후 cmd 창 종료>

### 테이블 GUI로 확인해보기
1. DBeaver 열기
2. SQL 편집기 실행
3. SELECT * FROM DEPT; / SELECT * FROM EMP; 입력하여 테이블 확인하기

