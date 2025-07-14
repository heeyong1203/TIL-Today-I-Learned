package com.sinse.practiceapp.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.practiceapp.exception.CommentException;
import com.sinse.practiceapp.model.Comment;
import com.sinse.practiceapp.model.PracticeNotice;
import com.sinse.practiceapp.repository.CommentDAO;

public class CommentRegisterServlet extends HttpServlet {
	CommentDAO commentDAO = new CommentDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String msg = request.getParameter("msg");
		String user = request.getParameter("user");
		int notice_id = Integer.parseInt(request.getParameter("notice_id"));
		
		PracticeNotice notice = new PracticeNotice();
		notice.setNotice_id(notice_id);
		
		Comment comment = new Comment();
		comment.setMsg(msg);
		comment.setUser(user);
		comment.setNotice(notice);
		
		
		try {
			commentDAO.insert(notice);
		} catch (CommentException e) {
			e.printStackTrace();
		}
	}
}
