class StringTest2{
	public static void main(String[] args){
		/*
		String 불변의 특징이 있다.
		즉 변경될 수 없다... immutable(수정불가능한)
		*/
		/* 
		String x="korea";
		x="korea fighting"; // x값이 korea → korea fighting으로 바뀐 것이 아니라, 두 가지가 모두 생성된 것임
		
		System.out.println(x);
		*/
		
		String x="korea";
		for(int i=1;i<=100;i++){
			x=x+i; // "korea1", "korea2", ... , "korea100"까지 만들어 짐 → 메모리 잡아먹는 괴물
			System.out.println(x);
		}

	}
}