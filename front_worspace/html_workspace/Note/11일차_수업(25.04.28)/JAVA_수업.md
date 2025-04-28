## JAVA
- 1995년 Sun Microsystems에서 발표된 객체 지향 프로그래밍 언어
- 가전 제품용 개발을 목표로 시작했으나, 기업 및 웹 애플리케이션, 모바일 등으로 활용 분야 발전

### "Write Once Run anywhere" 슬로건
- linux, windows, Mac 등 각 OS에 맞도록 사용할 수 있는 코드
- 단, JVM(Java Virtual Machine)을 설치하는 것이 전제 조건

오라클 JDK → 상엄적 이용 시 라이센스 비용을 지불해야 함
OPEN JDK → 소스를 반드시 오픈해야 함 / 비용 지출은 없음

javac.exe, java.exe 등의 Java 개발용 프로그램들이 위치하는 디렉토리는 bin이지만 이 디렉토리를 java_home으로 사용하지 않고, 상위 디렉토리를 java_home으로 사용하며 JDK 설치 루트 디렉토리라고 함

cmd \ powershell 실행
cmd \ notepad 열어 test.java (모든 파일 형식 / ansi 인코딩으로 저장)

class Test{
    String name = "류희용";
}

Test.java 사람이 보는 언어
Test.class 기계어 저장 → 컴파일 성공 후에는 기계어만 돌리면 되기 때문에 훨씬 빠름

컴파일은 .class로 저장하는 것
실행 명령문은 "java" 입력 ex) java Test // Test.class를 실행한다.
