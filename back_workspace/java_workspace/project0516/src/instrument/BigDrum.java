package instrument;

import riding.Roller;

// 클래스 상속은 extends
// 인터페이스 다중 상속은 implements
public class BigDrum extends MusicTool implements Roller{
								/*  is a */				/* can do(is a의 의미도 가짐)	*/
	public void setVolume(){
		System.out.println("드럼의 소리를 높여요");		
	}
	
	public void roll(){
		System.out.println("드럼을 굴려요");
	}
}