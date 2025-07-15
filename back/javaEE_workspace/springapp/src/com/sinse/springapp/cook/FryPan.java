package com.sinse.springapp.cook;

public class FryPan implements Pan{
	
	@Override
	public void boil() {
		System.out.println("불로 음식을 데워요!");
	}
	
}
