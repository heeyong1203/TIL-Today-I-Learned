package com.sinse.hiberasync2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinse.hiberasync2.repository.StoreDAO;
import com.sinse.hiberasync2.util.Message;
import com.google.gson.Gson;
import com.sinse.hiberasync2.exception.StoreException;
import com.sinse.hiberasync2.model.FoodType;
import com.sinse.hiberasync2.model.Store;

public class StoreRegist extends HttpServlet {
	private StoreDAO storeDAO;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		storeDAO = new StoreDAO();
		String store_name = request.getParameter("store_name");
		String tel = request.getParameter("tel");
		int food_type_id = Integer.parseInt(request.getParameter("food_type_id"));
		
		logger.debug("store_name "+store_name);
		logger.debug("tel "+tel);
		logger.debug("food_type_id "+food_type_id);
		
		FoodType foodType = new FoodType();
		foodType.setFood_type_id(food_type_id);
		
		Store store = new Store();
		store.setStore_name(store_name);
		store.setTel(tel);
		store.setFoodType(foodType);
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Message message = new Message();
		Gson gson = new Gson(); 
		
		
		try {
			storeDAO.insert(store);
			response.setStatus(HttpServletResponse.SC_CREATED); // 201
		} catch (StoreException e) {
			e.printStackTrace();
			message.setResult("fail");
			message.setMsg(e.getMessage());
			out.print(gson.toJson(message));
		}
		
	}
}
