# javaEE / 웹프로그램 / 웹애플리케이션 형태

## 38일차 수업(25.06.16.)
- Tomcat 설치 
- JAVA_HOME 환경변수 설정
- Tomcat bin 디렉토리에서 cmd 실행 후 dir 선택하여 startup 실행 (서버... 닫지 말 것)
- 서버 포트 변경 후 접속 ( http://localhost:8080 )
- 기본 localhost 충돌 시 localhost 주소 수정 (Tomcat > conf > server 메모장 혹은 vscode로 수정)

- http://IP주소:localhost주소/실행할html명


java 프로젝트 → 애플리케이션 생성

jsp 프로젝트 → 웹사이트 생성

mysite > WEB-INF/classes/src

자바의 클래스 중, 오직 java EE 기반의 서버에서만 해석 및 실행될 수 있는 클래스를 가리켜 서블릿(servlet)이라 함..

서블릿으로 정의하기 위해서는 서블릿을 상속 받아야 함

서블릿은 밴더사에서 java의 기준에 맞춰 javaEE 구현체로 만든다.

서블릿 jar은 WEB-INF/lib 디렉토리에 존재해야 함
