package com.sinse.practiceapp.model;

import lombok.Data;

@Data
public class PracticeNotice {
	private int notice_id;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;	
}
