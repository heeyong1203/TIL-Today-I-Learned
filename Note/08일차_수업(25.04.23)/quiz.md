![image](https://github.com/user-attachments/assets/2107dc82-7151-4a7a-a339-bd31047221cb)## 학습 정리 퀴즈

### 1. 다음의 for 문에 대한 설명 중 맞는 것은?
```
for(let i=0; i<5; i++){
};
```

(1) for 문의 중괄호 즉 {브레이스}는 반복 수행할 코드 영역이다.\
(2) for 문의 소괄호에는 시작값, 조건식, 증감식을 표현하는데 특히 증감식에는 반드시 ++연산자만 사용할 수 있다.\
(3) for 문은 소괄호 안의 조건식이 true인 동안만 수정된다.\
(4) for 문의 시작값은 반드시 0부터 시작해야 한다.\
(5) for 문의 조건식에 사용된 변수 i는 프로그램이 종료될 때, 즉 브라우저를 종료할 때 소멸된다.\
(6) for 문의 조건식에 사용된 변수 i는 현재 반복문의 실행 횟수에 대한 정보만을 참고하기 위한 변수에 불과하므로 {브레이스} 영역에서 사용할 일이 없다.

#### (1) O  (2) X  (3) O  (4) X  (5) X {브레이스}를 지나가면 소멸됨  (6) X i를 이용할 수 있을 듯
---

### 2. 아래의 for 문이 2회 반복될 경우, 실행 순서를 나열하세요
for (ⓐ시작값 ; ⓑ조건 ; ⓒ증감식){
     ⓓ반복 내용
}
ⓔ{브레이스} 이후 요소

#### ⓐⓑⓓⓒⓑⓓⓒⓑⓔ
---

### 3. 반복문에 대한 설명 중 틀린 것은?
(1) while 문은 for 문과 목적이 같은 반복문이다.\
(2) for 문과 while 문의 공통점은 () 안의 조건이 true인 동안만 반복한다는 점이다.\
(3) 반복의 범위를 수치 값으로 알고 있을 때는 while 문 사용이 더 유리하다.\
(4) for 문으로 작성된 코드는 while 문으로 절대 대체할 수 없다.\
(5) 다음 작성된 반복문은 무한 루프이므로 "딸기"가 끝없이 출력된다.
```
  while(true){
    console.log("딸기")
  }
```
  #### (3), (4)
---

![image](https://github.com/user-attachments/assets/dd40bc9d-3887-4c80-8e86-5308ec550fbf)

#### 10번 / 10번 / 8번 / 5번 / 무한반복 / 14번 / 5번 / 10번 / 9번 / 10번
---

### 5. HTML 문서에 다음과 같은 출력 결과가 나오도록 for 문을 작성해 보시오.
☆☆☆☆☆☆☆☆☆☆

#### 5번 문제풀이
```
<script>
  for(let i=1, i<=10, i++){
    document.write("☆");
  }
</script>
```
---

### 6. 2~10 수 중 2의 배수만을 출력하려고 할 때, A에 들어갈 증감식은?
```
for(let i=2;i<-10; A){
    console.log(i);

}
```
#### 6번 정답 i *= 2
---

### 7. 다음 반복문의 출력결과를 예상하시오.
```
let i=1;
for( ; i<=5; ){
  console.lig(i);
  i++;
}
```
#### 7번 정답 12345
---

![image](https://github.com/user-attachments/assets/467327b7-022c-413a-936c-cc0e74fd3188)
#### 8번 문제풀이
```
<script>
    for(let i=1; i<=96; i++){
        if(i%10==0){
            document.write("★<br>");
        }else{
            document.write("★");
        }
    }
</script>
```
---

![image](https://github.com/user-attachments/assets/ae24daa2-b4bc-4a15-a3c3-975782258dcd)
#### 9번 문제풀이
```
<script>
     for(let i=1; i<=25 ; i++){
          if(i%5 != 0){
               document.write("☆");    
          }else{
               document.write("★<br>");
          }
     } 또는
    for(let i=1; i<=25; i++){
        let a = (i%5!=0)? "☆":"★<br>" ;
        document.write(a);
    }
</script>
```
---

![image](https://github.com/user-attachments/assets/af257e9d-63a9-4c57-a182-fbd10463b368)
#### 10번 문제풀이
```
<script>
     for(let i=1; i<=10; i++){
          document.write(i+"회반복<br>");
     } 또는
    
     for(let i=1;i<=10;i++){
        document.write(`${i}회반복<br>`);
    }
</script>
```
---

![image](https://github.com/user-attachments/assets/11bf6d47-97b8-4284-9d11-2ee548e749a3)
#### 11번 문제풀이
```
<script>
     for(let i=2; i<=10; i+=2){
          document.write(`${i}회반복<br>`);
     }
</script>
```
---

![image](https://github.com/user-attachments/assets/fddd7b52-c9e7-406d-969f-b527b503ede8)
#### 12번 문제풀이
```
<script>    
     for(let i=1; i<=10; i++){
          if(i%2!=0){
               document.write(`${i}<br>`); 
          }else{
               document.write("짝수<br>");
          }
     }
</script>
```
---

![image](https://github.com/user-attachments/assets/59ca318f-3e68-416a-aec3-00021ecf8985)
#### 13번 문제풀이
```
<script>
     for(let i=1; i<=10; i++){
          if(i%3!=0){
               document.write(`${i}회반복<br>`);
          }else{
               document.write("★<br>");
          }
     }
</script>
```
---

![image](https://github.com/user-attachments/assets/5ad3f36c-9949-476d-ae2e-71d5e5975949)
#### 14번 문제풀이
```
<script>
     for(let i=1; i<20; i++){
          let a = (i%5!=0)? "☆" : "★"; 
          document.write(a);
     }
</script>
```
---

![image](https://github.com/user-attachments/assets/bd0241f2-9852-4a4d-ae59-7b71ae52f5e4)
#### 15번 문제풀이
```
<script>    
     for(i=105;i<=108;i++){
          document.write(`${i}<br>`);
     }
</script>
```
---

![image](https://github.com/user-attachments/assets/7a6b06e9-5e6c-4ed4-ab58-43bc4e05ae0c)
#### 16번 문제풀이
```
<script>
        for(i=1; i<=9; i++){
            document.write(`3*${i}=${i*3}<br>`);
        }
</script>
```
<br>

![image](https://github.com/user-attachments/assets/7946e82e-919f-4548-baf0-106e0287168a)
#### 17번 문제풀이
```
<script>
     let n = prompt("숫자를 입력하세요");

     for(i=1; i<=9; i++){
          document.write(`${n}*${i}=${n*i}<br>`);
     }
</script>
```
---

![image](https://github.com/user-attachments/assets/fadb6cae-4723-491c-9c8b-1657f2a3c98b)
#### 18번 문제풀이
```
<script>
     for(let i=1; i<=9; i++){
          document.write(`${3*i}=3*${i}<br>`);
     }
</script>
```
---

![image](https://github.com/user-attachments/assets/d802ec6a-39fd-4935-b1a4-9dcc687b4e2e)
#### 19번 문제풀이
```
<script>    
     for(i=1; i<9; i++){
          document.write(`${i}*${i+1}=${i*(i+1)}<br>`);
     }
</script>
```
---

![image](https://github.com/user-attachments/assets/f087d2bb-4215-461d-9782-c61d3e51832a)
#### 20번 문제풀이
```
<script>
     for(i=9; i>=1; i--){
          document.write(`5 * ${i} = ${5*i}<br>`);
     }
</script>
```
---

![image](https://github.com/user-attachments/assets/18813b06-4ca9-4e7a-9fdc-0352b524b5bb)
#### 21번 문제풀이
```
<script>
     for(i=1; i<=10; i++){
          let a = (i>5)? "★" : "☆" ; 
          document.write(a);
     }
</script>
```
---

![image](https://github.com/user-attachments/assets/b825c129-fb1a-4124-94ec-b77cec291fbe)
#### 22번 문제풀이
1) 5개 반복문
2) ---

![image](https://github.com/user-attachments/assets/da7b489e-c58d-449f-8d81-9998a7d7c0a2)

#### 23번 문제풀이
```
<script>
    let n = parseInt(prompt("숫자"));
    for(i=n; i>0; i--){
        document.write(`${i} `);
    }     
</script>
```
---

![image](https://github.com/user-attachments/assets/c0d7b075-7ebe-4ecf-8723-09a67fda9bd2)
#### 24번 문제풀이
```
<script>
    let n = parseInt(prompt("숫자"));
    for(i=n-1;i<=n+1;i++){
          document.write(i);
    }
</script>
```
---

![image](https://github.com/user-attachments/assets/c45ef94b-5963-4438-99e4-5d9ce846627d)
#### 25번 문제풀이
```
<script>
     let str = prompt("문자를 입력하세요");
     let n = parseInt(prompt("몇 번 반복할까요?"));
     for(i=1; i<=n; i++){
        document.write(str);
    }
</script>
```
---

![image](https://github.com/user-attachments/assets/74980aa7-404c-4a61-a150-ba498653e381)
#### 26번 문제풀이
```
<script>
     let str = parseInt(prompt("숫자를 입력하세요"));
     let n = parseInt(prompt("몇 번 개행할까요?"));
     for(i=1; i<=n*n; i++){
          document.write("★");
          if(i%n==0){
               document.write("<br>");
          }
     }
</script>
```
---
     
![image](https://github.com/user-attachments/assets/ac691440-2733-4135-8dec-9d961de03a20)

#### 27번 문제풀이
```
<script>
     let n = prompt("숫자를 입력하세요");
     for(i=1; i<=n*n; i++){
          document.write("★");
          if(i%n==0){
               document.write("<br>");
          }
     }     
</script>
```
---




