## FileReader
### 주요 메서드

#### 1. readAsText(file)
#### 2. readAsDataURL(file)
#### 3. readAsArrayBuffer(file)
|종류 |메서드                               | 설명                                              |
|-|-------------------------------- | ----------------------------------------------- |
|문서파일|`readAsText(file)`                | 파일을 텍스트 형식(UTF-8 등)으로 읽음                      |
|바이너리 파일|`readAsDataURL(file)`             | 파일을 Base64 인코딩된 Data URL로 읽음 (이미지 미리보기 등에 사용) |
|바이너리 파일|`readAsArrayBuffer(file)`         | 파일을 바이너리 형식(버퍼)으로 읽음      
```js
<input type="file" id="fileInput" />
<script>
  let input = document.getElementById('fileInput');
  input.addEventListener('change', () => {
    let file = input.files[0];
    let reader = new FileReader();
    
    reader.onload = () => {
      console.log(reader.result); // 파일 내용 출력
    };

    reader.readAsText(file); // 텍스트 파일일 경우
  });
</script>
```