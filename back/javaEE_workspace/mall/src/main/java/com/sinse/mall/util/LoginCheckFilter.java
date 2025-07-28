package com.sinse.mall.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

//쇼핑몰의 기능 중 로그인이 요구되는 요청마다 세션 존재여부를 체크하면 코드가 중복된다.
//이를 방지하기 위해 해당 요청에 필터 수준에서 세션 체크를 진행하자
@Slf4j
public class LoginCheckFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		
		//클라이언트의 요청이 /shop/cart/list, /shop/member/mypage 등등의 로그인이 필요한 서비스인 경우에는
		//세션 정보가 없다면, 아래의 chain.doFilter()를 만나지 않도록 처리한다.
		//내부의 서블릿을 만나지도 못하고 Tomcat으로 하여금 로그인폼을 응답정보로 보내도록 한다.
		String uri = request.getRequestURI();
		
		//현재 들어오는 요청객체가 세션 정보를 보유하고 있는지 체크
		//세션 내 회원정보가 있다면 요청 페이지를 보여주고, 회원정보가 없다면 로그인 폼 페이지로 강제 이동
		HttpSession session = request.getSession(false);
		log.debug("필터 동작함 :session은 " + session);
		
		if(//그냥 가도록 허용하고 싶은 uri
			uri.equals("/shop/main") ||
			
			//로그인 폼 & 로그아웃
			uri.equals("/shop/member/loginform") ||
			uri.equals("/shop/member/logout") ||
			
			//콜백 & 동의화면 관련
			uri.startsWith("/shop/callback/sns") ||
			uri.endsWith("/authurl") ||
			
			//상품 관련
			uri.equals("/shop/product/list") ||
			uri.startsWith("/shop/product/detail")
		) {
			chain.doFilter(req, res);

			//doFilter()를 만나면 실행부는 원래 요청했던 서블릿 혹은 다른 필터를 수행하려고 한다.
			//코드 관습 상 다른 개발자들에게 명확히 알려주기 위해 return을 명시한다.
			return;
			
		} 
		
		//세션이 존재하고, 그 세션 객체에 member가 들어있다면 로그인을 한 사람이다.
		Boolean loggined =(session != null && session.getAttribute("member") != null);
		
		//로그인하지 않은 경우에는 강제적으로 loginform을 만나게 한다.
		if(loggined==false) {			
			HttpServletResponse response = (HttpServletResponse)res;
			response.sendRedirect("/shop/member/loginform");
		} else {
			chain.doFilter(req, res);
		}
	}
	
	@Override
	public void destroy() {}
}
