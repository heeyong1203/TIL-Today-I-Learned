package mvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mvcproject.notice.domain.Notice;
import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

public class RegistController implements Controller {
	NoticeDAO noticeDAO = new NoticeDAO();
	
	@Override
	public void execute(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//3단계: 일 시키기
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		noticeDAO.insert(notice);
		
		//4단계: 생략(insert)
	}
	
	@Override
	public boolean isForward() {
		return false;
	}
	
	@Override
	public String getViewName() {
		return "/notice/regist/view";
	}
}
