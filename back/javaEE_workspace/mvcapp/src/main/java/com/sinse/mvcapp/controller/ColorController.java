package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinse.mvcapp.model.ColorManager;

/*
 * MVC 패턴에 의해 디자인과 로직을 분리시키려면, 중간에 중재자가 나서야 한다. 따라서 코드에서 분리 
 * 서블릿을 사용하는 이유?
 * 1) JSP는 View로 사용할 것이기 때문이다.
 * 2) 웹기반의 컨트롤러는 클라이언트의 요청을 받는 능력이 있어야하기 때문이다.
*/
public class ColorController implements Controller {
												/* is a */
	ColorManager colorManager = new ColorManager();
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 컨트롤러의 5대 업무
			 1) 요청을 받는다.
			 2) 요청을 분석한다.
			 3) 알맞는 로직 객체(모델)에 요청을 전가한다. (※ 직접 일하지 않는다. ※)
			 4) 결과에 보여질 데이터를 보관한다.
			 5) 알맞는 결과를 보여준다.
		*/
		String color = request.getParameter("color");	// 3)
		
		String result = colorManager.getAdvice(color);	// 4) 세션에 보관	
		// 여기서 절대로 결과를 출력하지 않는다... MVC로 분리해야 하므로 컨트롤러가 view 역할을 해서는 안된다.
		HttpSession session = request.getSession();
		session.setAttribute("msg", result);
		
		// result.jsp를 클라이언트가 보도록 처리..
		// 클라이언트로 하여금 지정된 url로 다시 요청을 시도하도록 강제
		// 즉, 웹컨테이너가 응답정보를 이용하여 응답 컨텐츠를 보내고 나서, 클라이언트가 다시 접속할 주소...
	}
	@Override
	public String getViewPage() {
		return "/color/result/view";
	}
}
