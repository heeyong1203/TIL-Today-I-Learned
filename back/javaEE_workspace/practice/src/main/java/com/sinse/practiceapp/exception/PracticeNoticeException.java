package com.sinse.practiceapp.exception;

public class PracticeNoticeException extends RuntimeException {
	public PracticeNoticeException(String msg) {
		super(msg);
	}
	public PracticeNoticeException(Throwable e) {
		super(e);
	}
	public PracticeNoticeException(String msg, Throwable e) {
		super(msg, e);
	}
}
