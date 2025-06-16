instance 초기화 블록과 static 초기화 블록
{

} 

static{

}

---------------------------------------------

public class Desk {
	int x;
	static int y;
	
	{ //A
		for(int i=0;i<10;i++){
			x++;
		}
	}
	
	
	static { //B
		for(int i=0;i<20;i++){
			y++;
		}
	}
	                              
	public static void main(String[] args){


System.out.println(x); //C
int a=new Desk().x; //D
		System.out.println(a); //E
		System.out.println(y); //F
		
	}
}

10.위의 코드에 대한 설명으로 올바른 것은?

(1) A 영역은 y의 값을 초기화 하기 위한 인스턴스 초기화 블럭이다. → x값인스턴스 초기화블럭

(2) B 영역은 클래스 변수를 초기화 하기 위한 static 초기화 블럭이다 →  O

(3) C 에서 문법상 문제가 없다. → new Desk()를 선언하지 않았음

(4) E 의 결과값은 10이다. → new Desk() 선언 후 인스턴스초기화블럭했으므로 O

(5) F에서 y값을 Desk 클래스의 레퍼런스 없이 접근하려 했으므로 에러가 발생할
     것이다. → X; 같은 클래스 내 동일한 static이기 때문에 new Desk()선언 필요없음

     11.아래의 코드에 대한 설명으로 올바른 것은?

-----------------------------------------------------------------------------

public class Radio {
	{
		System.out.println("A");
	}

	static{
		System.out.println("B");
	}
	public static void main(String[] args) {
		System.out.println("C");
		Radio ra1 = new Radio();
		Radio ra2 = new Radio();
	}
}
(1) 이 클래스의 초기화 블럭은 3개다. (2개)


(2) static으로 선언된 초기화 블럭이 실행되는 시점은 컴파일시이다. (X, 자바 실행 직전에)


(3) 인스턴스 초기화 블럭은 인스턴스가 생성될 때마다 매번 수행된다. (O)


(4) 이 클래스의 실행 순서는 C , B, A , A 이다. (X)


(5) 이 클래스의 실행 순서는 B, C, A, A 이다. (O)

----------------------------------------------------------------------------------

12.다음 중 틀린 것은?

public class Car {
	int price=100;
	
	public static void main(String[] args) {
		int x=5; //A
		Car car = new Car(); //B
		{
			int y=3; //C
		}
		System.out.println(y);//D
		System.out.println(car);//E
	}//F
}

(1) A에서 x는 main 메서드의 지역 변수이므로 stack에 쌓여있다가 F를 만나면 stack에서 소멸된다. (O)

(2) B에서 메모리에 올라간 car 변수와 Car 인스턴스는 F를 만나면 메모리에서 모두 소멸된다. (X; car변수만 죽음, 인스턴스는 GC를 만나야 소멸됨)

(3) C에서 y는 지역화 된 영역 안에서만 생명력을 가지므로 D 에서 접근할 수 없다. (O)

(4) E에서 car 를 출력하면 주소값이 출력되는데, 그 이유는 car 변수가 객체를 직접 보유하지 않고 힙영역에 생성된 인스턴스의 주소를 참조하기 때문이다. (O)

-------------------------------------------------------------------------------

public class Flower {
	int leaf=10; //A
	static int height=30; //B
	
	public void grow(){;//C
		int h=5
	}
	
	public static void main(String[] args){
	       height=20;//D
		
		Flower f1 = new Flower();
		Flower f2 = new Flower();
		
		f2.height=100; //E 
		System.out.println(height); //F
	}
} 



13. 위 코드에 대한 설명으로 틀린 것을 고르면?

(1) 개발자가 Flower 라는 사용자 정의 자료형을 정의한 것이다. (O)

(2) A,B와 같이 클래스 영역에 선언되는 변수를 멤버 변수라 하고, C를 멤버 메서드라 한다. (O)

(3) A의 leaf 멤버 변수는 Flower 클래스의 인스턴스가 메모리에 올라갈 때 해당 인스턴스에 포함 되므로 인스턴스 변수라 부른다. (O)

(4) D에서 height 변수를 접근하려 할 때 컴파일 에러가 발생할 것이다. (X, 같은 static이기 때문에 접근 가능함, 또한 같은 클래스이기 때문에 클래스명을 앞에 붙여줄 필요가 없음)

------------------------------------------------------------------------------

14.다음 중 틀린 것은?

public class Duck {
	int age=3; //A
	boolean fly; //B
	
	public static void main(String[] args){
		age=5;//C
		
		{
			int x=3;//D
			Duck d = new Duck(); //E
		}//F
		System.out.println(d.age);
	}
}
(1) A에서 age 변수가 메모리에 올라가는 시점은 클래스를 컴파일할 때이다. (X, 실행할 때 실행 직전)


(2) B에서 개발자가 멤버 변수 fly 를 초기화하지 않았으므로 아무런 값도 들어있지 않다. (default 초기화값은 false)


(3) C에 의해 오리가 갖는 A의 age 멤버 변수값은 5으로 변경된다. (X, new Duck()선언하지 않음, 인스턴스 없이는 접근할 수 없음)


(4) A,B 멤버 변수는 오리의 상태를 표현한 인스턴스 변수이므로 오리 인스턴스가 메모리에 올라가야 사용할 수 있다. (O)


(5) D의 변수 x는 닫는 브레이스 F 까지만 생명력을 갖는다. (O)


(6) E의 변수 d는 닫는 브레이스 F까지만 생명력을 갖는다. (O)


(7) E에서 메모리에 올라온 오리 인스턴스는 닫는 브레이스 F를 만나면 메모리에서 소멸된다 (X, 오리 인스턴스는 GC를 만나야 소멸됨)

----------------------------------------------------------------------------

15.아래 작성된 2개 클래스에 대해 실행 결과를 예상하세요.

class Phone{
	int price=200;
	String color="white";

	public void setPrice(){
		price = 500;
	}

	public void setColor(){
		color="red";
	}
}

public class UsePhone{
	public static void main(String[] args){
		int price=5;
		Phone  ph=new Phone();
		price=3;
		ph.setPrice();
		System.out.println(price);
	}
}

---------------------------------------------------------------------


class  TV{
	String color="black";
	String company="LG";
	int weight=45;

	public void setColor(String c){
		color=c;
	}

	public static void main(String[] args){
		weight=30;  (가)  
		new TV(); (나) 
		String color="blue"; (다)
		System.out.println(color);  (라) 
		int w=new TV().weight;  (마)
		System.out.println("무게는 "+w); (바)
	}
}


18. 위의 클래스에 대한 설명으로 옳은 것은?

(1) (가)에 의해 TV 클래스의 weight 멤버 변수 값은 30으로 변경될 것이다. (x)

(2) 실행부가 있는 클래스 이므로, 이 클래스는 java.exe로 실행시킬 수 있다. (o)

(3) (나)에서 자료형 및 변수 선언이 누락되었으므로, 컴파일 에러가 발생 할 것이다. (x)

(4) (다)에서 TV클래스의 color 멤버 변수값이 blue로 변경된다. (x)

(5) (라)에서는 "black"이 출력될 것이다. ("blue")

(6) (마)는 문법상 오류이므로 컴파일이 불가능하다. (x)

(7) (바)의 출력 결과는 “무게는 45” 이다. (o)

(8) 메인 실행부에서 메모리에 올려진 TV 인스턴스 갯수는 총 1개이다. (x, 2개)




