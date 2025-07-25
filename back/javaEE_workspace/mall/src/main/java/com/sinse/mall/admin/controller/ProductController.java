package com.sinse.mall.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinse.mall.domain.Color;
import com.sinse.mall.domain.Product;
import com.sinse.mall.domain.ProductColor;
import com.sinse.mall.domain.ProductSize;
import com.sinse.mall.domain.Size;
import com.sinse.mall.model.category.TopCategoryService;
import com.sinse.mall.model.product.ProductService;
import com.sinse.mall.util.Paging;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService; //Autowired는 누가 주입해주는 것인가? rootConfig
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	//페이징 처리 객체를 보유
	@Autowired
	private Paging paging;
	
	//localhost:8888/admin/admin/product/registform
	
	@RequestMapping(value = "/admin/product/registform")
	public ModelAndView registForm() {
		//상품 등록페이지를 보게 되는 초기에 상위 카테고리가 채워져있어야 한다.

		//4단계: 결과 저장
		ModelAndView mav = new ModelAndView();
		mav.setViewName("secure/product/regist");
		
		return mav;
	}
	
	//상품 등록 요청을 처리
	@PostMapping("admin/product/regist")
	@ResponseBody
	public String regist(Product product, int[] color, int[] size, HttpServletRequest request) {
		
		
		//Product 객체의 멤버변수로 직접 html과 매핑이 될 수 없는 경우엔 간접 매핑을 이용하라
		//파라미터를 별도로 받은 후, 다시 Product에 넣어준다.
		
		//사용자가 선택한 색상이 3개라면, ProductColor의 인스턴스도 3개를 생성!
		//스프링의 자동 매핑이 불가하므로, 개발자가 직접 생성한다.
		List<ProductColor> colorList = new ArrayList<>();
		List<ProductSize> sizeList = new ArrayList<>();
		
		for (int c : color) {
			Color cc = new Color();
			cc.setColor_id(c);
			
			ProductColor productColor = new ProductColor();
			//유저가 선택한 색상 대입
			productColor.setColor(cc);
			colorList.add(productColor);
		}
		
		for (int s : size) {
			Size ss = new Size();
			ss.setSize_id(s);
			
			ProductSize productSize = new ProductSize();
			productSize.setSize(ss);
			sizeList.add(productSize);
		}
		
		//매핑완료 후, Product에 대입
		product.setColorList(colorList);
		product.setSizeList(sizeList);
		
		//모델 객체는 table을 반영한 객체이므로 컨트롤러 영역에서 바로 파라미터를 받는 용도로 사용해서는 안된다.
		//DB 컬럼명이 노출되어 보안상 문제가 생기기 때문이다. 해결책으로 클라이언트의 파라미터를 받는 용도로써의 객체를 별도로 두어야 한다.(DTO)
		//DTO: Data Transfer Object.. DTO에서 Model 객체로 옮겨야 한다.
		
		String savePath = request.getServletContext().getRealPath("/data");
		
		try {
			productService.regist(product, savePath);
		} catch (Exception e) {
			productService.remove(product, savePath);
			e.printStackTrace();
		}
		
		//log.debug("product = "+product);
		//log.debug("photo = "+photo);
		//ServletContext context = request.getServletContext(); //jsp에선 application 내장 객체
		//String realPath = context.getRealPath("/data");
		//log.debug("realPath is "+realPath);
		
		//4단계: DML은 저장할게 없다
		return "ok";
	}
	
	//목록 요청 처리: 요청이 들어오면 list.jsp를 응답정보로 보내야 한다.
	//ResponseBody가 아닌 ModelAndView로 반환해야 한다. //결국 DispatcherServlet에게 전달하기 위함
	@GetMapping("/admin/product/list")
	public ModelAndView getList(HttpServletRequest request) {
		//3단계: 목록 가져오기
		List productList = productService.selectAll();
		
		paging.init(productList, request);
		
		//4단계: 결과 저장
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList", productList); //request.setAttribute("productList", productList)
		mav.addObject("paging", paging); //페이징 처리 객체도 담기
		mav.setViewName("secure/product/list");
		
		return mav;
	}
	
	//상세요청에 대한 처리
	@GetMapping("/admin/product/detail")
	public String getDetail(int product_id, Model model) {
		//3단계: 상세 내용 가져오기
		Product product = productService.select(product_id);
		log.debug("현재 product " + product);
		
		//4단계: 저장하기
		model.addAttribute("product", product);
		
		return "secure/product/detail";
	}
	
//	public ModelAndView regist(Product product, MultipartFile[] photo, HttpServletRequest request) {
//		
//		ModelAndView mav = new ModelAndView();
//		//3단계: 일 시키기
//		mav.setViewName("redirect:/admin/admin/product/list");
//		
//		
//		//4단계: DML은 저장할 것이 없음
//		return mav;
//	}
}
