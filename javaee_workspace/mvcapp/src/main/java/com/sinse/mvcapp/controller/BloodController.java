package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinse.mvcapp.model.BloodManager;

// 혈액형에 대한 판단 요청을 처리하는 컨트롤러 정의
public class BloodController implements Controller{
												/* is a */
	BloodManager bloodManager = new BloodManager();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청을 받는다. 
		String blood = request.getParameter("blood");
		
		// 2) 분석 (생략, why? 어차피 이 컨트롤러는 혈액형에 대한 처리이므로)
		// 3) 일을 시킨다. 
		String result = bloodManager.getAdvice(blood);
		
		// 4) view로 가져갈 것이 있다면 저장한다.
		HttpSession session = request.getSession(); // 웹컨테이너가 send.jsp에게 응답할 때 쿠키를 남김(동일 세션)
		session.setAttribute("msg", result);
	}
	
	public String getViewPage() {
		return "/blood/result/view";
	}
}
