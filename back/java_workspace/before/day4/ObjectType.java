
// java.exe의 대상이 되려면, 반드시 실행부인 main() 메서드가 존재해야 함
class ObjectType{
	public static void main(String[] args){
		// Java에서는 자료형이 총 네 개가 지원됨
		// 기본자료형(문자, 숫자, 논리값), 객체자료형 네 가지임
		int x=5;
		
		// 고정관념에서 벗어나자.
		// 자바에서는 개발자가 정의한 클래스를 새로운 자료형으로 인정해준다.
		// 따라서, 아래 코드에서 변수 d 앞에 선언해야 하는 자료형은 내가 class로 정의한 Dog형이다.
		Dog	d=new Dog();
		
		// 강아지를 짖게 하기
		d.bark();
		
		Tree t=new Tree();
		t.grow();
	}
}