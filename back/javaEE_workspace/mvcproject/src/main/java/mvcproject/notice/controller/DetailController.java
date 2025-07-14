package mvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mvcproject.notice.domain.Notice;
import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

// 상세보기 요청을 처리하는 컨트롤러
public class DetailController implements Controller {
	NoticeDAO noticeDAO = new NoticeDAO();
	
	@Override
	public void execute(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//3단계: 일 시키기
		Notice notice = noticeDAO.select(Integer.parseInt(request.getParameter("notice_id")));
		
		//4단계: 저장 하기
		request.setAttribute("notice", notice);
	}
	
	@Override
	public boolean isForward() {
		return true;
	}
	
	@Override
	public String getViewName() {
		return "/notice/detail/view";
	}
	
}
