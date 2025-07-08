### jsp&Servlet → MVC패턴 기반 프레임워크 스프링제작 → Spring4 framework
- JSP & Spring
- Spring 4
- 8월 초 프로젝트 발표
- 8월 초 프로젝트 발표
---


## 54일차 수업(25.07.09)

### 🛠️ Spring Framework를 직접 만들어보며 배우는 MVC 구조

#### 📌 What to do가 아닌 How to do!
- *무엇을 만들지*보다 *어떻게 만들지*를 고민하는 개발자로 성장하기 위한 시작
- 실무에서 주로 사용하는 **디자인 패턴**과 **웹 애플리케이션 구조**를 직접 설계하고 구현해보는 과정
- 특히 **Spring 프레임워크의 구조를 직접 구현**해보며 핵심 원리를 체득하는 것이 목표

---

### 🏢 SI업체와 정부 프레임워크

#### ✅ SI업체
- 회사마다 자체 프레임워크를 보유하거나 커스터마이징하여 사용
- 유지보수성과 일관성 확보 목적
- 공공기관에서 업체를 바꾸면 유지보수에 문제가 생겨 비용 증가 발생이 빈번하였음

#### ✅ 정부
- 위의 고민으로 표준 프레임워크를 제시하여 SI사들이 기준에 맞추는 효과를 얻음
- 대표적 예: **한국전자정부프레임워크**
- Spring 기반으로 구성
- MVC 기반의 표준 구조와 공통 모듈 제공
- 다양한 공공 프로젝트에 적용됨

---

### 🧩 MVC 패턴이란?

#### ✔️ 핵심 개념
| 역할 | 설명 |
|------|------|
| Model | 데이터 처리 로직 (DTO, DAO, Manager 등), 비즈니스 로직 포함 |
| View | 사용자에게 보여지는 화면 (JSP 등) |
| Controller | 요청 분석, 처리 흐름 제어, View 선택 |

> 👉 디자인과 비즈니스 로직을 구분하여 **관심사의 분리(SoC)** 실현

---

#### ⚖️ 막개발 vs MVC 구조

| 구분 | 막개발 | MVC 패턴 |
|------|--------|----------|
| 장점 | 빠른 개발 가능 | 유지보수, 협업, 재사용 용이 |
| 단점 | 유지보수 어려움, 로직 중복 | 컨트롤러/매핑이 많아질 수 있음 |
| 구조 | JSP에서 DB까지 모두 처리 | Controller + Model + View 명확 분리 |

---

### 🧠 MVC 구조의 발전 방향

#### ❗ MVC의 단점
- 기능이 많아질수록 `Controller` 클래스 수가 급증
- 요청별로 일일이 매핑해야 하므로 구조가 비대해짐

#### 💡 해결 방법
- **Front Controller**: 모든 요청을 하나의 서블릿이 받고, 내부적으로 분기 처리
- **Command Pattern**: 기능별 클래스를 만들어 위임하고, 공통 인터페이스로 처리 (다형성 활용)

---

### ⚙️ Command Pattern

#### 📌 필요성
- Controller가 모든 요청을 if문으로 처리하면 유지보수 어려움
- → 기능별로 클래스를 분리하고, 공통된 `execute()` 메서드로 실행

#### ✅ 요청 처리 5단계 흐름

1. 요청을 받는다 (`DispatcherServlet`)
2. 요청을 분석한다 (`URI`, 파라미터 등)
3. 일을 시킨다 (Model 호출 → DAO 또는 Manager)
4. 결과를 저장한다 (`request.setAttribute()`)
5. 알맞는 View를 선택한다 (`getViewPage()` → JSP로 forward)

---

### 🧪 직접 만든 구조 요약

#### 🏁 DispatcherServlet
- 모든 요청의 진입점
- `web.xml`에 등록, `init()` 시 `Properties` 파일 로딩
- `doGet/doPost → doRequest()`로 일원화 처리
- `Class.forName()`으로 Command 객체 동적 생성

#### 🧱 Controller 인터페이스
- 모든 컨트롤러는 `execute(request, response)` 구현
- `getViewPage()`로 뷰 경로 반환

#### 🧾 Properties 매핑파일
```properties
/memberJoin.do=com.mvc.controller.MemberJoinController
/memberList.do=com.mvc.controller.MemberListController
```

### 🧰 Filter와 Encoding 처리
#### 🔠 CharacterEncodingFilter

```java
request.setCharacterEncoding("UTF-8");
chain.doFilter(request, response);
```
#### 🔍 chain.doFilter() 위치에 따른 의미
| 위치 | 처리 시점   | 설명              |
| -- | ------- | --------------- |
| 이전 | 요청 전 처리 | 한글 인코딩, 인증 검사 등 |
| 이후 | 응답 후 처리 | 로그 기록, 리소스 정리 등 |

#### ☀️ 비유: 편광 필터
- 필터를 통과하기 전 → 원본 광선

- 필터를 통과한 후 → 편광 처리된 결과

- chain.doFilter()는 이 경계선에 해당

### 🆚 Model1 vs Model2(MVC)
| 구분   | Model1        | Model2 (MVC)        |
| ---- | ------------- | ------------------- |
| 구조   | JSP가 모든 역할 수행 | Controller + JSP 분리 |
| 확장성  | 낮음            | 높음                  |
| 사용 예 | 단순한 게시판       | 대규모 웹 프로젝트          |

### 📘 결론
이 구조는 단순한 웹 프로젝트를 넘어서,
Spring MVC의 핵심 원리를 직접 구현해보는 과정이다.

"Spring을 만든다"는 관점에서,
단순 사용자가 아닌 설계자 시야로 패턴과 구조를 익힐 수 있다.