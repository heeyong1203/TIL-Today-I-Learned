package com.sinse.memberapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import ch.qos.logback.classic.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import com.sinse.memberapp.exception.MemberNotFoundException;
import com.sinse.memberapp.model.Member;
import com.sinse.memberapp.repository.MemberDAO;

// Post로 전송되어 오는 로그인 정보를 받아, 회원테이블과의 일치여부에 따라 로그인 성공 및 실패
public class LoginServlet extends HttpServlet{
	Logger logger = (Logger) LoggerFactory.getLogger(getClass());
	MemberDAO memberDAO = new MemberDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 파라미터 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		
		Member user;
				
		out.print("<script>");
		try {
			user=memberDAO.login(member);
			// 로그인이 성공하면, 세션 객체에 담는다.
			// jsp에서는 내장객체로써, session이 지원되나, 현재 이 코드는 서블릿이기 때문에 개발자가 자료형으로 제어해야 함
			HttpSession session = request.getSession(); // 현재 이 요청에 의해 할당된 세션
			session.setAttribute("member", user);
			System.out.println(session.getId());
			
			out.print("alert('"+user.getName()+"님 반갑습니다.');");
			out.print("location.href='/member/index.jsp';");
		} catch (MemberNotFoundException e) {
			out.print("alert('"+e.getMessage()+"';)");
			out.print("history.back();");
			e.printStackTrace();
		}
		out.print("</script>");
		
		for(int i=1; i<=10; i++) {
			logger.trace("i는 "+i);
		}
		
		logger.debug("넘겨받은 id = "+ id);
		logger.debug("넘겨받은 pwd = "+ pwd);
		
//		logger.trace("trace 레벨 출력");
//		logger.debug("debug 레벨 출력");
//		logger.info("info 레벨 출력");
//		logger.warn("warn 레벨 출력");
//		logger.error("error 레벨 출력");
		
	}
}
