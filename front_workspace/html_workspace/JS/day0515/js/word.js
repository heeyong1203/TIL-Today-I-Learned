/* 단어를 정의한다 */
class Word{
    constructor(container, x, y, text, color){
        this.container=container;
        this.span =document.createElement("span");
        // 왜 스팬? span은 인라인이므로, 너비가 컨텐츠만큼만 확보(wrapping)...
        this.x=x;
        this.y=y;
        this.text=text; // 이 스팬이 포함할 단어
        this.color=color; // 글씨 색상

        // style & 조립
        this.span.style.display="inline-block";
        this.span.style.position="absolute";
        this.span.style.left=this.x+"px";
        this.span.style.top=this.y+"px";
        this.span.innerText=this.text
        this.span.style.color=this.color;
        this.span.style.fontWeight="bold";
        this.span.style.fontSize="20px";

        this.container.appendChild(this.span);

    }

    tick(){
        this.y += 5;
    }

    // 한발 씩 내려오기
    render(){
        this.span.style.top=this.y+"px";
    }
}