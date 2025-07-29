package com.sinse.mall.exception;

public class PasswordEncryptException extends RuntimeException {
	public PasswordEncryptException(String msg) {
		super(msg);
	}
	public PasswordEncryptException(Throwable e) {
		super(e);
	}
	public PasswordEncryptException(String msg, Throwable e) {
		super(msg, e);
	}
}
