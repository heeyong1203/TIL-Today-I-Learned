package com.sinse.myframework.shop.staff.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.myframework.staff.model.domain.Bio;
import com.sinse.myframework.staff.model.domain.Staff;
import com.sinse.myframework.staff.model.service.StaffService;
import com.sinse.myframework.web.servlet.Controller;

//사원 등록 요청을 처리하는 하위 컨트롤러 (3단계: 일 시키기 + 4단계: 저장 하기)
public class RegistController implements Controller {
	StaffService staffService = new StaffService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String sal = request.getParameter("sal");
		String email = request.getParameter("email");
		String blood = request.getParameter("blood");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		
		Staff staff = new Staff();
		staff.setName(name);
		staff.setSal(Integer.parseInt(sal));
		staff.setEmail(email);
		
		Bio bio = new Bio();
		bio.setBlood(blood);
		bio.setHeight(Integer.parseInt(height));
		bio.setWeight(Integer.parseInt(weight));
		bio.setStaff(staff);
		
		//3) 서비스에게 일 시키기
		staffService.regist(bio);
	}
	
	@Override
	public String getViewName() {
		return "/shop/staff/regist/view";
	}
	
	@Override
	public boolean isForward() {
		return false;
	}
}
