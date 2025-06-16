/*
게임에 등장할 모든 객체의 최상위 객체를 정의한다.
공통적인 속성과 기능들을 중복 작성하지 않기 위해서... 즉 재사용을 위해서 사용
*/
class GameObject{
    constructor(container, src, x, y, width, height, velX, velY){
        this.container=container;
        this.img=document.createElement("img");
        this.src=src;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.velX=velX;
        this.velY=velY;

        this.img.src=this.src;
        this.img.style.position="absolute";
        this.img.style.left=x+"px";
        this.img.style.top=y+"px";
        this.img.style.width=this.width+"px";
        this.img.style.height=this.height+"px";

        this.container.appendChild(this.img);
    }

    // 중복되는 메서드를 부모클래스에 정의하는 것은 올바른 개발 방식
    // 하지만 게임에 등장할 모든 객체들의 움직임을 부모가 예측할 수 없다. 


    // move()를 tick()과 render()로 분리
    // 물리량 변화
    tick(){}; // java에서는 {몸체}가 없는 메서드를 추상 메서드라고 함..
              // js에서는 es6에서 지원하지 않는 기능이기에 {브레이스}는 남겨둠
    
    // 변화된 물리량을 화면 출력 → 렌더링
    render(){};
}