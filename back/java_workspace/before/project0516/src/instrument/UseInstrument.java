package use;

import instrument.MusicTool;
import instrument.BigDrum;
import riding.Roller;

// 납품을 앞두고 모든 악기에 대해 최종 테스트
public class UseInstrument{
	public static void main(String[] args){
		// 첼로 볼륨 테스트
		// Cello cello = new Cello();
		// Trumpet trumpet = new Trumpet();
		// trumpet.setVolume(52);
		
		// 오케스트라 협주... 모든 악기를 한꺼번에 볼륨을 조절
		// MusicTool g=new Guitar();
		// g.setVolume();
		
		MusicTool d = new BigDrum();
		d.setVolume();
		
		Roller r = new BigDrum();
		r.roll();
		
	}

}