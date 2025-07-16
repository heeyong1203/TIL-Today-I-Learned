package com.sinse.mall.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sinse.mall.domain.Notice;
import com.sinse.mall.notice.model.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j //logger 선언 할 필요가 없어짐 대신 해줬기 때문에
@Controller
public class NoticeController {
	//규모가 작으면 상관없으나, 대규모 프로젝트에서는 유지 보수 시간은 곧 비용이다.
	//최대한 유지보수성을 높이려면 객체와 객체들 간 has a 관계는 느슨할 수록 좋다. (상위자료형 보유)
	
	//스프링 컨테이너로부터 인스턴스 주입 받기 (Injection)
	@Autowired
	NoticeService noticeService;
	
	//목록 요청 처리, 특정 uri에 매핑되는 대상을 컨트롤러 클래스로 처리하는 것이 아닌 메서드로 처리하기 위함
	@RequestMapping("/notice/list")
	public ModelAndView selectAll() {
		//3단계: db에서 가져오기
		//4단계: 결과 저장
		//request.setAttribute("list", "목록 list");
		//ModelAndView는 Model과 View를 합쳐놓은 객체이다.
		//Model 객체에 정보를 담으면 request.setAttribute()와 동일한 효과
		//View에는 DispatcherServlet에게 전달할 페이지파일명이 아닌 이름을 전달하는 용도
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/list");
		log.debug("목록 요청 받음");
		
		//3단계: 일 시키기
		List noticeList = noticeService.selectAll(); //서비스 메서드 호출
		
		//4단계: 결과 저장
		mav.addObject("noticeList", noticeList);
		mav.setViewName("secure/notice/list"); //이것만 넘기면 DispatcherServlet, ViewResolver에게 해석을 맡김
		
		return mav;
	}
	
	
	//상세보기 요청 처리
	
	//글쓰기 폼 요청 처리(write.jsp WEB-INF라는 보안 디렉토리에 들어있기 때문에 웹사이트 직접 접근 불가)
	@RequestMapping(value="/notice/registform", method=RequestMethod.GET)
	public String getRegistForm() { //View에 keyWord를 채우는 것과 동일하다.
		return "secure/notice/write";
	}
	
	//글 등록 요청 처리
	@RequestMapping(value="/notice/regist", method=RequestMethod.POST)
	public ModelAndView regist(Notice notice) {
		
		ModelAndView mav = new ModelAndView();
		try {
			noticeService.regist(notice);
			mav.setViewName("redirect:/admin/notice/list");
		} catch (Exception e) {
			log.error("등록 실패", e.getMessage(), e); //개발자를 위한 것
			mav.addObject("error", e);
			mav.setViewName("secure/error/result");
		}		
		
		return mav; //웹브라우저에서 다시 접속하라는 의미이므로 /admin이 필요함
	}
	
	//글 수정 요청 처리
	
	//글 삭제 요청 처리
}
