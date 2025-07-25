package com.sinse.mall.exception;

public class ProductSizeException extends RuntimeException {
	public ProductSizeException(String msg) {
		super(msg);
	}
	public ProductSizeException(Throwable e) {
		super(e);
	}
	public ProductSizeException(String msg, Throwable e) {
		super(msg, e);
	}
}
