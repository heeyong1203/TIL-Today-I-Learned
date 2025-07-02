package com.sinse.boardapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.boardapp.exception.NoticeException;
import com.sinse.boardapp.repository.NoticeDAO;

// 삭제 요청을 처리하는 서블릿, 삭제 요청은 별도의 디자인을 요구하는 요청이 아니므로 jsp가 아닌 서블릿으로 처리
// 삭제 후, 목록으로 링크 이동
public class DeleteServlet extends HttpServlet {
	// delete from notice where notice_id=6;
	
	NoticeDAO noticeDAO = new NoticeDAO();
	
	// 삭제를 요청하는 클라이언트가 Get방식으로 요청하고 있으므로..
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		String notice_id = request.getParameter("notice_id"); // 파라미터 받기
		// System.out.println("넘겨받은 pk값은 " + notice_id);
		
		// 실패를 했는지 성공을 했는지는 서버측만 알고 있고, 클라이언트는 모름 → 응답 정보 객체가 보유한 출력스트림에 원하는 문자열을 넣어두면,
		// 웹컨테이너가 응답정보를 구성하여 응답을 수행함
				
		try {
			noticeDAO.delete(Integer.parseInt(notice_id));
			out.print("<script>");
			out.print("alert('삭제 성공');");
			out.print("location.href = '/notice/list.jsp';");
			out.print("</script>");
		} catch (NoticeException e) {
			e.printStackTrace();
			out.print("<script>");
			out.print("alert('"+e.getMessage()+"');");
			out.print("history.back();"); // 브라우저 아이콘 중 뒤로가기 누르는 효과
			out.print("</script>");
		}
	}
}
