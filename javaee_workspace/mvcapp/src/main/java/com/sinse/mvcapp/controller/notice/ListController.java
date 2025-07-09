package com.sinse.mvcapp.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 공지 게시판의 목록 요청을 처리하는 컨트롤러
import com.sinse.mvcapp.controller.Controller;
import com.sinse.mvcapp.model.Notice;
import com.sinse.mvcapp.repository.NoticeDAO;

public class ListController implements Controller {
	
	private NoticeDAO noticeDAO = new NoticeDAO();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 3단계: 알맞는 로직 객체에 일 시키기
		List<Notice> list = noticeDAO.selectAll();
		
		// 4단계: 데이터 저장
		HttpSession session = request.getSession();
		session.setAttribute("noticeList", list);
		System.out.println("컨트롤러가 실행되었고, 리스트 크기: " + list.size());
	}

	@Override
	public String getViewPage() {
		return "/notice/list/view";
	}

}
