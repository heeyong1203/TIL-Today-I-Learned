class Hero extends GameObject{
    constructor(container, x, y, width, height, velX, velY, bg, border, borderColor){
        super(container, x, y, width, height, velX, velY, bg, border, borderColor);
    
        // 4개의 센서를 보유하자
        // this.upSensor;
        this.rightSensor=new RightSensor(this.div, this, this.width-3, 3, 3, this.height-6, "blue", 0, "");
        // this.leftSensor;
        // this.downSensor;
    }

    // 부모의 메서드 오버라이딩
    tick(){
        this.x+=this.velX
        this.y+=this.velY
    }

    render(){
        // 현재 화면에 등장한 벽돌과 나와의 교차여부 체크(collision check)
        for(let j=0; j<brickArray.length; j++){
            for(let i=0; i<brickArray[j].length;i++){
                let brick=brickArray[j][i];

                if(brick !=0){ // 0은 객체가 아닌 단순 숫자로, div를 따로 소유하고 있지 않음
                    let result = collisionCheck(this.div, brick.div)
                    // console.log(result);
                    if(result){
                        // 주인공 색상을 분홍색으로...
                        this.div.style.background="blue";
                    }
                }
            }
        }

        
        this.div.style.left=this.x+"px";
        this.div.style.top=this.y+"px";
    }
}