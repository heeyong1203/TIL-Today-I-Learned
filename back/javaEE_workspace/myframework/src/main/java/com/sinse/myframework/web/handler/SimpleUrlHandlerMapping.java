package com.sinse.myframework.web.handler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.sinse.myframework.web.servlet.Controller;

public class SimpleUrlHandlerMapping implements HandlerMapping {
	Logger logger = LoggerFactory.getLogger(getClass());
	JsonObject root; //DispatcherServlet이 생성한 json 매핑 파일을 해석(파싱)한 결과 객체
	Map<String, Controller> controllerMap = new HashMap<>(); //요청 시 요청컨트롤러를 반환해주기 위해 하위 컨트롤러들을 kry-value 쌍으로 보관해두자. 
	
	@Override
	public void setRoot(JsonObject root) {
		this.root=root;
		logger.debug("DispatcherServlet으로부터 전달받은 root는 " + root);		
	}
	
	@Override
	public void initialize() {
		JsonObject controllerMappings = root.getAsJsonObject("controllerMappings"); //root를 이용하여  json의 controllerMappings 검색
		logger.debug("controllerMappings 검색 결과 "+controllerMappings);
		
		//반복문으로 객체 내 모든 key값에 매칭된 클래스명을 대상으로 인스턴스화 작업을 시도하고, 컬렉션 객체에 수집하자.
		Set set = controllerMappings.keySet();
		Iterator<String> it= set.iterator();
		while(it.hasNext()) { //요소가 존재하는 동안 반복하겠다.
			String uri = it.next();
			logger.debug("요소는 =" + uri);
			
			String controllerName = controllerMappings.get(uri).getAsString();
			logger.debug("컨트롤러명은 "+controllerName);
			
			try {
				Controller controller = (Controller)Class.forName(controllerName).newInstance();
				controllerMap.put(uri, controller);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Controller getController(String uri) {
		return controllerMap.get(uri);
	}
}
