# String
### charAt 
- 문자열(String)의 index번 째 단어를 출력 
```javascript
let a="대한민국"
console.log(a.charAt(n));
n=0 : "대" 출력
n=1 : "한" 출력
n=2 : "민" 출력
n=3 : "국" 출력
```

### indexOf
- 문자열 내 단어의 index를 출력
```javascript
let a="대한민국"
console.log(a.indexOf(string));
string="대" : 0 출력
string="한" : 1 출력
string="민" : 2 출력
string="국" : 3 출력
```

### split
- 문자열 내에서 특정 요소를 기준으로 분리

### trim
- 문자열 내 공백을 지워줌

```javascript
let a = "대한민국, 화이팅, Korea, 화이팅";
console.log(a.split(",")[0]); // → '대한민국'
console.log(a.split(",")[1]); // → ' 화이팅'
console.log(a.split(",")[1].trim()); // → '화이팅'
```

### typeof
- 자료형을 확인하는데 사용
```js
typeof 123;           // "number" 숫자형
typeof "hello";       // "string" 문자열
typeof true;          // "boolean" 논리값
typeof undefined;     // "undefined" 
typeof null;          // "object" ← JS의 오래된 버그
typeof [1,2,3];       // "object"
typeof {name:"A"};    // "object"

```