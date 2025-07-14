class StringTest{
	
	public static void main(String[] args){
		// 모든 프로그래밍 언어에서 개발자가 사용할 수 있는 기본 자료형은
		// 문자, 숫자, 논리값이지만, 이 중 문자는 문자 1개를 말하는 것이므로,
		// 우리 일상에서 사용하는 문자열을 표현하려면, 개발자가 각 단어의 배열을 사용해야 한다.
		// 하지만, 개발의 불편성을 고려하여 현대적 프로그래밍 언어에서는 
		// 개발자들을 위해서 내부적으로는 배열로 처리되게끔 하여 문자열을 객체자료형으로 지원해준다.
		
		// new를 명시하지 않아도, 내부적으로 문자열 객체로 생성시키는 방법을 암시적, 묵시적(implicit) 생성법이라고 한다.
		String s1="korea";
		String s2="korea";
		System.out.println(s1==s2);
		
		// new 연산자를 이용하여 객체의 생성법을 그대로 따르는 문자열 생성법을 
		// 명시적(explicit) 생성법이라고 한다.
		String x1=new String("apple");
		String x2=new String("apple");
		System.out.println(x1==x2);
	}
}