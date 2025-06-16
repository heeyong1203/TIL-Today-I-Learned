package test;

public class Bird{
	String name="나는 새";
	int age=3;
	
	/**
	새를 잠 재우고 싶으면 이 메서드 호출
	*/
	public void sleep(){
		System.out.println("잠을 자요");
	}
	
	/**
	새에게 먹이를 주세요
	*/
		public void eat(){
		System.out.println("밥을 먹어요");
	}
}