package com.sinse.myframework.shop.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinse.myframework.web.servlet.Controller;

public class RegistController implements Controller {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	public String getViewName() {
		return null;
	}

	@Override
	public boolean isForward() {
		return false;
	}
	
}
