package com.sinse.myframework.web.handler;

import com.google.gson.JsonObject;
import com.sinse.myframework.web.servlet.Controller;

//모든 핸들러 매핑 객체들의 최상위 객체를 정의
public interface HandlerMapping {
	
	//DispatcherServlet이 보유한 Root JsonObject가 있어야 json 설정 파일 해석이 가능하므로, 넘겨받자
	//admin-servlet.json을 해석해야 하기 때문에
	public void setRoot(JsonObject root);
	
	//각 핸들러 매핑마다 하고 싶은 초기화 작업에 사용할 메서드
	public void initialize();
	
	//DispatcherServlet에게 전달할 컨트롤러 반환
	public Controller getController(String uri);
	
}
