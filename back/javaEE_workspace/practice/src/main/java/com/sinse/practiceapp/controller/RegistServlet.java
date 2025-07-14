package com.sinse.practiceapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.practiceapp.exception.PracticeNoticeException;
import com.sinse.practiceapp.model.PracticeNotice;
import com.sinse.practiceapp.repository.PracticeNoticeDAO;

// 클라이언트가 전송한 글쓰기 폼의 파라미터들을 받아 db에 insert 시키는 서블릿
public class RegistServlet extends HttpServlet {
	
	// 클라이언트인 브라우저가 전송한 변수 = 파라미터값을 받아 db에 넣기
	PracticeNoticeDAO noticeDAO = new PracticeNoticeDAO();
	
	// 요청 객체에 들어있는 파라미터 꺼내기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		PracticeNotice notice = new PracticeNotice();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		out.print("<script>");
		try {
			noticeDAO.insert(notice);
			out.print("alert('등록 성공');");
			out.print("location.href='/notice/list.jsp'");
		} catch (PracticeNoticeException e) {
			e.printStackTrace();
			out.print("alert('"+e.getMessage()+"')");
		}
		out.print("</script>");
		
		
	}
}
