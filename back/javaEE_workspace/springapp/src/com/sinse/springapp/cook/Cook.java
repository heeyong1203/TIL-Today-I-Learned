package com.sinse.springapp.cook;

public class Cook {
	private Pan pan; // 너무 정확한 자료형으로 has a 관계 사용 시, 객체간 결합도가 너무 높다.
								// 결합도를 낮추기 위해 부품이 될 객체는 느슨하게 보유해야 한다.
	
	public Cook(Pan pan) {
		this.pan = pan;				
	}
	
	// 음식을 만드는 행위
	public void cooking() {
		pan.boil();
	}
}
