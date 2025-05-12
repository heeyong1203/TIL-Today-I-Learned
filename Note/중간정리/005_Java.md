### java언어로 개발할 수 있는 분야??
#### 자바의 개발 플랫폼
1) JavaSE: 데스크탑 기반의 애플리케이션 (6월 말까지 배울 예정)
2) JavaEE: 웹애플리케이션 (수료때까지 배울 예정) ↔ 닷넷(망함 ms사), c#만 남음
3) JavaME: 임베디드 분야






# 유사한 메서드가 있는 경우
- 동일 메서드를 사용하되, 매개 변수에 차이를 둔다

ex)
```java
// 오리가 난다...
public void fly(){

}

// 오리가 조금 더 높이 난다...
public void fly(int h){

}
```

- 프로그램 작성 시, 개발자는 변수와 메서드명에 상당한 공을 들여 이름을 부여함
- 하지만, 개발 시 비슷한 기능의 메서드임에도 불구하고, 메서드명 중복을 피하려는 원칙을 너무 고수하면\ 메서드를 여러 개 만들어야 하는 상황이 발생할 수 있으며, 비효율적임
- java, c# OOP에서는 기능상 크게 차이가 없는 경우, 기존의 메서드명을 중복정의하는 기법을 지원함
- 이를 메서드 오버로딩(Method OverLoading : 메서드 중첩 기법)이라고 함
- 단, 오버로딩을 인정받기 위해서는 아래의 조건을 만족해야 함
    1) 메서드의 이름이 동일
    2) 매개변수의 자료형이나 개수가 달라야 인정됨

```java
public void fly(int h){

}

public void fly(int x){

} (오버로딩 X)

public void fly(int x, boolean k){

} (오버로딩 O)

```

```
다음 설명 중 올바른 설명은?

(1) Java 에서는 같은 클래스 내의 메서드 들 끼리 이름이 중복 정의되어서는 안된다.

(2) 메서드 이름은 중복되어도 인수의 자료형과 개수를 달리하면 메서드 간 구분이 가능하므로 이러한 메서드 정의법은 Java에서 허용된다.

(3) 중복된 메서드명이 허용된다고 할지라도, 많은 혼란을 초래하므로 현실적으로 사용 빈도는 높지 않다.

(4) 같은 클래스 내에서 중복된 이름을 허용하는 자바의 메서드 정의 기법을 오버로딩(Overloading)이라 한다.

(5) 개발자는 메서드명에 상당한 공을 들여 직관성을 부여한다, 하지만 기능상 큰 차이가 없는 또 다른 메서드를 정의하려고 할때, 이전에 지어놓은 메서드명 과의 ‘중복 금지’라는 원칙 때문에 다른 이름으로 지어야 한다면 개발자는 중복을 피하기 위해 새로운 메서드 이름을 짓는 데에 또 다른 시간과 노력을 들여야 하므로 개발의 효율성이 떨어진다. 또한 상당히 비슷한 기능을 갖는 메서드들 임에도 불구하고 이름을 달리 정의하게 될 경우, 메서드 이름만으로도 그 수행 내용을 예측할 수 있었던 직관성 또한 약해질 수 있다. 
```
정답: (4), (5)

---

```
아래 코드의 결과는?

Given:
1. public class A {
2.  public void doit() {

3.  }
4.  public String doit() {  
5.    return “a”;
6.  }
7.  public double doit(int x) {
8.    return 1.0;
9.  }
10.}

What is the result?

A. An exception is thrown at runtime.
B. Compilation fails because of an error in line 7.
C. Compilation fails because of an error in line 4.
D. Compilation succeeds and no runtime errors with class A occur.

```
정답: (C)

---

- 개발자가 생성자를 정의하지 않으면 컴파일러에 의해 default 생성자가 정의됨
- 이 때의 관여는 최소한의 관여이므로, 디폴트 생성자의 {몸체}에는 아무런 코드가 들어있지 않음 
- 	super() 제외
- 생성자도 메서드이다. 따라서, 메서드 오버로딩의 원칙이 당연히 적용됨

#### Q. 컴파일러는 왜 개발자가 정의하지도 않은 디폴트 생성자를 넣을까?
**A.** 자바에서는 `인스턴스` 생성 시 `new 연산자` 뒤에 강제하고 있기 때문에 <br> 
자칫 개발자가 `생성자`를 **정의하지 않는 경우**, <br>
존재하지 않는 생성자 호출에 의해 인스턴스 생성과정에서 많은 컴파일 에러가 발생할 여지가 있음 <br>
따라서 에러가 발생하지 않도록, 컴파일러 차원에서 최소한의 관여가 발생함

```java
public Cat(){
    /*
    주석으로 메서드 막기
    public Cat(){ 
		System.out.println("Cat() 호출");	
	} 
    */
}

public UseCat(){
    public static void main(String[] args){
        new Cat();
    }
}
```
#### 결과 : 아무것도 없는 빈 창 실행됨 (컴파일과 실행 모두 오류없이 진행됨)
---

<br>

메서드의 선언 형식
```java
[접근 제어자] [반환 타입]     메서드명        (매개변수){

}

    public     void     printMessage    (String msg){

}

접근 제어자와 반환 타입의 순서는 정해져 있지 않음.
그러나, 반환 타입은 반드시 메서드명 바로 앞에 명시해야 함
```

디렉토리 위치 변경
- javac 누르면 다양한 기능 확인 가능
- javac -d<directory> : Specify where to place generated class files
- javac -d E:\Lecture_workspace\back_workspace\java_workspace\testapp\bin Dog.java

- classpath 등록
- cmd > echo %classpath%
- E:\Lecture_workspace\back_workspace\java_workspace\testapp\bin


java use.UseDog

프로젝트 패키지 \
bin / src 패키지 생성 \
src - com 
        > sinse 
                > testproject

도메인을 뒤집고, 프로젝트명, 파일명
ex)
com.sinsegye.shop.파일명

과제
```
1) ~~~~bin 까지를 환경변수 등록하기
2) editplus에 개발환경(편리한) 만들기
3) ~~~~~~use 패키지 밑에 UseRose 클래스에서 bloom() 메서드 사용하기
```

```
1-1) bin디렉토리까지 주소 복사
E:\Lecture_workspace\back_workspace\java_workspace\testproject\bin
1-2) 환경변수 설정
시스템 설정 > 고급 시스템 설정 > 고급 탭 이동 > 환경 변수 클릭 > 시스템 변수, 새로 만들기
- 변수 이름: classpath
- 변수 값: E:\Lecture_workspace\back_workspace\java_workspace\testproject\bin

2-1) editPlus 도구 > 사용자 도구 구성
2-2) 그룹명 수정 후 추가 버튼 눌러 메뉴 제목 설정
2-3) 명령 옆에 ...리본 버튼 > javac.exe 찾기 (jdk-21.0.1 > bin > javac.exe)
2-4) cmd 동작을 기억해보자
     javac -d E:\Lecture_workspace\back_workspace\java_workspace\testproject dog.java
     (확장자까지 입력했음을 참고)
2-5) 인수명 : -d E:~\testproject ▼ 눌러 (파일 이름) 선택
2-6) 디렉토리 : ▼ 눌러 (파일 디렉토리) 선택
2-7) 동작 : 출력 내용 캡처 (컴파일 환경 설정 끝)
2-8) 그룹 내 추가 버튼 누른 후 메뉴 제목 설정
2-9) 명령: ... 버튼 통해 java.exe 찾기
2-10 인수 : (인수 내용 묻기) 선택 후 온점(.)입력 후 확장자를 뺀 파일이름 선택
            ex) $(prompt).$(FileNameNoExt)
2-11) 디렉토리 : 파일 디렉토리 선택 (실행 환경 설정 끝)

3-1) use 패키지 생성 후, UseRose클래스 생성
3-2) 사용하고자 하는 bloom 메서드는 plant 패키지에 있으므로 import 실시
3-3) 실행부 추가
3-4) 컴파일, 실행 작동 확인
```
```java
package com.sinse.testproject.use;

import com.sinse.testproject.plant.Rose;
class UseRose{
	
	public static void main(String[] args){
		Rose r = new Rose();
		r.bloom();
	}
}
```

