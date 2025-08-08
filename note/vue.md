Vue 애플리케이션을 개발하는 두 가지 방법
    1) CDN 방식
        - 개발 단계에서만 사용하는 것을 추천
        <!-- W3schools.com -->
        <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script> 
    2) Project 설정 방식
        - 실제 제품 개발 단계에서 사용하는 것을 추천
        - 일종의 프레임워크 기반이므로, Node.js가 설치되어 있어야 한다. (Tool만 당겨오면 된다.)

Vue는 Onload시점을 따로 잡는 것이 아닌 Script를 Body끝으로 내려 사용하는 것을 권장한다.