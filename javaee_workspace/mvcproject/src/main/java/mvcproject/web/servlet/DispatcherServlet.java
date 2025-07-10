package mvcproject.web.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 아주 큰 규모의 웹 애플리케이션에서 모든 요청을 이 서블릿이 받는다
public class DispatcherServlet extends HttpServlet {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private Properties props; // key-value 씽으로 이루어진 데이터를 이해할 수 있는 객체
	
	// 요청이 들어오기 전에 처리할 준비를 해야하기 때문에 init 메서드를 오버라이드 한다.
	@Override
	public void init(ServletConfig config) throws ServletException {
		// ServletContext란? Context는 문맥, 맥락.. 
		// 즉, 이 서블릿이 실행되고 있는 환경을 말하므로, 우리의 웹 애플리케이션을 의미한다.
		ServletContext context = config.getServletContext();
		String realPath = context.getRealPath(config.getInitParameter("contextConfigLocation"));
		
		logger.debug(realPath);// 현 시점엔 request, response가 없으므로 logger로 확인
		
		try(FileInputStream fis = new FileInputStream(realPath)){
			props = new Properties();
			props.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	// Get이든 Post이든 모두 이 메서드에서 요청 처리 (메서드의 공통화)
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("메서드 호출");
		
		//클라이언트의 요청 URI를 이용하여, 매핑파일을 검색하고 value를 반환받자
		String uri = request.getRequestURI(); // 클라이언트가 요청한 경로 텍스트로 반환
		String className = props.getProperty(uri); 
		logger.debug("요청 uri는 "+ uri);
		logger.debug("동작할 클래스는 " +className);
		
		// 텍스트에 불과한 classNames을 실제 클래스로 로드
		try {
			Class clazz=Class.forName(className); // static 영역에 해당 클래스 로드..
			Controller controller = (Controller)clazz.newInstance(); // new 연산자 말고도, 즉 메서드로도 인스턴스를 생성할 수 있음
			controller.execute(request, response);
			
			/* send.redirect가 아닌 forwarding을 써보자! */
			//하위 컨트롤러가 3,4단계를 완료한 시점. 반환받은 키워드로 다시 매핑 파일을 검색하자
			String viewName = controller.getViewName();
			
			//검색한 결과, 실제 보여질 페이지를 반환
			String viewPage = props.getProperty(viewName);
			
			//포워딩? 클라이언트에게 응답 정보로 재접속을 강요하는 것이 아니다.
			//즉, 응답을 보류한 상태로 현재 요청의 흐름을 서버 내 또 다른 서블릿 or jsp에게 전달하는 방법
			if(controller.isForward()) { // 요청을 유지할 경우, 즉 포워딩 (전화했더니 그 자리에서 내선 번호로 바로 연결해줌)
			RequestDispatcher dis = request.getRequestDispatcher(viewPage);
			dis.forward(request, response);
			} else { 
				response.sendRedirect(viewPage); // 요청 끊고 재접속 (전화번호 전달 받음)
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
