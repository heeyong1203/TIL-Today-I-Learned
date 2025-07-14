package com.sinse.practiceapp.exception;

public class CommentException extends RuntimeException {
	public CommentException(String msg) {
		super(msg);
	}
	public CommentException(Throwable e) {
		super(e);
	}
	public CommentException(String msg, Throwable e) {
		super(msg, e);
	}
}
