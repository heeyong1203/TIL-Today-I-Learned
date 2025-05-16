package instrument;

// 부장님이 정의해놓은 악기들의 최상위 클래스인 MusicTool을 상속받자
// 추상 클래스를 상속받는 자식은, 반드시 부모의 불완전한 메서드인 추상메서드를 완전하게 구현할 의무를 가진다(구현 강제)
public class Guitar extends MusicTool{
	// 부모의 메서드를 자식이 재정의 하는 메서드 정의기법, 즉 오버라이딩의 의무가 생김
	public void setVolume(){
		System.out.println("기타 소리를 조절합니다.");
	}
	
	public void setVolume	(String a){
		int volume=3;
		if (a=="+"){
			volume += 1;
			System.out.println("기타 소리= "+volume);

		}else if(a=="down"){
			volume -= 1;
			System.out.println("기타 소리= "+volume);
		}
	}
	
	public void MP3(){
		System.out.println("mp3를 재생해요");		
	}
	

		

}