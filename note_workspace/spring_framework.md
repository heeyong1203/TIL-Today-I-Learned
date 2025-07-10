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
| 구조   | JSP가 View+Controller 수행 | Model + Controller + JSP(View) 분리 |
| 확장성  | 낮음            | 높음                  |
| 사용 예 | 단순한 게시판       | 대규모 웹 프로젝트          |

### 📘 결론
이 구조는 단순한 웹 프로젝트를 넘어서,
Spring MVC의 핵심 원리를 직접 구현해보는 과정이다.

"Spring을 만든다"는 관점에서,
단순 사용자가 아닌 설계자 시야로 패턴과 구조를 익힐 수 있다.

## 55일차 수업(25.07.10)
- Web이 아닌 Swing으로 MVC 패턴을 이용해보자
- Model의 능력: web에서도 Swing에서도 모델은 그대로 사용 가능하다?!!

### 🖥️ 1. Swing 기반 MVC 패턴

- **🔄 Model 재사용성**
  - Web 애플리케이션용으로 작성된 **DAO · Service · DTO** 등의 비즈니스 로직을 그대로 Swing 애플리케이션에 재사용
  - Swing에서는 **View**(`JFrame`/`JPanel`)와 **Controller**(`ActionListener`)만 새로 구현하면 됩니다

```java
// 예시: View
public class BloodView extends JFrame {
    // 테이블, 버튼 등 컴포넌트 정의
    public BloodView() {
        setTitle("혈액 정보 관리");
        // 레이아웃 설정, 컴포넌트 배치
    }
}

// 예시: Controller
public class BloodController {
    private BloodModel model;
    private BloodView view;

    public BloodController(BloodModel model, BloodView view) {
        this.model = model;
        this.view = view;
        view.getBtnLoad().addActionListener(e -> loadData());
    }

    private void loadData() {
        List<Blood> list = model.fetchAll();
        view.updateTable(list);
    }
}
```

### 🌐 2. Web MVC 복습

### 🚦 Front Controller vs 세부 Controller 구조

#### 🧭 Front Controller (DispatcherServlet)

- 모든 클라이언트 요청을 최초로 수신하는 메인 컨트롤러

- 요청 URI에 따라 어떤 기능(세부 컨트롤러)을 수행할지 결정

- 매핑 파일 (.properties)에서 URI에 해당하는 클래스명(String) 을 조회

- 해당 클래스명을 기반으로:

```Java
Class.forName(className) // JVM 메소드 영역에 클래스 로드

Controller controller = (Controller)clazz.newInstance(); // 힙 메모리에 인스턴스 생성
``` 
- 생성된 세부 컨트롤러 인스턴스를 통해 **`execute(request, response)`** 메서드 실행

#### ⚙️ 세부 Controller (ex. ListController, RegistController)

- Front Controller가 실행한 실제 비즈니스 로직 담당 컨트롤러

- 공통 인터페이스(예: Controller)의 `execute()` 메서드를 구현

- 내부적으로 Model 호출, 결과 저장, View 경로 반환 처리

#### 📂 구조화된 흐름 요약
```
ServletContext context = config.getServletContext();

String realPath = context.getRealPath(config.getInitParameter("contextConfigLocation"));

요청 URI → DispatcherServlet → 매핑 파일 확인
            ↓
    Class.forName(className) (메소드 영역)
            ↓
    clazz.newInstance() (힙 영역)
            ↓
    controller.execute(request, response)
            ↓
    Model 호출 → 결과 처리 → View 포워딩
```

✅ 이 구조는 다양한 컨트롤러를 동적으로 처리할 수 있어 유지보수성과 확장성이 뛰어남

#### 🔄 Forward vs Redirect

|구분|Forward|Redirect|
|-|-|-|
|요청 횟수|1회 (서버 내부 이동)|2회 (`302 응답` + 클라이언트 재요청)|
|URL 변화|**유지**|**변경**|
|데이터 전달|같은 request 공유 <br> `request.setAttribute()` 사용|새 request 생성 <br> → `session.setAttribute()` 또는 URL 파라미터|

```java
// Forward 예시
dispatcher.forward(request, response);
// Redirect 예시
response.sendRedirect(request.getContextPath() + "/list.do");
```

#### 🗂️ request.setAttribute vs session.setAttribute

- `Forward` 시: 한 페이지 렌더링용 일회성 데이터 전달 → `request.setAttribute()` 권장

- `sendRedirect` 시: 새 요청이므로 request 사라짐 → 다음 요청에도 유지할 데이터는 `session.setAttribute()` 사용

### 🔧 3. Filter와 인코딩 처리

#### 📝 Filter 인터페이스 메서드

```java
init(FilterConfig filterConfig)

doFilter(ServletRequest, ServletResponse, FilterChain) (반드시 구현하고 chain.doFilter() 호출)

destroy()
```

#### 🔠 인코딩 설정 위치

```java
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
    // 1) 요청 파라미터 해석 전
    request.setCharacterEncoding("UTF-8");
    // 2) 응답 메시지 출력 전
    response.setCharacterEncoding("UTF-8");
    // 3) 다음 필터/서블릿 호출
    chain.doFilter(request, response);
    // 4) (Optional) 후처리 로직
}
```
- `체인 이전`에 인코딩 설정 필수 → 요청 파라미터 및 응답 메시지 모두 올바른 문자셋으로 처리

- `체인 이후`에 설정 시 이미 파라미터 해석·출력이 끝나 효과 없음

#### 🔗 Filter 체인과 실행 순서

- 여러 Filter 클래스가 등록된 순서대로 `doFilter()` 한 번씩 호출

- 순서 제어

    - `전통 Servlet`: web.xml `<filter-mapping>` 내 순서

    - `Spring Boot`: @Order 또는 `FilterRegistrationBean.setOrder()`

### ✨ 핵심 요약

- Swing 프로젝트에도 MVC 패턴 적용 → `Model 재사용`

- `Web MVC`: Forward/Redirect 차이와 request·session 속성 활용 방법

- `Filter`: 한 클래스의 doFilter() 한 번 구현, 인코딩 설정은 체인 이전에