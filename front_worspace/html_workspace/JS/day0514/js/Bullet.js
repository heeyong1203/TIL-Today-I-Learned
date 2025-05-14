class Bullet extends GameObject{
    constructor(container, src, x, y, width, height, velX, velY){
        super(container, src, x, y, width, height, velX, velY);
    }

    // 제거 메서드
    removeObject(array, target){
        // 1) 화면에서 제거
        // this 나의 인스턴스를 가리키는 대명사, 총알 입장에서 "나"
        let obj=array[array.indexOf(target)];
        this.container.removeChild(obj.img);

        // 2) 총알이 있던 배열에서도 제거 (제거하지 않을 시 반복문이 계속 작동)
        array.splice(array.indexOf(target),1);
    }

    tick(){
        this.x+=this.velX;
    }
    render(){
        // 총알이 한 걸음씩 나아갈 때마다, 총알과 적군과의 충돌 체크해서 제거 처리...
        for(let i=0; i<enemyArray.length; i++){
            let enemy = enemyArray[i] // 적군 한 마리 꺼내기
            let result = collisionCheck(this.img, enemy.img); // this는 인스턴스. 인스턴스는 스타일 시트 적용이 되지 않음
            if (result){
                this.removeObject(enemyArray, enemy);
                this.removeObject(bulletArray, this);
                setScore(10);
            }

        }

        // 적군에 닿지 않은 총알은 자동제거 해야 함.. 1500 px 넘어설 때 제거 처리
        if(this.x>1400){
            this.removeObject(bulletArray, this);
        }

        this.img.style.left=this.x+"px";
    }

}