# HTML 기본 태그 정리
### ✅ 제목 태그 (Heading)
```html
<h1>제목1</h1> ~ <h6>제목6</h6>
```

<h1>제목1</h1>
<h2>제목2</h2>
<h3>제목3</h3>
<h4>제목4</h4>
<h5>제목5</h5>
<h6>제목6</h6>


- `<h1>`이 가장 크고 중요, `<h6>`은 가장 작음
- 문서 구조를 시각적으로 표현하고, 검색 엔진 최적화(SEO)에도 중요함
---


### ✅ 단락 태그 (Paragraph)
```html
<p>문단을 나타내는 태그입니다.</p>
```
<p>문단을 나타내는 태그입니다.</p>  

- 텍스트의 단락을 나눌 때 사용
- 브라우저가 자동으로 줄 바꿈과 여백을 적용
---

### ✅ Bold 태그 
```html
<b>Bold체를 입히는 태그입니다.</b>
```
<b>Bold체를 입히는 태그입니다.</b>  

- 텍스트의 단락을 나눌 때 사용
- 브라우저가 자동으로 줄 바꿈과 여백을 적용
---

### ✅ 줄 바꿈, 수평선
```html
<br>   <!-- 줄바꿈 -->
<hr>   <!-- 수평선 -->
```
첫 번째 줄 뒤에 `<br>` 입력하면 줄 바꿈 효과
<br>   <!-- 줄바꿈 -->
두 번째 줄 뒤에 `<hr>` 입력하면 수평선 효과
<hr>   <!-- 수평선 -->

---

### ✅ 링크 태그 (Anchor)
```html
<a href="https://www.naver.com">사이트로 이동</a>
```
<a href="https://www.naver.com">네이버 이동</a>
- href: 이동할 경로 (URL, 파일, 내부 id 등)
- 클릭 가능한 하이퍼링크 생성
---

### ✅ 이미지 태그 (Image)
```html
<img src="image.jpg" alt="대체 텍스트">
```
- `src`: 이미지 경로
- `alt`: 이미지가 없을 때 보여줄 설명(눈이 불편하신 분들을 위해 필수적으로 입력하는 것으로 알고 있음)
---

### ✅ 목록 태그 (List)
#### 순서 없는 목록 (ul: unordered list) + 항목 (li)
```html
<ul>
  <li>항목 1</li>
  <li>항목 2</li>
</ul>
```
<ul>
  <li>항목 1</li>
  <li>항목 2</li>
</ul>

항목들을 **단순 나열**함

#### 순서 있는 목록 (ol: orderd list) + 항목 (li)
```html
<ol>
  <li>첫 번째</li>
  <li>두 번째</li>
</ol>
```
<ol>
  <li>첫 번째</li>
  <li>두 번째</li>
</ol>

항목들에 **순번을 매겨 나열**함

---

### ✅ 표 태그 (Table)
```html
<table>
  <tr> <!-- 3층 -->
    <th>1호 라인</th> <!-- 컬럼명은 <td> 아닌 <th>로 생성할 경우 자동 볼드처리 되어 표현됨 -->
    <th>2호 라인</th>
  </tr>
  <tr> <!-- 2층 -->
    <td>201호</td>
    <td>202호</td>
  </tr>
  <tr> <!-- 1층 -->
    <td>101호</td>
    <td>102호</td>
  </tr>
</table>
</table>
```
<table>
  <tr> 
    <th>1호 라인</th>
    <th>2호 라인</th>
  </tr>
  <tr> 
    <td>201호</td>
    <td>202호</td>
  </tr>
  <tr> 
    <td>101호</td>
    <td>102호</td>
  </tr>
</table>

- `<tr>`은 층수 `<td>`는 호수라고 생각하면 됨
---

### ✅ 이태릭체 태그 (Form)
```html
<i> italy font체입니다. </i>
```
<i> italy font체입니다. </i>
- 단순 이태릭체

<br>

```html
<em> italy font체입니다. </em>
```

<em> italy font체입니다. </em>
- bold체 + 이태릭체
---

### ✅ 입력 폼 태그 (Form)
```html
<form action="../submit" method="post"> 
  <label for="name">이름:</label>
  <input type="text" id="name" name="name">
  <button type="submit">제출</button>
</form>
```

action: form을 전송할 서버 쪽의 script 파일을 지정
  1) 전송되는 서버 url 또는 html 링크

<br>

method: 전송 방식 선택
  1) get: 256~4096 byte까지만 전송 가능
  2) post: 입력 내용의 길이에 제한 X

<br>

<form action="/submit" method="post">
  <label for="name">이름:</label>
  <input type="text" id="name" name="name">
  <button type="submit">제출</button>
</form>

