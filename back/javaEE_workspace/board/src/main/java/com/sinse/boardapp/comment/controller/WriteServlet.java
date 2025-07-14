package com.sinse.boardapp.comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.boardapp.exception.CommentException;
import com.sinse.boardapp.model.Comment;
import com.sinse.boardapp.model.News;
import com.sinse.boardapp.repository.CommentDAO;

public class WriteServlet extends HttpServlet {
	CommentDAO commentDAO = new CommentDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String msg = request.getParameter("msg");
		String user = request.getParameter("user");
		int news_id = Integer.parseInt(request.getParameter("news_id"));
		
		News news = new News();
		news.setNews_id(news_id);
		
		Comment comment = new Comment();
		comment.setMsg(msg);
		comment.setUser(user);
		comment.setNews(news);
		
		out.print("<script>");
		try {
			commentDAO.insert(comment);
			out.print("alert('등록 성공');");
			out.print("location.href='/news/content.jsp?news_id="+news_id+"';");
		} catch (CommentException e) {
			e.printStackTrace();
			out.print("alert('"+e.getMessage()+"');");
			out.print("history.back();");
		}
		out.print("</script>");
		
		System.out.println("전송된 파라미터1는 "+msg);
		System.out.println("전송된 파라미터2는 "+user);
	}
}
