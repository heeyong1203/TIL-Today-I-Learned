package com.sinse.myframework.exception;

public class StaffException extends RuntimeException {
	
	public StaffException(String msg) {
		super(msg); // 생성자는 물려받지 못하므로, 부모의 생성자를 호출한다.
	}
	
	public StaffException(Throwable e) {
		super(e); 
	}
	
	public StaffException(String msg, Throwable e) {
		super(msg, e); 
	}
}
