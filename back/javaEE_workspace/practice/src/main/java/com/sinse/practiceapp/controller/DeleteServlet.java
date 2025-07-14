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

public class DeleteServlet extends HttpServlet {
	PracticeNoticeDAO noticeDAO = new PracticeNoticeDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int notice_id = Integer.parseInt(request.getParameter("notice_id"));
		
		PracticeNotice notice = new PracticeNotice();
		notice.setNotice_id(notice_id);
		
		out.print("<script>");
		try {
			noticeDAO.delete(notice_id);
			out.print("alert('삭제 성공');");
			out.print("location.href='/notice/list.jsp';");
		} catch (PracticeNoticeException e) {
			e.printStackTrace();
			out.print("alert('"+e.getMessage()+"');");
			out.print("history.back();");
		}
		out.print("</script>");
	}
}
