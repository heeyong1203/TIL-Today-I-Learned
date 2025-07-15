package com.sinse.springmvc.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//스프링에서 관리하는 클래스를 가리켜 Bean이라 하며, Beans 중 bean들을 대상으로, 어떤 역할을 수행하는 관점에서 지칭되는 용어로 컴포넌트가 있다.
@Controller
public class NoticeController {
	
	Logger logger = LoggerFactory.getLogger(getClass()); 
	
	@RequestMapping("/notice/list")
	public ModelAndView selectAll() {
		// ModelAndView: Model에는 개발자가 저장할 데이터를 저장, View에는 DispatcherServlet이 조합할 뷰의 이름
		// Model: request.setAttribute("키", value);
		// View: 접두어, 접미어
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", "게시물 목록");
		mav.setViewName("notice/list");
		return mav;
	}
	
	//글쓰기 폼요청 처리 (원래 jsp를 webapp 바로 밑에 두었다면 매핑이 필요없다. 즉, 직접 접근이 가능하다.
	//하지만 spring mvc에서는 jsp마저도 직접 접근을 막고 컨트롤러 매핑으로 처리한다.)
	@RequestMapping("/notice/registform")
	public String registForm() {
		return "notice/write";
	}
	
	
	//메서드 호출 후, 반환할 값이 없을 때, 즉 저장할 것이 없을 때는
	//ModelAndView 중 View만 반환하면 되므로, 이 때는 String으로 대체해도 됨
	// 예) notice/detail → String을 넘겨받은 DispatcherServlet이 /WEB-INF/views/notice/detail.jsp로 조합함
	@RequestMapping(value="/notice/regist", method=RequestMethod.POST)
	public String regist() {
		logger.debug("글쓰기 요청받음");
		
		//개발자가 redirect를 명시하지 않으면 스프링은 디폴드가 forward이므로 redirect를 선언해준다.
		return "redirect:/shop/notice/list";
	}
	
	@RequestMapping("/notice/detail")
	public ModelAndView getDetail() {
		logger.debug("상세보기 요청 받음");
		return null;
	}
	
	@RequestMapping(value="/notice/edit", method=RequestMethod.GET)
	public String update() {
		logger.debug("수정 요청 받음");
		return "redirect:/shop/notice/detail?notice_id=33"; //response.sendRedirect("");
	}
	
	@RequestMapping(value="/notice/del", method=RequestMethod.GET)
	public String delete() {
		logger.debug("삭제 요청 받음");
		return "redirect:/shop/notice/list";
	}
	
}
