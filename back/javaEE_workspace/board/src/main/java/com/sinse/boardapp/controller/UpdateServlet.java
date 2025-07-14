package com.sinse.boardapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.boardapp.exception.NoticeException;
import com.sinse.boardapp.model.Notice;
import com.sinse.boardapp.repository.NoticeDAO;

// 클라이언트인 브라우저가 폼의 파라미터들을 Post로 요청하고 있으므로 doPost로 처리한다.
public class UpdateServlet extends HttpServlet {
	NoticeDAO noticeDAO = new NoticeDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 파라미터 받기 전 파라미터의 인코딩 처리
		response.setContentType("text/html; charset=utf-8"); //jsp의 page 지시영역
		PrintWriter out = response.getWriter();
		
		String notice_id = request.getParameter("notice_id");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Notice notice = new Notice();
		notice.setNotice_id(Integer.parseInt(notice_id));
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		out.print("<script>");
		try {
			noticeDAO.update(notice);
			out.print("alert('글 수정 완료');");
			out.print("location.href='/notice/content.jsp?notice_id="+notice_id+"';"); // 응답을 받은 브라우저로 하여금 지정한 url로 재접속하라
		} catch (NoticeException e) {
			e.printStackTrace();
			out.print("alert('"+e.getMessage()+"');");
			out.print("history.back();");
		}
		out.print("</script>");					

	}
}
