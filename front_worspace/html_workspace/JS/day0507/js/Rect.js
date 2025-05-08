/* 현실의 사각형 막대를 정의한다. */
class Rect{
    constructor(container, x, y, width, height, bg, a, targetH){
        this.container=container;
        this.div=document.createElement("div");
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.bg=bg;
        this.a=a;
        this.targetH=targetH;

        //style 부여
        this.div.style.position="absolute";
        this.div.style.left=this.x+"px";
        this.div.style.top=this.y+"px";
        this.div.style.width=this.width+"px";
        this.div.style.height=this.height+"px";
        this.div.style.background=this.bg;
    
        this.container.appendChild(this.div); // 부모에 부착

        this.move(); // 태어나자마자, 나의 루프 호출
    }

    move(){
        console.log("move()...");
        // 여기서 막대의 크기를 감속도 공식을 적용하여 움직여보자
        // 높이 = 초기높이 + 계수 * (목표높이-초기높이)
        this.height = parseInt((this.height)) + this.a*(parseInt(this.targetH-this.height))+"px"
        
        setTimeout(()=>{
            this.move();
        }, 10);
    }

   
}