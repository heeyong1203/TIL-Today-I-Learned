class DataType{
	
	public static void main String([] args){
	
	/* 정수 : byte short int long
					1		2		4		8
					1) 1byte에 담을 수 있는 숫자 : 2^(8)가지 이므로 256개의 수
					2) -128~127까지 (0이 포함되어 있으므로 128-1까지임)
					3) ex. int에서 다룰 수 있는 숫자는?
						-2^(31)~2^(31)-1까지
					
					고전적으로 연산에 최적화되어 있는 정수 자료형은 int임
					int보다 용량이 작은 자료형들의 연산 시 자료형을 int로 자동변환함 (Java의 컴파일러는 정수 자료형의 연산은 32비트(4byte)로 처리함 ; 이 때의 32bit는 64bit 기반의 컴퓨터 등과는 상관없음)
					long과의 연산 시에는 long값으로 변환하여 출력하여야 한다.
					
					
		 실수 : float double
					4		8
					아무 표기 없이 소수를 입력하면 컴퓨터는 기본적으로 double로 인식함
					ex) double x=3.14;
					따라서, float으로 표기하고 싶다면 실수 뒤에 f를 입력해주어야함
					ex) float y=3.14f
		 문자 : char
	*/
	// Java는 전세계 주요 국가의 문자를 수용 가능, 영미권 위주의 아스키 코드보다 확장된 유니코드 기반임; 한국어, 중국어...
	
	char c ='강'; // 2byte ; 2^(16) // short와 같은 2byte이지만 문자에서의 2byte는 0~65535까지의 숫자를 쓰므로, 다루는 숫자의 범위가 다름
						// 따라서 문자와 short 사이에 자동형변환은 일어날 수 없음;
	
	// Java에서 클래스는 대문자로 시작하고, 나머지 변수는 소문자로 시작함
	// 예외) 상수는 모두 대문자를 사용하며 언더바로 구분 (USER_LIMIT)
	// 예외) 패키지는 모두 소문자를 사용함 (org.spring.boot)
	
	// public class TestApp{
		// public static void main(String[] args){
			// boolean b=true;
			// int x=3;
			// short y=9;
			// char c='k';
			
			// int r1=b+x; error
			// short r2=y+c; 
			// int r3=x+c;
			// boolean r4=b+c; error
	// {
	// } 
	
	short s=7;
	byte b=9;
	long k=10;
	
	int x=s+b;
	?=k+s;
	}
}