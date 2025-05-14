package use;
import human.Asian;

class UseHuman{
	public static void main(String[] args){
		Asian a = new Asian();
		a.intellecThink(); // Asian.java에는 intellecThink() 메서드가 없지만, Asian의 부모인 Human.java에 intellecThink() 메서드가 있어, 해당 메서드를 Asian이 상속 받아 호출할 수 있게 됨
	}
}