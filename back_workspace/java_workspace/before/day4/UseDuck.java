class UseDuck {
	public static void main(String[] args){
		//age 변수값을 출력하시오.
		// Duck 클래스 자체는 오리를 생성할 수 있는 틀에 불과할 뿐, 오리가 아님
		// 따라서 사용하기 위해서는 인스턴스를 우선 생성한 후, 해당 인스턴스에 접근해야 함.
		Duck d = new Duck(); 
		
		// 단순 System.out.println(duck.age)만 쓴다면, error발생
		System.out.println(d.age);
	}
}