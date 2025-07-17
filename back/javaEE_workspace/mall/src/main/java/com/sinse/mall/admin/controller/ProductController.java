package com.sinse.mall.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@RequestMapping(value = "/admin/product/registform")
	public ModelAndView registForm() {
		ModelAndView mav = new ModelAndView("secure/product/regist");
		return mav;
	}
}
