package use;
import animal.Bird;
import animal.Duck;


class UseDuck{
	public static void main(String[] args){
		Bird b = new Duck();
		System.out.println(b.name); // b는 오리긴 하지만 b.name은 extends 된 멤버 변수인 Bird의 name 접근
		b.fly(); // 부모새가 날아요
		Duck d = new Duck();
		System.out.println(d.name); // Duck의 name에 접근
		d.fly(); // 오리가 날아요
		d.eat(); // 
		b=d;
		b.fly(); // 오리가 날아요
		// d=(Duck)b; // 하위 클래스를 상위 클래스로 대체하기 때문에 cast 연산자 사용
	//	d.fly();	// 부모새가 날아요
	}
}