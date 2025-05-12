# 프론트엔드 개발
### SPA(Single Page Application)
#### 정의
- 하나의 웹 페이지에서 대부분의 웹 어플리케이션 기능을 실행하는 방식
- 페이지 전체를 새로 고치지 않고, 필요한 부분만 동적으로 갱신
- JavaScript를 사용해 클라이언트 사이드에서 렌더링

#### 장점
- 빠른 페이지 전환 (새로고침 없음)
- 서버 요청 최소화 → 사용자 경험 향상

#### 단점
- 초기 로딩이 무거울 수 있음
- SEO(검색 엔진 최적화)가 어렵거나 별도 처리 필요
---

### ASY(Asynchronous) - 비동기 처리
#### 정의
- 비동기 : 작업을 요청하고 기다리지 않고, 다른 작업을 병행할 수 있음
- 주로 : AJAX, Fetch API, Promise, async/await 등을 사용

#### 장점
- 서버 응답을 기다리는 동안 UI가 멈추지 않음
- 사용자 경험(UX)을 향상시킴

#### 단점
- 복잡한 흐름 제어 필요 (ex: 에러 처리, 콜백 지옥 등)
---

### React

### Open API(Application Programming Interface)
- 누구나 사용할 수 있도록 시스템을 열어주되, 사용법을 공개해 놓은 것
- 개발자를 위해 개방되어 있는 지식
- google developer console > API 및 서비스 > API 라이브러리
- 프로젝트 등록 > 앱 담기

개발자 : 각 서비스마다 인증 key를 받아야 함
your_key
callback


### 고전적 객체 literal 방식
- 객체 지향 기술을 사용하기 이전에는 현실의 사물, 즉 객체를 담을 때에 주로 1차원 배열을 이용했음
- ex)
```javascript
["scott", 30, "서울"] → 직관성이 매우 떨어지며, 객체를 표현했다고 보기에 부족함    
```
- 하지만 OOP언어는 객체를 표현한 언어이기 때문에 일차원 배열 대신, 객체 리터럴도 표현 가능
- 따라서 index를 통해 접근하는 방법보다 현실 반영에 있어 훨씬 효율적 \
  (직관성이 있는 단어를 이용하기 때문)

```javascript
let memberList=[];
let member={
    name:"Adams",
    age: 30,
    gender: "man"
}

memberList.push(member);
let member2={
    name:"Scott",
    age: 31,
    gender: "man"
}
memberList.push(member2);
```
    
|name|age|gender|
|-|-|-|
|Adams|30|man|
|Scott|31|man|
    