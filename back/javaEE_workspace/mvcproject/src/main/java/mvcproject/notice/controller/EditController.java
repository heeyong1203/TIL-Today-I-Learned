package mvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import mvcproject.notice.domain.Notice;
import mvcproject.notice.repository.NoticeDAO;
import mvcproject.web.servlet.Controller;

public class EditController implements Controller {
	NoticeDAO noticeDAO = new NoticeDAO();
	
	@Override
	public void execute(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String notice_id = request.getParameter("notice_id");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Notice notice = new Notice();
		notice.setNotice_id(Integer.parseInt(notice_id));
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		//3단계: 일 시키기
		noticeDAO.update(notice);
		
		//4단계: 저장 하기
		// request.setAttribute("notice", notice);
	}
	
	@Override
	public boolean isForward() {
		return true;
		// return false; // redirect를 해야 하지만, 매핑 파일에는 변수 설정이 불가하여 포워딩으로 처리함
	}
	
	@Override
	public String getViewName() {
		return "/notice/edit/view";
	}
}
