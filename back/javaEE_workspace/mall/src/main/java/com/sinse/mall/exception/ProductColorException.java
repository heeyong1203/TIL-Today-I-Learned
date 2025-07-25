package com.sinse.mall.exception;

public class ProductColorException extends RuntimeException {
	public ProductColorException(String msg) {
		super(msg);
	}
	public ProductColorException(Throwable e) {
		super(e);
	}
	public ProductColorException(String msg, Throwable e) {
		super(msg, e);
	}
}
