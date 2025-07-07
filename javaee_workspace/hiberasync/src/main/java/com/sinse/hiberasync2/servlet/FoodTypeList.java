package com.sinse.hiberasync2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.sinse.hiberasync2.model.FoodType;
import com.sinse.hiberasync2.repository.FoodTypeDAO;

// 음식 타입 목록 요청을 받는 서블릿
public class FoodTypeList extends HttpServlet {
	private FoodTypeDAO foodTypeDAO;
	private List<FoodType> list;
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			list = foodTypeDAO.selectAll();
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			
			Gson gson = new Gson();
			String result = gson.toJson(list);
			
			logger.debug("문자열로 변환 후 데이터 " + result);
			out.print(result); // html로 넘길 데이터
	}
}
