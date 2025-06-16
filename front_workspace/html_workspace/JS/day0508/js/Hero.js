/* 주인공을 정의한다 */
class Hero{
    //ES6 클래스는 멤버변수를 생성자의 안에 둬야 함
    constructor(container, x, y, width, height, velX, velY){
        // 외부에서 전달된 데이터를 나의 객체에 보관하는 기법 : injection
        this.container=container;
        this.img=document.createElement("img");
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.velX=velX;
        this.velY=velY;
        // 주인공의 sprite 이미지명(프레임이 한 컷 한 컷 모인 것을 의미) 배열 선언
        this.imgArray=[];
        this.n=1; //이미지 배열의 index를 결정짓는 변수

        for(let i=1;i<=18;i++){
            this.imgArray.push(`../../images/hero/image${i}.png`)
        }

        //style
        this.img.src="../../images/hero/image1.png";
        this.img.style.position="absolute";
        this.img.style.left=this.x+"px";
        this.img.style.top=this.y+"px";

        this.img.style.width=this.width+"px";
        this.img.style.height=this.height+"px";

        this.container.appendChild(this.img); // 컨테이너에 부착

        // 움직이기 시작
        this.Doidle();
    }

    // 주인공 펄럭임 동작
    // 게임 루프와 상관없이 자체적으로 끝없는 루프로 움직임 표현
    Doidle(){
        this.n++;
        this.img.src=this.imgArray[this.n];

        if(this.n>=17)this.n=1;//이미지가 끝에 도달하면 다시 n을 1로 초기화
        setTimeout(()=>{
            // 화살표 함수는 this를 가질 수 없으므로, 여기서의 this는 상위 스코프를 나타냄
            this.Doidle();
        }, 50)
    }

    // 모든 방향에 대한 움직임 동작 정의
    move(){ 
        this.x += this.velX; // 물리적 변화량
        this.y += this.velY; // 물리적 변화량
        console.log(this.x, this.y);

        // 이동 제한 (stage 경계 0~1920, 0~576)
        if(this.x<=0) this.x=0;
        if(this.x>=1920-this.width) this.x=1920-this.width;
        if(this.y<=0) this.y=0;
        if(this.y>=576-this.height) this.y=576-this.width;
    
        // 변화된 물리량을 화면에 반영(rendering)
        this.img.style.left=this.x+"px";
        this.img.style.top=this.y+"px";
    }
}
