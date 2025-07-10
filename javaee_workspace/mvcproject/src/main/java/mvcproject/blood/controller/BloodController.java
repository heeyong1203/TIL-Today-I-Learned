package mvcproject.blood.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mvcproject.blood.model.BloodManager;
import mvcproject.web.servlet.Controller;

public class BloodController implements Controller {
	Logger logger = LoggerFactory.getLogger(getClass()); 
	BloodManager bloodManager = new BloodManager();
	
	@Override
	public void execute(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		logger.debug("하위 컨트롤러 호출 성공");
		
		String blood = request.getParameter("blood");
		String result = bloodManager.getAdvice(blood); //3단계) 일 시키기
		
		//4단계: 결과 저장 (이 클래스가 직접 결과를 보여주는 것이 아니므로, 결과를 저장해야 함)
		//Session에 담으면 데이터는 사용할 수 있지만, .do로 새롭게 들어오지 않을 경우 과거의 데이터를 보게 된다.
		// 즉, 갱신되지 않은 데이터를 보게된다.
		request.setAttribute("msg", result);
	}
	
	@Override
	public boolean isForward() {
		return true;
	}
	
	@Override
	public String getViewName() {
		return "/blood/view";
	}
}
