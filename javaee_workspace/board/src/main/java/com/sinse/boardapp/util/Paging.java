package com.sinse.boardapp.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

// 복잡한 페이징 처리 로직을 담당하는 유틸 클래스
@Data
public class Paging {
	private int totalRecord; // 총 레코드 수
	private int pageSize = 10; // 페이지 당 보여질 레코드 수
	private int totalPage; // 총 페이지 수
	private int blockSize = 10; // 블럭 당 보여질 페이지 수
	private int currentPage = 1; // 현재 보고 있는 페이지
	private int firstPage; // 블럭 당 첫 페이지
	private int lastPage; // 블럭 당 끝 페이지
	private int curPos; // 페이지 당 List의 커서(index) 위치
	private int num; // 페이지 당 시작 번호
	
	// 변수를 조합하여 계산 로직 작성함
	public void init(List list, HttpServletRequest request) {
		totalRecord = list.size();
		totalPage = (int)Math.ceil((double)totalRecord/pageSize);
		if(request.getParameter("currentPage")!=null) currentPage = Integer.parseInt(request.getParameter("currentPage"));
		firstPage = currentPage - (currentPage-1)%blockSize;
		lastPage = firstPage + (blockSize-1);
		curPos = (currentPage-1)*pageSize;
		num = totalRecord-curPos;
	}

}
