/*
변수와 자료형
*/


/* Test는 존재하므로 Test2로 만들자*/
class  Test2{
	// 자바의 실행부 ; 이 함수가 없다면 java.exe의 대상이 될 수 없으며, 실행될 수 없음
	public static void main(String[] args){
		/*
		java도 기존 언어의 전통을 이어받았기 때문에, 
		기본 자료형은 문자, 숫자, 논리값 3가지이다.
		*/	
		// java의 문자는 문자와 문자열로 구별이 됨
		// java의 문자 자료형 char
		char a='우'; // 한 글자를 문자형이라고 한다. <character형>
		String str="대한민국"; // 두 글자 이상의 문자집합을 문자열이라고 한다. <String형>
		
		// 자바의 논리값은 js 및 다른 언어들과 동일함 <true> or <false>
		boolean b=true; // 주의: 다른 언어에서는 1이 true, 0이 false의 의미를 대신할 수 있으나, java는 대신할 수 없음
									// 따라서, 자바는 철저하게 true 혹은 false로 표기하여야 한다.
									
		/* java의 숫자형은 크게 정수와 소수점을 지원하는 실수로 구분함 
		  * 정수는 용량에 따라 byte < short < int < long

		  * 실수는 float < double
		*/
		int x=75; // 정수에 대한 선언
		
		float y=5.6f; //자바에서는 개발자가 소수점만 적으면 무조건 double로 생각함, 따라서 float을 선언할 때에는 숫자 뒤에 f를 붙여야 함
		
		System.out.println(str);
	}
}
