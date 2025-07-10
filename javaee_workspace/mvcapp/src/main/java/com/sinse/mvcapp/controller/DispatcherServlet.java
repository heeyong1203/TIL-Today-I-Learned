package com.sinse.mvcapp.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// 모든 ~~~ 종류의 요청을 다 받을 수 있는 서블릿
public class DispatcherServlet extends HttpServlet {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private FileInputStream fis;
	
	// java.util.Map의 자식 중 Properties라는 객체는 자신이 읽어들인 문자열이 만일
	// '='을 기준으로 key=value 형태로 되어있다면 이것을 해석할 수 있는 객체이다. 
	private Properties props; 
	
	// 이 서블릿의 인스턴스가 생성될 때, 초기화가 진행되고, 이 초기화 진행 시점에 
	// 설정 파일로부터 해당 요청에 어떤 하위 컨트롤러가 작동해야 하는지 분석하여
	// 요청을 전달하기 위한 메서드
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext(); // 현재 서블릿이 실행되고 있는 문맥상의 애플리케이션
		// WEB-INF: 외부 브라우저에서 접속하는 것은 차단되어 있으나 자바 내부 코드에서는 접근 가능하다.
		String realPath = context.getRealPath(config.getInitParameter("contextConfigLocation"));
		
		logger.debug(realPath);
		
		try {
			fis = new FileInputStream(realPath);
			props = new Properties(); 	
			props.load(fis); // 실제적으로 파일을 읽어들인 객체는 fis이므로, props는 fis를 로드해야 한다.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*---------------------------------------------------------------------------------
			매 요청마다 1:1 대응되는 매핑을 피하기 위해 하나의 진입점으로 몰았으나,
		 	진입점이 되는 클래스가 매 요청마다 1:1 대응되는 if 조건문이 작성되고 있는 문제점 발생
		 	→ Command Pattern + 다형성
		---------------------------------------------------------------------------------*/
		Controller controller = null;
		// 혈액형을 전문적으로 처리하는 컨트롤러에게 업무 분담!!
		// 요청에 대한 처리를 1:1 대응하는 객체로 처리하는 개발 패턴을 가리켜 Command Pattern이라고 함	
		// new 연산자만이 인스턴스를 생성할 수 있는 것은 아니다.
		try {
			Class clazz = Class.forName(props.getProperty(request.getRequestURI()));
			controller = (Controller)clazz.newInstance();
			controller.execute(request, response);

			// 5) 알맞는 view 보여주기
			response.sendRedirect(props.getProperty(controller.getViewPage()));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		if(fis!=null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
