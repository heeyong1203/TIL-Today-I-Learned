package com.sinse.hiberasync.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.sinse.hiberasync.exception.StoreException;
import com.sinse.hiberasync.model.FoodType;
import com.sinse.hiberasync.model.Store;
import com.sinse.hiberasync.repository.StoreDAO;
import com.sinse.hiberasync.util.Message;

// 맛집 정보 수정 요청을 처리하는 서블릿
public class StoreEdit extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	StoreDAO storeDAO = new StoreDAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("store_id");
		String fId = request.getParameter("food_type_id");
		
		int store_id = Integer.parseInt(sId);
		String store_name = request.getParameter("store_name");
		String tel = request.getParameter("tel");
		int food_type_id = Integer.parseInt(fId);
		
		logger.debug("store_id= "+store_id);
		logger.debug("store_name= "+store_name);
		logger.debug("tel= "+tel);
		logger.debug("food_type_id= "+food_type_id);
		
		// 모델 채우기
		Store store = new Store();
		store.setStore_id(store_id);
		store.setStore_name(store_name);
		store.setTel(tel);
		
		FoodType foodType = new FoodType();
		foodType.setFood_type_id(food_type_id);
		store.setFoodType(foodType);
		
		// 응답 정보 만들기
		Message message = new Message();
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		
		// update 쿼리 실행
		try {
			storeDAO.update(store);
			response.setStatus(HttpServletResponse.SC_NO_CONTENT); //204
			message.setResult("success");
			message.setMsg("수정 성공");
		} catch (StoreException e) {
			e.printStackTrace();
			message.setResult("fail");
			message.setMsg(e.getMessage());
		}
		String jsonResult = gson.toJson(message);
		out.print(jsonResult); // 즉시 전송되는 게 아니라, 웹컨테이너가 스트림에 쓴 내용을 모으고, 응답을 commit할 타이밍에 브라우저로 전송
	}
}
