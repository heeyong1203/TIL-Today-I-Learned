package com.sinse.practiceapp.model;

import lombok.Data;

@Data
public class PracticeNotice {
	private int practiceNotice_id;
	private String title;
	private String writer;
	private String content;
	private String date;
	private int hit;	
}
