/* 현실의 공을 정의한다 */
class Ball{

    // 이 공이 태어날 때 부여하고 싶은 특성들을 여기서 결정(생성자)
    constructor(container, x, y, width, height, velX, velY, accX, accY, bg){
        this.container=container; // 이 공을 어디에 붙일지 결정... (wrapper, body, aside...)
        this.div=document.createElement("div");
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.velX=velX; //x축으로의 속도
        this.velY=velY; //y축으로의 속도
        this.bg=bg; // 공의 색상

        this.accX=accX;
        this.accY=accY;

        //style
        this.div.style.position="absolute";
        // this.div.style.left=this.x+"px";
        // this.div.style.top=this.y+"px";
        this.div.style.borderRadius=50+"%";

        this.div.style.width=this.width+"px";
        this.div.style.height=this.height+"px";
        this.div.style.background=this.bg;

        // 넘겨받을 대상 컨테이너는 아직 정해지지 않음 → 개발자 호출 시 결정됨
        this.container.appendChild(this.div);

    }
    // 현재 이 공의 움직임을 정의함 (method)
    move(){
        this.velX = this.velX + this.accX * (-this.velX)
        this.velY = this.velY + this.accY * (-this.velY)
        this.x += this.velX;
        this.y += this.velY;
        // 각 네 면을 만날 때 마다, 적절하게 velX, velY를 양수로 부여할지, 
        // 음수로 부여할지 결정하면, 방향을 바꾼다
        if(this.x<=0 || this.x>=(600-this.width)){ // 공의 x축값이 좌측 또는 우측 경게면일 때
            this.velX=-this.velX
        }
        if(this.y<=0 || this.y>=(600-this.height)){ // 공의 y축값이 위 또는 아래쪽 경게면일 때
            this.velY=-this.velY
        }

        this.div.style.left=this.x+"px";
        this.div.style.top=this.y+"px";
    }
    
}