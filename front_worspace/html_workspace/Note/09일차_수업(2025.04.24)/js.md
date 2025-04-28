## [기초]

### 변수와 자료형

### 연산자

### 제어문

#### 조건문
- 조건이 true일 때만 지정한 영역을 실행하게 하는 명령문
- 특정 영역의 수행 여부 결정 → 실행부에 대한 제어 역할; 제어문 중 하나

|조건문의 유형 |용도                    |
|------------|------------------------|
|if 문       |단일 조건일 때            |
|if ~else    |조건 판단 대상이 단 두 가지|
|else ~if    |조건 판단 대상 두 가지 이상|
|switch      |else ~if문 간단 작성 시  |

##### switch
- 조건이 여러 개일 때
- else ~if문 보다 보기에 훨씬 간소화
- 단 case에 들어갈 판단 대상은 변수가 아닌 상수여야 함
- 조건 대상에 상수 아닌 다양한 조건식이 필요하다면? → else if
- else의 역할은 break;와 default: 가 수행 

```
switch(n){
    case1:console.log("one"); break;
    case2:console.log("two"); break;
    case3:console.log("three"); break;
    case4:console.log("four"); break;
    case5:console.log("five"); break;
    default:console.log("exception");
}
```


#### 반복문

### 함수