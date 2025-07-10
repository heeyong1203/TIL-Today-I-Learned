package mvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

public class DeleteController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();
	
	@Override
	public void execute(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//3단계: 일 시키기
		String notice_id = request.getParameter("notice_id");
		
		noticeDAO.delete(Integer.parseInt(notice_id));
		
		//4단계: 생략
	}

	@Override
	public boolean isForward() {
		return false;
	}

	@Override
	public String getViewName() {
		return "/notice/delete/view";
	}

}
