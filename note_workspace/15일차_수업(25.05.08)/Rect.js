class Rect{
    constructor(container, x, y, width, height, bg){
        this.container=container;
        this.div=document.createElement("div");
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.bg=bg;
        this.targetH=200;
        this.a=0.05;
        
        //style 부여
        this.div.style.position="absolute";
        this.div.style.left=this.x+"px";
        this.div.style.top=this.y+"px";

        this.div.style.width=this.width+"px";
        this.div.style.height=this.height+"px";
        this.div.style.backgroundColor=this.bg;

        this.container.appendChild(this.div);

        this.move();
    }

    move(){
        this.height=parseFloat(this.height)+this.a*(this.targetH-parseFloat(this.height));

        this.div.style.height=this.height+"px";
        setTimeout(()=>{
            this.move();
        }, 10);
    }

}