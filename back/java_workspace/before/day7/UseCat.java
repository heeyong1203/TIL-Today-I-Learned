/* 
	현실의 사물을 표현하기 위한 클래스가 아닌, 그냥 실행부를 두기 위한 클래스임
	따라서, 이 클래스는 재활용성이 없음
*/
class UseCat{
	public static void main(String[] args){
		new Cat();
		/*
		Cat 클래스에 생성자가 눈에 보이지 않더라도 new 연산자 뒤에 에러가 나지 않는 이유?
		컴파일러에 의한 디폴트 생성자의 존재 때문
		*/
	}
}