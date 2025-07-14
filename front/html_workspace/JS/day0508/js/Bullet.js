/* 총알을 정의한다 */
class Bullet{
    constructor(container, x, y, width, height, velX, velY){
        this.container=container;
        this.img=document.createElement("img");
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.velX=velX;
        this.velY=velY;

        //style
        this.img.src="../../images/슈팅_종스크롤/ball.png";
        this.img.style.left=this.x+"px";
        this.img.style.top=this.y+"px";
        this.img.style.position="absolute";
        this.img.style.width=this.width+"px";
        this.img.style.height=this.height+"px";
        // 총알 테두리에 블러효과 주기
        this.img.style.filter="blur(3px)";

        this.container.appendChild(this.img);

    }   
    // 총알이 날아가는 기능 정의
    move(){
        // 만일 총알이 적에게 맞지 않고 화면 밖으로 나가는 경우, 메모리 관리를 위해
        // 제거를 할 예정 (화면제거 + 배열제거)
        if(this.x>1920-this.width || this.x<0 || this.y<0 || this.y>576-this.height ){
            this.container.removeChild(this.img); // 화면에서의 제거
            
            // 전역변수로의 접근 가능
            // 현재 총알인 내가, 배열의 몇 번째에 위치해 있는지, 배열에게 물어봐서
            // 위치를 알아내자..
            let index = bulletArray.indexOf(this); // this는 현재 Bullet 객체를 의미
            bulletArray.splice(index, 1);
            console.log("현재 존재하는 총알 수는"+bulletArray.length);
        }
        this.x+=this.velX;
        this.y+=this.velY;

        this.img.style.left=this.x+"px";
        this.img.style.top=this.y+"px";
    }


}