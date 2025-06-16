/* 
현실의 총알을 정의한다. 
java, c#, python.. 모든 클래스 내부에는 단 두 가지만 작성할 수 있음
(property(상태)와 method(동작))
*/
class Bullet{

    // 아래의 생성자 메서드는 new 연산자 뒤에서 호출됨
    // 예) new Bullet() 방식으로...
    constructor(bg, y){ // 총알이 보유할 속성(property) 선언
        this.div=document.createElement("div");
        this.x=0; // 총알의 left값
        this.y=y; // 총알의 top 값
        this.velX=10; // 총알의 속도
        this.bg = bg; // 매개변수로 넘어온 데이터를 클래스 변수에 보관해놓기

        // 총알이 어떤 모습으로 보여질지 개성을 결정(style)
        this.div.style.width=20+"px";
        this.div.style.height=20+"px";
        this.div.style.borderRadius=50+"%";
        this.div.style.background=this.bg;
        this.div.style.position="absolute";
        this.div.style.left=this.x+"px";
        this.div.style.top=this.y+"px";

        document.body.appendChild(this.div);

        console.log("저 방금 태어났어요");
    }

    // 총알의 상태를 변경시키기 위한, 즉 움직임을 표현한 메서드 정의
    move(){
        this.x += this.velX; // 등속도 운동
        this.div.style.left=this.x+"px";
    }
}