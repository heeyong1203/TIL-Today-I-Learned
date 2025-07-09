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
import com.sinse.hiberasync.model.Store;
import com.sinse.hiberasync.repository.StoreDAO;
import com.sinse.hiberasync.util.Message;

public class StoreDelete extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	StoreDAO storeDAO = new StoreDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("store_id");
		int store_id = Integer.parseInt(sId);
		
		logger.debug("삭제할 레코드 pk값 = "+store_id);
		
		Store store = new Store();
		store.setStore_id(store_id);
		
		Message message = new Message();
		response.setContentType("application/json");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		
		try {
			storeDAO.delete(store_id);
			response.setStatus(HttpServletResponse.SC_NO_CONTENT); //204
			message.setResult("success");
			message.setMsg("삭제 성공");
		} catch (StoreException e) {
			e.printStackTrace();
			message.setResult("fail");
			message.setMsg(e.getMessage());			
		}
		String jsonResult = gson.toJson(message);
		out.print(jsonResult); // 즉시 전송되는 게 아니라, 웹컨테이너가 스트림에 쓴 내용을 모으고, 응답을 commit할 타이밍에 브라우저로 전송
		
	}
}
