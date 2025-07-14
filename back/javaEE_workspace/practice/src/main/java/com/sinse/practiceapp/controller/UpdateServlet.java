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

public class UpdateServlet extends HttpServlet {
	PracticeNoticeDAO noticeDAO = new PracticeNoticeDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int notice_id = Integer.parseInt(request.getParameter("notice_id"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		PracticeNotice notice = new PracticeNotice();
		notice.setNotice_id(notice_id);
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		out.print("<script>");
		try {
			noticeDAO.update(notice);
			out.print("alert('수정 성공');");
			out.print("location.href='/notice/content.jsp?notice_id="+notice_id+"';");
			out.print("console.log('notice_id: " + notice_id + "');");
		} catch (PracticeNoticeException e) {
			e.printStackTrace();
			out.print("alert('"+e.getMessage()+"');");
			out.print("history.back();");
		}
		out.print("</script>");
		
		
	}
}
