# 제어문
- 조건문과 반복문으로 이루어짐
---

## 조건문

```
<script>
    console.log("A");  // 2번 라인
    console.log("B");  // 3번 라인
    console.log("C");  // 4번 라인
</script>
```
```js
<script><>

```

ABC라고 출력이 될 것임 
Why? 위에서부터 컴퓨터가 읽기 때문

if 1) 3번 라인을 읽지 말라는 제어문을 준다면? 2번라인을 읽은 후 4번 라인으로 바로 넘어갈 것임 <br>
if 2) 4번에서 5번 머물라고 한다면? 2,3,4번 라인을 읽은 후 4번 라인을 4번 더 읽을 것임

프로그램 상에서 지적하세요 (콕 짚는 것) → {}

```
<script>
    console.log("A");
    if(false){
        console.log("B"); // if(false)를 통하여 B에 대해 제어문을 실행했으며, 해당 라인을 읽지 않게 함
    }
    console.log("C");
</script>
```

```
<script>
    console.log("A");
    if(true){
        console.log("B"); // if(true)를 통하여 B에 대해 제어문을 실행했으며, 해당 라인을 다시 읽게 함
    }
    console.log("C");
</script>
```

### 조건문이란?
- 조건이 true일 때만 지정 영역을 실행하도록 하는 명령문
- 특정 영역의 수행 여부를 결정지으므로, 실행에 대한 제어를 한다고 하여 제어문 중 하나임

### 조건문의 유형
|조건문의 유형|용도|
|-|-|
|if문|단일 조건일 때|
|if ~else|조건 판단 대상이 단 두 가지 유형일 때|
|else~ if|조건 판단 대상이 여러 대상일 때|



### if문
```
<script>
    let n = 3
    
    if(n%2==0){ //짝수라면..
        console.log("짝수입니다.");
    }
    if(n%2!=0){ //홀수라면..
        console.log("홀수입니다.");
    }
</script>
``` 

### if ~else문
- 조건 판단 대상이 단 2가지로 분류되는 경우는 if문을 여러 번 사용하지 말고, 영어회화처럼 if ~else문으로 처리함
- if ~else 대안으로 삼항연산자를 고려해볼 수 있음
- 
#### 위 if문 if ~else문으로 바꾸면?
  ```
  <script>
    let n = prompt("숫자를 입력하세요");

    if(n%2 == 0){ 
        console.log("짝수입니다.");
    }else{
        console.log("홀수입니다.");
    }
  </script>
  ```
#### vs 삼항연산자
```
(n%2 == 0)? console.log("짝수입니다.") : console.log("홀수입니다.");
```
- 조건문은 조건에 따른 로직(코드 블럭)을 다루지만 삼항연산자는 조건에 따른 '데이터'를 선택하므로, 조건문이 훨씬 더 많은 것을 처리할 수 있음

### else~ if문
```
<script>
   let n=prompt("점수를 입력하세요.")

    if(n>=90){
        document.write("A학점");
    }else if(n>=80){
        document.write("B학점");
    }else if(n>=70){
        document.write("C학점");  
    }else if(n>=60){              
        document.write("D학점");  
    }else if(n<60){               
        document.write("F학점");
    }
// n=75라고 입력했다고 하자. 단순 if문 5개가 반복되었다면
// 컴퓨터는 위에서부터 읽어내려오고, if(n>=75)와 if(n>=60) 두 가지 조건을 충족하게 된다.
// 하지만 코드에 닫는 장치가 없기 때문에, 두 가지 모두 표현하게 되어 원하는 학점인 "C학점"만을 보여줄 수 없다.
// 이를 방지하기 위해서 조건이 성립되면 이후 문장은 읽지 않게 하기 위한 if~else문을 쓰도록 하자. 
</script>
```
```
<script>
    let bd = prompt("본인의 혈액형을 입력하세요 대문자 A, B, O, AB");

    if(bd == "A"){ 
        document.write("세심하다.") // A
    }else if(bd == "B"){
        document.write("고집이 세다.") // B
    }else if(bd == "O"){   
        document.write("오지랖이 넓다.") // O
    }else if(bd == "AB"){
        document.write("결정을 잘 못한다.") // AB
    }else{ // 조건문에서 처리하지 않는 그 이외의 모든 경우를 통틀어...
        document.write("존재하지 않는 혈액형입니다.")
    }
</script>
```

### 유사한 구문 (switch~case문)
```
<script>
    /* switch~case문 : else~if와 목적이 동일 */

    let bd=prompt("혈액형을 입력하세요")

    /* (소괄호) 내부에 올 수 있는 데이터 : 숫자, 문자, 논리값 */
    switch(bd){ 
        case "A":document.write("세심한 분이죠"); break; 
        case "B":document.write("고집 쎈 분이죠"); break;
        case "O":document.write("사교성 좋은 분이죠"); break;
        case "AB":document.write("엉뚱한 분이죠");  break;
        //replace 방법 : 문구 드래그 후 ctrl+H
        //break : else~if문에서의 else의 역할, 조건 이외 경우 차단
        default:document.write("입력한 혈액형은 지원하지 않습니다.")
        //case에 지정된 조건 외의 모든 경우일 때...
        //else~if문의 마지막 단독 else와 동일

    case에 올 수 있는 코드는 오직 문자, 숫자, 논리값 같은 상수만 올 수 있음
    따라서, else if문을 대체할 수 없음
    가령, if문과 같이 조건을 줄 수 없음
    case a>10: (X)
    }

</script>
```

### else if문을 사용해서 html문서 만들어보기
- 어떤 문서를 만들어볼까?
  1) 움직이는 배경화면 만들기
  2) 배경화면 위에서 움직이는 비행기 만들기
  3) 방향키를 눌렀을 때 어떤 방향키를 눌렀는지 확인할 수 있게 하기
  4) 방향키를 누르면 비행기가 움직이게 만들기
 
#### 1. 움직이는 배경화면 내에서 움직이는 비행기 화면 만들기
1. 배경화면이 들어갈 공간 만들기 (1000*576)
  ```
  <body>
        <div id="stage"></div>
  </body> 
  body 작성 후 style 작성
  <style>
        #stage{
          width: 1000px;
          height: 576px;
          background-image: url(../../images/plane/bg.jpg); /* 배경화면으로 bg.jpg 넣기 */
          background-position: 0px 0px; /* 배경화면 left, top 위치 설정 */
          margin: auto; /* 배경화면 홈페이지 가로 중앙 정렬 */
          position: relative; /* 향후 비행기(자식 요소) 위치 설정을 위하여 부모 요소 position 설정 */ 
        }
  </style>
  ```
      
2. 비행기 이미지 부착하기 (width=45px)
   - css가 아니라 js로 작성해볼 것
   - <script>
       let img = document.createElement("img"); /* <div> 안에 들어갈 <img>요소 생성 : createElement */
       img.src="../../images/plane/plane.png"; /* 어떤 이미지를 불러올 것인지 이미지가 들어있는 저장소 내 이미지 지정 */
       let stlye = img.style; /* 이미지의 스타일을 지정하고자 하는데, 중복 표현(img.style) 피하고자 지정 */
       style.width = 45+"px";
       style.position="absolute"; /* 부모 요소(background image)를 기준으로 위치 조절, 이를 위해 부모 요소 포지션을 지정했음 */
       style.left = 300+"px"; /* 비행기의 초기 left 위치 */
       style.top = 200+"px"; /* 비행기의 초기 top 위치 */
       let stage = document.getElementByID("stage"); 
       stage.appendChild(img); /* 대입된 이미지(plane)을 자식 요소로 부착 → bg.jpg의 자식요소로 plane을 지정한 것 */
     </script> 
   - 실행이 안 됨 why?
     1. script에서 let stage=document.getElementByID("stage"); 입력하였는데,
        현재 <script>는 <body>보다 윗라인에 있어, stage는 지정되지 않은 ID이기 때문에 불러올 수가 없는 것
     2. 이를 해결하기 위해 이벤트 핸들러를 이용 (load 이벤트)
        <body> 안에 <body onLoad="init()"> 입력 /* <body></body> 내의 모든 컨텐츠가 실행된 후 함수 init()을 실행하라 */
     3. 함수 init()을 생성하여 script 명령문을 함수에서만 실행되게 설정
        기존 script 명령문을 함수 init()로 감싼다.
        <script>
          function init(){
             let img = document.createElement("img");
             img.src="../../images/plane/plane.png";
             let stlye = img.style;
             style.width = 45+"px";
             style.position="absolute";
             style.left = 300+"px";
             style.top = 200+"px";
             let stage = document.getElementByID("stage"); 
             stage.appendChild(img);
          }
        </script>
        
3. 배경화면 움직이게 만들기
  <script>
    
  </script>
4. 

```
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    #stage{
        width: 1000px;
        height: 576px;
        background-image: url(../../images/plane/bg.jpg);
        background-position: 0px 0px; /* x축방향, y축방향 */
        margin: auto;
        position: relative;
    }
</style>
<script>
    let stage;
    // js로 css의 배경을 제어해보자
    let bgX = 0; //배경의 left값을 변경할 전역변수
    let img; // init()에 두면 지역변수이기 때문에, 
            // 다른 함수 블럭에서 접근할 수 없으므로
            // 모든 함수영역에서도 접근할 수 있도록
            // 전역 변수로 빼둠

    function bgEffect(){
        //현재 stage div에 적용된 배경 이미지의 포지션의 left 값을 감소시켜보자
        //stage를 Load와 동시에 전역변수에 받아놓았으므로, 또 얻어오는 코드를
        // 중복 작성할 필요가 없다. 즉 전역변수를 활용하면 된다.
        bgX-=5;
        stage.style.backgroundPosition=bgX+"px 0px";
    }

    //  사용자가 키보드를 누를 때마다, 개발자는 해당 키에 대한 아스키 코드를 얻어와서
    //  어떤 키를 눌렀는지 분석하여
    //  좌우측 방향키는 left값을 각각 감소, 증가
    //  상하측 방향키는 top값을 각각 감소, 증가
    //  따라서 키에 대한 조건 판단의 경우의 수가 총 4가지이므로 else~if문 사용 
    let X = 300;
    let Y = 200;
    function move(){
        // event 객체는 이미 자바스크립트 내부적으로 자동 생성되는 객체임
        // 사용자가 일으킨 모든 이벤트 정보가 들어있음
        let key = event.keyCode;
        if(key == 37){
            console.log("당신이 누른 키는 좌측키입니다.");
            X -= 5;
            img.style.left = X+"px"
        }else if(key == 39){
            console.log("당신이 누른 키는 우측키입니다.");
                    // 전역변수 img의 left 값을 증가시켜보자
            X += 5;
            img.style.left = X+"px";
        }else if(key == 38){
            console.log("당신이 누른 키는 상측키입니다.");
            Y -= 5;
            img.style.top=Y+"px";
        }else if(key == 40){
            console.log("당신이 누른 키는 하측키입니다.");
            Y += 5;
            img.style.top=Y+"px";
        }

        
    }

    function init(){
        /*  지금까지는 이미지를 body 태그에 직접 작성하여 존재시켰으나,
            이제는 자바스크립트에서 동적으로 이미지를 생성하여 화면에 부착해보자.
            * 동적(runtime) = 프로그램 가동되는 동안
        */
        img = document.createElement("img"); // <img> 태그 작성과 동일
        img.src="../../images/plane/plane.png";
        let style = img.style;
        style.width=45+"px"; //프로그래밍으로 css제어
        style.position="absolute"; //부모를 기준으로 한 위치
        // 부모의 포지션을 relative 혹은 absolute로 지정하기 위해 style태그 작성
        style.left=300+"px"
        style.top=200+"px";        
        // 생성된 이미지를 어느 부모 밑에 부착할 지 결정해야 함
        stage = document.getElementById("stage");
        // 기존에 없었던 요소 생성 시 : createElement()
        // 기존에 있었던 요소 불러오기 : getElementByID(), querySelector()
        stage.appendChild(img); // 대입된 이미지를 자식으로 부착!

        // 사람 대신, 컴퓨터(js)가 우리가 정의한 함수를 호출하는 기능 이용
        // 자동 배경 화면 효과 구현
        setInterval(bgEffect, 10);

    }
</script>
<body onLoad="init()" onKeyDown="move()">
    <div id="stage">
        
    </div>
</body>
</html>
```

#### 라이센스 없는 이미지 가져오기
- iconfinder.com 접속
- 검색어 입력
- free / no link back 설정
- 이미지 눌렀을 때 Free for commercial use라는 문구가 있어야 함

#### 과제
사용자로부터 과일을 선택하도록 입력받고
입력받은 과일명에 해당하는 사진이 출력되게 하기

else~if문 이용 프로그램 
switch문 이용 프로그램

---

## 반복문
