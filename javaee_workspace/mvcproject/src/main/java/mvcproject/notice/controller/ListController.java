package mvcproject.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

// Spring ver 2.5
public class ListController implements Controller {
	NoticeDAO noticeDAO = new NoticeDAO();
	
	@Override
	public void execute(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//3단계: 일시키기
		List noticeList = noticeDAO.selectAll();
		
		//4단계: 저장하기
		request.setAttribute("noticeList", noticeList);
	}
	
	@Override
	public boolean isForward() {
		return true;
	}
	
	@Override
	public String getViewName() {
		return "/notice/list/view";
	}
}
