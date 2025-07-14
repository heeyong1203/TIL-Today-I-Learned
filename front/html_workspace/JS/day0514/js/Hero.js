class Hero extends GameObject{
    
    //js에서는 생성자를 작성하기만 하면, 무조건 생성자 내에서 super()명시해야 함
    // 부모에 매개변수가 있다면, 그에 맞게 호출
    constructor(container, src, x, y, width, height, velX, velY){
        super(container, src, x, y, width, height, velX, velY);
    }

    // **메서드 오버라이딩**
    // 부모가 완성하지 못했던 method를 자식이 자신의 상황에 맞게 커스텀하는 메서드 정의 기법
    // 부모의 메서드를 무시하고 업그레이드 하는 행위(overridng)

    tick(){
        this.x+=this.velX;
        this.y+=this.velY;
    }
    render(){
        this.img.style.left=this.x+"px";
        this.img.style.top =this.y+"px";
    }
}